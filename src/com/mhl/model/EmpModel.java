/*
 * ����һ�����µ�����ģ���࣬��ɶ����±��rued����	
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
	
	//дһ�����������ڸ��µ�Ա����Ϣ(��ɾ��)
	public void updateEmp(String sql,String []array){
		SqlHelper sh = new SqlHelper();
		sh.update(sql, array);
	}
	//дһ�����������ڲ�ѯ��Ҫ��ʾ��������Ϣ
	public void queryEmp(String sql,String []array){
		//��ʼ����
		colums = new Vector<String>();
		//����SqlHelper����
		SqlHelper sh = new SqlHelper();
		ResultSet rs= sh.query(sql, array);
		//��ʼ����
		rows =new Vector<String>();
		try {//���Դ�ResultSet����rs�п��Եõ�ResultSetMetaData
			//��rsmt���ṩ�˷������Եõ�����ж����У����ҿ���֪���е�����
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			DatabaseConnection.close(rs);
			DatabaseConnection.close(sh.psmt);
			DatabaseConnection.close(sh.conn);
		}
	}
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.colums.size();
	}

	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rows.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.rows.get(arg0)).get(arg1);
	}
	@Override
	public String getColumnName(int arg0) {
		// TODO �Զ����ɵķ������
		return (String)this.colums.get(arg0);
	}

}
