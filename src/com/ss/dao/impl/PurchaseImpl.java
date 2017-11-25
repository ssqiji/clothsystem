package com.ss.dao.impl;

import java.util.List;
import java.util.Map;

import com.ss.dao.DBHelper;
import com.ss.dao.IPurchaseDao;

public class PurchaseImpl implements IPurchaseDao{

	@Override
	public Map<String, Object> findIfExit(String goodid) {  //判断服装是否存在
		DBHelper db = new DBHelper();
		String sql="select goodid,gooname,styname,gooprice,goodcolor,goodsize,goodpic,goodstatus,goodinventory"
				+ " from goods g,goodsdetails go,style s where s.styid=g.styid and g.gooid=go.gooid and goodid=?";
		List<Map<String,Object>> list = db.find(sql, goodid);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
