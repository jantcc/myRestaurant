/*
 * 这是用户表数据模型，用它完成对用户的各种操作
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
		//组织sql语句对数据库操作
		try { String []array={uid,pwd};
			String sql = "select emp.empJob,emp.empName from emp,login where emp.empId=login.loginId and loginId = ? and loginPasswd=?";
			 sh = new SqlHelper();
			ResultSet rs = sh.query(sql, array);
			if(rs.next()){
				//取出职位
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
