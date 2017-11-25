package com.ss.dao.impl;

import java.util.List;
import java.util.Map;

import com.ss.dao.DBHelper;
import com.ss.dao.IStaffDao;

public class StaffDaoImpl implements IStaffDao{
	//查询员工信息
	@Override
	public List<Map<String, Object>> findStaff(Integer pageNo,Integer pageSize) {
		DBHelper db = new DBHelper();
		String sql = "select staid,staname,stasex,staage,statel,staphoto,rolname from staff,roles "
				+ "where staff.rolid=roles.rolid and rolname!='管理员' limit ?,?";
		return db.find(sql, (pageNo-1)*pageSize, pageSize);
	}

	//获取员工总数
	@Override
	public int total() {
		DBHelper db = new DBHelper();
		String sql = "select count(staid) total from staff,roles where "
				+ "staff.rolid=roles.rolid and roles.rolname!='管理员'";
		return db.getTotal(sql);
	}

	//获取角色名
	@Override
	public List<Map<String, Object>> getRoles() {
		DBHelper db = new DBHelper();
		String sql="select rolid,rolname from roles where rolname!='管理员'";
		return db.find(sql);
	}

	//添加员工信息
	@Override
	public int addStaff(String staname, String stapwd, String stasex, String staage, String statel, byte []staphoto,
			String rolid) {
		DBHelper db = new DBHelper();
		String sql1 = "select rolid from roles where rolname=?";
		List<Map<String,Object>> list = db.find(sql1, rolid);
		
		if(list != null && list.size() > 0){
			String sql = "insert into staff values(0,?,?,?,?,?,?,?)";
			return db.update(sql, staname, stapwd, stasex, staage, statel, staphoto, Integer.parseInt(String.valueOf(list.get(0).get("rolid"))));
		}else{
			return 0;
		}
	}

	//修改员工信息
	@Override
	public int updateStaff(int staid, String stasex, String staage, String statel, byte[] staphoto, String rolid) {
		DBHelper db = new DBHelper();
		String sql1 = "select rolid from roles where rolname=?";
		List<Map<String,Object>> list = db.find(sql1, rolid);
		
		String sql="update staff set stasex=?,staage=?,statel=?,staphoto=?,rolid=? where staid=?";
		return db.update(sql, stasex, staage, statel, staphoto, Integer.parseInt(String.valueOf(list.get(0).get("rolid"))),staid);
	}

	//修改员工信息
	@Override
	public int updateStaff(int staid, String stasex, String staage, String statel, String rolid) {
		DBHelper db = new DBHelper();
		String sql1 = "select rolid from roles where rolname=?";
		List<Map<String,Object>> list = db.find(sql1, rolid);
		
		String sql="update staff set stasex=?,staage=?,statel=?,rolid=? where staid=?";
		return db.update(sql, stasex, staage, statel, Integer.parseInt(String.valueOf(list.get(0).get("rolid"))),staid);
	}

	@Override
	public int deleteStaff(int staid) {
		DBHelper db = new DBHelper();
		String sql="delete from staff where staid=?";
		return db.update(sql, staid);
	}
}
