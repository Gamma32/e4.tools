/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *     Sopot Cela <sopotcela@gmail.com>
 ******************************************************************************/
package org.eclipse.e4.internal.tools.wizards.classes;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.internal.tools.wizards.classes.AbstractNewClassPage.JavaClass;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.pde.core.project.IRequiredBundleDescription;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public abstract class AbstractNewClassWizard extends Wizard implements INewWizard {
	protected IPackageFragmentRoot root;
	protected IFile file;
	public AbstractNewClassWizard() {
		this.setWindowTitle("New contribution class");
	}
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		root = getFragmentRoot(getInitialJavaElement(selection));
	}

	protected IJavaElement getInitialJavaElement(IStructuredSelection selection) {
		IJavaElement jelem = null;
		if (selection != null && !selection.isEmpty()) {
			Object selectedElement = selection.getFirstElement();
			if (selectedElement instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable) selectedElement;

				jelem = (IJavaElement) adaptable.getAdapter(IJavaElement.class);
				if (jelem == null || !jelem.exists()) {
					jelem = null;
					IResource resource = (IResource) adaptable
							.getAdapter(IResource.class);
					if (resource != null
							&& resource.getType() != IResource.ROOT) {
						while (jelem == null
								&& resource.getType() != IResource.PROJECT) {
							resource = resource.getParent();
							jelem = (IJavaElement) resource
									.getAdapter(IJavaElement.class);
						}
						if (jelem == null) {
							jelem = JavaCore.create(resource); // java project
						}
					}
				}
			}
		}

		return jelem;
	}

	protected IPackageFragmentRoot getFragmentRoot(IJavaElement elem) {
		IPackageFragmentRoot initRoot = null;
		if (elem != null) {
			initRoot = (IPackageFragmentRoot) elem
					.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
			try {
				if (initRoot == null
						|| initRoot.getKind() != IPackageFragmentRoot.K_SOURCE) {
					IJavaProject jproject = elem.getJavaProject();
					if (jproject != null) {
						initRoot = null;
						if (jproject.exists()) {
							IPackageFragmentRoot[] roots = jproject
									.getPackageFragmentRoots();
							for (int i = 0; i < roots.length; i++) {
								if (roots[i].getKind() == IPackageFragmentRoot.K_SOURCE) {
									initRoot = roots[i];
									break;
								}
							}
						}
						if (initRoot == null) {
							initRoot = jproject.getPackageFragmentRoot(jproject
									.getResource());
						}
					}
				}
			} catch (JavaModelException e) {
				// TODO
				e.printStackTrace();
			}
		}
		return initRoot;
	}

	protected abstract String getContent();
	
	public JavaClass getDomainClass() {
		return ((AbstractNewClassPage) getPages()[0]).getClazz();
	}
	
	protected void checkRequiredBundles() {
		IProject project = getDomainClass().getFragmentRoot().getJavaProject().getProject();
		BundleContext context = FrameworkUtil.getBundle(NewAddonClassWizard.class).getBundleContext();
		ServiceReference<IBundleProjectService> ref = context.getServiceReference(IBundleProjectService.class);
		IBundleProjectService service = context.getService(ref);
		try {
			IBundleProjectDescription description = service.getDescription(project);
			Set<String> requiredBundles = getRequiredBundles();
			IRequiredBundleDescription[] arTmp = description.getRequiredBundles();
			List<IRequiredBundleDescription> descs = new ArrayList<IRequiredBundleDescription>();
			if( arTmp != null ) {
				descs.addAll(Arrays.asList(arTmp));
			}
			for( IRequiredBundleDescription bd : descs ) {
				requiredBundles.remove(bd.getName());
			}
			
			if( requiredBundles.size() > 0 ) {
				for( String b : requiredBundles ) {
					descs.add(service.newRequiredBundle(b, null, false, false));
				}
				description.setRequiredBundles(descs.toArray(new IRequiredBundleDescription[0]));
				description.apply(new NullProgressMonitor());
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Set<String> getRequiredBundles() {
		Set<String> rv = new HashSet<String>();
		rv.add("javax.inject");
		return rv;
	}
	
	@Override
	public boolean performFinish() {
		JavaClass clazz = getDomainClass();
		String content = getContent();
		
		if( clazz.getFragmentRoot() == null ) {
			return false;
		}
		
		checkRequiredBundles();
		
		IPackageFragment fragment = clazz.getPackageFragment();
		boolean exists = false;
		if (fragment != null) {
			IJavaElement[] children;
			try {
				children = clazz.getFragmentRoot().getChildren();
			
					for (IJavaElement iJavaElement : children) {
						IPackageFragment pf = (IPackageFragment) iJavaElement;
						if (pf.getElementName().equals(fragment.getElementName())){
						exists = true;
						break;
						}
					}
			;
			
			if (!exists)
				fragment = clazz.getFragmentRoot().createPackageFragment(fragment.getElementName(), true, null);
			} catch (JavaModelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String cuName = clazz.getName() + ".java";
			ICompilationUnit unit = fragment.getCompilationUnit(cuName); 
			IResource resource = unit.getResource();
			file = (IFile) resource;
			try {
				if (!file.exists()) {
					file.create(new ByteArrayInputStream(content.getBytes()),
							true, null);
				} else {
					file.setContents(new ByteArrayInputStream(content.getBytes()),
							IFile.FORCE | IFile.KEEP_HISTORY, null);
				}
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
//				unit.open(null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			String cuName = clazz.getName() + ".java";
			IFolder p = (IFolder) clazz.getFragmentRoot().getResource();
			file = p.getFile(cuName);
			try {
				if (!file.exists()) {
					file.create(new ByteArrayInputStream(content.getBytes()),
							true, null);
				} else {
					file.setContents(new ByteArrayInputStream(content.getBytes()),
							IFile.FORCE | IFile.KEEP_HISTORY, null);
				}
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;

	}
	
	public IFile getFile() {
		return file;
	}
}
