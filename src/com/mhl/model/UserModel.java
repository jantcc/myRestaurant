/*
 * �����û�������ģ�ͣ�������ɶ��û��ĸ��ֲ���
 */
package com.mhl.model;

import java.sql.*;

import com.mhl.db.DatabaseConnection;
import com.mhl.db.SqlHelper;

public class UserModel {
	public String[] checkUser(String uid,String pwd){
		String backinfo[]= new String[2];
		String zhiwei="";
		String name="";
		SqlHelper sh=null;
		//��֯sql�������ݿ����
		try { String []array={uid,pwd};
			String sql = "select emp.empJob,emp.empName from emp,login where emp.empId=login.loginId and loginId = ? and loginPasswd=?";
			 sh = new SqlHelper();
			ResultSet rs = sh.query(sql, array);
			if(rs.next()){
				//ȡ��ְλ
				zhiwei=rs.getString(1);
				name = rs.getString(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			DatabaseConnection.close(sh.rs);
			DatabaseConnection.close(sh.psmt);
			DatabaseConnection.close(sh.conn);
		}
		backinfo[0]=zhiwei;
		backinfo[1]=name;
		return backinfo;
	}
	
}
