package org.osate.ge.internal.ui.tools;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.Activator;

class FlowDialogUtil {
	private FlowDialogUtil() {
	}

	private final static Image errorImage = PlatformUI.getWorkbench().getSharedImages()
			.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
	private final static Image warningImage = PlatformUI.getWorkbench().getSharedImages()
			.getImage(ISharedImages.IMG_OBJS_WARN_TSK);

	public static TableViewer createErrorTableViewer(final Composite container) {
		final TableViewer errorTableViewer = getErrorTableViewer(container);
		final Table errorTable = errorTableViewer.getTable();
		setTableData(errorTable);

		final TableColumnLayout layout = getColumnLayout(errorTable);
		container.setLayout(layout);
		container.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

		errorTableViewer.setComparator(new ViewerComparator() {
			@Override
			public int compare(final Viewer viewer, final Object o1, final Object o2) {
				// Show errors at top of table
				final int severity1 = ((Diagnostic) o1).getSeverity();
				final int severity2 = ((Diagnostic) o2).getSeverity();
				if (severity1 == severity2) {
					return 0;
				}

				return severity1 == Diagnostic.ERROR ? -1 : 1;
			}
		});

		return errorTableViewer;
	}

	public static Composite createFlowArea(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);

		composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		composite.setFont(parent.getFont());

		return composite;
	}

	public static Composite createSegmentComposite(final Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);

		composite.setLayoutData(GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 65).grab(true, false).create());
		composite.setFont(parent.getFont());
		return composite;
	}

	private static TableColumnLayout getColumnLayout(final Table errorTable) {
		// Create column
		final TableColumn tableColumn = new TableColumn(errorTable, SWT.NONE);
		tableColumn.setText("Model Errors");

		// Create column layout
		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(tableColumn, new ColumnWeightData(1, true));
		return layout;
	}

	private static void setTableData(final Table errorTable) {
		errorTable.setLayout(new GridLayout());
		errorTable.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		errorTable.setHeaderVisible(true);
		errorTable.setLinesVisible(true);
	}

	public static void setInput(final TableViewer errorTableViewer, final Object input) {
		errorTableViewer.setInput(input);

		final Table table = errorTableViewer.getTable();
		// Set column width to account for vertical scroll
		final ScrollBar verticalBar = table.getVerticalBar();
		if (verticalBar.isVisible()) {
			final int tableWidth = table.getSize().x;
			final int columnWidth = tableWidth - verticalBar.getSize().x - 5;
			if (tableWidth > columnWidth) {
				final TableColumn tableColumn = table.getColumn(0);
				tableColumn.setWidth(columnWidth);
			}
		} else {
			final int tableWidth = table.getSize().x;
			final int columnWidth = tableWidth - verticalBar.getSize().x - 5;
			if (tableWidth > columnWidth) {
				final TableColumn tableColumn = table.getColumn(0);
				tableColumn.setWidth(tableWidth - 5);
			}
		}

		errorTableViewer.getTable().layout(true, true);
	}

	private static TableViewer getErrorTableViewer(final Composite container) {
		final TableViewer errorTableViewer = new TableViewer(container,
				SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		errorTableViewer.setContentProvider(ArrayContentProvider.getInstance());
		setLabelProvider(errorTableViewer);
		return errorTableViewer;
	}

	private static void setLabelProvider(final TableViewer errorTableViewer) {
		errorTableViewer.setLabelProvider(new CellLabelProvider() {
			@Override
			public void update(final ViewerCell cell) {
				final Diagnostic diagnostic = (Diagnostic) cell.getElement();
				cell.setText(diagnostic.getMessage());
				cell.setImage(diagnostic.getSeverity() == Diagnostic.ERROR ? errorImage : warningImage);
			}
		});
	}

	// Dialog to tell user existing model errors and warnings must be resolved before using the flow tools
	public static ErrorDialog getErrorDialog(final String message) {
		final IStatus errorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				"There are existing errors and warnings in the model.");
		return new ErrorDialog(Display.getDefault().getActiveShell(), "Flow Tool Error", message, errorStatus,
				IStatus.ERROR);
	}

	public static StyledText createFlowSegmentLabel(final Composite flowSegmentComposite) {
		final StyledText flowSegmentLabel = new StyledText(flowSegmentComposite,
				SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		flowSegmentLabel.setEditable(false);
		flowSegmentLabel.setEnabled(false);
		flowSegmentLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		flowSegmentLabel.setMargins(5, 5, 5, 5);
		flowSegmentLabel.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		return flowSegmentLabel;
	}
}
