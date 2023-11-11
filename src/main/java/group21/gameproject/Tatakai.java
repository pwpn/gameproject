/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Lenovo
 */
public class Tatakai extends JFrame{
    
    static int issuper=0;
    
        Theman tm= new Theman("src/data/rsc/pic/actor_d.gif",0,0,this);
        
        Boss1 boss1=new Boss1("",650,150,new JFrame());static int bossi=0;
        
        
        public Yourself ys=new Yourself("src/data/rsc/pic/jinlin.png",100,100,new JFrame(),tm);
        
    private int a=0;
    public Image ScreemImage=null;
    
    public static JFrame jfi=new JFrame();
    
    SoundBG fsbg=new SoundBG("src/data/rsc/sound/fight.wav");
    
    public cs csc=null;
    
    public final JButton superjb=new JButton();
    public final JButton jbb1=new JButton();
    public final JButton jbb2=new JButton();
    public final JButton jbb3=new JButton();
    public final JButton jbb4=new JButton();
    
    public static void main(String[] args){
            new Tatakai(new Theman("",0,0,new JFrame()),1);
    }
//    
    
    public Tatakai(Theman tm,int iwho){
//        this.tm=tm;
//        jfi.add(this);
        
        init();
       
        this.setIconImage(new ImageIcon("src/data/rsc/pic/009.png").getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.add(csc);
//        repaint();
       
//        this.setDefaultCloseOperation(2);
        this.setDefaultCloseOperation(3);
        this.setBounds(150, 60, 1000, 589); 
        this.setVisible(true);

        
        this.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) { }

            @Override
            public void windowClosing(WindowEvent e) {
                tm.setistouched(false);
                System.out.println("666");
                fsbg.stop();
            }

            @Override
            public void windowClosed(WindowEvent e) {
             
            }

            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        attackbt();
        
int timerDelay = 1000;
        new Timer(timerDelay, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ++a;
                repaint();
                   }
        }).start();

        new Timer(100, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                if(bossi<=3){
                    Image bossimg=boss1.imgg[bossi++];
                    boss1.img=bossimg;
                    if(bossi==3){
                        bossi=0;
                    }
                }else if(bossi==4){
                    Image bossimg=boss1.imgg[bossi];
                    boss1.img=bossimg;
                    boss1.y-=10;
                }else{
                    Image bossimg=boss1.imgg[bossi++];
                    boss1.img=bossimg;
                    boss1.x-=50;
                    if(bossi==9){
                        bossi=0;
                    }
                }
                
                

                repaint();
            }
        }).start();
        
       
//        SwingUtilities.updateComponentTreeUI(this);
    }
    
    private void init(){
     
        fsbg.start(); 
        csc=new cs();
        csc.setLayout(null);
        this.setBounds(150, 60, 1000, 589);
        
        csc.add(superjb);
        csc.add(jbb1);
        csc.add(jbb2);
        csc.add(jbb3);
        csc.add(jbb4);
        
        this.aff(superjb,0,"src/data/rsc/pic/chaobisha.png","src/data/rsc/pic/chaobishaww.png");
        this.aff(jbb1,250,"src/data/rsc/pic/jineng1.png","src/data/rsc/pic/jineng1ww.png");
        this.aff(jbb2,436,"src/data/rsc/pic/jineng2.png","src/data/rsc/pic/jineng2ww.png");
        this.aff(jbb3,617,"src/data/rsc/pic/jineng3.png","src/data/rsc/pic/jineng3ww.png");
        this.aff(jbb4,800,"src/data/rsc/pic/jineng4.png","src/data/rsc/pic/jineng4ww.png");         

//        superjb.setContentAreaFilled(false);
//        this.repaint();
//        repaint();
//        SwingUtilities.updateComponentTreeUI(this);
    }
    
    private void attackbt(){
        superjb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                issuper=0;
                ys.chaobisha();bossattack();
                
                gameresult();                
            }
            
        });
        
        jbb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(issuper<4){
                   issuper++;
                }
                ys.jineng1();bossattack();
                
                gameresult();        
                bossi=4;
            }
            
        });
        
        jbb2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(issuper<4){
                   issuper++;
                }
                ys.jineng2();bossattack();
//                ys.yourblood-=100;
//                System.out.println(ys.yourblood);
                bossi=5;
                
                gameresult();                
            }
            
        });
                
        jbb3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(issuper<4){
                   issuper++;
                }
                ys.jineng3();bossattack();
                boss1.b1nowblood-=100;
                
                gameresult();
            }
            
        });
                        
        jbb4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(issuper<4){
                   issuper++;
                }
                ys.jineng4();bossattack();
                
                gameresult();                
            }
            
        });
    }
    
    //boss出招
    public void bossattack(){
        switch(boss1.randomm()){
            case 1:
                boss1.skill1();
                break;
            case 2:
                boss1.skill2();
                break;
            case 3:
                boss1.skill3();
                break;
            case 4:
                boss1.skill4();
                break;
        }
    }

    private void aff(JButton jbb,int a,String i,String o){
        ImageIcon img=new ImageIcon(i);
        jbb.setIcon(img);
        jbb.setBounds(a, 550-img.getIconHeight(), img.getIconWidth(), img.getIconHeight());
        jbb.setBorderPainted(false);
        jbb.setBorder(null);
//        jbb.setBorder(BorderFactory.createRaisedBevelBorder());
//        jbb.setVisible(true);
        jbb.setRolloverIcon(new ImageIcon(o));
    }
    
    class cs extends JPanel{
        
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                
                if(ScreemImage==null){
                    ScreemImage=this.createImage(1000,589);
                }
        
                Graphics gImage=ScreemImage.getGraphics(); 
                Image background=Toolkit.getDefaultToolkit().getImage("src/data/rsc/pic/fightbgm.jpg");//fightbgm.jpg
                gImage.drawImage(background, 0, 0, this);
                
                gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/data/rsc/pic/jnl.png"),0,370,this);
                
                gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/data/rsc/pic/timer.png"), 420 ,-15, this);
                
//                Timer time=new Timer();
//            for(int i=0;i>=0;i++){
//                gImage.drawString(Integer.toString(i), 0, 100);
//            }
                //时间
                gImage.setFont(new Font("仿宋",Font.BOLD,50));
                gImage.setColor(Color.BLUE);
                if(a<10){
                    gImage.drawString(Integer.toString(a), 470, 55);
                }else if(a>=10&&a<100){
                    gImage.drawString(Integer.toString(a), 450, 55);         
                }else{
                    gImage.drawString(Integer.toString(a), 445, 55);
                }
                
                //血量
                gImage.setFont(new Font("仿宋",Font.BOLD,30));
                gImage.setColor(Color.BLACK);
                gImage.drawString("你的血量：",200,70);
                gImage.drawString("Boss的血量：",560,70);
                gImage.setColor(Color.GREEN);
                gImage.drawString(Integer.toString((int)(ys.getyourblood())), 355, 70);
                gImage.drawString(Integer.toString((int)(boss1.b1nowblood)), 755, 70);
                
                float lineWidth = 23.0f; 
                ((Graphics2D)gImage).setStroke(new BasicStroke(lineWidth));
                ((Graphics2D)gImage).setColor(Color.black);
                ((Graphics2D)gImage).drawLine(10, 30, 400, 30);
                ((Graphics2D)gImage).drawLine(560, 30, 990, 30);
                
                ((Graphics2D)gImage).setColor(Color.red);
                
                double chu=ys.getyourblood()/ys.getblood();
                double chuboss=boss1.b1nowblood/boss1.b1blood;
//                double bn=ys.getlastblood();
                
                ((Graphics2D)gImage).drawLine(10, 30, (int) ((double)400*chu), 30);
                ((Graphics2D)gImage).drawLine((560+(int)(430*(1-chuboss))), 30, 990, 30);
//                System.out.println(chu);System.out.println(ys.getyourblood()+" "+ys.getblood());
                
//                tm.paintSelft(gImage);
//                boss1.paintSelft(gImage);
                ys.paintSelft(gImage);
                lineWidth = 12.0f;((Graphics2D)gImage).setStroke(new BasicStroke(lineWidth));
                ((Graphics2D)gImage).drawLine(189,540,189,540-(23*issuper));
                if(issuper==4){
                    superjb.setEnabled(true);                  
                }else{
                    superjb.setEnabled(false);
                }
                
                //boss
                boss1.paintSelft(gImage);
                //
                
                
                g.drawImage(ScreemImage, 0, 0, null);
                gameresult();
            }
            
    }
    
    public void gameresult(){
        if(ys.getyourblood()<=0){
            System.out.println("lose");
        }
        if(boss1.b1nowblood<=0){
            System.out.println("win");
        }
    }
}
