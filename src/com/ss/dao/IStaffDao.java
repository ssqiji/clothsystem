package com.ss.dao;

import java.util.List;
import java.util.Map;

public interface IStaffDao {
	//添加员工信息
	public int addStaff(String staname,String stapwd,String stasex,
			String staage,String statel,byte []staphoto,String rolid);
	
	//查询员工信息
	public List<Map<String,Object>> findStaff(Integer pageNo,Integer pageSize);
	
	//获取员工总数
	public int total();
	
	//获取角色名
	public List<Map<String,Object>> getRoles();
	
	//修改员工信息
	public int updateStaff(int staid, String stasex,String staage,String statel,byte []staphoto,String rolid);
	
	//修改员工信息
	public int updateStaff(int staid, String stasex,String staage,String statel,String rolid);
	
	//删除员工信息
	public int deleteStaff(int staid);
}
