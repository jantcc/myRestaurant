/**
 * �����ݿ��������
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
	//����,ɾ��,�޸Ĳ��� update�����
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
	//��ѯ
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
