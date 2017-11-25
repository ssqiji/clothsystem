package com.ss.staff;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.IStaffDao;
import com.ss.dao.impl.StaffDaoImpl;
import com.ss.util.ImageUtil;
import com.ss.util.StringUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

public class UpdateStaff extends Dialog {

	protected Object result;
	protected Shell shell;
	private TableItem item;
	private Image image;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private ImageUtil imageUtil;
	private String filePath = null;
	private Combo combo_1;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UpdateStaff(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(TableItem item, Image image) {
		this.item = item;
		this.image = image;
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(467, 353);
		shell.setLocation(Display.getCurrent().getClientArea().width/2-shell.getSize().x/2,
				Display.getCurrent().getClientArea().height/2-shell.getSize().y/2);
		shell.setText("修改员工信息");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(35, 25, 75, 15);
		lblNewLabel.setText("员工编号：");
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(117, 20, 154, 27);
		text.setText(String.valueOf(item.getText(1)));
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(35, 74, 75, 17);
		lblNewLabel_1.setText("员工姓名：");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(117, 68, 154, 27);
		text_1.setText(String.valueOf(item.getText(2)));
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(35, 123, 75, 17);
		lblNewLabel_2.setText("员工性别：");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(118, 117, 153, 25);
		combo.add("男");
		combo.add("女");
		combo.setText(String.valueOf(item.getText(3)));
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_3.setBounds(35, 170, 75, 17);
		lblNewLabel_3.setText("员工年龄：");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(117, 164, 154, 27);
		text_2.setText(String.valueOf(item.getText(4)));
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(35, 219, 75, 17);
		lblNewLabel_4.setText("联系电话：");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(117, 213, 154, 27);
		text_3.setText(String.valueOf(item.getText(5)));
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(34, 265, 69, 17);
		lblNewLabel_5.setText("员工职位：");
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_6.setBounds(309, 22, 71, 17);
		lblNewLabel_6.setText("员工照片：");
		
		Label lblNewLabel_7 = new Label(shell, SWT.BORDER);
		lblNewLabel_7.setBounds(311, 57, 60, 60);
		imageUtil = new ImageUtil();
		lblNewLabel_7.setImage(image);
		
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(389, 56, 45, 27);
		btnNewButton.setText("上传");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(310, 148, 124, 27);
		btnNewButton_1.setText("确认修改");
		
		combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(118, 261, 153, 25);
		combo_1.setText(String.valueOf(item.getText(6)));
		getRoles();
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(389, 93, 45, 27);
		btnNewButton_2.setText("删除");
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {  //上传照片
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog=new FileDialog(shell);
				fileDialog.setText("上传员工照片");
				fileDialog.setFilterExtensions(new String[]{"*.jpg","*.png","*.jpeg","*.ico","*.gif"});
				filePath = fileDialog.open();
				
				lblNewLabel_7.setImage(imageUtil.getImage(filePath, 60, 60));
			}
		});
		
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {  //删除照片
			@Override
			public void widgetSelected(SelectionEvent e) {
				filePath = null;
				lblNewLabel_7.setImage(null);
			}
		});
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {  //确认修改
			@Override
			public void widgetSelected(SelectionEvent e) {
				int staid = Integer.parseInt(text.getText().trim());
				String stasex = combo.getText().trim();
				String staage = text_2.getText().trim();
				String statel = text_3.getText().trim();
				String rolid = combo_1.getText().trim();
				
				if(StringUtil.isNull(staage)){
					MessageDialog.openError(shell, "温馨提示", "员工年龄不能为空...");
					return;
				}
				
				if(StringUtil.isNull(statel)){
					MessageDialog.openError(shell, "温馨提示", "联系电话不能为空...");
					return;
				}
				
				byte []bt = null;
				boolean flag = false;
				if(filePath != null){
					bt = imageUtil.getImageData(filePath);
				}else if(filePath == null && lblNewLabel_7.getImage() != image){
					flag = true;
				}else{
					bt = null;
				}
				
				IStaffDao staffDao = new StaffDaoImpl();
				int result = 0;
				if(flag || bt != null){
					result = staffDao.updateStaff(staid,stasex, staage, statel, bt, rolid);
				}else{
					result = staffDao.updateStaff(staid,stasex, staage, statel, rolid);
				}
				
				if(result > 0){
					text.setText("");
					text_1.setText("");
					combo.setText("");
					text_2.setText("");
					text_3.setText("");
					combo_1.setText("");
					lblNewLabel_7.setImage(null);
					filePath = null;
					
					
					StaffManager.list = staffDao.findStaff(StaffManager.pageInfo .getPageNo(), 
							StaffManager.pageInfo.getPageSize());
					StaffManager.showData(StaffManager.list);
					MessageDialog.openInformation(shell, "成功提示", "修改员工信息成功...");
					shell.dispose();
				}else{
					MessageDialog.openError(shell, "失败提示", "修改员工信息失败...");
				}
			}
		});
	}
	
	public void getRoles(){
		IStaffDao staffDao = new StaffDaoImpl();
		List<Map<String,Object>> list = staffDao.getRoles();
		if(list != null && list.size()>0){
			for(Map<String,Object> map:list){
				combo_1.add(String.valueOf(map.get("rolname")));
			}
		}
	}
}
