/*
 * ����ϵͳ����Ա���������ܿ��Խ���Ĳ������棬�����˲��ܽ�.
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
	//����һ����ǩ
	JLabel timeNow,jp1_jl1,jp1_jl2,jp1_jl3,jp1_jl4,jp1_jl5,jp1_jl6,jp1_jl7,jp1_jl8;//����������ʾ��ǰʱ��
	JLabel jp2_jl1,jp2_jl2;
	//javax.swing.Timer����Զ�ʱ�Ĵ���Actionʱ�䣬���ǿ�����������ʱ��������
	Timer t;
	//����������Ƭ����
	 CardLayout Cardjp2 =null;
	 CardLayout Cardjp3 =null;
	//������Ҫ��������
	JPanel jp1,jp2,jp3,jp4,jp5;
	//������Ҫ�����
	Image titelIcon,timebg,jp1bg;
	JSplitPane jspt =null;//�ָ���
	//�˵���
	JMenuBar jmb;
	//������
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//һ���˵�
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//�����˵�
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6,jmi7,jmi8,jmi9,jmi10,jmi11,jmi12;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Windows1 w1 = new Windows1("ţ��","����Ա");
	}
	//��ʼ���˵�
	public void initMenu(){
		//����һ���˵�
				jm1 = new JMenu("ϵͳ����");
				jm1.setFont(MyTools.f1);
				//�������Ķ����˵�
				jmi1= new JMenuItem("�л��û�",new ImageIcon("img/login_b.jpg"));
				jmi1.setFont(MyTools.f2);
				jmi2= new JMenuItem("�л����տ����",new ImageIcon("img/hr_b.jpg"));
				jmi2.setFont(MyTools.f2);
				jmi3= new JMenuItem("��½����",new ImageIcon("img/pc_b.jpg"));
				jmi3.setFont(MyTools.f2);
				jmi4= new JMenuItem("������",new ImageIcon("img/wnl.jpg"));
				jmi4.setFont(MyTools.f2);
				jmi5= new JMenuItem("�˳�",new ImageIcon("img/info_b.jpg"));
				jmi5.setFont(MyTools.f2);
				//����
				jm1.add(jmi1);
				jm1.add(jmi2);
				jm1.add(jmi3);
				jm1.add(jmi4);
				jm1.add(jmi5);
				jm2 = new JMenu("���¹���");
				jm2.setFont(MyTools.f1);
				jm3 = new JMenu("�˵�����");
				jm3.setFont(MyTools.f1);
				jm4 = new JMenu("����ͳ��");
				jm4.setFont(MyTools.f1);
				jm5 = new JMenu("�ɱ����ⷿ");
				jm5.setFont(MyTools.f1);
				jm6 = new JMenu("����");
				jm6.setFont(MyTools.f1);
				//��һ���˵����뵽�˵���
				jmb = new JMenuBar();
				jmb.add(jm1);
				jmb.add(jm2);
				jmb.add(jm3);
				jmb.add(jm4);
				jmb.add(jm5);
				jmb.add(jm6);
				//�Ѳ˵�����ӵ�JFrame
				this.setJMenuBar(jmb);
				
	}
	//��ʼ��������
	public void initToolBar(){
		//����������
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
	//��ʼ���м�����Panel
	public void initAllPanel(){
		//����jp1���
				jp1 = new JPanel(new BorderLayout());
				//��ȡjp1����ͼ
				jp1bg = new ImageIcon("img/jp1_bg.jpg").getImage();
				ImagePanel ip1 = new ImagePanel(jp1bg);
				//��ip1����ΪGirdLayout����
				ip1.setLayout(new GridLayout(8,1));
				//�������ͼ��(������JLabel�Ͼ���ʾ���)
				Cursor myCursor = new Cursor(Cursor.HAND_CURSOR);
				jp1_jl1=new JLabel(new ImageIcon("img/jp1_JLabel/label_1.jpg"));
				jp1_jl2=new JLabel("�� �� �� ��",new ImageIcon("img/jp1_JLabel/label_2.jpg"),JLabel.CENTER);
				jp1_jl2.setFont(MyTools.f2B);
				jp1_jl2.setEnabled(false);
				//ע���������¼�
				jp1_jl2.addMouseListener(this);
				//���ù��ͼ��
				jp1_jl2.setCursor(myCursor);
				jp1_jl3=new JLabel("�� ½ �� ��",new ImageIcon("img/jp1_JLabel/label_3.jpg"),JLabel.CENTER);
				jp1_jl3.setFont(MyTools.f2B);
				jp1_jl3.setEnabled(false);
				//ע���������¼�
				jp1_jl3.addMouseListener(this);
				//���ù��ͼ��
				jp1_jl3.setCursor(myCursor);
				jp1_jl4=new JLabel("�� �� �� ��",new ImageIcon("img/jp1_JLabel/label_4.jpg"),JLabel.CENTER);
				jp1_jl4.setFont(MyTools.f2B);
				jp1_jl4.setEnabled(false);
				//ע���������¼�
				jp1_jl4.addMouseListener(this);
				//���ù��ͼ��
				jp1_jl4.setCursor(myCursor);
				jp1_jl5=new JLabel("�� �� ͳ ��",new ImageIcon("img/jp1_JLabel/label_5.jpg"),JLabel.CENTER);
				jp1_jl5.setFont(MyTools.f2B);
				jp1_jl5.setEnabled(false);
				//ע���������¼�
				jp1_jl5.addMouseListener(this);
				//���ù��ͼ��
				jp1_jl5.setCursor(myCursor);
				jp1_jl6=new JLabel("�ɱ����ⷿ",new ImageIcon("img/jp1_JLabel/label_6.jpg"),JLabel.CENTER);
				jp1_jl6.setFont(MyTools.f2B);
				jp1_jl6.setEnabled(false);
				//ע���������¼�
				jp1_jl6.addMouseListener(this);
				//���ù��ͼ��
				jp1_jl6.setCursor(myCursor);
				jp1_jl7=new JLabel("ϵ ͳ �� ��",new ImageIcon("img/jp1_JLabel/label_7.jpg"),JLabel.CENTER);
				jp1_jl7.setFont(MyTools.f2B);
				jp1_jl7.setEnabled(false);
				//ע���������¼�
				jp1_jl7.addMouseListener(this);
				//���ù��ͼ��
				jp1_jl7.setCursor(myCursor);
				jp1_jl8=new JLabel("�� �� �� ��",new ImageIcon("img/jp1_JLabel/label_8.jpg"),JLabel.CENTER);
				jp1_jl8.setFont(MyTools.f2B);
				jp1_jl8.setEnabled(false);
				//ע���������¼�
				jp1_jl8.addMouseListener(this);
				//���ù��ͼ��
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
				//����jp2,jp3,jp4���
				jp4 = new JPanel(new BorderLayout());
				//jp2Ϊ��Ƭ����
				Cardjp2= new CardLayout();
				jp2 = new JPanel(Cardjp2);
				jp2_jl1 = new JLabel(new ImageIcon("img/p2_left.jpg"));
				jp2_jl1.addMouseListener(this);
				jp2_jl2 = new JLabel(new ImageIcon("img/p2_right.jpg"));
				jp2_jl2.addMouseListener(this);
				jp2.add(jp2_jl1,"0");
				jp2.add(jp2_jl2,"1");
				//jp3Ϊ��Ƭ����
			    Cardjp3 = new CardLayout();
				jp3 = new JPanel(Cardjp3);
				//�ȸ�p3����һ��������Ŀ�Ƭ
				ImagePanel ip3= new ImagePanel(new ImageIcon("img/jp3_test/00.jpg").getImage());
				//����������濨Ƭ���뵽jp3��
				jp3.add(ip3,"0");
				//�������¹���Panel�Ķ���,����jp3�е������¹���Ƭ
				EmpInfo empInfoPanel = new EmpInfo();
				jp3.add(empInfoPanel,"1");
				//��jp2,jp3���뵽jp4
				jp4.add(jp2,"West");
				jp4.add(jp3,"Center");
				//��һ����ִ���,��jp1��jp4��������,jp1�����
				jspt = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp4);
				jspt.setDividerSize(0);
				//ָ����ߵ����ռ�ݶ��ķ�Χ
				jspt.setDividerLocation(200);
	}
    public Windows1(String job,String name){
		//�������
		titelIcon = new ImageIcon("img/cup.gif").getImage();
		//���ó�ʼ���˵�����
		this.initMenu();
		//���ó�ʼ������������
		this.initToolBar();
		//���ó�ʼ���м�����Panel�ĺ���(jp1,jp2,jp3,jp4)
		this.initAllPanel();
		//����jp5���
		jp5 = new JPanel(new BorderLayout());
		//��ʾ��ǰ��ʱ��
		 timeNow = new JLabel("��ǰʱ��:"+Calendar.getInstance().getTime().toLocaleString()+"                ");
		 timeNow.setFont(MyTools.f2);
		 timebg=new ImageIcon("img/time_bg.jpg").getImage();
		 ImagePanel ip = new ImagePanel(timebg);
		 ip.setLayout(new BorderLayout());
		 ip.add(timeNow,"East");
		//��JFrame��ȡ��Container
		//ÿ��һ��ȥ����ActionEvent
		 t = new Timer(1000, this);
		 t.start();
		 jp5.add(ip);
		Container ct =this.getContentPane();
		ct.add(jtb,"North");
		ct.add(jp5,"South");
		ct.add(jspt,"Center");
		//�����Ļ��С
		int w=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int h=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setSize(w, h-40);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڵ�ͼ��
		this.setIconImage(titelIcon);
		this.setTitle("����¥��������ϵͳ"+"          "+"��ǰ�û���"+name+"   ְλ:"+job);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		this.timeNow.setText("��ǰʱ��:"+Calendar.getInstance().getTime().toLocaleString()+"                ");
	}
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		//����û�ѡ����ĳ��JLabel����,��JLabelҪ����,ȡ���Ұ�Ч��
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
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
}
