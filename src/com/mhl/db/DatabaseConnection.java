package com.mhl.db;
import java.sql.*;
public class DatabaseConnection {
	static Connection conn=null;
	
		public static Connection getConnection(){
		try {//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			 //2.�õ�����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "root");
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
		}
		
		public static void close(Connection conn){
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		public static void close(PreparedStatement psmt){
			if(psmt!=null){
				try {
					psmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
		public static void close(ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
}

	


