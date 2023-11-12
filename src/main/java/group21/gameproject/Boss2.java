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
public class Boss2 extends Boss{
    
    private int width=170;
    private int height=331;
    
    public int x;
    public int y;
    
    public double b1attack=300;
    public double b1defence=200;

    public int b1speed=3;
    public double b1blood=1000;
    
    public double b1nowattack=300;
    public double b1nowdefence=200;
    public double b1nowblood=1000;
    
    public int blattlev;
    public int bldeflev;
    
    public Image[] imgg=new Image[9];
    
    public Boss2(String img,int x,int y,JFrame jf){
        
        super(img,x,y,jf);
        
            this.x=x;
            this.y=y;
            
            b1blood=1000;
            b1speed=2;
            
            blattlev=0;
            bldeflev=0;
            
//        System.out.println("jhhh");

        for(int i = 1;i < imgg.length + 1;i ++){
                try{
                    imgg[i - 1] = ImageIO.read(new File("src/boss2/boss2" + i + ".png"));
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
        if((this.b1nowblood+50)>=b1blood){
            this.b1nowblood=b1blood;
        }else{
            this.b1nowblood+=50;
        }
        System.out.println(1);
        return 1;
    }


    public double skill2(double a,double b) {

        if((blattlev+2)<=10){
            blattlev+=2;
        }else if(blattlev==9){
            blattlev+=1;
        }
        this.b1nowattack=b1attack+((b1attack/10)*blattlev);        
                System.out.println(2);
        return (a/b)*100;
    }


    public double skill3(double a,double b) {
        if((blattlev+4)<=10){
            blattlev+=4;
        }else{
            blattlev=10;
        }
        
        this.b1nowattack=b1attack+((b1attack/10)*blattlev);            
                System.out.println(3);
        return 1;
    }


    public double skill4(double a,double b) {
        if((this.b1nowblood+50)>=b1blood){
            this.b1nowblood=b1blood;
        }else{
            this.b1nowblood+=50;
        }
                System.out.println(4);
        return (a/b)*150;
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
