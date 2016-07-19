/**
 * 对数据库操作的类
 */
package com.mhl.db;
import java.sql.*;
import java.util.*;

import com.mhl.db.*;
public class SqlHelper {
 public	Connection conn=null;
 public	PreparedStatement psmt=null;
 public	ResultSet rs= null;
	public SqlHelper(){
		 conn = DatabaseConnection.getConnection();
	}
	//增加,删除,修改操作 update来完成
    public boolean update(String sql,String []array){
	    boolean b=true;
	    try { psmt= conn.prepareStatement(sql);
		if(array!=null){
		for(int i=0;i<array.length;i++){
			psmt.setString(i+1, array[i]);
		}
		int i= psmt.executeUpdate();
		}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}finally{
		DatabaseConnection.close(rs);
		DatabaseConnection.close(psmt);
		DatabaseConnection.close(conn);
	}
	return b;
}
	//查询
	public ResultSet query(String sql,String []array){
		try {
			psmt = conn.prepareStatement(sql);
			if(array!=null){
			for(int i=0;i<array.length;i++){
			psmt.setString((i+1), array[i]);
			}
			rs =psmt.executeQuery();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return rs;
	}
}
