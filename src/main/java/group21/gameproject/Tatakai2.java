/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

/**
 *
 * @author Lenovo
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
import java.util.concurrent.TimeUnit;
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
public class Tatakai2 extends JFrame{
    
    static int shenji=3;//回合升级属性
    static int issuper=0;
    
    private boolean isdead=false;
    Theman tm;
        
    Boss2 boss2=new Boss2("",650,150,new JFrame());static int bossi=0; 
        
        
    public Yourself ys;
        
    private int a=0;
    private Image ScreemImage=null;
    
    private static JFrame jfi=new JFrame();
    
    SoundBG fsbg=new SoundBG("src/data/music/fight.wav");
    
    public cs csc=null;
    
    private final JButton superjb=new JButton();
    private final JButton jbb1=new JButton();
    private final JButton jbb2=new JButton();
    private final JButton jbb3=new JButton();
    private final JButton jbb4=new JButton();
    
//    
    
    public Tatakai2(Theman tm){
        this.tm=tm;
        ys=new Yourself("src/data/pic/photo/jinlin.png",100,100,new JFrame(),tm);
//        jfi.add(this);
        init();
       
        this.setIconImage(new ImageIcon("src/data/pic/photo/009.png").getImage());
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
            @Override
            public void actionPerformed(ActionEvent e) {
                ++a;
                repaint();
                   }
        }).start();

        new Timer(200, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(bossi<=3){
                    Image bossimg=boss2.imgg[bossi++];
                    boss2.img=bossimg;
                    ys.img=bossimg;
                    if(bossi==3){
                        bossi=0;
                    }
                }else if(bossi==4){
                    Image bossimg=boss2.imgg[bossi];
                    boss2.img=bossimg;
                    boss2.y-=10;
                    if(boss2.y<=50){
                        boss2.y=150;
                        bossi=0;
                    }
                }else{
                    Image bossimg=boss2.imgg[bossi++];
                    boss2.img=bossimg;
                    boss2.x-=150;
                    if(bossi==9){
                        bossi=0;
                        boss2.x=650;
                    }
                }
                
                repaint();
            }
        }).start();
//        SwingUtilities.updateComponentTreeUI(this);
//          xxrun.run();yyrun.run();
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
        
        this.aff(superjb,0,"src/data/pic/photo/chaobisha.png","src/data/pic/photo/chaobishaww.png");
        this.aff(jbb1,250,"src/data/pic/photo/jineng1.png","src/data/pic/photo/jineng1ww.png");
        this.aff(jbb2,436,"src/data/pic/photo/jineng2.png","src/data/pic/photo/jineng2ww.png");
        this.aff(jbb3,617,"src/data/pic/photo/jineng3.png","src/data/pic/photo/jineng3ww.png");
        this.aff(jbb4,800,"src/data/pic/photo/jineng4.png","src/data/pic/photo/jineng4ww.png");         

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
                double shang=ys.chaobisha(ys.yourattack,boss2.b1nowdefence);
                if((boss2.b1nowblood-shang)>=0){
                    boss2.b1nowblood-=shang;
                }else{
                    boss2.b1nowblood=0;
                }
                if(boss2.bldeflev>-6){
                  boss2.bldeflev-=1;                  
                }
                if(boss2.blattlev>-6){
                  boss2.blattlev-=1;                  
                }
                repaint();
                gameresult();
                bossattack();
                gameresult();                
            }
            
        });
        
        jbb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                offbutton();
                if(issuper<4){
                   issuper++;
                }
                ys.jineng1();
                repaint();
                gameresult();

                bossattack();
                
                gameresult();        
                onbutton();
            }
            
        });
        
        jbb2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                offbutton();
                if(issuper<4){
                   issuper++;
                }

                double shang=ys.jineng2(ys.yourattack,boss2.b1nowdefence);
                if((boss2.b1nowblood-shang)>=0){
                    boss2.b1nowblood-=shang;
                }else{
                    boss2.b1nowblood=0;
                }
               if(boss2.bldeflev>-6){
                  boss2.bldeflev-=1;                  
               }
               boss2.b1nowdefence=boss2.b1defence+((boss2.b1defence/10)*boss2.bldeflev);
               System.out.println(boss2.b1nowdefence);
               
               
               repaint();gameresult(); 
                    
               bossattack();

                gameresult(); onbutton();  
            }
            
        });
                
        jbb3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                offbutton();
                if(issuper<4){
                   issuper++;
                }
                
                if(ys.yourspeed>=boss2.b1speed){
                    
                    double shang=ys.jineng3(ys.yourattack,boss2.b1nowdefence);
                   if((boss2.b1nowblood-shang)>=0){
                       boss2.b1nowblood-=shang;
                   }else{
                       boss2.b1nowblood=0;
                   } repaint();gameresult();
                   
                    bossattack();                   
                    
                }else{
                    bossattack();      repaint();gameresult();             
                          
                    double shang=ys.jineng3(ys.yourattack,boss2.b1nowdefence)*10;
                    if((boss2.b1nowblood-shang)>=0){
                        boss2.b1nowblood-=shang;
                    }else{
                        boss2.b1nowblood=0;
                    }
                }
                
                gameresult();                onbutton();
            }
            
        });
                        
        jbb4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                offbutton();
                if(issuper<4){
                   issuper++;
                }
                if(ys.yourspeed>=boss2.b1speed){
                    ys.jineng4(); repaint();gameresult();
                   
                    bossattack();
                    
                }else{
                    bossattack(); repaint();gameresult();
                    
                    ys.jineng4();                    
                }
                shenji=0;
                
                gameresult();                 onbutton();  
            }
            
        });
    }
    
    //boss出招
    public void bossattack(){
        switch(boss2.randomm()){
            case 1:
                boss2.skill1(boss2.b1nowattack,ys.yourdefence);
                if(ys.attlev>=-4){
                    ys.attlev-=2;
                }else{
                    ys.attlev=-6;
                }
                if(ys.deflev>=-4){
                    ys.deflev-=2;
                }else{
                    ys.deflev=-6;
                }                
                bossi=4;
                break;
            case 2:
                double shang=boss2.skill2(boss2.b1nowattack,ys.yourdefence);
                if((ys.yourblood-shang)>=0){
                    ys.yourblood-=shang;
                }else{
                    ys.yourblood=0;
                }               
                bossi=5;
                break;
            case 3:
                boss2.skill3(1, 1);
                bossi=5;
                break;
            case 4:
                double shan=boss2.skill4(boss2.b1nowattack,ys.yourdefence);
               if((ys.yourblood-shan)>=0){
                    ys.yourblood-=shan;
                }else{
                    ys.yourblood=0;
                }
                bossi=4;
                break;
        }
    }
    public void onbutton(){
        jbb1.setEnabled(true);
        jbb2.setEnabled(true);
        jbb3.setEnabled(true);
        jbb4.setEnabled(true);
        if(shenji<3&&ys.attlev<10){
            ys.attlev++;shenji++;
        }
        repaint();
    }
    
    public void offbutton(){
        jbb1.setEnabled(false);
        jbb2.setEnabled(false);
        jbb3.setEnabled(false);
        jbb4.setEnabled(false);  
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tatakai.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
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
                Image background=Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/fightbgm.jpg");//fightbgm.jpg
                gImage.drawImage(background, 0, 0, this);
                
                gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/jnl.png"),0,370,this);
                
                gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/timer.png"), 420 ,-15, this);
                
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
                
                //强度
                gImage.setFont(new Font("仿宋",Font.BOLD,15));
                gImage.setColor(Color.BLACK);
                gImage.drawString("攻击：",10,70);gImage.drawString(Integer.toString((int)(ys.attlev)), 40, 70);
                gImage.drawString("防御：",10,90);gImage.drawString(Integer.toString((int)(ys.deflev)), 40, 90);
                gImage.drawString("攻击：",900,70);gImage.drawString(Integer.toString((int)(boss2.blattlev)), 940, 70);
                gImage.drawString("防御：",900,90);gImage.drawString(Integer.toString((int)(boss2.bldeflev)), 940, 90);                
                
                //血量
                gImage.setFont(new Font("仿宋",Font.BOLD,30));
                gImage.setColor(Color.BLACK);
                gImage.drawString("你的血量：",200,70);
                gImage.drawString("Boss的血量：",560,70);
                gImage.setColor(Color.GREEN);
                gImage.drawString(Integer.toString((int)(ys.getyourblood())), 355, 70);
                gImage.drawString(Integer.toString((int)(boss2.b1nowblood)), 755, 70);
                
                float lineWidth = 23.0f; 
                ((Graphics2D)gImage).setStroke(new BasicStroke(lineWidth));
                ((Graphics2D)gImage).setColor(Color.black);
                ((Graphics2D)gImage).drawLine(10, 30, 400, 30);
                ((Graphics2D)gImage).drawLine(560, 30, 990, 30);
                
                ((Graphics2D)gImage).setColor(Color.red);
                
                double chu=ys.getyourblood()/ys.getblood();
                double chuboss=boss2.b1nowblood/boss2.b1blood;
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
                boss2.paintSelft(gImage);
                //
                
                
                g.drawImage(ScreemImage, 0, 0, null);
                gameresult();setisdead();
            }
            
    }
    public void setisdead(){
        if(ys.yourblood<=0||boss2.b1nowblood<=0){
            isdead=true;
        }
    }    
    
    public void gameresult(){
        csc.repaint();
        
        if(ys.getyourblood()<=0&&isdead){       fsbg.stop();
            Winorlose ws=new Winorlose(tm,2,3);
                try {
                    Thread.sleep(500);       this.dispose();  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tatakai.class.getName()).log(Level.SEVERE, null, ex);
                }          
            System.out.println("lose");
            ys.returnyou();
            boss2.returnbo();            
        }
        
        if(boss2.b1nowblood<=0&&isdead){       fsbg.stop();
            System.out.println("win");
            Winorlose ws=new Winorlose(tm,1,3);
            tm.level++;tm.update();
                try {
                    Thread.sleep(500);this.dispose();  
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tatakai.class.getName()).log(Level.SEVERE, null, ex);
                }     
            ys.updateys(tm);
            ys.returnyou();
            boss2.returnbo();
        }
    }
}

       