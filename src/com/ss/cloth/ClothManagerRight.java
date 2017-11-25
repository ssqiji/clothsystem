package com.ss.cloth;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class ClothManagerRight extends Composite {
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ClothManagerRight(Composite parent, int style) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setBackground(SWTResourceManager.getColor(240, 230, 140));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(33, 33, 61, 17);
		lblNewLabel.setText("吊牌号：");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(100, 27, 194, 29);
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(33, 88, 61, 17);
		lblNewLabel_1.setText("服装名：");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(100, 82, 194, 29);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(214, 150, 80, 27);
		btnNewButton.setText("查询");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
