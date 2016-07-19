/*
 * ����������ʾ���¹���Ľ���
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
	//�����������
	JPanel jp1,jp2,jp3,jp4,jp5;
	//����JLabel
	JLabel jp1_jl1,jp3_jl1;
	//�����ı���
	JTextField jtf1;
	//����JButton
	JButton jp1_jb1,jp1_jb2,jp4_jb1,jp4_jb2,jp4_jb3,jp4_jb4;
	//����һ����
	JTable jp2_jtable;
	//����һ��������
	JScrollPane jsp;
	//����һ��EmpModel����
	EmpModel em =null;
	//ˢ�±�
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
		//ȫ������ΪBorderLayout
		this.setLayout(new BorderLayout());
		//����jp1
		jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jp1_jl1 = new JLabel("����������(Ա���Ż���ְλ):");
		jtf1 = new JTextField(20);
		jp1_jb1 = new JButton("ˢ��");
		//ע�����
		jp1_jb1.addActionListener(this);
		jp1.add(jp1_jl1);
		jp1.add(jtf1);
		jp1.add(jp1_jb1);
		//����jp2
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
		//����jp3,jp4,jp5 (jp5=(jp3+jp4))
		jp5= new JPanel(new BorderLayout());
		//����jp3
		jp3 = new JPanel();
		jp3_jl1 = new JLabel("            ����"+em.getRowCount()+"����¼");
		jp3.add(jp3_jl1);
		//����jp4
		jp4 = new JPanel();
		jp4_jb1 = new JButton("��ϸ��Ϣ");
		jp4_jb1.setEnabled(false);
		jp4_jb2 = new JButton("���");
		jp4_jb3 = new JButton("�޸�");
		jp4_jb3.setEnabled(false);
		jp4_jb4 = new JButton("ɾ��");
		jp4_jb4.setEnabled(false);
		//��jp4��ťע�����
		jp4_jb1.addActionListener(this);
		jp4_jb2.addActionListener(this);
		jp4_jb3.addActionListener(this);
		jp4_jb4.addActionListener(this);
		jp4.add(jp4_jb1);
		jp4.add(jp4_jb2);
		jp4.add(jp4_jb3);
		jp4.add(jp4_jb4);
		//��jp3,jp4���뵽jp5
		jp5.add(jp3,"West");
		jp5.add(jp4,"East");
		//��jp5���뵽ȫ�ֵ�South
		this.add(jp1,"North");
		this.add(jp2,"Center");
		this.add(jp5,"South");
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
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
			//����JTable
			jp2_jtable.setModel(em);
			jtf1.setText(null);
		}
		else if(e.getSource()==jp4_jb1){
			int selectRow = jp2_jtable.getSelectedRow();
			String getempId= (String)em.getValueAt(selectRow, 0);
			String getempName=(String)em.getValueAt(selectRow, 1);
			EmpAllInfo ei = new EmpAllInfo("Ա����"+getempName+"  "
					+ "��ϸ��Ϣ",getempId);
		}
		//�����Ա��
		else if(e.getSource()==jp4_jb2){
			EmpAdd  ea = new EmpAdd();	
			
			}
		
		//ɾ��Ա��
		else if(e.getSource()==jp4_jb4){
			int selectRow = jp2_jtable.getSelectedRow();
			//�õ�ѡ����Ա����empId
			String getid = (String)em.getValueAt(selectRow, 0);
			String sql = "delete from emp where empId=?";
			String array[]={getid};
			em.updateEmp(sql, array);
			JOptionPane.showMessageDialog(this, "ɾ����¼�ɹ�");
			this.refreshTable();
		}
		else if(e.getSource()==jp4_jb3){
			int selectRow = jp2_jtable.getSelectedRow();
			//�õ�ѡ����Ա����empId
			String getid = (String)em.getValueAt(selectRow, 0);
			String getname =(String)em.getValueAt(selectRow, 1);
			String info[]={getid,getname};
			EmpUpdate eu = new EmpUpdate(info);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
}
