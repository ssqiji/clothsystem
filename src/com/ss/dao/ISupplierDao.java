package com.ss.dao;

import java.util.List;
import java.util.Map;

public interface ISupplierDao {
	//添加供应商
	public int addSupplier(String supname,String supaddress,String supcontacts,String suptel,String supemail);
	
	//查询供应商
	public List<Map<String,Object>> findSupplier(Integer pageNo,Integer pageSize);
	
	//查询数据总条数
	public int total();
	
	//条件查询
	public List<Map<String,Object>> findByIf(Map<String,String> map,Integer pageNo,Integer pageSize);
	
	//修改供应商信息
	public int updateSupplier(Integer supid, String supname,String supaddress,String supcontacts,String suptel,String supemail);

	//删除供应商信息
	public int deleteSupplier(Integer supid);

}
