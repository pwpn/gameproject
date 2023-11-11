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
public class Yourself extends GameObject{
    
    
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
    private Theman tm;
    
    private int attack;
    private int speed;
    private int defence;
    private int level;
    private double blood;
    public double yourblood;
    public double lastblood;
	
    public Yourself(String img,int x,int y,JFrame jf,Theman tm){	
        
        super(img,x,y,jf);
        
        this.x=x;
        this.img=Toolkit.getDefaultToolkit().getImage(img);
        this.y=y;
        this.jf=jf;
        this.tm=tm;
        
        this.level=tm.level;
        this.attack=tm.attack;
        this.defence=tm.defence;
        this.speed=tm.speed;
        this.blood=tm.blood;
        yourblood=blood;
        lastblood=blood;
    }
    

    @Override
    public void paintSelft(Graphics g) {
         g.drawImage(img, this.x, this.y, null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,img.getWidth(gp),img.getWidth(gp));
    }
    
    public void chaobisha(){
        System.out.println("ccc");
    }
    
    public void jineng1(){
        lastblood=yourblood;
        yourblood+=100;
//        System.out.println("1");
    }
    public void jineng2(){
                lastblood=yourblood;
                yourblood-=100;
//                System.out.println("2");
    }
    public void jineng3(){
//                System.out.println("3");
    }
    public void jineng4(){
//                System.out.println("4");
    }
    
    public boolean alive(){
        if(this.yourblood<=0){
            return false;
        }else{
            return true;
        }
    }
    
    
    public double getblood(){
        return blood;
    }

    public double getyourblood(){
        return this.yourblood;
    }
    public void setyourblood(int i,Yourself ys){
        lastblood=ys.yourblood;
        ys.yourblood=i;
        System.out.println(ys.yourblood);
    }
    
    public double getlastblood(){
        return this.lastblood;
    }
}
