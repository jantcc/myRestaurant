/**
 * �������¹���ϵͳ��jp4��emp��ϸ��Ϣ�Ľ���
 */
package com.mhl.view.Emp;
import java.awt.*;

import javax.swing.*;

import com.mhl.model.EmpModel;
public class EmpAllInfo extends JDialog {
	 JTable jt;
	 JScrollPane jsp ;
	 EmpModel em;
	public EmpAllInfo(String title,String id){
		String sql ="select *from emp where empId=?";
		String array[]={id};
		em = new EmpModel();
		em.queryEmp(sql, array);
		jt = new JTable(em);
		jsp= new JScrollPane(jt);
		this.add(jsp);
		this.setTitle(title);
		this.setSize(1000, 300);
		//���ô�����ʾ����Ļ�м�
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/5, h/2-150);
		this.setVisible(true);
	}
}
