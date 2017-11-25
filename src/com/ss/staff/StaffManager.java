package com.ss.staff;

import org.eclipse.swt.widgets.Composite;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.IStaffDao;
import com.ss.dao.PageInfo;
import com.ss.dao.impl.StaffDaoImpl;
import com.ss.util.ImageUtil;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.MenuItem;

/**
 * 员工面板
 * @author 神兽
 * 2017-10-18
 */
public class StaffManager extends Composite {
	private static Table table;
	
	public static Label lblNewLabel_1;  //总页数
	public static Label lblNewLabel_3;  //每页多少条
	public static Label lblNewLabel_6;  //共多少条
	public static Label lblNewLabel_9;  //当前第几页
	
	IStaffDao staffDao;  //员工操作
	public static PageInfo pageInfo;  //分页查询
	public static List<Map<String,Object>> list;  //所有员工信息

	public StaffManager(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		table.setBackground(SWTResourceManager.getColor(255, 255, 204));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.LEFT);
		tblclmnNewColumn.setWidth(60);
		tblclmnNewColumn.setText(" 照片");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(79);
		tblclmnNewColumn_1.setText("编号");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(140);
		tblclmnNewColumn_2.setText("姓名");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(109);
		tblclmnNewColumn_3.setText("性别");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(109);
		tblclmnNewColumn_4.setText("年龄");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_5.setWidth(178);
		tblclmnNewColumn_5.setText("联系电话");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_6.setWidth(155);
		tblclmnNewColumn_6.setText("职位");
		
		TableCursor tableCursor = new TableCursor(table, SWT.NONE);
		Menu menu = new Menu(tableCursor);
		tableCursor.setMenu(menu);
		
		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.setText("修改");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu, SWT.NONE);
		mntmNewItem_1.setText("删除");
		
		staffDao = new StaffDaoImpl();
		pageInfo = new PageInfo(1, 2, staffDao.total());
		list = staffDao.findStaff(pageInfo.getPageNo(), pageInfo.getPageSize());
		
		showData(list);  //显示表格数据
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_1.setBackground(SWTResourceManager.getColor(255, 255, 204));
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(29, 22, 61, 17);
		lblNewLabel.setText("总页数：");
		
		lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(91, 22, 22, 17);
		lblNewLabel_1.setText(String.valueOf(pageInfo.getTotalPage()));  //总页数
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(122, 22, 37, 17);
		lblNewLabel_2.setText("每页");
		
		lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_3.setBounds(165, 22, 22, 17);
		lblNewLabel_3.setText(String.valueOf(pageInfo.getPageSize()));  //每页多少条
		
		Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(193, 22, 22, 17);
		lblNewLabel_4.setText("条");
		
		Label lblNewLabel_5 = new Label(composite_1, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(226, 22, 16, 17);
		lblNewLabel_5.setText("共");
		
		lblNewLabel_6 = new Label(composite_1, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_6.setBounds(248, 22, 22, 17);
		lblNewLabel_6.setText(String.valueOf(pageInfo.getTotalSize()));  //总共多少条
		
		Label lblNewLabel_7 = new Label(composite_1, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_7.setBounds(276, 22, 48, 17);
		lblNewLabel_7.setText("条数据");
		
		Label lblNewLabel_8 = new Label(composite_1, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_8.setBounds(339, 22, 48, 17);
		lblNewLabel_8.setText("当前第");
		
		lblNewLabel_9 = new Label(composite_1, SWT.NONE);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_9.setBounds(400, 22, 22, 17);
		lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));  //当前第几页
		
		Label lblNewLabel_10 = new Label(composite_1, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_10.setBounds(428, 22, 22, 17);
		lblNewLabel_10.setText("页");
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setBounds(528, 18, 80, 27);
		btnNewButton.setText("上一页");
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setBounds(675, 18, 80, 27);
		btnNewButton_1.setText("下一页");
		sashForm.setWeights(new int[] {521, 60});

		btnNewButton.addSelectionListener(new SelectionAdapter() {  //上一页
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageInfo.front();
				list = staffDao.findStaff(pageInfo.getPageNo(), pageInfo.getPageSize());
				showData(list); 
				lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
			}
		});
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {  //下一页
			@Override
			public void widgetSelected(SelectionEvent e) {
				pageInfo.next();
				list = staffDao.findStaff(pageInfo.getPageNo(), pageInfo.getPageSize());
				showData(list); 
				lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
			}
		});
		
		mntmNewItem.addSelectionListener(new SelectionAdapter() {  //修改
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = tableCursor.getRow();
				UpdateStaff dialog = new UpdateStaff(getShell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
				dialog.open(item,item.getImage(0));
			}
		});
		
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {  //删除
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(MessageDialog.openConfirm(getShell(), "删除提示", "数据一旦删除将无法恢复\n您确定要删除吗？")){
					TableItem item = tableCursor.getRow();
					int result = staffDao.deleteStaff(Integer.parseInt(item.getText(1)));
					
					if(result > 0){
						pageInfo = new PageInfo(1,2,staffDao.total());
						List<Map<String,Object>> list = staffDao.findStaff(pageInfo.getPageNo(), pageInfo.getPageSize());
						showData(list);
						lblNewLabel_1.setText(String.valueOf(pageInfo.getTotalPage()));
						lblNewLabel_3.setText(String.valueOf(pageInfo.getPageSize()));
						lblNewLabel_6.setText(String.valueOf(pageInfo.getTotalSize()));
						lblNewLabel_9.setText(String.valueOf(pageInfo.getPageNo()));
						MessageDialog.openInformation(getShell(), "成功提示", "员工信息删除成功...");
					}else{
						MessageDialog.openError(getShell(), "失败提示", "员工信息删除失败...");
					}
				}
			}
		});
	}

	public static void showData(List<Map<String,Object>> list){  //显示表格数据
		table.removeAll();
		
		if(list != null && list.size()>0){
			TableItem ti = null;
			ImageUtil imageUtil = new ImageUtil();
			for(Map<String,Object> map:list){
				ti = new TableItem(table, SWT.NONE);
				
				Object obj = map.get("staphoto");
				if(obj != null && obj instanceof byte[]){
					byte []bt = (byte[]) obj;
					ti.setImage(imageUtil.getImage(bt, 60, 60));
				}
				ti.setText(1, String.valueOf(map.get("staid")));
				ti.setText(2, String.valueOf(map.get("staname")));
				ti.setText(3, String.valueOf(map.get("stasex")));
				ti.setText(4, String.valueOf(map.get("staage")));
				ti.setText(5, String.valueOf(map.get("statel")));
				ti.setText(6, String.valueOf(map.get("rolname")));
			}
		}
	}
	
	@Override
	protected void checkSubclass() {
	}
}
