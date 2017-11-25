package com.ss.supplier;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.dao.ISupplierDao;
import com.ss.dao.impl.SupplierDaoImpl;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UpdateSupplier extends Dialog {

	protected Object result;
	protected Shell shell;
	private TableItem item;
	private Text text;
	private Label lblNewLabel_1;
	private Text text_1;
	private Label lblNewLabel_2;
	private Text text_2;
	private Label lblNewLabel_3;
	private Text text_3;
	private Label lblNewLabel_4;
	private Text text_4;
	private Label lblNewLabel_5;
	private Text text_5;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UpdateSupplier(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(TableItem item) {
		this.item = item;
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
		shell.setSize(398, 390);
		shell.setLocation(Display.getCurrent().getClientArea().width/2-shell.getSize().x/2,
				Display.getCurrent().getClientArea().height/2-shell.getSize().y/2);
		shell.setText("修改供应商信息");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel.setBounds(56, 18, 72, 24);
		lblNewLabel.setText("供应商编号：");
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(143, 17, 170, 23);
		text.setText(item.getText(0));
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_1.setBounds(56, 65, 72, 24);
		lblNewLabel_1.setText("供应商名称：");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(143, 64, 170, 23);
		text_1.setText(item.getText(1));
		
		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_2.setBounds(56, 115, 72, 24);
		lblNewLabel_2.setText("供应商地址：");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(143, 114, 170, 23);
		text_2.setText(item.getText(2));
		
		lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_3.setBounds(56, 167, 72, 24);
		lblNewLabel_3.setText("联系人姓名：");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(143, 166, 170, 23);
		text_3.setText(item.getText(3));
		
		lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_4.setBounds(56, 218, 72, 24);
		lblNewLabel_4.setText("联系人电话：");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(143, 216, 170, 23);
		text_4.setText(item.getText(4));
		
		lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel_5.setBounds(56, 266, 72, 24);
		lblNewLabel_5.setText("联系人邮箱：");
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(143, 265, 170, 23);
		text_5.setText(item.getText(5));
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(56, 315, 80, 27);
		btnNewButton.setText("保存");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(230, 315, 80, 27);
		btnNewButton_1.setText("取消");
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {  //保存修改
			@Override
			public void widgetSelected(SelectionEvent e) {
				Integer supid = Integer.parseInt(text.getText().trim());
				String supname = text_1.getText().trim();
				String supaddress = text_2.getText().trim();
				String supcontacts = text_3.getText().trim();
				String suptel = text_4.getText().trim();
				String supemail = text_5.getText().trim();
				
				ISupplierDao supplierDao = new SupplierDaoImpl();
				int result = supplierDao.updateSupplier(supid, supname, supaddress, supcontacts, suptel, supemail);
				
				if(result > 0){
					text.setText("");
					text_1.setText("");
					text_2.setText("");
					text_3.setText("");
					text_4.setText("");
					text_5.setText("");
					List<Map<String,Object>> list = supplierDao.findSupplier(SupplierManager.pageInfo.getPageNo(), SupplierManager.pageInfo.getPageSize());
					SupplierManager.showData(list);
					MessageDialog.openInformation(getParent(), "成功提示", "修改供应商信息成功...");
					shell.dispose();
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
