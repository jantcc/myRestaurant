/*
 * ����һ�����Զ�̬����һ��ͼƬ��������JPanel
 */
package com.mhl.tools;
import java.awt.*;
import javax.swing.*;
public class ImagePanel extends JPanel {
	Image im;
	public ImagePanel(Image im){
		this.im=im;
		//����Panel��С(����Ӧ)
		int w=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int h=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setSize(w,h);
	}
	//��������
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(im, 0,0,this.getWidth(),this.getHeight(),this);
		
	}
}
