package com.ss.Manager;

import org.eclipse.swt.custom.StackLayout;

import com.ss.cloth.ClothManagerRight;
import com.ss.purchase.PurchaseManagerRight;
import com.ss.staff.StaffManagerRight;
import com.ss.supplier.SupplierManagerRight;

public class StaticManagerRight {
	public static StackLayout stackLayout = new StackLayout();
	public static InitCompositeRight initCompositeRight;  //初始化面板右
	public static SupplierManagerRight supplierManagerRight;  //供应商面板右
	public static StaffManagerRight staffManagerRight;  //员工面板右
	public static ClothManagerRight clothManagerRight;  //服装管理面板右
	public static PurchaseManagerRight purchaseManagerRight;  //进货管理面板右
}
