package com.ss.util;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Label;

public class ImageUtil {
	/**
	 * 根据指定路径读取图片，并将其缩放到指定的lable大小
	 * @param label 
	 * @param filePath 
	 * @return
	 */
	public Image getImage(Label label,String filePath){
		Image image=null;
		if(filePath!=null&&!"".equals(filePath)){//路径不为空
			File file=new File(filePath);
			if(file.exists()){//文件存在
				FileInputStream fis=null;//从磁盘把文件读到内存
				try {
					fis=new FileInputStream(file);
					ImageData imageData=new ImageData(fis);
					//缩放图片
					imageData=imageData.scaledTo(label.getSize().x, label.getSize().y);
					image=new Image(null, imageData);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(fis!=null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}
		return image;
	}
	/**
	 * 根据指定路径和图片大小，读取并缩放图片
	 * @param filePath
	 * @param width
	 * @param height
	 * @return
	 */
	public Image getImage(String filePath,int width,int height){
		Image image=null;
		if(filePath!=null&&!"".equals(filePath)){//路径不为空
			File file=new File(filePath);
			if(file.exists()){//文件存在
				FileInputStream fis=null;//从磁盘把文件读到内存
				try {
					fis=new FileInputStream(file);
					ImageData imageData=new ImageData(fis);
					//缩放图片
					imageData=imageData.scaledTo(width, height);
					image=new Image(null, imageData);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(fis!=null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}
		return image;
	}
	/**
	 * 将字节数据转成指定大小的图片（从数据库读取的图片是以字节数据存在的）
	 * @param bt
	 * @param width
	 * @param height
	 * @return
	 */
	public Image getImage(byte[] bt,int width,int height){
		if(bt!=null){
			//把字节数组中的数据转换成图片
			ImageData imageData=new ImageData(new ByteArrayInputStream(bt));
			imageData=imageData.scaledTo(width, height);
			return new Image(null,imageData);
		}
		return null;
	}
	/**
	 * 将指定路径的文件以字节的方式读到字节数组
	 * @param filePath
	 * @return
	 */
	public byte[] getImageData(String filePath){
		byte[] bt=null;
		if(filePath!=null&&!"".equals(filePath)){//路径不为空
			File file=new File(filePath);
			if(file.exists()){
				FileInputStream fis=null;
				try {
					fis=new FileInputStream(file);
					//将文件读到字节数组
					bt=new byte[fis.available()];
					fis.read(bt);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(fis!=null){
						try {
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		return bt;

	}




}
