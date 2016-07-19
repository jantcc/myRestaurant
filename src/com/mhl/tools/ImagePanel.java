/*
 * 这是一个可以动态加载一个图片作背景的JPanel
 */
package com.mhl.tools;
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel {
	Image im;
	public ImagePanel(Image im){
		this.im=im;
		//设置Panel大小(自适应)
		int w=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int h=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setSize(w,h);
	}
	//画出背景
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(im, 0,0,this.getWidth(),this.getHeight(),this);
		
	}
}
