package com.mhl.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mhl.model.UserModel;
import com.mhl.tools.MyTools;
public class UserLogin extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3;
	JTextField jName;
	JPasswordField jPasswd;
	JButton jb1,jb2;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		UserLogin userlogin = new UserLogin();
	}
	public UserLogin(){
		
		//���ò���Ϊ�ղ���
		this.setLayout(null);
		//��ʼ����ť
		jb1 = new JButton("ȷ��");
		jb1.setFont(MyTools.f2);
		jb1.setForeground(Color.blue);
		jb1.setBounds(110, 300, 60, 25);
		this.add(jb1);
		jb2 = new JButton("ȡ��");
		jb2.setFont(MyTools.f2);
		jb2.setForeground(Color.blue);
		jb2.setBounds(220, 300, 60, 25);
		this.add(jb2);
		//��ʼ����ǩ
		jl1 = new JLabel("�������û���:");
		jl1.setFont(MyTools.f1);
		jName = new JTextField(10);
		//��ʼ����ǩ
		jl2 = new JLabel("(��Ա����)");
		jl2.setForeground(Color.red);
		//��ʼ����ǩ
		jl3 = new JLabel("����������:");
		jl3.setFont(MyTools.f1);
		jPasswd = new JPasswordField(10);
		//����λ��
		jl1.setBounds(55, 180, 150, 30);
		jName.setBounds(170,180, 150, 30);
		jl2.setBounds(100, 200, 75, 30);
		jl3.setBounds(55, 230, 150, 30);
		jPasswd.setBounds(170, 230, 150, 30);
		//����һ��BackImage��
		BackImage bi=new BackImage();
		//����ͼƬλ��
		bi.setBounds(0, 0, 360, 360);
		//��������ʾ����Ļ���м�
		int w=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int h=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		//���뵽������
		this.add(jl1);
		this.add(jl2);
		this.add(jName);
		this.add(jl3);
		this.add(jPasswd);
		this.add(bi);
		this.setSize(360, 360);
		this.setUndecorated(true);
		this.setLocation(w/2-200, h/2-150);
		this.setVisible(true);
		//ע�����
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	//�����ڲ��࣬������ͼƬ
	class BackImage extends JPanel{
		Image img;
		public BackImage(){
			//�õ�ͼƬ
			img = new ImageIcon("img/userlogin.gif").getImage();
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, 360, 360, this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==jb2){
			System.exit(0);
		}
		else if(e.getSource()==jb1){
			UserModel um = new UserModel();
			String getId=jName.getText().trim();
			String getPwd=new String(jPasswd.getPassword());
			String info[]=um.checkUser(getId, getPwd);
			if(info[0].equals("����")||info[0].equals("����")||info[0].equals("����Ա")){
				Windows1 w1= new Windows1(info[0],info[1]);
				this.dispose();//�رյ�ǰ����
			}
			else if(info[0].equals("")){
				JOptionPane.showMessageDialog(this, "��������û������������");
				jName.setText(null);
				jPasswd.setText(null);
			}
		}
	}
}
