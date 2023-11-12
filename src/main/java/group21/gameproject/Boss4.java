/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class Boss4 extends Boss{
    
    private int width=200;
    private int height=220;
    
    public int x;
    public int y;
    
    public double b1attack=400;
    public double b1defence=400;

    public int b1speed=3;
    public double b1blood=1500;
    
    public double b1nowattack=400;
    public double b1nowdefence=400;
    public double b1nowblood=1500;
    
    public int blattlev;
    public int bldeflev;
    
    public Image[] imgg=new Image[9];
    
    public Boss4(String img,int x,int y,JFrame jf){
        
            super(img,x,y,jf);
        
            this.x=x;
            this.y=y;
            
            b1blood=1500;
            b1speed=2;
            
            blattlev=0;
            bldeflev=0;
            
//        System.out.println("jhhh");

        for(int i = 1;i < imgg.length + 1;i ++){
                try{
                    imgg[i - 1] = ImageIO.read(new File("src/boss4/boss4" + i + ".png"));
                } catch (IOException ex) {
                    Logger.getLogger(Boss1.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        setImg(img);
    }
    

    
    public void setImg(String img) {
	this.img=Toolkit.getDefaultToolkit().getImage(img);
    }
    
    @Override
    public void paintSelft(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,width,height);
    }


    public double skill1(double a,double b) {
        if((this.b1nowblood+400)>=b1blood){
            this.b1nowblood=b1blood;
        }else{
            this.b1nowblood+=400;
        }
        if((blattlev+2)<=10){
            blattlev+=2;
        }else if(blattlev==9){
            blattlev+=1;
        }
        if((bldeflev+2)<=10){
            bldeflev+=2;
        }else if(bldeflev==9){
            bldeflev+=1;
        }
        
        this.b1nowattack=b1attack+((b1attack/10)*blattlev); 
        this.b1nowdefence=b1defence+((b1defence/10)*bldeflev);
        System.out.println(1);
        return 0;
    }


    public double skill2(double a,double b) {
        if((this.b1nowblood+50)>=b1blood){
            this.b1nowblood=b1blood;
        }else{
            this.b1nowblood+=50;
        }
        if((blattlev+2)<=10){
            blattlev+=2;
        }else if(blattlev==9){
            blattlev+=1;
        }
        this.b1nowattack=b1attack+((b1attack/10)*blattlev);        
                System.out.println(2);
        return (a/b)*150;
    }


    public double skill3(double a,double b) {
//        if((blattlev+1)<=10){
//            blattlev+=1;
//        }
//        
//        this.b1nowattack=b1attack+((b1attack/10)*blattlev);            
                System.out.println(3);
        return (a/b)*120;
    }


    public double skill4(double a,double b) {
        if((blattlev+1)<=10){
            blattlev+=1;
        }
        if((bldeflev+1)<=10){
            bldeflev+=1;
        }
        
        this.b1nowattack=b1attack+((b1attack/10)*blattlev); 
        this.b1nowdefence=b1defence+((b1defence/10)*bldeflev);
                System.out.println(4);
        return (a/b)*20;
    }
    
    public boolean alive(){
        if(this.b1nowblood<=0){
            return false;
        }else{
            return true;
        }
    }
    
    
    public int randomm(){
        Random rd=new Random();
        int a=rd.nextInt(101);
        
        if(a>0&&a<=25){
            return 1;
        }else if(a>25&&a<=50){
            return 2;
        }else if(a>50&&a<=75){
            return 3;
        }else{
            return 4;
        }
    }
    
    public void returnbo(){
        this.b1nowattack=this.b1attack;
        this.b1nowblood=this.b1blood;
        this.b1nowdefence=this.b1defence;
        this.blattlev=0;
        this.bldeflev=0;
    }
}
