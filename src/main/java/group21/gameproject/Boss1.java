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
public class Boss1 extends Boss{
    
    private int width=100;
    private int height=107;
    
    public int x;
    public int y;
    
    public int b1attack=300;
    public int b1defence=100;

    public int b1speed=3;
    public double b1blood=800;
    public double b1nowblood=800;
    
    public Image[] imgg=new Image[9];
    
    public Boss1(String img,int x,int y,JFrame jf){
        
        super(img,x,y,jf);
        
            this.x=x;
            this.y=y;
            
            b1attack = 300;
            b1defence = 50;
            b1blood=800;
            b1speed=1;
            
            
//        System.out.println("jhhh");

        for(int i = 1;i < imgg.length + 1;i ++){
                try{
                    imgg[i - 1] = ImageIO.read(new File("src/data/rsc/pic/boss1" + i + ".png"));
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

    @Override
    public int skill1() {
        System.out.println(1);
        return 1;
    }

    @Override
    public int skill2() {
                System.out.println(2);
        return 1;
    }

    @Override
    public int skill3() {
                System.out.println(3);
        return 1;
    }

    @Override
    public int skill4() {
                System.out.println(4);
        return 1;
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
}
