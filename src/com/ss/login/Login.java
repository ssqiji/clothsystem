package com.ss.login;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.Manager.Manager;
import com.ss.dao.ILoginDao;
import com.ss.dao.impl.LoginDaoImpl;

import org.eclipse.swt.widgets.Composite;

import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.widgets.Text;

/**
 * 登录页面
 * @author 神兽
 *	2017-10-17
 */
public class Login {
	Display display;
	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
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
		shell = new Shell(display,SWT.NONE);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setImage(SWTResourceManager.getImage(Login.class, "/images/yc.ico"));
		shell.setSize(459, 317);
		shell.setLocation(Display.getCurrent().getClientArea().width/2-shell.getSize().x/2,
				Display.getCurrent().getClientArea().height/2-shell.getSize().y/2);
		shell.setText("服装管理系统登录");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setForeground(SWTResourceManager.getColor(0, 0, 139));
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackgroundImage(SWTResourceManager.getImage(Login.class, "/images/background.jpg"));
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(30, 23, 214, 33);
		lblNewLabel.setText("服装管理系统后台登录");
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_close_normal.png"));
		lblNewLabel_1.setBounds(418, 0, 39, 20);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_mini_normal.png"));
		lblNewLabel_2.setBounds(390, 0, 28, 20);
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_3.setBounds(88, 88, 56, 26);
		lblNewLabel_3.setText("账号：");
		
		text = new Text(composite, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		text.setBackground(SWTResourceManager.getColor(0, 0, 139));
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text.setBounds(165, 83, 192, 33);
		
		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_4.setBounds(88, 151, 56, 26);
		lblNewLabel_4.setText("密码：");
		
		text_1 = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		text_1.setBackground(SWTResourceManager.getColor(0, 0, 139));
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		text_1.setBounds(165, 148, 192, 33);
		
		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		
		lblNewLabel_5.setImage(SWTResourceManager.getImage(Login.class, "/images/login.jpg"));
		lblNewLabel_5.setBounds(109, 220, 85, 42);
		
		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setImage(SWTResourceManager.getImage(Login.class, "/images/reset.jpg"));
		lblNewLabel_6.setBounds(254, 220, 85, 42);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {  
			@Override
			public void mouseDown(MouseEvent e) {  //鼠标点击退出X
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_close_down.png"));
			}
			@Override
			public void mouseUp(MouseEvent e) {  //关闭实现
				if(MessageDialog.openConfirm(shell, "退出确认", "您确定要退出吗？")){
					shell.dispose();
				}
			}
		});
		lblNewLabel_1.addMouseTrackListener(new MouseTrackAdapter() {  
			@Override
			public void mouseHover(MouseEvent e) {  //鼠标移入退出X
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_close_highlight.png"));
			}
			@Override
			public void mouseExit(MouseEvent e) {  //鼠标移出退出X
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_close_normal.png"));
			}
		});
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {  //鼠标点击最小化-
				lblNewLabel_2.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_mini_down.png"));
			}
			@Override
			public void mouseUp(MouseEvent e) {  //实现最小化
				shell.setMinimized(true);
			}
		});
		
		lblNewLabel_2.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {  //鼠标移入最小化-
				lblNewLabel_2.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_mini_highlight.png"));
			}
			@Override
			public void mouseExit(MouseEvent e) {  //鼠标移出最小化-
				lblNewLabel_2.setImage(SWTResourceManager.getImage(Login.class, "/images/btn_mini_normal.png"));
			}
		});
		
		lblNewLabel_5.addMouseListener(new MouseAdapter() {  //登录
			@Override
			public void mouseUp(MouseEvent e) {
				String uname = text.getText().trim();
				String pwd = text_1.getText().trim();
				
				if("".equals(uname)){
					MessageDialog.openError(shell, "温馨提示", "用户名不能为空");
					return;
				}
				
				if("".equals(pwd)){
					MessageDialog.openError(shell, "温馨提示", "密码不能为空");
					return;
				}
				
				ILoginDao loginDao = new LoginDaoImpl();
				Map<String, Object> result = loginDao.login(uname, pwd);
				
				if(result != null && !"".equals(result)){
					shell.dispose();
					Manager manager = new Manager(result);
					manager.open();
				}else{
					MessageDialog.openError(shell, "错误提示", "用户名或密码错误");
				}
			}
		});
		
		lblNewLabel_6.addMouseListener(new MouseAdapter() {  //重置
			@Override
			public void mouseUp(MouseEvent e) {
				text.setText("");
				text_1.setText("");
			}
		});
	}
}
