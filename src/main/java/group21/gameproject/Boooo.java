/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Lenovo
 */
public class Boooo extends GameObject{
    
    
    public int x;
    public int y;
    
    
    public Image[] imgg=new Image[10];//a
    public Image[] imgg1=new Image[9];//d
    public Image[] imgg2=new Image[6];//g
    public Image[] imgg3=new Image[6];//p
    public Image[] yimg=new Image[14];//s
    
    public Boooo(String img,int x,int y,JFrame jf){
        
        super(img,x,y,jf);
        
            this.x=x;
            this.y=y;

            
//        System.out.println("jhhh");
        //a
        for(int i = 2;i < imgg.length + 1;i ++){
            try {       imgg[0]= ImageIO.read(new File("src/Flash/a.gif"));
                        imgg[i - 1] = ImageIO.read(new File("src/Flash/a000" + (i-1) + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(Boooo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //d
        for(int i = 2;i < imgg1.length + 1;i ++){
            try {       imgg1[0]= ImageIO.read(new File("src/Flash/d.gif"));
                        imgg1[i - 1] = ImageIO.read(new File("src/Flash/d000" + (i-1) + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(Boooo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //g
        for(int i = 3;i < imgg2.length + 1;i ++){
            try {       imgg2[0]= ImageIO.read(new File("src/Flash/g.gif"));imgg2[1]= ImageIO.read(new File("src/Flash/f.png"));
                        imgg2[i - 1] = ImageIO.read(new File("src/Flash/g000" + (i-2) + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(Boooo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //p
        for(int i = 2;i < imgg3.length + 1;i ++){
            try {       imgg3[0]= ImageIO.read(new File("src/Flash/p.gif"));
                        imgg3[i - 1] = ImageIO.read(new File("src/Flash/p000" + (i-1) + ".png"));
            } catch (IOException ex) {
                Logger.getLogger(Boooo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//y s
        for(int i = 2;i < yimg.length + 1;i ++){
            try {       yimg[0]= ImageIO.read(new File("src/Flash/s.gif"));int xx=i-1;
                       if(i-1<10)
                        yimg[i - 1] = ImageIO.read(new File("src/Flash/s000" + xx + ".png"));
                       else if(i-1>=10)
                        yimg[i - 1] = ImageIO.read(new File("src/Flash/s00" + xx + ".png"));   
            } catch (IOException ex) {
                Logger.getLogger(Boooo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
                 
    }
        

    @Override
    public void paintSelft(Graphics g) {
        g.drawImage(img, x,y,null);
    }

    @Override
    public Rectangle getRec() {return null;
    }
    
}
