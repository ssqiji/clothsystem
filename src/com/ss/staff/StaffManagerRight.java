package com.ss.staff;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.IStaffDao;
import com.ss.dao.PageInfo;
import com.ss.dao.impl.StaffDaoImpl;
import com.ss.util.ImageUtil;
import com.ss.util.StringUtil;

import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StaffManagerRight extends Composite {
	private Text text;
	private Text text_2;
	private Text text_3;
	private String filePath;  //图片路径
	private Combo combo ;  //员工职位
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public StaffManagerRight(Composite parent, int style) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(23, 38, 74, 23);
		lblNewLabel.setText("员工姓名：");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(108, 32, 185, 27);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(23, 137, 74, 23);
		lblNewLabel_1.setText("员工性别：");
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(23, 186, 74, 23);
		lblNewLabel_2.setText("员工年龄：");
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(108, 180, 185, 27);
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_3.setBounds(23, 238, 74, 23);
		lblNewLabel_3.setText("联系电话：");
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setBounds(108, 233, 185, 27);
		
		Label lblNewLabel_4 = new Label(this, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(23, 289, 74, 23);
		lblNewLabel_4.setText("员工职位：");
		
		combo = new Combo(this, SWT.NONE);
		combo.setBounds(108, 286, 185, 27);
		getRoles();  //添加元素
		
		Label lblNewLabel_5 = new Label(this, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(23, 340, 74, 23);
		lblNewLabel_5.setText("员工照片：");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(23, 393, 53, 27);
		btnNewButton.setText("上传");
		
		Label lblNewLabel_6 = new Label(this, SWT.BORDER);
		lblNewLabel_6.setBounds(153, 339, 140, 140);
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setBounds(23, 451, 112, 27);
		btnNewButton_1.setText("添加员工");
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(108, 132, 185, 27);
		combo_1.add("男");
		combo_1.add("女");
		
		Label lblNewLabel_7 = new Label(this, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_7.setBounds(23, 87, 74, 23);
		lblNewLabel_7.setText("员工密码：");
		
		text_1 = new Text(this, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(108, 80, 185, 29);
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.setBounds(82, 393, 53, 27);
		btnNewButton_2.setText("删除");

		btnNewButton.addSelectionListener(new SelectionAdapter() {  //上传照片
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog=new FileDialog(parent.getShell());
				fileDialog.setText("上传员工照片");
				fileDialog.setFilterExtensions(new String[]{"*.jpg","*.png","*.jpeg","*.ico","*.gif"});
				filePath = fileDialog.open();
				
				ImageUtil imageUtil=new ImageUtil();
				lblNewLabel_6.setImage(imageUtil.getImage(lblNewLabel_6, filePath));
			}
		});
		
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {  //删除照片
			@Override
			public void widgetSelected(SelectionEvent e) {
				filePath = null;
				lblNewLabel_6.setImage(null);
			}
		});
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {  //添加员工
			@Override
			public void widgetSelected(SelectionEvent e) {
				String staname = text.getText().trim();
				String stapwd = text_1.getText().trim();
				String stasex = combo_1.getText().trim();
				String staage = text_2.getText().trim();
				String statel = text_3.getText().trim();
				String rolid = combo.getText().trim();
				
				ImageUtil imageUtil = new ImageUtil();
				byte[] bt = imageUtil.getImageData(filePath);
				
				if(StringUtil.isNull(staname)){
					MessageDialog.openError(getShell(), "温馨提示", "员工姓名不能为空");
					return;
				}
				
				if(StringUtil.isNull(stapwd)){
					MessageDialog.openError(getShell(), "温馨提示", "员工密码不能为空");
					return;
				}
				
				if(StringUtil.isNull(stasex)){
					MessageDialog.openError(getShell(), "温馨提示", "员工性别不能为空");
					return;
				}
				
				if(StringUtil.isNull(staage)){
					MessageDialog.openError(getShell(), "温馨提示", "员工年龄不能为空");
					return;
				}
				
				if(StringUtil.isNull(statel)){
					MessageDialog.openError(getShell(), "温馨提示", "联系电话不能为空");
					return;
				}
				
				if(StringUtil.isNull(rolid)){
					MessageDialog.openError(getShell(), "温馨提示", "员工职位不能为空");
					return;
				}
				
				IStaffDao staffDao = new StaffDaoImpl();
				int result = staffDao.addStaff(staname, stapwd, stasex, staage, statel, bt, rolid);
				
				if(result > 0){
					text.setText("");
					text_1.setText("");
					combo_1.setText("");
					text_2.setText("");
					text_3.setText("");
					combo.setText("");
					lblNewLabel_6.setImage(null);
					filePath = null;
					
					StaffManager.pageInfo = new PageInfo(1, 2, staffDao.total());
					StaffManager.list = staffDao.findStaff(StaffManager.pageInfo.getPageNo(), 
							StaffManager.pageInfo.getPageSize());
					StaffManager.showData(StaffManager.list);  //刷新数据
					
					StaffManager.lblNewLabel_1.setText(String.valueOf(StaffManager.pageInfo.getTotalPage()));
					StaffManager.lblNewLabel_3.setText(String.valueOf(StaffManager.pageInfo.getPageSize()));
					StaffManager.lblNewLabel_6.setText(String.valueOf(StaffManager.pageInfo.getTotalSize()));
					StaffManager.lblNewLabel_9.setText(String.valueOf(StaffManager.pageInfo.getPageNo()));
					
					MessageDialog.openInformation(getShell(), "成功提示", "添加员工信息成功...");
				}else{
					MessageDialog.openError(getShell(), "失败提示", "添加员工信息失败...");
				}
			}
		});
	}

	public void getRoles(){
		IStaffDao staffDao = new StaffDaoImpl();
		List<Map<String,Object>> list = staffDao.getRoles();
		if(list != null && list.size()>0){
			for(Map<String,Object> map:list){
				combo.add(String.valueOf(map.get("rolname")));
			}
		}
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
