package com.ss.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ss.dao.DBHelper;
import com.ss.dao.ISupplierDao;

public class SupplierDaoImpl implements ISupplierDao{
	//添加供应商
	@Override
	public int addSupplier(String supname, String supaddress, String supcontacts, String suptel, String supemail) {
		DBHelper db = new DBHelper();
		String sql="insert into supplier values(0,?,?,?,?,?)";
		return db.update(sql, supname, supaddress, supcontacts, suptel, supemail);
	}

	//查询供应商
	@Override
	public List<Map<String, Object>> findSupplier(Integer pageNo, Integer pageSize) {
		DBHelper db = new DBHelper();
		String sql="select supid,supname,supaddress,supcontacts,suptel,supemail from supplier limit ?,?";
		return db.find(sql, (pageNo-1)*pageSize, pageSize);
	}

	//查询数据总条数
	@Override
	public int total() {
		DBHelper db = new DBHelper();
		String sql="select count(supid) total from supplier";
		return db.getTotal(sql);
	}

	//条件查询
	@Override
	public List<Map<String, Object>> findByIf(Map<String,String> map,Integer pageNo,Integer pageSize) {
		DBHelper db = new DBHelper();
		List<Object> params=new ArrayList<Object>();
		String sql="select supid,supname,supaddress,supcontacts,suptel,supemail from supplier where 1=1";
				
		if(map != null && map.size()>0){
			Set<String> keys = map.keySet();
			for(String key:keys){
				sql+=" and "+key+"?";
				params.add(map.get(key));   
			}
		}
			
		return db.finds(sql, params);
	}

	//修改供应商
	@Override
	public int updateSupplier(Integer supid,String supname, String supaddress, String supcontacts, String suptel, String supemail) {
		DBHelper db = new DBHelper();
		String sql="update supplier set supname=?,supaddress=?,supcontacts=?,suptel=?,supemail=? where supid=?";
		return db.update(sql, supname, supaddress, supcontacts, suptel, supemail, supid);
	}

	//删除供应商信息
	@Override
	public int deleteSupplier(Integer supid) {
		DBHelper db = new DBHelper();
		String sql = "delete from supplier where supid=?";
		return db.update(sql, supid);
	}
}
