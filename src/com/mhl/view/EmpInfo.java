/*
 * 这是用于显示人事管理的界面
 */
package com.mhl.view;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.mhl.model.EmpModel;
import com.mhl.view.Emp.EmpAdd;
import com.mhl.view.Emp.EmpAllInfo;
import com.mhl.view.Emp.EmpUpdate;
public class EmpInfo extends JPanel implements ActionListener,MouseListener{
	//定义五个布局
	JPanel jp1,jp2,jp3,jp4,jp5;
	//定义JLabel
	JLabel jp1_jl1,jp3_jl1;
	//定义文本框
	JTextField jtf1;
	//定义JButton
	JButton jp1_jb1,jp1_jb2,jp4_jb1,jp4_jb2,jp4_jb3,jp4_jb4;
	//定义一个表单
	JTable jp2_jtable;
	//定义一个滚动条
	JScrollPane jsp;
	//创建一个EmpModel对象
	EmpModel em =null;
	//刷新表单
	public void refreshTable(){
		String sql = "select empId,empName,empSex,empJob,empEdu,empMarrige from emp where 1=?";
		String array[]={"1"};
		em = new EmpModel();
		em.queryEmp(sql, array);
		jp4_jb1.setEnabled(false);
		jp4_jb3.setEnabled(false);
		jp4_jb4.setEnabled(false);
		jp2_jtable.setModel(em);
	}
	public EmpInfo(){
		//全局设置为BorderLayout
		this.setLayout(new BorderLayout());
		//处理jp1
		jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp1_jl1 = new JLabel("请输入姓名(员工号或者职位):");
		jtf1 = new JTextField(20);
		jp1_jb1 = new JButton("刷新");
		//注册监听
		jp1_jb1.addActionListener(this);
		jp1.add(jp1_jl1);
		jp1.add(jtf1);
		jp1.add(jp1_jb1);
		//处理jp2
		 em = new EmpModel();
		String sql = "select empId,empName,empSex,empJob,empEdu,empMarrige from emp where 1=?";
		String array[]={"1"};
		em.queryEmp(sql, array);
		jp2_jtable = new JTable(em);
		jsp = new JScrollPane(jp2_jtable);
		jp2 = new JPanel(new BorderLayout());
		jp2.add(jsp);
		jsp.addMouseListener(this);
		this.addMouseListener(this);
		jp2_jtable.addMouseListener(this);
		//处理jp3,jp4,jp5 (jp5=(jp3+jp4))
		jp5= new JPanel(new BorderLayout());
		//处理jp3
		jp3 = new JPanel();
		jp3_jl1 = new JLabel("            共有"+em.getRowCount()+"条记录");
		jp3.add(jp3_jl1);
		//处理jp4
		jp4 = new JPanel();
		jp4_jb1 = new JButton("详细信息");
		jp4_jb1.setEnabled(false);
		jp4_jb2 = new JButton("添加");
		jp4_jb3 = new JButton("修改");
		jp4_jb3.setEnabled(false);
		jp4_jb4 = new JButton("删除");
		jp4_jb4.setEnabled(false);
		//给jp4按钮注册监听
		jp4_jb1.addActionListener(this);
		jp4_jb2.addActionListener(this);
		jp4_jb3.addActionListener(this);
		jp4_jb4.addActionListener(this);
		jp4.add(jp4_jb1);
		jp4.add(jp4_jb2);
		jp4.add(jp4_jb3);
		jp4.add(jp4_jb4);
		//将jp3,jp4加入到jp5
		jp5.add(jp3,"West");
		jp5.add(jp4,"East");
		//把jp5加入到全局的South
		this.add(jp1,"North");
		this.add(jp2,"Center");
		this.add(jp5,"South");
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jp1_jb1){
			String getInput = jtf1.getText();
			if(getInput.equals("")){
				this.refreshTable();
			} else{
			String sql = "select empId,empName,empSex,empJob from emp where empName=? "
					+ "or empId=? or  empJob=?";
			String array[]={getInput,getInput,getInput};
			em = new EmpModel();
			em.queryEmp(sql, array);
			}
			//更新JTable
			jp2_jtable.setModel(em);
			jtf1.setText(null);
		}
		else if(e.getSource()==jp4_jb1){
			int selectRow = jp2_jtable.getSelectedRow();
			String getempId= (String)em.getValueAt(selectRow, 0);
			String getempName=(String)em.getValueAt(selectRow, 1);
			EmpAllInfo ei = new EmpAllInfo("员工："+getempName+"  "
					+ "详细信息",getempId);
		}
		//添加新员工
		else if(e.getSource()==jp4_jb2){
			EmpAdd  ea = new EmpAdd();	
			
			}
		
		//删除员工
		else if(e.getSource()==jp4_jb4){
			int selectRow = jp2_jtable.getSelectedRow();
			//得到选中行员工的empId
			String getid = (String)em.getValueAt(selectRow, 0);
			String sql = "delete from emp where empId=?";
			String array[]={getid};
			em.updateEmp(sql, array);
			JOptionPane.showMessageDialog(this, "删除记录成功");
			this.refreshTable();
		}
		else if(e.getSource()==jp4_jb3){
			int selectRow = jp2_jtable.getSelectedRow();
			//得到选中行员工的empId
			String getid = (String)em.getValueAt(selectRow, 0);
			String getname =(String)em.getValueAt(selectRow, 1);
			String info[]={getid,getname};
			EmpUpdate eu = new EmpUpdate(info);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jp2_jtable){
			jp4_jb1.setEnabled(true);
			jp4_jb3.setEnabled(true);
			jp4_jb4.setEnabled(true);
		}
		else if(e.getSource()!=jp2_jtable && e.getClickCount()==2){
			jp2_jtable.clearSelection();
			jp4_jb1.setEnabled(false);
			jp4_jb3.setEnabled(false);
			jp4_jb4.setEnabled(false);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
}
