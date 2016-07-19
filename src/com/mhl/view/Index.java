/*
 * 用户登录的闪屏效果
 */
package com.mhl.view;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

//这里不用JFrame,用JWindow(没有JFrame外面的那些蓝色的框条，只有中间的窗口)
public class Index extends JWindow implements Runnable{
	//定义一个带有图片的JLabel
	JLabel jl;
	flashScreen fs;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			// 将当前窗体外观设置为所在操作系统的外观
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
		//设定窗口的初始位置
		int width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation(width/2-200, height/2-150);
		this.setVisible(true);
	}
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			try {
				Thread.sleep(30*500);//等待闪屏结束
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			this.dispose();//关闭此闪屏，跳转到登陆界面
			new UserLogin();
			break;
		}
	}
}
//开发一个闪屏类
class flashScreen extends JPanel implements Runnable{
	private String[] ads = {"满","汉","楼","融","满","汉","精","华","做","天","下","美","味","招","八","方","食","客","接","四","海","宾","朋","|","制","作","人","周","建","川"};
	private int flag=0;
	public flashScreen(){
		Thread t1 = new Thread(this);
		t1.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		//获得背景图片
		Image image;
		image = Toolkit.getDefaultToolkit().getImage("img/flashscreen.jpg");// 获得背景图片
		g.drawImage(image, 0, 0, this.getWidth(),this.getHeight()-50, this);
		//逐字写诗
		for(int j=0; j<=flag; j++){
			//题词
			g.setColor(Color.RED);
			Font myfont= new Font("宋体",Font.BOLD,16);
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
			//画进度条
			//进度条边框颜色
			Random r = new Random();
			int red = r.nextInt(255);
			int green = r.nextInt(255);
			int blue = r.nextInt(255);
			Color bordercolor= new Color(red,green,blue);
			g.setColor(bordercolor);
			g.drawRect(0, 250,399,49);
			//填充进度条
			g.setColor(Color.yellow);
			g.fillRect(0, 250, 9+flag*13, 48);
			//进度条的光标
			g.setColor(bordercolor);
			g.fillRect(9+flag*13, 250, 13, 48);
			//提示文字
			g.setColor(Color.BLACK);
			g.setFont(new Font("宋体",Font.PLAIN,12));
			if(flag%4 == 1){
				g.drawString("系  统  正  在  加  载 , 请  稍  后  *", 80, 280);
			}else if(flag%4 == 2){
				g.drawString("系  统  正  在  加  载 , 请  稍  后  * *", 80, 280);
			}else if(flag%4 == 3){
				g.drawString("系  统  正  在  加  载 , 请  稍  后  * * *", 80, 280);
			}else{
				g.drawString("系  统  正  在  加  载 , 请  稍  后  * * * *", 80, 280);
			}
		}
	}
	public void run() {
		// TODO 自动生成的方法存根
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
