package com.ss.purchase;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ss.util.ImageUtil;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ClothExitAdd extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	Map<String,Object> map;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ClothExitAdd(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(Map<String,Object> map) {
		this.map = map;
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
		shell.setSize(527, 460);
		shell.setText("商品入库");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel.setBounds(50, 22, 74, 17);
		lblNewLabel.setText("服装条码：");
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(130, 18, 175, 23);
		text.setText(String.valueOf(map.get("goodid")));
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(50, 75, 74, 17);
		lblNewLabel_1.setText("服装名称：");
		
		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(130, 69, 175, 23);
		text_1.setText(String.valueOf(map.get("gooname")));
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_2.setBounds(50, 127, 74, 17);
		lblNewLabel_2.setText("服装款式：");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(130, 123, 175, 23);
		text_2.setText(String.valueOf(map.get("styname")));
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_3.setBounds(50, 177, 74, 17);
		lblNewLabel_3.setText("服装售价：");
		
		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(130, 173, 175, 23);
		text_3.setText(String.valueOf(map.get("gooprice")));
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_4.setBounds(50, 232, 74, 17);
		lblNewLabel_4.setText("服装颜色：");
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(130, 229, 175, 23);
		text_4.setText(String.valueOf(map.get("goodcolor")));
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_5.setBounds(50, 288, 74, 17);
		lblNewLabel_5.setText("服装尺寸：");
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(130, 284, 175, 23);
		text_5.setText(String.valueOf(map.get("goodsize")));
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_6.setBounds(50, 340, 74, 17);
		lblNewLabel_6.setText("服装状态：");
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(133, 337, 171, 23);
		text_6.setText(String.valueOf(map.get("goodstatus")));
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_7.setBounds(51, 390, 72, 17);
		lblNewLabel_7.setText("库存量：");
		
		text_7 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_7.setBounds(130, 386, 175, 23);
		text_7.setText(String.valueOf(map.get("goodinventory")));
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_8.setBounds(366, 22, 74, 17);
		lblNewLabel_8.setText("服装图片：");
		
		Label lblNewLabel_9 = new Label(shell, SWT.BORDER);
		lblNewLabel_9.setBounds(368, 56, 100, 100);
		byte []bt = (byte[]) map.get("goodpic");
		ImageUtil imageUtil = new ImageUtil();
		lblNewLabel_9.setImage(imageUtil.getImage(bt, 100, 100));
		
		Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("仿宋", 11, SWT.NORMAL));
		lblNewLabel_10.setBounds(364, 177, 74, 17);
		lblNewLabel_10.setText("进货数量：");
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(366, 208, 102, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(366, 260, 102, 27);
		btnNewButton.setText("确认入库");

		btnNewButton.addSelectionListener(new SelectionAdapter() {  //确认进货
			@Override
			public void widgetSelected(SelectionEvent e) {
				String purcnum = text_8.getText().trim();
			}
		});
	}
}
