/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import account.User;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class Theman extends GameObject{
    
//    public Graphics gh=null;
    
    public double attack=100;
    public double defence=50;
    public int level=1;
    public double blood=600;
    public int speed=1;
    
        
    private static boolean istouched=false;
    private static boolean isinthestar=true;
    
    public static int x = 200;
    public static int y = 300;
    
    private static int m_x=200;
    private static int m_y=300;
    
    //走路
    private int foot=3;
    
    public int width=32;
    public int height=32;
    
    public Theman(String img,int x,int y,JFrame jf){
        
        super(img,x,y,jf);
              

        this.attack=attack+20*(level-1);
        this.blood=blood+50*(level-1);
        this.defence=defence+10*(level-1);
        
//        System.out.println("jhhh");
        setImg(img);
    }
    
    public void update(){
        x = 200;
        y = 300;
        m_x=200;
        m_y=300;
        this.attack=attack+20*(level-1);
        this.blood=blood+50*(level-1);
        this.defence=defence+10*(level-1); 
        User.setLevel(level);
        User.CheckUserFrame();
        try {
            User.SaveData();
        } catch (SQLException ex) {
            Logger.getLogger(Theman.class.getName()).log(Level.SEVERE, "Failed to save", ex);
        }
    }
    
    public void strong(int a,int d,int b){
        
    }
    
    public void paint(Canvas canvas, Paint paint){
        
    }

    public void setImg(String img) {
	this.img=Toolkit.getDefaultToolkit().getImage(img);
    }
    
    @Override
    public void paintSelft(Graphics g) {
        g.drawImage(img, this.x, this.y, null);
        move();
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,width,height);
    }
    
    public void mousePressed(MouseEvent e){
//        System.out.println("KKK");
        this.m_x=e.getX()-6;
        this.m_y=e.getY()-15;
//        System.out.println(m_x);
        move();
    }
    
    public void keyPressed(KeyEvent e) {
	int key=e.getKeyCode();
	switch(key){
	    case KeyEvent.VK_A:
                x+=foot;
		left = true;break;
	    case KeyEvent.VK_S:
                y+=foot;
		down=true;break;
	    case KeyEvent.VK_D:
                x-=foot;
		right=true;break;
	    case KeyEvent.VK_W:
                y-=foot;
		up=true;break;
	    default:
		break;
		}
	}
    public void keyReleased(KeyEvent e) {
	int key=e.getKeyCode();
	switch(key){
	    case KeyEvent.VK_A:
		left=false;break;
	    case KeyEvent.VK_S:
		down=false;break;
	    case KeyEvent.VK_D:
		right=false;break;
	    case KeyEvent.VK_W:
		up=false;break;
	   default:
		break;
		}
    }
    
    public boolean isinit(){
        return isinthestar;
    }

    public void move() {
        isinthestar=false;

        if((x-3)>m_x){
            this.x-=foot;
        }else if((x+3)<m_x){
            this.x+=foot;
        }
        
        if((y+3)<m_y){
            this.y+=foot;
//            try {
//		Thread.sleep(25);
//	    } catch (Exception e) {
//		e.printStackTrace();
//	    }
//            move();
//            this.paintSelft(g);
        }else if((y-3)>m_y){
            this.y-=foot;
//            move();
//            this.paintSelft(g);
        }else{
//            System.out.print("out out out+="+isinthestar);
            isinthestar=true;
        }
        
//        hittouch();
    }
    
    public void hittouch(){
        istouched=false;
        Boss boss=this.gp.boss;
//        System.out.println(" "+this.x+" "+this.y );
        if(this.getRec().intersects(boss.getRec())) {
            istouched=true;
//            System.out.println("666666666666");
	}	  
    }
    
    public boolean getistouched(){
        return istouched;
    }
    public void setistouched(boolean xxx){
        this.istouched=xxx;
    }
}
