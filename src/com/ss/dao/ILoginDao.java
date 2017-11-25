package com.ss.dao;

import java.util.Map;

public interface ILoginDao {
	public Map<String,Object> login(String uname,String pwd);  //登录
	
	public int updatePwd(String uname,String oldPwd,String newPwd);  //修改密码
}
