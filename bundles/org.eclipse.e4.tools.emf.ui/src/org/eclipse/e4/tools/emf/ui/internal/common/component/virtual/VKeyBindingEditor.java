/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 ******************************************************************************/
package org.eclipse.e4.tools.emf.ui.internal.common.component.virtual;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.e4.tools.emf.ui.common.component.AbstractComponentEditor;
import org.eclipse.e4.tools.emf.ui.internal.common.ModelEditor;
import org.eclipse.e4.tools.emf.ui.internal.common.VirtualEntry;
import org.eclipse.e4.ui.model.application.MApplicationFactory;
import org.eclipse.e4.ui.model.application.MApplicationPackage;
import org.eclipse.e4.ui.model.application.MKeyBinding;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class VKeyBindingEditor extends AbstractComponentEditor {
	private Composite composite;
	private EMFDataBindingContext context;
	private ModelEditor editor;

	public VKeyBindingEditor(EditingDomain editingDomain, ModelEditor editor) {
		super(editingDomain);
		this.editor = editor;
	}

	@Override
	public Image getImage(Object element, Display display) {
		return null;
	}

	@Override
	public String getLabel(Object element) {
		return "KeyBindings";
	}

	@Override
	public String getDetailLabel(Object element) {
		return null;
	}

	@Override
	public String getDescription(Object element) {
		return "KeyBindings Bla Bla Bla Bla Bla";
	}

	@Override
	public Composite getEditor(Composite parent, Object object) {
		if( composite == null ) {
			context = new EMFDataBindingContext();
			composite = createForm(parent,context, getMaster());
		}
		getMaster().setValue(((VirtualEntry<?>)object).getOriginalParent());
		return composite;
	}

	private Composite createForm(Composite parent, EMFDataBindingContext context,
			WritableValue master) {
		parent = new Composite(parent,SWT.NONE);
		parent.setLayout(new GridLayout(3, false));

		{
			Label l = new Label(parent, SWT.NONE);
			l.setText("Keybindings");
			l.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

			TableViewer viewer = new TableViewer(parent);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.heightHint = 300;
			viewer.getControl().setLayoutData(gd);
			viewer.getTable().setHeaderVisible(true);

			TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText("KeySequence");
			column.getColumn().setWidth(100);
			
			column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText("Command");
			column.getColumn().setWidth(200);
			
			column = new TableViewerColumn(viewer, SWT.NONE);
			column.getColumn().setText("Id");
			column.getColumn().setWidth(170);

			
			IEMFEditListProperty prop = EMFEditProperties.list(getEditingDomain(), MApplicationPackage.Literals.BINDING_CONTAINER__BINDINGS);
			IValueProperty[] props = {
				EMFEditProperties.value(getEditingDomain(), MApplicationPackage.Literals.KEY_SEQUENCE__KEY_SEQUENCE),
				EMFEditProperties.value(getEditingDomain(), FeaturePath.fromList(MApplicationPackage.Literals.KEY_BINDING__COMMAND, MApplicationPackage.Literals.COMMAND__COMMAND_NAME)),
				EMFEditProperties.value(getEditingDomain(), MApplicationPackage.Literals.APPLICATION_ELEMENT__ID)
			};
			
			ViewerSupport.bind(viewer, prop.observeDetail(getMaster()), props);
			
			Composite buttonComp = new Composite(parent, SWT.NONE);
			buttonComp.setLayoutData(new GridData(GridData.FILL,GridData.END,false,false));
			GridLayout gl = new GridLayout();
			gl.marginLeft=0;
			gl.marginRight=0;
			gl.marginWidth=0;
			gl.marginHeight=0;
			buttonComp.setLayout(gl);

			Button b = new Button(buttonComp, SWT.PUSH | SWT.FLAT);
			b.setText("Up");
			b.setImage(getImage(b.getDisplay(), ARROW_UP));
			b.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));

			b = new Button(buttonComp, SWT.PUSH | SWT.FLAT);
			b.setText("Down");
			b.setImage(getImage(b.getDisplay(), ARROW_DOWN));
			b.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));

			b = new Button(buttonComp, SWT.PUSH | SWT.FLAT);
			b.setText("Add ...");
			b.setImage(getImage(b.getDisplay(), TABLE_ADD_IMAGE));
			b.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
			b.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					MKeyBinding handler = MApplicationFactory.eINSTANCE.createKeyBinding();
					Command cmd = AddCommand.create(getEditingDomain(), getMaster().getValue(), MApplicationPackage.Literals.BINDING_CONTAINER__BINDINGS, handler);
					
					if( cmd.canExecute() ) {
						getEditingDomain().getCommandStack().execute(cmd);
						editor.setSelection(handler);
					}
				}
			});

			b = new Button(buttonComp, SWT.PUSH | SWT.FLAT);
			b.setText("Remove");
			b.setImage(getImage(b.getDisplay(), TABLE_DELETE_IMAGE));
			b.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		}


		return parent;
	}

	@Override
	public IObservableList getChildList(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}