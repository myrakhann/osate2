package org.osate.ge.internal.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.Categories;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.di.GetNameLabelConfiguration;
import org.osate.ge.internal.graphics.AadlGraphics;
import org.osate.ge.internal.graphics.FolderGraphicBuilder;
import org.osate.ge.internal.labels.LabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.ImageHelper;

public class ComponentInstanceHandler {	
	private static final LabelConfiguration nameLabelConfiguration = LabelConfigurationBuilder.create().top().horizontalCenter().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return true;
	}
		
	@GetGraphic
	public Graphic getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return AadlGraphics.getGraphic(ci.getComponentClassifier());
	}	
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		return ci.getFullName();
	}
	
	@GetNameLabelConfiguration
	public LabelConfiguration getNameLabelConfiguration() {
		return nameLabelConfiguration;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ComponentInstance ci) {
		Stream.Builder<Object> connectionReferenceStreamBuilder = Stream.builder();
		for(final ConnectionInstance connectionInstance : ci.getConnectionInstances()) {
			for(final ConnectionReference cr : connectionInstance.getConnectionReferences()) {
				connectionReferenceStreamBuilder.add(cr);
			}
		}	

		return Stream.concat(Stream.concat(ci.getComponentInstances().stream(), 
				ci.getFeatureInstances().stream()),
				connectionReferenceStreamBuilder.build());
	}
}
