package com.ss.Manager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.cloth.ClothManager;
import com.ss.cloth.ClothManagerRight;
import com.ss.purchase.PurchaseManager;
import com.ss.purchase.PurchaseManagerRight;
import com.ss.staff.StaffManager;
import com.ss.staff.StaffManagerRight;
import com.ss.supplier.SupplierManager;
import com.ss.supplier.SupplierManagerRight;

import org.eclipse.swt.custom.SashForm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;

public class Manager {

	protected Shell shell;
	protected Display display;
	public static Map<String,Object> map;  //保存用户名和密码
	Label lblNewLabel_16;  //当前时间

	public Manager(){
		super();
	}
	
	public Manager(Map<String,Object> map){
		Manager.map = map;
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		try {
			Manager window = new Manager(map);
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
		shell.setBackground(SWTResourceManager.getColor(0, 255, 255));
		shell.setImage(SWTResourceManager.getImage(Manager.class, "/images/yc.ico"));
		shell.setSize(541, 364);
		shell.setBounds(0, 0, display.getClientArea().width, display.getClientArea().height);
		shell.setText("服装销售管理系统");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(shell, SWT.NONE);
		sashForm.setBackground(SWTResourceManager.getColor(32, 178, 170));
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackground(SWTResourceManager.getColor(0, 128, 128));
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_close_normal.png"));
		lblNewLabel_1.setBounds(1325, 0, 39, 20);
		
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_mini_normal.png"));
		lblNewLabel_2.setBounds(1299, 0, 28, 20);
		
		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("方正舒体", 28, SWT.NORMAL));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(173, 216, 230));
		lblNewLabel_3.setBounds(50, 25, 306, 43);
		lblNewLabel_3.setText("服装销售管理系统");
		
		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.NORMAL));
		lblNewLabel_4.setBounds(1003, 64, 61, 20);
		lblNewLabel_4.setText("欢迎您：");
		
		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel_5.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.NORMAL));
		lblNewLabel_5.setBounds(1083, 64, 88, 20);
		
		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.NORMAL));
		lblNewLabel_6.setBounds(1188, 64, 79, 20);
		lblNewLabel_6.setText("修改密码");
		
		Label lblNewLabel_15 = new Label(composite, SWT.NONE);
		lblNewLabel_15.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.NORMAL));
		lblNewLabel_15.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel_15.setBounds(1002, 34, 112, 20);
		lblNewLabel_15.setText("当前系统时间：");
		
		lblNewLabel_16 = new Label(composite, SWT.NONE);
		lblNewLabel_16.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel_16.setFont(SWTResourceManager.getFont("方正舒体", 13, SWT.NORMAL));
		lblNewLabel_16.setBounds(1120, 33, 146, 20);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		lblNewLabel_16.setText(df.format(new Date()));
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(32, 178, 170));
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(composite_1, SWT.NONE);
		sashForm_1.setBackground(SWTResourceManager.getColor(32, 178, 170));
		
		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		composite_3.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_3.setBackground(SWTResourceManager.getColor(0, 128, 128));
		
		Label lblNewLabel_7 = new Label(composite_3, SWT.CENTER);
		lblNewLabel_7.setImage(SWTResourceManager.getImage(Manager.class, "/images/gys.jpg"));
		
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(0, 128, 128));
		lblNewLabel_7.setFont(SWTResourceManager.getFont("方正舒体", 14, SWT.NORMAL));
		lblNewLabel_7.setAlignment(SWT.CENTER);
		lblNewLabel_7.setBounds(0, 0, 170, 50);
		
		Label lblNewLabel_8 = new Label(composite_3, SWT.NONE);
		lblNewLabel_8.setImage(SWTResourceManager.getImage(Manager.class, "/images/yg.jpg"));
		lblNewLabel_8.setBounds(0, 52, 170, 50);
		
		Label lblNewLabel_9 = new Label(composite_3, SWT.NONE);
		lblNewLabel_9.setImage(SWTResourceManager.getImage(Manager.class, "/images/kh.jpg"));
		lblNewLabel_9.setBounds(0, 104, 170, 50);
		
		Label lblNewLabel_10 = new Label(composite_3, SWT.NONE);
		lblNewLabel_10.setImage(SWTResourceManager.getImage(Manager.class, "/images/fz.jpg"));
		lblNewLabel_10.setBounds(0, 156, 170, 50);
		
		Label lblNewLabel_11 = new Label(composite_3, SWT.NONE);
		lblNewLabel_11.setImage(SWTResourceManager.getImage(Manager.class, "/images/dd.jpg"));
		lblNewLabel_11.setBounds(0, 208, 170, 50);
		
		Label lblNewLabel_12 = new Label(composite_3, SWT.NONE);
		lblNewLabel_12.setImage(SWTResourceManager.getImage(Manager.class, "/images/jh.jpg"));
		lblNewLabel_12.setBounds(0, 260, 170, 50);
		
		Label lblNewLabel_13 = new Label(composite_3, SWT.NONE);
		lblNewLabel_13.setImage(SWTResourceManager.getImage(Manager.class, "/images/bb.jpg"));
		lblNewLabel_13.setBounds(0, 312, 170, 50);
		
		Label lblNewLabel_14 = new Label(composite_3, SWT.NONE);
		
		lblNewLabel_14.setImage(SWTResourceManager.getImage(Manager.class, "/images/gy.jpg"));
		lblNewLabel_14.setBounds(0, 364, 170, 50);
		
		final Composite composite_4 = new Composite(sashForm_1, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(0, 139, 139));
		StaticManager.initComposite = new InitComposite(composite_4, SWT.NONE);
		StaticManager.stackLayout.topControl = StaticManager.initComposite;  //将顶层设置为初始化页面
		
		composite_4.setLayout(StaticManager.stackLayout);
		composite_4.layout();
		
		final Composite composite_5 = new Composite(sashForm_1, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(0, 139, 139));
		StaticManagerRight.initCompositeRight = new InitCompositeRight(composite_5, SWT.NONE);
		StaticManagerRight.stackLayout.topControl = StaticManagerRight.initCompositeRight;  //将顶层设置为初始化页面
		
		composite_5.setLayout(StaticManagerRight.stackLayout);
		composite_5.layout();
		
		sashForm_1.setWeights(new int[] {170, 839, 349});
		
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite_2.setBackground(SWTResourceManager.getColor(0, 128, 128));
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblNewLabel.setForeground(SWTResourceManager.getColor(173, 216, 230));
		lblNewLabel.setBounds(620, 10, 196, 24);
		lblNewLabel.setText("版权所有©源辰信息科技");
		sashForm.setWeights(new int[] {102, 585, 33});
		
		lblNewLabel_5.setText(String.valueOf(map.get("staname")));
		
		lblNewLabel_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseHover(MouseEvent e) {  //退出键鼠标悬停
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_close_highlight.png"));
			}
			@Override
			public void mouseExit(MouseEvent e) {  //退出键鼠标移出
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_close_normal.png"));
			}
		});
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {  //退出键鼠标按下
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_close_down.png"));
			}
			@Override
			public void mouseUp(MouseEvent e) {  //退出键鼠标弹起
				if(MessageDialog.openConfirm(shell, "退出提示", "是否退出系统？"))
				shell.dispose();
			}
		});
		
		lblNewLabel_2.addMouseTrackListener(new MouseTrackAdapter() {
			@Override 
			public void mouseHover(MouseEvent e) {  //最小化鼠标悬停
				lblNewLabel_2.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_mini_highlight.png"));
			}
			@Override
			public void mouseExit(MouseEvent e) {  //最小化鼠标移出
				lblNewLabel_2.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_mini_normal.png"));
			}
		});

		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {  //最小化鼠标按下
				lblNewLabel_2.setImage(SWTResourceManager.getImage(Manager.class, "/images/btn_mini_down.png"));
			}
			@Override
			public void mouseUp(MouseEvent e) {  //最小化鼠标弹起
				shell.setMinimized(true);
			}
		});
		
		lblNewLabel_6.addMouseListener(new MouseAdapter() {  //修改密码
			@Override
			public void mouseUp(MouseEvent e) {
				UpdatePwd updatePwd = new UpdatePwd(map);
				updatePwd.open();
			}
		});
		
		lblNewLabel_14.addMouseListener(new MouseAdapter() {  //关于系统
			@Override
			public void mouseUp(MouseEvent e) {
				MessageDialog.openInformation(shell, "关于系统", "本系统版本号为1.0\n"
						+ "在您使用的过程中如遇到问题，请及时联系我们！\n"
						+ "联系电话：18229248976");
			}
		});
		
		StaticManager.supplierManager = new SupplierManager(composite_4, SWT.NONE);
		StaticManagerRight.supplierManagerRight = new SupplierManagerRight(composite_5, SWT.NONE);
		lblNewLabel_7.addMouseListener(new MouseAdapter() {  //供应商管理
			@Override
			public void mouseUp(MouseEvent e) {
				StaticManager.stackLayout.topControl = StaticManager.supplierManager;  //将supplierManager面板设置为堆栈的最顶层面板  
				composite_4.layout();
				StaticManagerRight.stackLayout.topControl = StaticManagerRight.supplierManagerRight;
				composite_5.layout();
			}
		});
		
		StaticManager.staffManager = new StaffManager(composite_4, SWT.NONE);
		StaticManagerRight.staffManagerRight = new StaffManagerRight(composite_5,SWT.NONE);
		lblNewLabel_8.addMouseListener(new MouseAdapter() {  //员工管理
			@Override
			public void mouseUp(MouseEvent e) {
				StaticManager.stackLayout.topControl = StaticManager.staffManager;
				composite_4.layout();
				StaticManagerRight.stackLayout.topControl = StaticManagerRight.staffManagerRight;
				composite_5.layout();
			}
		});
		
		StaticManager.clothManager = new ClothManager(composite_4, SWT.NONE);
		StaticManagerRight.clothManagerRight = new ClothManagerRight(composite_5, SWT.NONE);
		lblNewLabel_10.addMouseListener(new MouseAdapter() {  //服装管理
			@Override
			public void mouseUp(MouseEvent e) {
				StaticManager.stackLayout.topControl = StaticManager.clothManager;
				composite_4.layout();
				StaticManagerRight.stackLayout.topControl = StaticManagerRight.clothManagerRight;
				composite_5.layout();
			}
		});
		
		StaticManager.purchaseManager = new PurchaseManager(composite_4, SWT.NONE);
		StaticManagerRight.purchaseManagerRight = new PurchaseManagerRight(composite_5, SWT.NONE);
		lblNewLabel_12.addMouseListener(new MouseAdapter() {  //进货管理
			@Override
			public void mouseUp(MouseEvent e) {
				StaticManager.stackLayout.topControl = StaticManager.purchaseManager;
				composite_4.layout();
				StaticManagerRight.stackLayout.topControl = StaticManagerRight.purchaseManagerRight;
				composite_5.layout();
			}
		});
	}
}

