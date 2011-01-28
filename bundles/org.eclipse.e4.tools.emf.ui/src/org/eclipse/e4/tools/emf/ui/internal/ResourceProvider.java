package org.eclipse.e4.tools.emf.ui.internal;

import org.eclipse.e4.tools.services.AbstractBundleResourceProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ResourceProvider extends AbstractBundleResourceProvider {
	public static final String IMG_Addons = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Addons"; //$NON-NLS-1$
	public static final String IMG_Application = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Application"; //$NON-NLS-1$
	public static final String IMG_Area_vertical = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Area_vertical"; //$NON-NLS-1$
	public static final String IMG_Area = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Area"; //$NON-NLS-1$
	public static final String IMG_BindingContext = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.BindingContext"; //$NON-NLS-1$
	public static final String IMG_BindingTable = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.BindingTable"; //$NON-NLS-1$
	public static final String IMG_Category = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Category"; //$NON-NLS-1$
	public static final String IMG_Command = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Command"; //$NON-NLS-1$
	public static final String IMG_CommandParameter = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.CommandParameter"; //$NON-NLS-1$
	public static final String IMG_CoreExpression = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.CoreExpression"; //$NON-NLS-1$
	public static final String IMG_DirectMenuItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.DirectMenuItem"; //$NON-NLS-1$
	public static final String IMG_DirectToolItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.DirectToolItem"; //$NON-NLS-1$
	public static final String IMG_HandledMenuItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.HandledMenuItem"; //$NON-NLS-1$
	public static final String IMG_HandledToolItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.HandledToolItem"; //$NON-NLS-1$
	public static final String IMG_Handler = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Handler"; //$NON-NLS-1$
	public static final String IMG_KeyBinding = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.KeyBinding"; //$NON-NLS-1$
	public static final String IMG_Menu = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Menu"; //$NON-NLS-1$
	public static final String IMG_MenuContribution = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.MenuContribution"; //$NON-NLS-1$
	public static final String IMG_MenuItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.MenuItem"; //$NON-NLS-1$
	public static final String IMG_MenuSeparator = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.MenuSeparator"; //$NON-NLS-1$
	public static final String IMG_ModelFragments = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.ModelFragments"; //$NON-NLS-1$
	public static final String IMG_Parameter = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Parameter"; //$NON-NLS-1$
	public static final String IMG_Part = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Part"; //$NON-NLS-1$
	public static final String IMG_PartDescriptor = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.PartDescriptor"; //$NON-NLS-1$
	public static final String IMG_PartSashContainer_vertical = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.PartSashContainer_vertical"; //$NON-NLS-1$
	public static final String IMG_PartSashContainer = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.PartSashContainer"; //$NON-NLS-1$
	public static final String IMG_PartStack = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.PartStack"; //$NON-NLS-1$
	public static final String IMG_Perspective = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Perspective"; //$NON-NLS-1$
	public static final String IMG_PerspectiveStack = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.PerspectiveStack"; //$NON-NLS-1$
	public static final String IMG_Placeholder = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Placeholder"; //$NON-NLS-1$
	public static final String IMG_StringModelFragment = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.StringModelFragment"; //$NON-NLS-1$
	public static final String IMG_ToolBar = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.ToolBar"; //$NON-NLS-1$
	public static final String IMG_ToolBarContribution = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.ToolBarContribution"; //$NON-NLS-1$
	public static final String IMG_ToolBarSeparator = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.ToolBarSeparator"; //$NON-NLS-1$
	public static final String IMG_ToolControl = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.ToolControl"; //$NON-NLS-1$
	public static final String IMG_TrimContribution = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.TrimContribution"; //$NON-NLS-1$
	public static final String IMG_Window = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.Window"; //$NON-NLS-1$
	public static final String IMG_WindowTrim = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.WindowTrim"; //$NON-NLS-1$

	public static final String IMG_Tbr_Addons = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Addons"; //$NON-NLS-1$
	public static final String IMG_Tbr_Application = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Application"; //$NON-NLS-1$
	public static final String IMG_Tbr_Area_vertical = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Area_vertical"; //$NON-NLS-1$
	public static final String IMG_Tbr_Area = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Area"; //$NON-NLS-1$
	public static final String IMG_Tbr_BindingContext = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.BindingContext"; //$NON-NLS-1$
	public static final String IMG_Tbr_BindingTable = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.BindingTable"; //$NON-NLS-1$
	public static final String IMG_Tbr_CommandParameter = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.CommandParameter"; //$NON-NLS-1$
	public static final String IMG_Tbr_DirectMenuItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.DirectMenuItem"; //$NON-NLS-1$
	public static final String IMG_Tbr_DirectToolItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.DirectToolItem"; //$NON-NLS-1$
	public static final String IMG_Tbr_HandledMenuItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.HandledMenuItem"; //$NON-NLS-1$
	public static final String IMG_Tbr_HandledToolItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.HandledToolItem"; //$NON-NLS-1$
	public static final String IMG_Tbr_Menu = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Menu"; //$NON-NLS-1$
	public static final String IMG_Tbr_MenuContribution = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.MenuContribution"; //$NON-NLS-1$
	public static final String IMG_Tbr_MenuItem = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.MenuItem"; //$NON-NLS-1$
	public static final String IMG_Tbr_MenuSeparator = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.MenuSeparator"; //$NON-NLS-1$
	public static final String IMG_Tbr_ModelFragments = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.ModelFragments"; //$NON-NLS-1$
	public static final String IMG_Tbr_Parameter = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Parameter"; //$NON-NLS-1$
	public static final String IMG_Tbr_Part = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Part"; //$NON-NLS-1$
	public static final String IMG_Tbr_PartDescriptor = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.PartDescriptor"; //$NON-NLS-1$
	public static final String IMG_Tbr_PartSashContainer_vertical = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.PartSashContainer_vertical"; //$NON-NLS-1$
	public static final String IMG_Tbr_PartSashContainer = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.PartSashContainer"; //$NON-NLS-1$
	public static final String IMG_Tbr_PartStack = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.PartStack"; //$NON-NLS-1$
	public static final String IMG_Tbr_Perspective = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Perspective"; //$NON-NLS-1$
	public static final String IMG_Tbr_PerspectiveStack = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.PerspectiveStack"; //$NON-NLS-1$
	public static final String IMG_Tbr_Placeholder = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Placeholder"; //$NON-NLS-1$
	public static final String IMG_Tbr_StringModelFragment = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.StringModelFragment"; //$NON-NLS-1$
	public static final String IMG_Tbr_ToolBar = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.ToolBar"; //$NON-NLS-1$
	public static final String IMG_Tbr_ToolBarContribution = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.ToolBarContribution"; //$NON-NLS-1$
	public static final String IMG_Tbr_ToolBarSeparator = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.ToolBarSeparator"; //$NON-NLS-1$
	public static final String IMG_Tbr_ToolControl = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.ToolControl"; //$NON-NLS-1$
	public static final String IMG_Tbr_TrimContribution = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.TrimContribution"; //$NON-NLS-1$
	public static final String IMG_Tbr_Window = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.Window"; //$NON-NLS-1$
	public static final String IMG_Tbr_WindowTrim = "IMG_org.eclipse.e4.tools.emf.ui.modelelements.tbr.WindowTrim"; //$NON-NLS-1$

	public static final String IMG_Obj16_arrow_down = "IMG_org.eclipse.e4.tools.emf.ui.obj16.arrow_down"; //$NON-NLS-1$
	public static final String IMG_Obj16_arrow_up = "IMG_org.eclipse.e4.tools.emf.ui.obj16.arrow_up"; //$NON-NLS-1$
	public static final String IMG_Obj16_class_obj = "IMG_org.eclipse.e4.tools.emf.ui.obj16.class_obj"; //$NON-NLS-1$
	public static final String IMG_Obj16_cross = "IMG_org.eclipse.e4.tools.emf.ui.obj16.cross"; //$NON-NLS-1$
	public static final String IMG_Obj16_EPackage = "IMG_org.eclipse.e4.tools.emf.ui.obj16.EPackage"; //$NON-NLS-1$
	public static final String IMG_Obj16_field_public_obj = "IMG_org.eclipse.e4.tools.emf.ui.obj16.field_public_obj"; //$NON-NLS-1$
	public static final String IMG_Obj16_headermenu = "IMG_org.eclipse.e4.tools.emf.ui.obj16.headermenu"; //$NON-NLS-1$
	public static final String IMG_Obj16_table_add = "IMG_org.eclipse.e4.tools.emf.ui.obj16.table_add"; //$NON-NLS-1$
	public static final String IMG_Obj16_table_delete = "IMG_org.eclipse.e4.tools.emf.ui.obj16.table_delete"; //$NON-NLS-1$
	public static final String IMG_Obj16_zoom = "IMG_org.eclipse.e4.tools.emf.ui.obj16.zoom"; //$NON-NLS-1$
	public static final String IMG_Obj16_application_form = "IMG_org.eclipse.e4.tools.emf.ui.obj16.application_form"; //$NON-NLS-1$
	public static final String IMG_Obj16_chart_organisation = "IMG_org.eclipse.e4.tools.emf.ui.obj16.chart_organisation"; //$NON-NLS-1$

	public static final String IMG_Wizban16_fieldrefact_wiz = "IMG_org.eclipse.e4.tools.emf.ui.wizban.fieldrefact_wiz"; //$NON-NLS-1$
	public static final String IMG_Wizban16_import_wiz = "IMG_org.eclipse.e4.tools.emf.ui.wizban.import_wiz"; //$NON-NLS-1$
	public static final String IMG_Wizban16_newclass_wiz = "IMG_org.eclipse.e4.tools.emf.ui.wizban.newclass_wiz"; //$NON-NLS-1$
	public static final String IMG_Wizban16_newexp_wiz = "IMG_org.eclipse.e4.tools.emf.ui.wizban.newexp_wiz"; //$NON-NLS-1$
	public static final String IMG_Wizban16_typerefact_wiz = "IMG_org.eclipse.e4.tools.emf.ui.wizban.typerefact_wiz"; //$NON-NLS-1$

	public Image getFont(Display display, String key) {
		return null;
	}

	public Image getColor(Display display, String key) {
		return null;
	}

}