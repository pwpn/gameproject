/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public abstract class Boss extends GameObject{
//图片
	public  Image img;
//坐标
	public int x;
	public int y;
	
	public boolean left;
	public boolean right;
	public boolean up;
	public boolean down;
//游戏界面
	public GameFirstP gp;//=new GameFirstP();
        public Graphics ghi;
        public JFrame jf;
	
	public Boss(String img,int x,int y,JFrame jf){
                super(img,x,y,jf);
		this.img=Toolkit.getDefaultToolkit().getImage(img);
		this.x=x;
		this.y=y;
		this.jf=jf;	
//                jf.add(new GameFirstP());
	}

        @Override
	public abstract void paintSelft(Graphics g);
        @Override
	public abstract Rectangle getRec();
        public abstract int skill1();
        public abstract int skill2();
        public abstract int skill3();
        public abstract int skill4();
}
