/*
 * 这是系统管理员，经理，主管可以进入的操作界面，其他人不能进.
 */
package com.mhl.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.Timer;

import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;

public class Windows1 extends JFrame implements ActionListener,MouseListener{
	//定义一个标签
	JLabel timeNow,jp1_jl1,jp1_jl2,jp1_jl3,jp1_jl4,jp1_jl5,jp1_jl6,jp1_jl7,jp1_jl8;//可以用来显示当前时间
	JLabel jp2_jl1,jp2_jl2;
	//javax.swing.Timer类可以定时的触发Action时间，我们可以利用它让时间走起来
	Timer t;
	//定义两个卡片布局
	 CardLayout Cardjp2 =null;
	 CardLayout Cardjp3 =null;
	//定义需要的五个面板
	JPanel jp1,jp2,jp3,jp4,jp5;
	//定义需要的组件
	Image titelIcon,timebg,jp1bg;
	JSplitPane jspt =null;//分割栏
	//菜单栏
	JMenuBar jmb;
	//工具栏
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//一级菜单
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//二级菜单
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6,jmi7,jmi8,jmi9,jmi10,jmi11,jmi12;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Windows1 w1 = new Windows1("牛逼","管理员");
	}
	//初始化菜单
	public void initMenu(){
		//创建一级菜单
				jm1 = new JMenu("系统管理");
				jm1.setFont(MyTools.f1);
				//创建它的二级菜单
				jmi1= new JMenuItem("切换用户",new ImageIcon("img/login_b.jpg"));
				jmi1.setFont(MyTools.f2);
				jmi2= new JMenuItem("切换到收款界面",new ImageIcon("img/hr_b.jpg"));
				jmi2.setFont(MyTools.f2);
				jmi3= new JMenuItem("登陆管理",new ImageIcon("img/pc_b.jpg"));
				jmi3.setFont(MyTools.f2);
				jmi4= new JMenuItem("万年历",new ImageIcon("img/wnl.jpg"));
				jmi4.setFont(MyTools.f2);
				jmi5= new JMenuItem("退出",new ImageIcon("img/info_b.jpg"));
				jmi5.setFont(MyTools.f2);
				//加入
				jm1.add(jmi1);
				jm1.add(jmi2);
				jm1.add(jmi3);
				jm1.add(jmi4);
				jm1.add(jmi5);
				jm2 = new JMenu("人事管理");
				jm2.setFont(MyTools.f1);
				jm3 = new JMenu("菜单服务");
				jm3.setFont(MyTools.f1);
				jm4 = new JMenu("报表统计");
				jm4.setFont(MyTools.f1);
				jm5 = new JMenu("成本及库房");
				jm5.setFont(MyTools.f1);
				jm6 = new JMenu("帮助");
				jm6.setFont(MyTools.f1);
				//把一级菜单加入到菜单栏
				jmb = new JMenuBar();
				jmb.add(jm1);
				jmb.add(jm2);
				jmb.add(jm3);
				jmb.add(jm4);
				jmb.add(jm5);
				jmb.add(jm6);
				//把菜单栏添加到JFrame
				this.setJMenuBar(jmb);
				
	}
	//初始化工具栏
	public void initToolBar(){
		//创建工具栏
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton(new ImageIcon("img/JToolBar/jb01.jpg"));
		jb2 = new JButton(new ImageIcon("img/JToolBar/jb2.jpg"));
		jb3 = new JButton(new ImageIcon("img/JToolBar/jb3.jpg"));
		jb4 = new JButton(new ImageIcon("img/JToolBar/jb4.jpg"));
		jb5 = new JButton(new ImageIcon("img/JToolBar/jb5.jpg"));
		jb6 = new JButton(new ImageIcon("img/JToolBar/jb6.jpg"));
		jb7 = new JButton(new ImageIcon("img/JToolBar/jb7.jpg"));
		jb8 = new JButton(new ImageIcon("img/JToolBar/jb8.jpg"));
		jb9 = new JButton(new ImageIcon("img/JToolBar/jb9.jpg"));
		jb10 = new JButton(new ImageIcon("img/JToolBar/jb10.jpg"));
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
	}
	//初始化中间所有Panel
	public void initAllPanel(){
		//处理jp1面板
				jp1 = new JPanel(new BorderLayout());
				//获取jp1背景图
				jp1bg = new ImageIcon("img/jp1_bg.jpg").getImage();
				ImagePanel ip1 = new ImagePanel(jp1bg);
				//将ip1设置为GirdLayout布局
				ip1.setLayout(new GridLayout(8,1));
				//创建光标图案(鼠标放在JLabel上就显示这个)
				Cursor myCursor = new Cursor(Cursor.HAND_CURSOR);
				jp1_jl1=new JLabel(new ImageIcon("img/jp1_JLabel/label_1.jpg"));
				jp1_jl2=new JLabel("人 事 登 记",new ImageIcon("img/jp1_JLabel/label_2.jpg"),JLabel.CENTER);
				jp1_jl2.setFont(MyTools.f2B);
				jp1_jl2.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl2.addMouseListener(this);
				//设置光标图案
				jp1_jl2.setCursor(myCursor);
				jp1_jl3=new JLabel("登 陆 管 理",new ImageIcon("img/jp1_JLabel/label_3.jpg"),JLabel.CENTER);
				jp1_jl3.setFont(MyTools.f2B);
				jp1_jl3.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl3.addMouseListener(this);
				//设置光标图案
				jp1_jl3.setCursor(myCursor);
				jp1_jl4=new JLabel("菜 谱 价 格",new ImageIcon("img/jp1_JLabel/label_4.jpg"),JLabel.CENTER);
				jp1_jl4.setFont(MyTools.f2B);
				jp1_jl4.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl4.addMouseListener(this);
				//设置光标图案
				jp1_jl4.setCursor(myCursor);
				jp1_jl5=new JLabel("报 表 统 计",new ImageIcon("img/jp1_JLabel/label_5.jpg"),JLabel.CENTER);
				jp1_jl5.setFont(MyTools.f2B);
				jp1_jl5.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl5.addMouseListener(this);
				//设置光标图案
				jp1_jl5.setCursor(myCursor);
				jp1_jl6=new JLabel("成本及库房",new ImageIcon("img/jp1_JLabel/label_6.jpg"),JLabel.CENTER);
				jp1_jl6.setFont(MyTools.f2B);
				jp1_jl6.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl6.addMouseListener(this);
				//设置光标图案
				jp1_jl6.setCursor(myCursor);
				jp1_jl7=new JLabel("系 统 设 置",new ImageIcon("img/jp1_JLabel/label_7.jpg"),JLabel.CENTER);
				jp1_jl7.setFont(MyTools.f2B);
				jp1_jl7.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl7.addMouseListener(this);
				//设置光标图案
				jp1_jl7.setCursor(myCursor);
				jp1_jl8=new JLabel("动 画 帮 助",new ImageIcon("img/jp1_JLabel/label_8.jpg"),JLabel.CENTER);
				jp1_jl8.setFont(MyTools.f2B);
				jp1_jl8.setEnabled(false);
				//注册鼠标监听事件
				jp1_jl8.addMouseListener(this);
				//设置光标图案
				jp1_jl8.setCursor(myCursor);
				ip1.add(jp1_jl1);
				ip1.add(jp1_jl2);
				ip1.add(jp1_jl3);
				ip1.add(jp1_jl4);
				ip1.add(jp1_jl5);
				ip1.add(jp1_jl6);
				ip1.add(jp1_jl7);
				ip1.add(jp1_jl8);
				jp1.add(ip1);
				//处理jp2,jp3,jp4面板
				jp4 = new JPanel(new BorderLayout());
				//jp2为卡片布局
				Cardjp2= new CardLayout();
				jp2 = new JPanel(Cardjp2);
				jp2_jl1 = new JLabel(new ImageIcon("img/p2_left.jpg"));
				jp2_jl1.addMouseListener(this);
				jp2_jl2 = new JLabel(new ImageIcon("img/p2_right.jpg"));
				jp2_jl2.addMouseListener(this);
				jp2.add(jp2_jl1,"0");
				jp2.add(jp2_jl2,"1");
				//jp3为卡片布局
			    Cardjp3 = new CardLayout();
				jp3 = new JPanel(Cardjp3);
				//先给p3加入一个主界面的卡片
				ImagePanel ip3= new ImagePanel(new ImageIcon("img/jp3_test/00.jpg").getImage());
				//将这个主界面卡片加入到jp3中
				jp3.add(ip3,"0");
				//创建人事管理Panel的对象,放入jp3中当做人事管理卡片
				EmpInfo empInfoPanel = new EmpInfo();
				jp3.add(empInfoPanel,"1");
				//把jp2,jp3加入到jp4
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				//做一个拆分窗口,将jp1和jp4加入其中,jp1在左边
				jspt = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
				jspt.setDividerSize(0);
				//指定左边的面板占据多大的范围
				jspt.setDividerLocation(200);
	}
    public Windows1(String job,String name){
		//创建组件
		titelIcon = new ImageIcon("img/cup.gif").getImage();
		//调用初始化菜单函数
		this.initMenu();
		//调用初始化工具栏函数
		this.initToolBar();
		//调用初始化中间所有Panel的函数(jp1,jp2,jp3,jp4)
		this.initAllPanel();
		//处理jp5面板
		jp5 = new JPanel(new BorderLayout());
		//显示当前的时间
		 timeNow = new JLabel("当前时间:"+Calendar.getInstance().getTime().toLocaleString()+"                ");
		 timeNow.setFont(MyTools.f2);
		 timebg=new ImageIcon("img/time_bg.jpg").getImage();
		 ImagePanel ip = new ImagePanel(timebg);
		 ip.setLayout(new BorderLayout());
		 ip.add(timeNow,"East");
		//从JFrame中取得Container
		//每隔一秒去触发ActionEvent
		 t = new Timer(1000, this);
		 t.start();
		 jp5.add(ip);
		Container ct =this.getContentPane();
		ct.add(jtb,"North");
		ct.add(jp5,"South");
		ct.add(jspt,"Center");
		//获得屏幕大小
		int w=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int h=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setSize(w, h-40);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口的图标
		this.setIconImage(titelIcon);
		this.setTitle("满汉楼餐饮管理系统"+"          "+"当前用户："+name+"   职位:"+job);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		this.timeNow.setText("当前时间:"+Calendar.getInstance().getTime().toLocaleString()+"                ");
	}
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jp1_jl2){
			Cardjp3.show(jp3, "1");
		}
		else if (e.getSource()==jp2_jl1){
			Cardjp2.show(jp2, "1");
			this.jspt.setDividerLocation(0);
		}
		else if (e.getSource()==jp2_jl2){
			Cardjp2.show(jp2, "0");
			this.jspt.setDividerLocation(200);
		}
	}
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		//如果用户选择了某个JLabel操作,则JLabel要高亮,取消灰暗效果
		if(e.getSource()==jp1_jl2){
			jp1_jl2.setEnabled(true);
		}
		else if(e.getSource()==jp1_jl3){
			jp1_jl3.setEnabled(true);
		}
		else if(e.getSource()==jp1_jl4){
			jp1_jl4.setEnabled(true);
		}
		else if(e.getSource()==jp1_jl5){
			jp1_jl5.setEnabled(true);
		}
		else if(e.getSource()==jp1_jl6){
			jp1_jl6.setEnabled(true);
		}
		else if(e.getSource()==jp1_jl7){
			jp1_jl7.setEnabled(true);
		}
		else if(e.getSource()==jp1_jl8){
			jp1_jl8.setEnabled(true);
		}
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==jp1_jl2){
			jp1_jl2.setEnabled(false);
		}
		else if(e.getSource()==jp1_jl3){
			jp1_jl3.setEnabled(false);
		}
		else if(e.getSource()==jp1_jl4){
			jp1_jl4.setEnabled(false);
		}
		else if(e.getSource()==jp1_jl5){
			jp1_jl5.setEnabled(false);
		}
		else if(e.getSource()==jp1_jl6){
			jp1_jl6.setEnabled(false);
		}
		else if(e.getSource()==jp1_jl7){
			jp1_jl7.setEnabled(false);
		}
		else if(e.getSource()==jp1_jl8){
			jp1_jl8.setEnabled(false);
		}
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
}
