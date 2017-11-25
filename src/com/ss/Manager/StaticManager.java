package com.ss.Manager;

import org.eclipse.swt.custom.StackLayout;

import com.ss.cloth.ClothManager;
import com.ss.purchase.PurchaseManager;
import com.ss.staff.StaffManager;
import com.ss.supplier.SupplierManager;

public class StaticManager {
	public static StackLayout stackLayout = new StackLayout();
	public static InitComposite initComposite;  //初始化面板左
	public static SupplierManager supplierManager;  //供应商面板
	public static StaffManager staffManager;  //员工面板
	public static ClothManager clothManager;  //服装面板
	public static PurchaseManager purchaseManager;  //进货面板
}
