package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.instance.ComponentInstance;
import org.sireum.aadl.ir.Aadl;
import org.sireum.aadl.osate.util.Util;
import org.sireum.awas.AADLBridge.AadlHandler;
import org.sireum.awas.ast.Model;
import org.sireum.awas.awasfacade.AwasGraphImpl;
import org.sireum.awas.fptc.FlowEdge;
import org.sireum.awas.fptc.FlowGraph;
import org.sireum.awas.fptc.FlowNode;
import org.sireum.awas.symbol.SymbolTable;
import org.sireum.awas.symbol.SymbolTableHelper;
import org.sireum.awas.util.JavaConverters;
import org.sireum.util.ConsoleTagReporter;

/**
 * Singleton that provides access to AWAS related functionality. We use a
 * singleton because a) Sirius's java services can't hold state, and b) the
 * initialization costs of AWAS / AIR / Sireum is significant
 *
 * See Wikipedia for the code the lazy initialization is adapted from:
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 * @author Sam Procter
 *
 */
public class AWASManager {

	private Map<ComponentInstance, AWASCacheTriple> graphTableCache;

	private AWASManager() {
		graphTableCache = new HashMap<>();
	}

	private static class LazyHolder {
		static final AWASManager INSTANCE = new AWASManager();
	}

	public static AWASManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public Collection<EObject> getNeighbors(ComponentInstance component) throws NoSuchElementException {
		initTableAndGraph(component.getContainingComponentInstance());
		FlowNode flowNode = JavaConverters.toJavaOptional(FlowNode.getNode(SymbolTableHelper.getUriFromString(
				graphTableCache.get(component.getContainingComponentInstance()).table, component.getName()).get()))
				.get();
		FlowGraph<FlowNode, FlowEdge<FlowNode>> nodeGraph = flowNode.getOwner();
		Set<FlowNode> neighbors = new HashSet<>();
		neighbors.addAll(JavaConverters.toJavaSet(nodeGraph.getPredecessorNodes(flowNode)));
		neighbors.addAll(JavaConverters.toJavaSet(nodeGraph.getSuccessorNodes(flowNode)));
		Set<String> uris = neighbors.stream().map(n -> n.getUri()).collect(Collectors.toSet());
		return urisToInstEObjs(component.eResource().getResourceSet(), uris);
	}

	private void initTableAndGraph(ComponentInstance component) {
		if (graphTableCache.containsKey(component)) {
			return;
		}
		Aadl airModel = Util.getAir(component, false);
		Model awasModel = AadlHandler.buildAwasModel(airModel);
		SymbolTable st = SymbolTable.apply(awasModel, new ConsoleTagReporter());
		FlowGraph<FlowNode, FlowEdge<FlowNode>> graph = FlowGraph.apply(awasModel, st);
		graphTableCache.put(component, new AWASCacheTriple(graph, st));
	}

	public Collection<EObject> backwardReach(ComponentInstance component) {
		initTableAndGraph(component);
		return urisToInstEObjs(component.eResource().getResourceSet(),
				graphTableCache.get(component).agi.backwardReachUsingNames(component.getName()));
	}

	public Collection<EObject> forwardReach(ComponentInstance component) {
		initTableAndGraph(component.getContainingComponentInstance());
		return urisToInstEObjs(component.eResource().getResourceSet(),
				graphTableCache.get(component.getContainingComponentInstance()).agi
						.forwardReachUsingNames(component.getName()));
	}

	private Collection<EObject> urisToInstEObjs(ResourceSet rs, Collection<String> uris) {
		return uris.stream().map(u -> uriToInstEObj(rs, u)).collect(Collectors.toSet());
	}

	private EObject uriToInstEObj(ResourceSet rs, String uri) {
		return rs.getEObject(URI.createURI(uri), false);
	}

	private class AWASCacheTriple {
		private FlowGraph<FlowNode, FlowEdge<FlowNode>> graph;
		private SymbolTable table;
		private AwasGraphImpl agi;

		public AWASCacheTriple(FlowGraph<FlowNode, FlowEdge<FlowNode>> graph, SymbolTable table) {
			this.graph = graph;
			this.table = table;
			this.agi = new AwasGraphImpl(graph, table);
		}
	}
}