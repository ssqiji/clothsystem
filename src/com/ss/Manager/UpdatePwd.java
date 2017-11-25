package com.ss.Manager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.ILoginDao;
import com.ss.dao.impl.LoginDaoImpl;

import org.eclipse.swt.widgets.Label;

import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UpdatePwd {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private static Map<String,Object> map;

	public UpdatePwd(){
		super();
	}
	
	public UpdatePwd(Map<String,Object> map){
		UpdatePwd.map = map;
	}
	
	public static void main(String[] args) {
		try {
			UpdatePwd window = new UpdatePwd(map);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(UpdatePwd.class, "/images/yc.ico"));
		shell.setSize(393, 300);
		shell.setLocation(Display.getCurrent().getClientArea().width/2-shell.getSize().x/2, 
				Display.getCurrent().getClientArea().height/2-shell.getSize().y/2);
		shell.setText("修改密码");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("方正舒体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(61, 30, 64, 24);
		lblNewLabel.setText("原密码：");
		
		text = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text.setBounds(143, 29, 151, 29);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("方正舒体", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(61, 90, 64, 24);
		lblNewLabel_1.setText("新密码：");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(143, 87, 151, 29);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("方正舒体", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(64, 148, 73, 24);
		lblNewLabel_2.setText("确认密码：");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(143, 145, 151, 29);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		btnNewButton.setBounds(61, 210, 80, 27);
		btnNewButton.setText("确认修改");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(214, 210, 80, 27);
		btnNewButton_1.setText("取消");
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {  //确认修改
			@Override
			public void widgetSelected(SelectionEvent e) {
				String oldPwd = text.getText().trim();
				String newPwd = text_1.getText().trim();
				String renewPwd = text_2.getText().trim();
				
				if(!newPwd.equals(renewPwd)){
					MessageDialog.openError(shell, "错误提示", "您两次输入的密码不一致,请重新输入...");
					text.setText("");
					text_1.setText("");
					text_2.setText("");
				}else{
					ILoginDao loginDao = new LoginDaoImpl();
					int result = loginDao.updatePwd(String.valueOf(map.get("staname")), oldPwd, newPwd);
					if(result > 0){
						String staname = String.valueOf(map.get("staname"));
						map.clear();
						map.put("stapwd", newPwd);
						map.put("staname", staname);
						Manager.map = map;
						MessageDialog.openInformation(shell, "成功提示", "密码修改成功...");
						shell.dispose();
					}else{
						MessageDialog.openError(shell, "失败提示", "密码修改失败...");
					}
				}
			}
		});
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {  //取消修改
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
	}
}
