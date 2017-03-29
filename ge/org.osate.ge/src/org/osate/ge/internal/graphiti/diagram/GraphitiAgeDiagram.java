package org.osate.ge.internal.graphiti.diagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.CurvedConnection;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.DiagramModificationListener;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.ElementAddedEvent;
import org.osate.ge.internal.diagram.ElementRemovedEvent;
import org.osate.ge.internal.diagram.ElementUpdatedEvent;
import org.osate.ge.internal.diagram.ModificationsCompletedEvent;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.graphics.AgeConnectionTerminator;
import org.osate.ge.internal.graphics.AgeShape;
import org.osate.ge.internal.graphics.ConnectionTerminatorSize;
import org.osate.ge.internal.graphiti.AnchorNames;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.diagram.AgeDiagramElement;

/**
 * Class that integrates AgeDiagram with Graphiti. 
 * Handles updating the Graphiti diagram to reflect changes in the AgeDiagram.
 * The Graphiti diagram must not be modified directly.
 *
 */
public class GraphitiAgeDiagram implements NodePictogramBiMap, AutoCloseable {
	public final static String AADL_DIAGRAM_TYPE_ID = "AADL Diagram";
	
	private final AgeDiagram ageDiagram;
	private final Diagram graphitiDiagram;
	private final Map<PictogramElement, DiagramNode> pictogramElementToDiagramNodeMap = new HashMap<>();
	private final Map<DiagramNode, PictogramElement> diagramNodeToPictogramElementMap = new HashMap<>();
	private final GraphitiDiagramModificationListener modificationListener = new GraphitiDiagramModificationListener();
	
	/**
	 * 
	 * @param ageDiagram is the AgeDiagram that will be associated with the Graphiti Diagram
	 * @param editingDomain is the editing domain to use to make modifications to the diagram. It must not contain any other diagrams.
	 */
	public GraphitiAgeDiagram(final AgeDiagram ageDiagram, final EditingDomain editingDomain) {
		this.ageDiagram = Objects.requireNonNull(ageDiagram, "ageDiagram must not be null");
		Objects.requireNonNull(editingDomain, "editingDomain must not be null");
				
		this.graphitiDiagram = Graphiti.getPeService().createDiagram(GraphitiAgeDiagram.AADL_DIAGRAM_TYPE_ID, "", true);
		addMapping(ageDiagram, graphitiDiagram);
		
		// Create a URI to use for the resource. This resource uses a scheme which does not have a registered handler.
		// A handler is not needed the resource's save() should not be called. The URI just serves as a unique identifier in the resource set.
		final URI ignoredUri = URI.createHierarchicalURI("osate_ge_ignore",
				null,
				null,
				new String[] { "internal.aadl_diagram" },
				null,
				null);
		
		// Create the diagram resource and add the diagram to it.
		final Resource diagramResource = editingDomain.getResourceSet().createResource(ignoredUri);				
		editingDomain.getCommandStack().execute(new AbstractCommand() {
			@Override
			protected boolean prepare() {
				return true;
			}

			@Override
			public void execute() {
				diagramResource.getContents().add(graphitiDiagram);		
				createUpdateElementsFromAgeDiagram();
			}

			@Override
			public void redo() {
			}						
		});
		
		ageDiagram.addModificationListener(modificationListener); // Listen for updates
	}
	
	/**
	 * Creates/Updates and lays out graphiti elements for all diagram elements. Does not remove elements which are no longer in the graphiti diagram.
	 */
	private void createUpdateElementsFromAgeDiagram() {
		ensureCreatedChildren(ageDiagram, graphitiDiagram);
		updateChildren(ageDiagram, true);
		LayoutUtil.layoutDepthFirst(graphitiDiagram, ageDiagram, GraphitiAgeDiagram.this); // Layout
		finishUpdatingConnections(ageDiagram);
	}
	
	@Override
	public void close() {
		ageDiagram.removeModificationListener(modificationListener);		
	};
	
	public void modify(final DiagramModifier modifier) {
		this.ageDiagram.modify(modifier); 
	}
	
	/**
	 * Modify method that disabled the modification listener if updateGraphitiDiaram is false. This is used to allow updating the diagram to reflect the state of the
	 * Grpahiti diagram without triggering modification of the Graphiti diagram.
	 * @param modifier
	 * @param updateGraphitiDiagram
	 */
	public void modify(final DiagramModifier modifier, final boolean updateGraphitiDiagram) {
		try {
			if(!updateGraphitiDiagram){ 
				modificationListener.disable();
			}
		
			this.ageDiagram.modify(modifier);
		} finally {
			if(!updateGraphitiDiagram) {
				modificationListener.enable();
			}
		}
	}
	
	/**
	 * Stores mapping between the diagram node and the pictogram element
	 * @param dn
	 * @param pe
	 */
	private void addMapping(final DiagramNode dn, final PictogramElement pe) {
		diagramNodeToPictogramElementMap.put(dn, pe);
		pictogramElementToDiagramNodeMap.put(pe, dn);
	}
	
	/**
	 * Removes the mapping for the specified diagram node and all children
	 * @param dn
	 */
	private void removeMappingForBranch(final DiagramNode dn) {
		// Remove mapping for children
		for(final DiagramNode child : dn.getDiagramElements()) {
			removeMappingForBranch(child);
		}
		
		// Remove mapping for the element itself
		final PictogramElement pe = getPictogramElement(dn);
		pictogramElementToDiagramNodeMap.remove(pe);
		diagramNodeToPictogramElementMap.remove(dn);
	}
	
	/**
	 * Ensures graphiti elements for children of the specified node have been created
	 * @param dn
	 * @param containerShape
	 */
	private void ensureCreatedChildren(final DiagramNode dn, final ContainerShape containerShape) {
		for(final AgeDiagramElement e : dn.getDiagramElements()) {			
			ensureCreatedDiagramElement(e, containerShape);
		}
	}

	/**
	 * Creates/updates the pictogram element. Also creates most anchors. Connection anchors are not created. They are lazily created. 
	 * @param de
	 * @param containerShape
	 */
	private void ensureCreatedDiagramElement(final AgeDiagramElement de, final ContainerShape containerShape) {
		final Graphic g = de.getGraphic();
		
		// Create/Update the pictogram Element
		final PictogramElement pe = createUpdatePictogramElementForGraphic(graphitiDiagram, g, containerShape, getPictogramElement(de));		
		Objects.requireNonNull(pe, "pe must not be null");

		addMapping(de, pe);
		
		// Configure PE if one exists
		if(pe instanceof Shape) {										
			final Shape shape = ((Shape)pe);			
			AnchorUtil.createOrUpdateChopboxAnchor(shape);
											
			if(de.getDockArea() != null) {
				// Create/update the flow specification anchor for all docked shapes
				AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.FLOW_SPECIFICATION, 0, 0, false);
			}
		}
		
		// Determine which shape to use for children
		final ContainerShape nextContainerShape;
		if(g instanceof AgeShape) {
			nextContainerShape = (ContainerShape)pe;
		} else if(g instanceof AgeConnection) {
			nextContainerShape = containerShape;
		} else {
			throw new RuntimeException("Unsupported graphic: " + g);
		}

		// Update Children
		ensureCreatedChildren(de, nextContainerShape);
	}
	
	private void updateChildren(final DiagramNode elementContainer, final boolean recursive) {
		for(final AgeDiagramElement e : elementContainer.getDiagramElements()) {			
			updateDiagramElement(e, recursive);
		}
	}

	/**
	 * Refreshes transient shapes and updates pictogram element properties based on the diagram element.
	 * @param de
	 * @param recursive
	 */
	private void updateDiagramElement(final AgeDiagramElement de, final boolean recursive) {
		final Graphic g = de.getGraphic();
		
		final PictogramElement pe = getPictogramElement(de);
		if(pe == null) {
			return;
		}

		// Configure PE if one exists
		if(pe instanceof Shape) {										
			final Shape shape = ((Shape) pe);
			
			// Remove all non-chopbox anchors that do not have an incoming or outgoing connection
			final Iterator<Anchor> it = shape.getAnchors().iterator();
			while(it.hasNext()) {
				final Anchor anchor = it.next();
				if(!(anchor instanceof ChopboxAnchor) && anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size() == 0) {
					it.remove();
				}
			}

			PropertyUtil.setDockArea(pe, de.getDockArea());		
			
			// Delete Transient Shapes
			if(shape instanceof ContainerShape) {
				List<Shape> shapesToDelete = null; // Shapes that should be deleted .
				final ContainerShape containerShape = (ContainerShape)shape;
				for(final Shape childShape : containerShape.getChildren()) {
					if(PropertyUtil.isTransient(childShape)) {
						if(shapesToDelete == null) {
							shapesToDelete = new ArrayList<Shape>();
						}
						
						shapesToDelete.add(childShape);
					}
				}
				
				// Delete all shapes that were marked for deletion
				if(shapesToDelete != null) {
					for(final Shape s : shapesToDelete) {
						EcoreUtil.delete(s, true);
					}
				}
			}
		} else if(pe instanceof Connection) {
			final Connection connection = (Connection)pe;
			
			// Set Anchors
			connection.setStart(getAnchor(de.getStartElement()));
			connection.setEnd(getAnchor(de.getEndElement()));

	        final GraphicsAlgorithm ga = connection.getGraphicsAlgorithm();
	        ga.setStyle(null);
	        ga.setLineStyle(AgeGraphitiGraphicsUtil.toGraphitiLineStyle(((AgeConnection)g).lineStyle));
	        ga.setLineWidth(2);
	        ga.setForeground(Graphiti.getGaService().manageColor(graphitiDiagram, IColorConstant.BLACK));
	        
	        if(pe instanceof CurvedConnection) {
	        	ConnectionUtil.updateControlPoints((CurvedConnection)pe);
			}
	        
	        if(pe instanceof FreeFormConnection) {
	        	final FreeFormConnection ffc = (FreeFormConnection)pe;
	        	final List<org.eclipse.graphiti.mm.algorithms.styles.Point> graphitiBendpoints = ffc.getBendpoints();
	        	graphitiBendpoints.clear();
	        	for(final org.osate.ge.internal.diagram.Point bendpoint : de.getBendpoints()) {
	        		graphitiBendpoints.add(Graphiti.getGaService().createPoint(bendpoint.x, bendpoint.y));
	        	}
	        }
		}

		// Update Children
		if(recursive) {
			updateChildren(de, recursive);
		}
		
		// Get the name
		final String name = de.getName();
		if(pe instanceof ContainerShape) {
			// Create Labels
			if(name != null) {
				final Shape labelShape = LabelUtil.createLabelShape(graphitiDiagram, (ContainerShape)pe, ShapeNames.nameShapeName, name, true);
				labelShape.setActive(false);
			}

			final AgeShape ageShape = (AgeShape)de.getGraphic();
			final String annotation = ageShape.getAnnotation();
			if(annotation != null) {
				final Shape annotationShape = LabelUtil.createLabelShape(graphitiDiagram, (ContainerShape)pe, ShapeNames.annotationsShapeName, annotation, true);
				annotationShape.setActive(false);
			}
		} else if(pe instanceof Connection) {
			final Connection connection = (Connection)pe;
		    final AgeConnection ageConnection = (AgeConnection)de.getGraphic();
		    
			// Store position of all decorators which have ID's
			final Map<String, Point> decoratorNameToLocation = new HashMap<>();
			
			for(final ConnectionDecorator d : connection.getConnectionDecorators()) {
				if(d.getGraphicsAlgorithm() instanceof Text) {
					final String id = PropertyUtil.getName(d);
					if(id != null) {
						final Text text = (Text)d.getGraphicsAlgorithm();
						decoratorNameToLocation.put(id, new Point(text.getX(), text.getY()));
					}
				}
			}

			// Clear decorators
			connection.getConnectionDecorators().clear();

			final IGaService gaService = Graphiti.getGaService();
			
			// Create label decorator
			int labelX = 0;
			int labelY = 0;
			if(name != null) {
				final IPeCreateService peCreateService = Graphiti.getPeCreateService();
				final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, ageConnection.isFlowIndicator ? 1.0 : 0.5, true);
				final Text text = gaService.createDefaultText(graphitiDiagram, textDecorator);
				LabelUtil.setStyle(graphitiDiagram, text);
				PropertyUtil.setName(textDecorator, ShapeNames.nameShapeName);						
			    text.setValue(name);

			    final Point labelPosition = decoratorNameToLocation.get(ShapeNames.nameShapeName);
			    if(labelPosition == null) {
			    	// Set default position
			    	final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(name, text.getFont());
			    	if(ageConnection.isFlowIndicator) { // Special default position for flow indicator labels
			    		labelX = -28; // Position the label such that it the default text does not intersect with the border when docked on the left or on the right
			    		labelY = 5;
			    	} else {
			    		labelX = -labelTextSize.getWidth()/2;
			    		labelY = -labelTextSize.getHeight()/2;
			    	}
			    } else {
			    	labelX = labelPosition.x;
			    	labelY = labelPosition.y;
			    }
			    gaService.setLocation(text, labelX, labelY);
			}

			// Create Graphiti decorators for connection terminators
		    createDecorator(connection, ageConnection.srcTerminator, 0.0);
		    createDecorator(connection, ageConnection.dstTerminator, 1.0);
		}

		// Refresh the Top Level Graphics Algorithm. Connections do not have their graphics algorithms recreated because they all have the same type of GraphicsAlgorithm
		// and because there are issues when recreating the graphics algorithm of connections. Upon update, the connections may disappear.
		if(pe instanceof Shape) {
			final Shape shape = (Shape)pe;
			final int width = Math.max(10, de.getWidth());
			final int height = Math.max(10, de.getHeight());

			// Set the position of the refreshed graphics algorithm
			final IGaService gaService = Graphiti.getGaService();
			final GraphicsAlgorithm newGa = gaService.createInvisibleRectangle(shape);
			
			// Set Size
			gaService.setSize(newGa, width, height);
			
			// Set Position
			final org.osate.ge.internal.diagram.Point position = de.getPosition();
			if(position != null) {
				gaService.setLocation(newGa, position.x, position.y);
				PropertyUtil.setIsLayedOut(pe, true);
			}
		}
	}
	
	/**
	 * Finishes updating connections for all elements contained in the diagram.
	 */
	private void finishUpdatingConnections(final AgeDiagram diagram) {
		for(final AgeDiagramElement element : diagram.getDiagramElements()) {							
			finishUpdatingConnections(element);
		}	
	}
	
	/**
	 * Refreshes the control points and anchors of connections related to the specified element.
	 * This function depends on the position of connection anchors so it should be executed after layout has been performed for all relevant elements.
	 */
	private void finishUpdatingConnections(final AgeDiagramElement element) {
		final PictogramElement pe = getPictogramElement(element);
		if(pe instanceof Shape) {
			final Shape shape = ((Shape)pe);
			
			// Update control points of curved connections which are connected to the shape.
			for(final Anchor anchor : shape.getAnchors()) {
				ConnectionUtil.updateControlPoints(anchor.getIncomingConnections());
				ConnectionUtil.updateControlPoints(anchor.getOutgoingConnections());
			}
			
			AnchorUtil.updateConnectionAnchors(shape, GraphitiAgeDiagram.this);
		} else if(pe instanceof Connection) {
			AnchorUtil.updateConnectionAnchor(element, (Connection)pe, GraphitiAgeDiagram.this);
		}
		
		for(final AgeDiagramElement child : element.getDiagramElements()) {
			finishUpdatingConnections(child);
		}		
	}
		
	/**
	 * Creates or updates a pictogram element as appropriate to match the specified graphic.
	 * @param graphitiDiagram
	 * @param graphic
	 * @param shapeContainer is the container to use when creating shapes.
	 * @param pe is the current pictogram element for the graphic.
	 * @return
	 */
	private static PictogramElement createUpdatePictogramElementForGraphic(final Diagram graphitiDiagram, final Graphic graphic, final ContainerShape shapeContainer, PictogramElement pe) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Create/Change Pictogram Element Based on the Graphic
		if(graphic instanceof AgeConnection) {
			final AgeConnection ac = (AgeConnection)graphic;
			
			// Remove the PE If it is of the wrong type...
			if(pe != null) {
				if((ac.isCurved && !(pe instanceof CurvedConnection)) || (!ac.isCurved && !(pe instanceof FreeFormConnection))) {
					EcoreUtil.delete(pe, true);
					pe = null;
				}
			}
			
			if(pe == null) {
		        // Create the connection
				if(ac.isCurved) {
					pe = peCreateService.createCurvedConnection(new double[] {0.0, 0.0}, graphitiDiagram);
				} else {
					pe = peCreateService.createFreeFormConnection(graphitiDiagram);
				}					
				
				Graphiti.getGaService().createPlainPolyline(pe);
			}
		
		} else if(graphic instanceof AgeShape) {
			if(pe == null) {
		        // Create the container shape
				pe = peCreateService.createContainerShape(shapeContainer, true);
			}
		} else {
			throw new RuntimeException("Unsupported graphic: " + graphic);
		}
		
		return pe;
	}
	
	public final DiagramNode getDiagramNode(final PictogramElement pe) {
		return pictogramElementToDiagramNodeMap.get(pe);
	}
	
	@Override
	public PictogramElement getPictogramElement(final DiagramNode de) {
		return diagramNodeToPictogramElementMap.get(de);
	}
	
	public Diagram getGraphitiDiagram() {
		return graphitiDiagram;
	}
	
	public AgeDiagram getAgeDiagram() {
		return ageDiagram;
	}
	
	private Anchor getAnchor(final AgeDiagramElement de) {
		final PictogramElement pe = diagramNodeToPictogramElementMap.get(de);
		if(pe == null) {
			return null;
		}
		
		if(pe instanceof Connection) {
			return AnchorUtil.getOrCreateConnectionAnchor(de, (Connection)pe, this);
		} else if(pe instanceof AnchorContainer) {
			final AnchorContainer anchorContainer = (AnchorContainer)pe;
			return Graphiti.getPeService().getChopboxAnchor(anchorContainer);
		} else {		
			return null;
		}
	}
	
	
	private void createDecorator(final Connection connection, final AgeConnectionTerminator terminator, final double position) {
		if(terminator != null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
			final ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, position, true);
			final Diagram diagram = connection.getParent();
			final Color black = Graphiti.getGaService().manageColor(diagram, IColorConstant.BLACK);
			final Color white = Graphiti.getGaService().manageColor(diagram, IColorConstant.WHITE);

			final GraphicsAlgorithm ga;
			switch(terminator.type) {
			case FILLED_ARROW:
				ga = createPolygonArrow(cd, terminator.size);
			    ga.setForeground(black);
			    ga.setBackground(black);
				break;

			case OPEN_ARROW:
				ga = createPolygonArrow(cd, terminator.size);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;
			
			case LINE_ARROW:
				ga = createLineArrow(cd, terminator.size);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;
				
			case ORTHOGONAL_LINE:
				ga = createOrthogonalLine(cd);
			    ga.setForeground(black);
			    ga.setBackground(white);
				break;

			default:
				throw new RuntimeException("Unsupported terminator type: " + terminator.type);
			}
			
			if(terminator.reversed) {
				AgeGraphitiGraphicsUtil.mirrorX(ga);
			}				
		}
	}
	
	private GraphicsAlgorithm createOrthogonalLine(final GraphicsAlgorithmContainer gaContainer) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolyline(gaContainer, new int[] {
	    		0, 8,
	    		0, -8});
	    ga.setLineWidth(2);

	    return ga;
	}
	
	private GraphicsAlgorithm createLineArrow(final GraphicsAlgorithmContainer gaContainer, final ConnectionTerminatorSize size) {
		final IGaService gaService = Graphiti.getGaService();
		switch(size) {
		case REGULAR:
			return gaService.createPlainPolyline(gaContainer, new int[] {
	    		-14, 8, 
	    		2, 0, 
	    		-14, -8});
		case SMALL:
	    	return gaService.createPlainPolyline(gaContainer, new int[] {
	    		-6, 5, 
	    		2, 0, 
	    		-6, -5});
		}		
	
		throw new RuntimeException("Unsupported connection terminator size: " + size);
	}
	
	private GraphicsAlgorithm createPolygonArrow(final GraphicsAlgorithmContainer gaContainer, final ConnectionTerminatorSize size) {
		final IGaService gaService = Graphiti.getGaService();
		switch(size) {
		case REGULAR:
			return gaService.createPlainPolygon(gaContainer, new int[] {
		    		-14, 8, 
		    		2, 0, 
		    		-14, -8});
		case SMALL:
			return gaService.createPlainPolygon(gaContainer, new int[] {
		    		-6, 4, 
		    		2, 0, 
		    		-6, -4});	
		}		
		
		throw new RuntimeException("Unsupported connection terminator size: " + size);
	}
	
	private DiagramNode getUndockedDiagramNode(DiagramNode n) {
		while(n instanceof AgeDiagramElement) {
			final AgeDiagramElement e = ((AgeDiagramElement) n);
			if(e.getDockArea() == null) {
				return e;
			}
			
			n = e.getContainer();
		}
		return n;
		
	}
	
	private class GraphitiDiagramModificationListener implements DiagramModificationListener {
		private boolean enabled = true;
		
		boolean elementAdded = false;
		final Set<AgeDiagramElement> elementsToUpdate = new LinkedHashSet<>();
		final Set<AgeDiagramElement> elementsToRemove = new LinkedHashSet<>();
		
		@Override
		public void elementAdded(final ElementAddedEvent e) {
			if(enabled) {
				elementsToRemove.remove(e.element);
				elementAdded = true;
				//elementsToAdd.add(e.element);
				//elementsToUpdate.add(e.element);
				elementsToUpdate.clear(); // Clear all elements to update. They will not be processed if an element has been added.
			}
		}

		@Override
		public void elementRemoved(final ElementRemovedEvent e) {
			if(enabled) {
				elementsToRemove.add(e.element);
				//elementsToAdd.remove(e.element);
				elementsToUpdate.remove(e.element);
			}
		}

		@Override
		public void elementUpdated(final ElementUpdatedEvent e) {
			// Don't store updated elements when an element has been added. The add will trigger a complete update.
			if(enabled && !elementAdded) {
				// All updates are treated the same at this point. Each element is updated and containers are layed out.
				if(!elementsToRemove.contains(e.element)) {
					// If the element is already in the elements to update set, remove it so that it will be inserted at the end of the set
					if(elementsToUpdate.contains(e.element)) {
						elementsToUpdate.remove(e.element);
					}
					
					elementsToUpdate.add(e.element);
				}
			}
		}

		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent event) {
			if(enabled) {
				try {				
					// Remove elements
					for(final AgeDiagramElement element : elementsToRemove) {						
						// Remove any contained connections first. Connections are stored at the diagram level in the Graphiti model so they need to be deleted individually.
						removeContainedConnections(element);
						
						final PictogramElement pe = getPictogramElement(element);
						if(pe != null) {
							EcoreUtil.delete(pe, true);
						}
						
						// Remove the mapping
						removeMappingForBranch(element);
					}
					
					if(elementAdded) {
						createUpdateElementsFromAgeDiagram();
					} else {					
						final Set<DiagramNode> nodesToLayout = new HashSet<>();
						
						// Update modified elements 
						for(final AgeDiagramElement element : elementsToUpdate) {
							final PictogramElement pe = getPictogramElement(element);
							updateDiagramElement(element, false);
	
							if(pe instanceof ContainerShape) {
								final DiagramNode undockedContainer = getUndockedDiagramNode(element.getContainer());
								nodesToLayout.add(undockedContainer);
							}
						}
								
						// Layout Nodes
						// OPTIMIZE: It would be more efficient to only layout the nodes that need to be layed out instead of laying out all descendants of the container.
						nodesToLayout.removeIf((n) -> collectionContainsAnyAncestor(nodesToLayout, n)); // Filter out elements whose parents are in the collection of nodes to layout
						for(final DiagramNode n : nodesToLayout) {
							if(n instanceof AgeDiagram) {
								LayoutUtil.layoutDepthFirst(graphitiDiagram, (AgeDiagram)n, GraphitiAgeDiagram.this);	
							} else if(n instanceof AgeDiagramElement) {
								LayoutUtil.layoutDepthFirst(graphitiDiagram, (AgeDiagramElement)n, GraphitiAgeDiagram.this);
							}
						}
						
						// Update affected connections
						for(final AgeDiagramElement element : elementsToUpdate) {							
							finishUpdatingConnections(element);
						}			
					}
				} finally {
					elementAdded = false;
					//elementsToAdd.clear();
					elementsToRemove.clear();
					elementsToUpdate.clear();
				}
			}
		}		
		
		private boolean collectionContainsAnyAncestor(final Collection<?> collection, final DiagramNode n) {
			DiagramNode t = n.getContainer();
			while(t != null) {
				if(collection.contains(t)) {
					return true;
				}
				t = t.getContainer();
			}
			return false;
		}		
		
		/**
		 * Removes all connections contained in the specified element or its descendants.
		 */
		private void removeContainedConnections(final AgeDiagramElement e) {
			for(final AgeDiagramElement element : e.getDiagramElements()) {
				final PictogramElement pe = getPictogramElement(element);
				removeContainedConnections(element);
				
				if(pe instanceof Connection) {
					EcoreUtil.delete(pe, true);
				}
			}
		}
		
		public void enable() {
			this.enabled = true;
		}
		
		public void disable() {
			this.enabled = false;
		}
	}
}
