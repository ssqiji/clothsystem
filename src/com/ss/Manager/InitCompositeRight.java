package com.ss.Manager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class InitCompositeRight extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public InitCompositeRight(Composite parent, int style) {
		super(parent, style);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		setBackground(SWTResourceManager.getColor(0, 139, 139));
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(0, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("方正舒体", 20, SWT.NORMAL));
		lblNewLabel.setBounds(127, 270, 128, 42);
		lblNewLabel.setText("源辰科技");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
