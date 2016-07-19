/*
 * 这是一个人事的数据模型类，完成对人事表的rued操作	
 */
package com.mhl.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import javax.swing.table.AbstractTableModel;

import com.mhl.db.DatabaseConnection;
import com.mhl.db.SqlHelper;

public class EmpModel extends AbstractTableModel {
	Vector rows,colums;
	
	//写一个方法，用于更新的员工信息(增删改)
	public void updateEmp(String sql,String []array){
		SqlHelper sh = new SqlHelper();
		sh.update(sql, array);
	}
	//写一个方法，用于查询需要显示的人事信息
	public void queryEmp(String sql,String []array){
		//初始化列
		colums = new Vector<String>();
		//创建SqlHelper对象
		SqlHelper sh = new SqlHelper();
		ResultSet rs= sh.query(sql, array);
		//初始化行
		rows =new Vector<String>();
		try {//可以从ResultSet对象rs中可以得到ResultSetMetaData
			//从rsmt中提供了方法可以得到结果有多少列，而且可以知道列的名字
			ResultSetMetaData rsmt = rs.getMetaData();
			for(int i=0;i<rsmt.getColumnCount();i++){
				this.colums.add(rsmt.getColumnName(i+1));
			}
			while(rs.next()){
				Vector temp = new Vector<String>();
				for(int i=0;i<rsmt.getColumnCount();i++){
					temp.add(rs.getString(i+1));
				}
				rows.add(temp);
				
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(rs);
			DatabaseConnection.close(sh.psmt);
			DatabaseConnection.close(sh.conn);
		}
	}
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return this.colums.size();
	}

	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.rows.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		// TODO 自动生成的方法存根
		return ((Vector)this.rows.get(arg0)).get(arg1);
	}
	@Override
	public String getColumnName(int arg0) {
		// TODO 自动生成的方法存根
		return (String)this.colums.get(arg0);
	}

}
