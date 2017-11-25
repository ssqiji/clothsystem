package com.ss.purchase;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.IPurchaseDao;
import com.ss.dao.impl.PurchaseImpl;

import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

public class PurchaseManagerRight extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PurchaseManagerRight(Composite parent, int style) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(32, 214, 80, 27);
		btnNewButton.setText("查询");
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(32, 38, 62, 17);
		lblNewLabel.setText("经办人：");
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(99, 35, 171, 25);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(30, 100, 61, 17);
		lblNewLabel_1.setText("供应商：");
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(99, 97, 171, 25);
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setBounds(30, 157, 61, 17);
		lblNewLabel_2.setText("进货时间：");

		//判断进货的服装有没有销售过
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//String goodid = text.getText().trim();
				IPurchaseDao purchaseDao = new PurchaseImpl();
				//Map<String,Object> map = purchaseDao.findIfExit(goodid);
				//if(map != null && map.size()>0){
					ClothExitAdd dialog = new ClothExitAdd(getShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			//		dialog.open(map);
				//}else{
					System.out.println("服装不存在");
				//}
			}
		});
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
