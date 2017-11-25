package com.ss.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties extends Properties{
	private static final long serialVersionUID = 1L;
	private static ReadProperties instance=new ReadProperties();
	
	private ReadProperties(){
		InputStream is=null;
		
		try {
			is=ReadProperties.class.getClassLoader().getResourceAsStream("db.properties");
			load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	static public ReadProperties getInstance(){
		return instance;
	}
}
