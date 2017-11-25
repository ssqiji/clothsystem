package com.ss.cloth;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class ClothManager extends Composite {
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ClothManager(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		sashForm.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackground(SWTResourceManager.getColor(255, 255, 204));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(60);
		tblclmnNewColumn_8.setText("  图片");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(180);
		tblclmnNewColumn.setText("吊牌号");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(174);
		tblclmnNewColumn_2.setText("服装名");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(70);
		tblclmnNewColumn_3.setText("颜色");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(70);
		tblclmnNewColumn_4.setText("尺寸");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_5.setWidth(70);
		tblclmnNewColumn_5.setText("价格");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_6.setWidth(70);
		tblclmnNewColumn_6.setText("状态");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_7.setWidth(68);
		tblclmnNewColumn_7.setText("款式");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(70);
		tblclmnNewColumn_1.setText("库存量");
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(255, 255, 204));
		
		Label lblNewLabel = new Label(composite_1, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(30, 20, 61, 17);
		lblNewLabel.setText("总页数：");
		
		Label lblNewLabel_1 = new Label(composite_1, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_1.setBounds(90, 20, 23, 17);
		lblNewLabel_1.setText("2");
		
		Label lblNewLabel_2 = new Label(composite_1, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(114, 20, 38, 17);
		lblNewLabel_2.setText("每页");
		
		Label lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_3.setBounds(158, 20, 23, 17);
		lblNewLabel_3.setText("2");
		
		Label lblNewLabel_4 = new Label(composite_1, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(181, 20, 16, 17);
		lblNewLabel_4.setText("条");
		
		Label lblNewLabel_5 = new Label(composite_1, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(212, 20, 16, 17);
		lblNewLabel_5.setText("共");
		
		Label lblNewLabel_6 = new Label(composite_1, SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_6.setBounds(238, 20, 23, 17);
		lblNewLabel_6.setText("2");
		
		Label lblNewLabel_7 = new Label(composite_1, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_7.setBounds(267, 20, 48, 17);
		lblNewLabel_7.setText("条数据");
		
		Label lblNewLabel_8 = new Label(composite_1, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_8.setBounds(336, 20, 48, 17);
		lblNewLabel_8.setText("当前第");
		
		Label lblNewLabel_9 = new Label(composite_1, SWT.NONE);
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_9.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_9.setBounds(398, 20, 23, 17);
		lblNewLabel_9.setText("2");
		
		Label lblNewLabel_10 = new Label(composite_1, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_10.setBounds(427, 20, 16, 17);
		lblNewLabel_10.setText("页");
		
		Button btnNewButton = new Button(composite_1, SWT.NONE);
		btnNewButton.setBounds(517, 15, 80, 27);
		btnNewButton.setText("上一页");
		
		Button btnNewButton_1 = new Button(composite_1, SWT.NONE);
		btnNewButton_1.setBounds(674, 15, 80, 27);
		btnNewButton_1.setText("下一页");
		sashForm.setWeights(new int[] {533, 48});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
