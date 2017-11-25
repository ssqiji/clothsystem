package com.ss.dao.impl;

import java.util.Map;

import com.ss.dao.DBHelper;
import com.ss.dao.ILoginDao;

public class LoginDaoImpl implements ILoginDao{
	@Override
	public Map<String,Object> login(String uname, String pwd) {  //登录
		DBHelper db = new DBHelper();
		String sql = "select staname,stapwd from staff where staname = ? and stapwd = ?";
		Map<String,Object> map = db.findSingle(sql, uname, pwd);
		
		if(map != null && map.size() > 0){
			return map;
		}else{
			return null;
		}
	}

	@Override
	public int updatePwd(String uname,String oldPwd, String newPwd) {  //修改密码
		DBHelper db = new DBHelper();
		String sql = "select staname from staff where staname=? and stapwd = ?";
		if(db.find(sql, uname, oldPwd)!= null && db.find(sql, uname, oldPwd).size()>0){
			String sql1 = "update staff set stapwd=? where staname=?";
			return db.update(sql1, newPwd, uname);
		}else{
			return 0;
		}
	}
}
