/**
 * 
 * @author Jantc
 *��һ���¹����������Ա������
 */
package com.mhl.view.Emp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.TableModel;

import com.mhl.db.SqlHelper;
import com.mhl.model.EmpModel;
import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;
public class EmpUpdate extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10;
	JRadioButton jrb1,jrb2,jrb3,jrb4;
	JComboBox jcb1,jcb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	JTextArea jta;
	JScrollPane jsp;
	JButton jb1,jb2,jb3;
	JPanel jp;
	static  String imgpath = null; 
	static ImagePanel ip =null;
	ButtonGroup bg =null;
	String ID=null;
	public EmpUpdate(String info[]) {
		this.ID=info[0];
		jl1= new JLabel("����:");
		jl1.setBounds(10, 0, 100, 50);
		jl1.setFont(MyTools.f1);
		jtf1 = new JTextField(20);
		jtf1.setText(info[1]);
		jtf1.setBounds(50, 15, 80, 20);
		jl2= new JLabel("�ֻ�:");
		jl2.setBounds(10, 40, 100, 50);
		jl2.setFont(MyTools.f1);
		jtf2 = new JTextField(20);
		jtf2.setBounds(50, 57, 80, 20);
		jl3= new JLabel("���:");
		jl3.setFont(MyTools.f1);
		jl3.setBounds(10, 82, 100, 50);
		jtf3 = new JTextField(20);
		jtf3.setText("���ɸ���");
		jtf3.setEditable(false);
		jtf3.setBounds(50, 99, 80, 20);
		jl4= new JLabel("��ַ:");
		jl4.setFont(MyTools.f1);
		jl4.setBounds(10, 125, 100, 50);
		jtf4 = new JTextField(20);
		jtf4.setBounds(50, 141, 80, 20);
		jl5= new JLabel("��֤:");
		jl5.setFont(MyTools.f1);
		jl5.setBounds(10, 167, 100, 50);
		jtf5 = new JTextField(20);
		jtf5.setBounds(50, 183, 80, 20);
		jl6= new JLabel("��ע:");
		jl6.setFont(MyTools.f1);
		jl6.setBounds(10, 220, 100, 50);
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jsp.setBounds(50, 230, 80, 50);
		//�ж��Ա�
		jl7= new JLabel("�Ա�:");
		jl7.setFont(MyTools.f1);
		jl7.setBounds(10, 280, 100, 50);
		jrb1 = new JRadioButton("��",true);
		jrb1.setBounds(50, 280, 40, 50);
		jrb2 = new JRadioButton("Ů");
		jrb2.setBounds(90, 280, 40, 50);
		//����һ����ť��
		 bg = new ButtonGroup();
		//��2����ѡ��ť���������
		bg.add(jrb1);
		bg.add(jrb2);
		jl8 = new JLabel("���:");
		jl8.setFont(MyTools.f1);
		jl8.setBounds(10, 313, 100, 50);
		//����״��
		jrb3 = new JRadioButton("δ��",true);
		jrb3.setFont(MyTools.f1);
		jrb3.setBounds(50, 313, 60, 50);
		jrb4 = new JRadioButton("�ѻ�");
		jrb4.setFont(MyTools.f1);
		jrb4.setBounds(110, 313, 60, 50);
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(jrb3);
		bg1.add(jrb4);
		
		//ѧ��
		jl9 = new JLabel("ѧ��:");
		jl9.setFont(MyTools.f1);
		jl9.setBounds(260, 220, 100, 50);
		String xl[]={"��","Сѧ","��ѧ","��ѧ","�о���"};
		jcb1 = new JComboBox(xl);
		jcb1.setFont(MyTools.f2);
		jcb1.setBounds(300, 230, 75, 40);
		
		//ְλ
		jl10 =new JLabel("ְλ:");
		jl10.setFont(MyTools.f1);
		jl10.setBounds(140, 220, 100, 50);
		String job[]={" ","����","����","��ʦ","����Ա","����Ա","����Ա"};
		jcb2 = new JComboBox(job);
		jcb2.setFont(MyTools.f1);
		jcb2.setBounds(180, 220, 75, 60);
		
		//��Ƭ+���ͼƬ��ť
		Image img = new ImageIcon("img/jp3_test/00.jpg").getImage();
		ip = new ImagePanel(img);
		ip.setBounds(200, 0, 183, 170);
		//��jb1����¼�.
		jb1 = new JButton("�޸���Ƭ");
		jb1.addActionListener(this);
		jb1.setFont(MyTools.f1);
		jb1.setBounds(250, 180, 100, 30);
		
		//ȷ�����Ա����ť+ȡ����ť
		jb2 = new JButton("�޸�Ա��");
		jb2.addActionListener(this);
		jb2.setFont(MyTools.f2);
		jb2.setBounds(200, 300, 100, 30);
		jb3 = new JButton("ȡ��");
		jb3.addActionListener(this);
		jb3.setFont(MyTools.f2);
		jb3.setBounds(320, 300, 60, 30);
		this.add(ip);
		this.add(jb3);
		this.add(jb2);
		this.add(jb1);
		this.add(jl10);
		this.add(jl9);
		this.add(jcb1);
		this.add(jcb2);
		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		this.add(jtf2);
		this.add(jl3);
		this.add(jtf3);
		this.add(jl4);
		this.add(jtf4);
		this.add(jl5);
		this.add(jtf5);
		this.add(jl6);
		this.add(jsp);
		this.add(jl7);
		this.add(jrb1);
		this.add(jrb2);
		this.add(jl8);
		this.add(jrb3);
		this.add(jrb4);
		this.setLayout(null);
		this.setSize(400, 400);
		//������ʾ����Ļ�м�
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/3, h/2-150);
		this.setTitle("�޸�Ա����Ϣ(������Ϊ��Ҳ�Ḳ��֮ǰ��¼)");
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==jb1){
			JFileChooser jf =new JFileChooser();
			jf.showOpenDialog(null);
			jf.setVisible(true);
			imgpath = jf.getSelectedFile().getAbsolutePath();
			Image img = new ImageIcon(imgpath).getImage();
			ip = new ImagePanel(img);
			ip.setBounds(200, 0, 183, 170);
			this.add(ip);
			ip.updateUI();
		}
		//���
		else if(e.getSource()==jb2){
			String name = jtf1.getText();
			System.out.println(name);
			String tel = jtf2.getText();
			String home =jtf4.getText().trim();
			String sfz = jtf5.getText();
			String bz =jta.getText().trim();
			String sex =null;
			if(jrb1.isSelected()){
				 sex = jrb1.getText();
			} else if(jrb2.isSelected()){
				 sex =jrb2.getText();
			}
			String hunfou =null;
			if(jrb3.isSelected()){
				 hunfou = jrb3.getText();
			} else if(jrb4.isSelected()){
				hunfou = jrb4.getText();
			}
			String xueli =jcb1.getSelectedItem().toString();
			String job = jcb2.getSelectedItem().toString();
			String sql="update emp set empName=?,empTel=?,empHome=?,empSFZid=?,empRemark=?,empMarrige=?,empEdu=?,empJob=?,empSex=? where empId=?";
			String array[]={name,tel,home,sfz,bz,hunfou,xueli,job,sex,ID};
			EmpModel em = new EmpModel();
			em.updateEmp(sql, array);
			this.dispose();
			}
			
		
		//ȡ��
		else if(e.getSource()==jb3){
			this.dispose();
		}
	}
}
