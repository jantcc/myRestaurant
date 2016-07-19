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
		// TODO 自动生成的方法存根
		UserLogin userlogin = new UserLogin();
	}
	public UserLogin(){
		
		//设置布局为空布局
		this.setLayout(null);
		//初始化按钮
		jb1 = new JButton("确定");
		jb1.setFont(MyTools.f2);
		jb1.setForeground(Color.blue);
		jb1.setBounds(110, 300, 60, 25);
		this.add(jb1);
		jb2 = new JButton("取消");
		jb2.setFont(MyTools.f2);
		jb2.setForeground(Color.blue);
		jb2.setBounds(220, 300, 60, 25);
		this.add(jb2);
		//初始化标签
		jl1 = new JLabel("请输入用户名:");
		jl1.setFont(MyTools.f1);
		jName = new JTextField(10);
		//初始化标签
		jl2 = new JLabel("(或员工号)");
		jl2.setForeground(Color.red);
		//初始化标签
		jl3 = new JLabel("请输入密码:");
		jl3.setFont(MyTools.f1);
		jPasswd = new JPasswordField(10);
		//设置位置
		jl1.setBounds(55, 180, 150, 30);
		jName.setBounds(170,180, 150, 30);
		jl2.setBounds(100, 200, 75, 30);
		jl3.setBounds(55, 230, 150, 30);
		jPasswd.setBounds(170, 230, 150, 30);
		//创建一个BackImage类
		BackImage bi=new BackImage();
		//设置图片位置
		bi.setBounds(0, 0, 360, 360);
		//将窗口显示在屏幕正中间
		int w=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int h=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		//加入到窗体中
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
		//注册监听
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	//做个内部类，画背景图片
	class BackImage extends JPanel{
		Image img;
		public BackImage(){
			//得到图片
			img = new ImageIcon("img/userlogin.gif").getImage();
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, 360, 360, this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jb2){
			System.exit(0);
		}
		else if(e.getSource()==jb1){
			UserModel um = new UserModel();
			String getId=jName.getText().trim();
			String getPwd=new String(jPasswd.getPassword());
			String info[]=um.checkUser(getId, getPwd);
			if(info[0].equals("经理")||info[0].equals("主管")||info[0].equals("管理员")){
				Windows1 w1= new Windows1(info[0],info[1]);
				this.dispose();//关闭当前窗口
			}
			else if(info[0].equals("")){
				JOptionPane.showMessageDialog(this, "您输入的用户名或密码错误");
				jName.setText(null);
				jPasswd.setText(null);
			}
		}
	}
}
