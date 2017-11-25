package com.ss.supplier;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.ISupplierDao;
import com.ss.dao.PageInfo;
import com.ss.dao.impl.SupplierDaoImpl;
import com.ss.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SupplierManagerRight extends Composite {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SupplierManagerRight(Composite parent, int style) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(26, 43, 88, 24);
		lblNewLabel.setText("供应商名称：");
		
		text = new Text(this, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(255, 255, 204));
		text.setBounds(120, 39, 191, 27);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(26, 99, 88, 24);
		lblNewLabel_1.setText("供应商地址：");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(255, 255, 204));
		text_1.setBounds(121, 95, 191, 27);
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(26, 154, 88, 26);
		lblNewLabel_2.setText("联系人姓名：");
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(255, 255, 204));
		text_2.setBounds(120, 150, 191, 27);
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_3.setBounds(26, 209, 88, 24);
		lblNewLabel_3.setText("联系人电话：");
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBackground(SWTResourceManager.getColor(255, 255, 204));
		text_3.setBounds(120, 206, 191, 27);
		
		Label lblNewLabel_4 = new Label(this, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(26, 267, 88, 24);
		lblNewLabel_4.setText("联系人邮箱：");
		
		text_4 = new Text(this, SWT.BORDER);
		text_4.setBackground(SWTResourceManager.getColor(255, 255, 204));
		text_4.setBounds(120, 264, 191, 27);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBackground(SWTResourceManager.getColor(240, 230, 140));
		btnNewButton.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		btnNewButton.setBounds(47, 338, 80, 27);
		btnNewButton.setText("添加");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		btnNewButton_1.setBounds(203, 340, 80, 27);
		btnNewButton_1.setText("查询");

		btnNewButton.addSelectionListener(new SelectionAdapter() {  //添加供应商
			@Override
			public void widgetSelected(SelectionEvent e) {
				String supname = text.getText().trim();
				String supaddress = text_1.getText().trim();
				String supcontacts = text_2.getText().trim();
				String suptel = text_3.getText().trim();
				String supemail = text_4.getText().trim();
				
				if(supname == null || "".equals(supname)){
					MessageDialog.openError(getShell(), "温馨提示", "供应商名字不能为空...");
					return;
				}
				
				if(supaddress == null || "".equals(supaddress)){
					MessageDialog.openError(getShell(), "温馨提示", "供应商地址不能为空...");
					return;
				}
				
				if(supcontacts == null || "".equals(supcontacts)){
					MessageDialog.openError(getShell(), "温馨提示", "联系人姓名不能为空...");
					return;
				}
				
				if(suptel == null || "".equals(suptel)){
					MessageDialog.openError(getShell(), "温馨提示", "联系人电话不能为空...");
					return;
				}
				
				ISupplierDao supplierDao = new SupplierDaoImpl();
				int result = supplierDao.addSupplier(supname, supaddress, supcontacts, suptel, supemail);
				
				if(result > 0){
					text.setText("");
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					
					SupplierManager.pageInfo = new PageInfo(1,2,supplierDao.total());
					List<Map<String,Object>> list = supplierDao.findSupplier(SupplierManager.pageInfo.getPageNo(), SupplierManager.pageInfo.getPageSize());
					SupplierManager.showData(list);
					SupplierManager.lblNewLabel_1.setText(String.valueOf(SupplierManager.pageInfo.getTotalPage()));
					SupplierManager.lblNewLabel_3.setText(String.valueOf(SupplierManager.pageInfo.getPageSize()));
					SupplierManager.lblNewLabel_6.setText(String.valueOf(SupplierManager.pageInfo.getTotalSize()));
					SupplierManager.lblNewLabel_9.setText(String.valueOf(SupplierManager.pageInfo.getPageNo()));
					
					MessageDialog.openInformation(getShell(), "成功提示", "添加供应商信息成功...");
				}else{
					MessageDialog.openError(getShell(), "失败提示", "添加供应商信息失败...");
				}
			}
		});
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() { //条件查询
			@Override
			public void widgetSelected(SelectionEvent e) {
				String supname = text.getText().trim();
				String supaddress = text_1.getText().trim();
				String supcontacts = text_2.getText().trim();
				String suptel = text_3.getText().trim();
				
				Map<String,String> map=new HashMap<String,String>();
				if(!StringUtil.isNull(supname)){
					map.put("supname like ", "%"+supname+"%");
				}
				
				if(!StringUtil.isNull(supaddress)){
					map.put("supaddress like ", "%"+supaddress+"%");
				}
				
				if(!StringUtil.isNull(supcontacts)){
					map.put("supcontacts like ", "%"+supcontacts+"%");
				}
				
				if(!StringUtil.isNull(suptel)){
					map.put("suptel like ", "%"+suptel+"%");
				}
				
				ISupplierDao supplierDao = new SupplierDaoImpl();
				if(map != null && map.size()>0){
					SupplierManager.btnNewButton.setEnabled(false);
					SupplierManager.btnNewButton_1.setEnabled(false);
					
					List<Map<String,Object>> list = supplierDao.findByIf(map, 1, 2);
					SupplierManager.showData(list);
					SupplierManager.lblNewLabel_1.setText(String.valueOf(1));
					SupplierManager.lblNewLabel_3.setText(String.valueOf(list.size()));
					SupplierManager.lblNewLabel_6.setText(String.valueOf(list.size()));
					SupplierManager.lblNewLabel_9.setText(String.valueOf(1));
				}else{
					SupplierManager.btnNewButton.setEnabled(true);
					SupplierManager.btnNewButton_1.setEnabled(true);
					SupplierManager.pageInfo = new PageInfo(1,2,supplierDao.total());
					List<Map<String,Object>> list = supplierDao.findSupplier(SupplierManager.pageInfo.getPageNo(), SupplierManager.pageInfo.getPageSize());
					SupplierManager.showData(list);
					SupplierManager.lblNewLabel_1.setText(String.valueOf(SupplierManager.pageInfo.getTotalPage()));
					SupplierManager.lblNewLabel_3.setText(String.valueOf(SupplierManager.pageInfo.getPageSize()));
					SupplierManager.lblNewLabel_6.setText(String.valueOf(SupplierManager.pageInfo.getTotalSize()));
					SupplierManager.lblNewLabel_9.setText(String.valueOf(SupplierManager.pageInfo.getPageNo()));
				}
			}
		});
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
