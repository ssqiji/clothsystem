package com.ss.supplier;

import org.eclipse.swt.widgets.Composite;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.ISupplierDao;
import com.ss.dao.PageInfo;
import com.ss.dao.impl.SupplierDaoImpl;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.MenuItem;

/**
 * 供应商面板
 * @author 神兽
 * 2017-10-18
 */
public class SupplierManager extends Composite {
	private static Table table;
	public static Label lblNewLabel_1;  //总页数
	public static Label lblNewLabel_3;  //每页多少条
	public static Label lblNewLabel_6;  //共多少条
	public static Label lblNewLabel_9;  //当前第几页
	public static PageInfo pageInfo;
	public static Button btnNewButton;  //上一页
	public static Button btnNewButton_1;  //下一页

	public SupplierManager(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(255, 255, 204));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		table.setForeground(SWTResourceManager.getColor(0, 51, 102));
		table.setBackground(SWTResourceManager.getColor(255, 255, 204));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(62);
		tblclmnNewColumn.setText(" 编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(205);
		tblclmnNewColumn_1.setText("供应商名称");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(187);
		tblclmnNewColumn_2.setText("供应商地址");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(107);
		tblclmnNewColumn_3.setText("联系人");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(155);
		tblclmnNewColumn_4.setText("联系电话");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_5.setWidth(122);
		tblclmnNewColumn_5.setText("邮箱");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		Menu menu=new Menu(tableCursor);
		tableCursor.setMenu(menu);
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("修改");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_1.setText("删除");
		
		ISupplierDao supplierDao = new SupplierDaoImpl();
		pageInfo = new PageInfo(1,2,supplierDao.total());
		List<Map<String,Object>> list = supplierDao.findSupplier(pageInfo.getPageNo(), pageInfo.getPageSize());
		
		showData(list);  //显示表格数据
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setBackground(SWTResourceManager.getColor(255, 255, 204));
		
		btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setBounds(537, 14, 80, 31);
		btnNewButton.setText("上一页");
		
		btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setBounds(657, 14, 80, 31);
		btnNewButton_1.setText("下一页");
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(50, 24, 64, 22);
		lblNewLabel.setText("总页数：");
		
		lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("方正舒体", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(120, 21, 27, 24);
		lblNewLabel_1.setText(String.valueOf(pageInfo.getTotalPage()));
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(151, 24, 37, 24);
		lblNewLabel_2.setText("每页");
		
		lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("方正舒体", 12, SWT.NORMAL));
		lblNewLabel_3.setBounds(194, 21, 20, 17);
		lblNewLabel_3.setText(String.valueOf(pageInfo.getPageSize()));
		
		Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(218, 24, 20, 22);
		lblNewLabel_4.setText("条");
		
		Label lblNewLabel_5 = new Label(composite_1, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(248, 24, 20, 17);
		lblNewLabel_5.setText("共");
		
		lblNewLabel_6 = new Label(composite_1, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("方正舒体", 12, SWT.NORMAL));
		lblNewLabel_6.setBounds(268, 21, 27, 17);
		lblNewLabel_6.setText(String.valueOf(pageInfo.getTotalSize()));
		
		Label lblNewLabel_7 = new Label(composite_1, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_7.setBounds(294, 24, 48, 18);
		lblNewLabel_7.setText("条数据");
		
		Label lblNewLabel_8 = new Label(composite_1, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_8.setBounds(357, 24, 48, 17);
		lblNewLabel_8.setText("当前第");
		
		lblNewLabel_9 = new Label(composite_1, SWT.NONE);
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_9.setBounds(412, 24, 20, 17);
		lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
		
		Label lblNewLabel_10 = new Label(composite_1, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_10.setBounds(435, 24, 27, 21);
		lblNewLabel_10.setText("页");
		sashForm.setWeights(new int[] {524, 57});
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {  //上一页
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageInfo.front();
				List<Map<String,Object>> list = supplierDao.findSupplier(pageInfo.getPageNo(), pageInfo.getPageSize());
				showData(list);
				lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
			}
		});
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {  //下一页
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageInfo.next();
				List<Map<String,Object>> list = supplierDao.findSupplier(pageInfo.getPageNo(), pageInfo.getPageSize());
				showData(list);
				lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
			}
		});
		
		mntmNewItem.addSelectionListener(new SelectionAdapter() {  //修改
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = tableCursor.getRow();
				UpdateSupplier dialog = new UpdateSupplier(getShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
				dialog.open(item);
			}
		});
		
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {  //删除
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(MessageDialog.openConfirm(getShell(), "删除提示", "数据一旦删除将无法恢复\n您确定要删除吗？")){
					TableItem item = tableCursor.getRow();
					int result = supplierDao.deleteSupplier(Integer.parseInt(item.getText(0)));
					
					if(result > 0){
						pageInfo = new PageInfo(1,2,supplierDao.total());
						List<Map<String,Object>> list = supplierDao.findSupplier(pageInfo.getPageNo(), pageInfo.getPageSize());
						showData(list);
						lblNewLabel_1.setText(String.valueOf(pageInfo.getTotalPage()));
						lblNewLabel_3.setText(String.valueOf(pageInfo.getPageSize()));
						lblNewLabel_6.setText(String.valueOf(pageInfo.getTotalSize()));
						lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
						MessageDialog.openInformation(getShell(), "成功提示", "供应商信息删除成功...");
					}else{
						MessageDialog.openError(getShell(), "失败提示", "供应商信息删除失败...");
					}
				}
			}
		});
	}
	
	public static void showData(List<Map<String,Object>> list){  //显示表格数据
		table.removeAll();
		
		if(list != null && list.size()>0){
			TableItem ti = null;
			for(Map<String,Object> map:list){
				ti = new TableItem(table, SWT.NONE);
				ti.setText(0, String.valueOf(map.get("supid")));
				ti.setText(1, String.valueOf(map.get("supname")));
				ti.setText(2, String.valueOf(map.get("supaddress")));
				ti.setText(3, String.valueOf(map.get("supcontacts")));
				ti.setText(4, String.valueOf(map.get("suptel")));
				ti.setText(5, String.valueOf(map.get("supemail")));
			}
		}
	}

	@Override
	protected void checkSubclass() {
	}
}
