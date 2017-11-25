package com.ss.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelper {
	//1.导包
	//2.加载驱动
	static{
		try {
			Class.forName(ReadProperties.getInstance().getProperty("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立连接
	 * @return
	 */
	public Connection getConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection(ReadProperties.getInstance().getProperty("url"),ReadProperties.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭连接
	 * @param con
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection con,PreparedStatement pstmt,ResultSet rs){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 给预编译语句中的占位符赋值ֵ
	 * @param pstmt
	 * @param params
	 */
	public void setValue(PreparedStatement pstmt,Object ...params){
		if(params!=null){
			try {
				for(int i=0,len=params.length;i<len;i++){				
					pstmt.setObject(i+1, params[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 给预编译语句中的占位符赋值ֵ
	 * @param pstmt
	 * @param params
	 */
	public void setValues(PreparedStatement pstmt,List<Object> params){
		if(params!=null){
			try {
				for(int i=0,len=params.size();i<len;i++){				
					pstmt.setObject(i+1, params.get(i));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 更新
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object ...params){
		int result=0;
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			//建立连接
			con=this.getConnection();

			//预编译语句
			pstmt=con.prepareStatement(sql);

			//给预编译语句中的占位符赋值ֵ
			this.setValue(pstmt,params);

			//获得结果集
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, null);
		}

		return result;
	}

	/**
	 * 更新
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updates(String sql,List<Object> params){
		int result=0;
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			//建立连接
			con=this.getConnection();

			//预编译语句
			pstmt=con.prepareStatement(sql);

			//给预编译语句中的占位符赋值ֵ
			this.setValue(pstmt,params);

			//获得结果集
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, null);
		}

		return result;
	}

	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> find(String sql,Object ...params){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			//建立连接
			con=this.getConnection();

			//预编译语句
			pstmt=con.prepareStatement(sql);

			//给预编译语句中的占位符赋值ֵ
			this.setValue(pstmt, params);

			//获得结果集
			rs=pstmt.executeQuery();

			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();

			//获得结果集中的列名
			String []colNames=this.getColNames(rsmd, colCount);
			
			Map<String,Object> map=null;
			Object obj=null;
			String colType=null;
			
			while(rs.next()){
				map=new HashMap<String,Object>();
				 
				for(String col:colNames){
					obj=rs.getObject(col);
					
					if(obj!=null){
						colType=obj.getClass().getSimpleName();
						
						if("BLOB".equals(colType)){
							Blob blob=rs.getBlob(col);
							
							byte[] bt=blob.getBytes(1, (int) blob.length());
							map.put(col, bt);
						}else{
							map.put(col, obj);
						}
					}else{
						map.put(col, obj);
					}					
				}
				list.add(map);
				map=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> finds(String sql,List<Object> params){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			con=this.getConnection();

			pstmt=con.prepareStatement(sql);

			this.setValues(pstmt, params);

			rs=pstmt.executeQuery();

			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();

			String []colNames=this.getColNames(rsmd, colCount);
			
			Map<String,Object> map=null;
			Object obj=null;
			String colType=null;
			
			while(rs.next()){
				map=new HashMap<String,Object>();
				 
				for(String col:colNames){
					obj=rs.getObject(col);
					
					if(obj!=null){
						colType=obj.getClass().getSimpleName();
						
						if("BLOB".equals(colType)){
							Blob blob=rs.getBlob(col);
							
							byte[] bt=blob.getBytes(1, (int) blob.length());
							map.put(col, bt);
						}else{
							map.put(col, obj);
						}
					}else{
						map.put(col, obj);
					}					
				}
				list.add(map);
				map=null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String,String>> findStr(String sql,Object ...params){
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			con=this.getConnection();

			pstmt=con.prepareStatement(sql);

			this.setValue(pstmt, params);

			rs=pstmt.executeQuery();

			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();

			String []colNames=this.getColNames(rsmd, colCount);
			
			Map<String,String> map=null;
			String str=null;
			
			while(rs.next()){
				map=new HashMap<String,String>();
							
				for(String col:colNames){
					str=rs.getString(col); 
					map.put(col, str);
				}
				list.add(map);
				map=null;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询单条数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<String,Object> findSingle(String sql,Object ...params){
		Map<String,Object> map=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			con=this.getConnection();

			pstmt=con.prepareStatement(sql);

			this.setValue(pstmt, params);

			rs=pstmt.executeQuery();
		
			if(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int colCount=rsmd.getColumnCount();

				String []colNames=this.getColNames(rsmd, colCount);
				
				Object obj=null;
				String colType=null;
				map=new HashMap<String,Object>();
				 
				for(String col:colNames){
					obj=rs.getObject(col);
					
					if(obj!=null){
						colType=obj.getClass().getSimpleName();
						
						if("BLOB".equals(colType)){
							Blob blob=rs.getBlob(col);
							
							byte[] bt=blob.getBytes(1, (int) blob.length());
							map.put(col, bt);
						}else{
							map.put(col, obj);
						}
					}else{
						map.put(col, obj);
					}					
				}
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return map;
	}

	/**
	 * 查询单条数据
	 * @param sql
	 * @param params
	 * @return
	 */
	public Map<String,String> findSingleByStr(String sql,Object ...params){
		Map<String,String> map=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try {
			con=this.getConnection();

			pstmt=con.prepareStatement(sql);

			this.setValue(pstmt, params);

			rs=pstmt.executeQuery();
		
			if(rs.next()){
				ResultSetMetaData rsmd=rs.getMetaData();
				int colCount=rsmd.getColumnCount();

				String []colNames=this.getColNames(rsmd, colCount);
				
				String obj=null;
				String colType=null;
				map=new HashMap<String,String>();
				 
				for(String col:colNames){
					obj=rs.getString(col);
					
					if(obj!=null){
						colType=obj.getClass().getSimpleName();
						
						if("BLOB".equals(colType)){
							Blob blob=rs.getBlob(col);
							
							byte[] bt=blob.getBytes(1, (int) blob.length());
							map.put(col, String.valueOf(bt));
						}else{
							map.put(col, obj);
						}
					}else{
						map.put(col, obj);
					}					
				}
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return map;
	}

	
	/**
	 * 获取结果集中的列名
	 * @param rsmd
	 * @param colCount
	 * @return
	 */
	public String[] getColNames(ResultSetMetaData rsmd,int colCount){
		String []colNames=null;

		if(rsmd!=null){
			colNames=new String[colCount];
			try {
				for(int i=0;i<colCount;i++){			
					colNames[i]=rsmd.getColumnName(i+1).toLowerCase();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colNames;
	}
	
	/**
	 * 获取记录数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getTotal(String sql,Object ...params){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result=0;
				
		try {
			// 获取连接
			con = this.getConnection();

			// 执行预编译语句
			pstmt = con.prepareStatement(sql);

			// 给预编译语句中的占位符赋值
			this.setValue(pstmt, params);

			// 获取结果集
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result=rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, rs);
		}
		return result;
	}

}
