package com.ss.Manager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

/**
 * 初始化界面
 * @author 神兽
 * 2017-10-18
 */
public class InitComposite extends Composite {

	public InitComposite(Composite parent, int style) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setBackground(SWTResourceManager.getColor(0, 139, 139));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("方正舒体", 20, SWT.NORMAL));
		lblNewLabel.setBounds(278, 260, 336, 53);
		lblNewLabel.setText("欢迎使用服装销售管理系统");

	}

	@Override
	protected void checkSubclass() {
	}
}
