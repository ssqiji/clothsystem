package com.ss.dao;

import java.util.Map;

public interface IPurchaseDao {
	//判断服装是否存在
	public Map<String,Object> findIfExit(String goodid);
}
