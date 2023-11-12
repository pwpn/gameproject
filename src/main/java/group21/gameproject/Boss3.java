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
public class Boss3 extends Boss{
    
    private int width=150;
    private int height=221;
    
    public int x;
    public int y;
    
    public double b1attack=200;
    public double b1defence=400;

    public int b1speed=3;
    public double b1blood=1200;
    
    public double b1nowattack=200;
    public double b1nowdefence=400;
    public double b1nowblood=1200;
    
    public int blattlev;
    public int bldeflev;
    
    public Image[] imgg=new Image[9];
    
    public Boss3(String img,int x,int y,JFrame jf){
        
        super(img,x,y,jf);
        
            this.x=x;
            this.y=y;
            
            b1blood=1200;
            b1speed=2;
            
            blattlev=0;
            bldeflev=0;
            
//        System.out.println("jhhh");

        for(int i = 1;i < imgg.length + 1;i ++){
                try{
                    imgg[i - 1] = ImageIO.read(new File("src/boss3/boss3" + i + ".png"));
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
        if((blattlev+1)<=10){
            blattlev+=1;
        }
        this.b1nowattack=b1attack+((b1attack/10)*blattlev);
        
        System.out.println(1);
        if(randomm1()==1){
            return (a/b)*150;
        }else{
            return (a/b)*300;
        }
    }


    public int skill2() {
        if((this.b1nowblood+500)>=b1blood){
            this.b1nowblood=b1blood;
        }else{
            this.b1nowblood+=500;
        }
        if((blattlev+1)<=10){
            blattlev+=1;
        }
        
        this.b1nowattack=b1attack+((b1attack/10)*blattlev);        
                System.out.println(2);
        return 1;
    }


    public double skill3(double a,double b) {
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
                System.out.println(3);
        return 0;
    }


    public double skill4(double a,double b) {
        System.out.println(4);
        return (a/b)*50;
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
    public int randomm1(){
            Random rd=new Random();
            int a=rd.nextInt(101);

            if(a>0&&a<=50){
                return 1;
            }else{
                return 2;
            }
        }
    public int randomm2(){
            Random rd=new Random();
            int a=rd.nextInt(101);

            if(a>0&&a<=20){
                return 1;
            }else{
                return 2;
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
