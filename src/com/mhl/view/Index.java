/*
 * �û���¼������Ч��
 */
package com.mhl.view;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

//���ﲻ��JFrame,��JWindow(û��JFrame�������Щ��ɫ�Ŀ�����ֻ���м�Ĵ���)
public class Index extends JWindow implements Runnable{
	//����һ������ͼƬ��JLabel
	JLabel jl;
	flashScreen fs;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
			// ����ǰ�����������Ϊ���ڲ���ϵͳ�����
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Index index = new Index();
		Thread t = new Thread(index);
		t.start();
	}
	public Index(){
		fs=new flashScreen();
		this.add(fs);
		
	

	
		this.setSize(400, 300);
		//�趨���ڵĳ�ʼλ��
		int width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
	}
	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
			try {
				Thread.sleep(30*500);//�ȴ���������
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			this.dispose();//�رմ���������ת����½����
			new UserLogin();
			break;
		}
	}
}
//����һ��������
class flashScreen extends JPanel implements Runnable{
	private String[] ads = {"��","��","¥","��","��","��","��","��","��","��","��","��","ζ","��","��","��","ʳ","��","��","��","��","��","��","|","��","��","��","��","��","��"};
	private int flag=0;
	public flashScreen(){
		Thread t1 = new Thread(this);
		t1.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		//��ñ���ͼƬ
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("img/flashscreen.jpg");// ��ñ���ͼƬ
		g.drawImage(image, 0, 0, this.getWidth(),this.getHeight()-50, this);
		//����дʫ
		for(int j=0; j<=flag; j++){
			//���
			g.setColor(Color.RED);
			Font myfont= new Font("����",Font.BOLD,16);
			g.setFont(myfont);
			if(j<3){
			g.drawString(ads[j], 250, 70+20*j);
			}
			else if(j<8){
			g.drawString(ads[j], 210, 70+20*(j-3));	
			}
			else if(j<13){
				g.drawString(ads[j], 170, 70+20*(j-8));	
				}
			else if(j<18){
				g.drawString(ads[j], 130, 70+20*(j-13));	
				}
			else if(j<23){
				g.drawString(ads[j], 90, 70+20*(j-18));	
				}
			else if(j<30){
				g.setColor(Color.blue);
				g.drawString(ads[j], 50, 70+20*(j-23));	
				}
			//��������
			//�������߿���ɫ
			Random r = new Random();
			int red = r.nextInt(255);
			int green = r.nextInt(255);
			int blue = r.nextInt(255);
			Color bordercolor= new Color(red,green,blue);
			g.setColor(bordercolor);
			g.drawRect(0, 250,399,49);
			//��������
			g.setColor(Color.yellow);
			g.fillRect(0, 250, 9+flag*13, 48);
			//�������Ĺ��
			g.setColor(bordercolor);
			g.fillRect(9+flag*13, 250, 13, 48);
			//��ʾ����
			g.setColor(Color.BLACK);
			g.setFont(new Font("����",Font.PLAIN,12));
			if(flag%4 == 1){
				g.drawString("ϵ  ͳ  ��  ��  ��  �� , ��  ��  ��  *", 80, 280);
			}else if(flag%4 == 2){
				g.drawString("ϵ  ͳ  ��  ��  ��  �� , ��  ��  ��  * *", 80, 280);
			}else if(flag%4 == 3){
				g.drawString("ϵ  ͳ  ��  ��  ��  �� , ��  ��  ��  * * *", 80, 280);
			}else{
				g.drawString("ϵ  ͳ  ��  ��  ��  �� , ��  ��  ��  * * * *", 80, 280);
			}
		}
	}
	public void run() {
		// TODO �Զ����ɵķ������
		while(flag<ads.length){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			flag++;
			this.repaint();
			 }
			
	    }
		
	}
