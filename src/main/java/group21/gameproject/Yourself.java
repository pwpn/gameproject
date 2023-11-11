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
    
    private double attack;
    private int speed;
    private double defence;
    private int level;
    private double blood;
    
    public int yourspeed;
    
    //战斗中
    public double yourattack;
    public double yourdefence;
    public double yourblood;
    public double lastblood;
    
    public int attlev=0;
    public int deflev=0;
	
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
        
        yourspeed=speed;
        yourattack=attack;
        yourdefence=defence;
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
    
    public double chaobisha(double yourattck,double bossdefence ){
        if((attlev+2)<=10){
            attlev+=2;
        }else if(attlev==9){
            attlev+=1;
        }
        if((deflev+2)<=10){
            deflev+=2;
        }else if(deflev==9){
            deflev+=1;
        }

        this.yourattack=attack+((attack/10)*attlev);
        this.yourdefence=defence+((defence/10)*deflev);
        
        System.out.println("ccc");
        
        return (yourattack/bossdefence)*160;
    }
    
    public void jineng1(){
//        lastblood=yourblood;
//        yourblood+=100;
//        System.out.println("1");

        if((attlev+2)<=10){
            attlev+=2;
        }else if(attlev==9){
            attlev+=1;
        }
        if((deflev+2)<=10){
            deflev+=2;
        }else if(deflev==9){
            deflev+=1;
        }
        this.yourattack=attack+((attack/10)*attlev);
        this.yourdefence=defence+((defence/10)*deflev);
    }
    
    public double jineng2(double yourattck,double bossdefence){
//                lastblood=yourblood;
//                yourblood-=100;
//                System.out.println("2");
           if((yourblood+50)<=blood){
               yourblood+=50;
           }else if(yourblood<blood){
               yourblood=blood;
           }
           
        return (yourattack/bossdefence)*80;
    }
    public double jineng3(double yourattck,double bossdefence){
        
        if((attlev+1)<=10){
            attlev+=1;
        }
        this.yourattack=attack+((attack/10)*attlev);        
//        yourblood-=100;
//                System.out.println("3");
        return (yourattack/bossdefence)*120;
    }
    public void jineng4(){
           if((yourblood+200)<=blood){
               yourblood+=200;
           }else if(yourblood<blood){
               yourblood=blood;
           }
//      System.out.println("4");
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
    
    public void returnyou(){
        this.yourattack=attack;
        this.yourspeed=speed;
        this.yourattack=attack;
        this.yourdefence=defence;
        this.yourblood=blood;
        this.lastblood=blood;      
        this.attack=0;
        this.attlev=0;
    }
    public void updateys(Theman tm){
        this.level=tm.level;
        this.attack=tm.attack;
        this.defence=tm.defence;
        this.speed=tm.speed;
        this.blood=tm.blood;        
    }
}
