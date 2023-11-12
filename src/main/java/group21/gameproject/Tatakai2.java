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

import account.User;
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
import java.sql.SQLException;
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
        
    Boss2 boss2=new Boss2("",650,150,new JFrame());static int bossi=0; static int ysi=0;
        static int boo=0;
    static int boo1=0;static int boo2=0;static int boo3=0;static int boo4=0;
    Boooo bo=new Boooo("",100,80,new JFrame());
    Boooo bo1=new Boooo("",600,80,new JFrame());
    Boooo bo2=new Boooo("",200,100,new JFrame());
    Boooo bo3=new Boooo("",350,0,new JFrame());
    Boooo bo4=new Boooo("",200,200,new JFrame());      
        
    public Yourself ys;
        
    private int a=0;
    private Image ScreemImage=null;
    
    private static JFrame jfi=new JFrame();
    
    SoundBG fsbg=new SoundBG("src/music/fight.wav");
    
    public cs csc=null;
    
    private final JButton superjb=new JButton();
    private final JButton jbb1=new JButton();
    private final JButton jbb2=new JButton();
    private final JButton jbb3=new JButton();
    private final JButton jbb4=new JButton();
    
//    
    public static void main(String[] args){
        new Tatakai2(new Theman("",0,0,null));
    }
    
    public Tatakai2(Theman tm){
        
        this.tm=tm;
        ys=new Yourself("src/manba/jinlin.png",100,100,new JFrame(),tm);
//        jfi.add(this);
        init();
       
        this.setIconImage(new ImageIcon("src/photo/009.png").getImage());
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
                    if(bossi==3){
                        bossi=0;
                    }
                }else if(bossi==4){
                    Image bossimg=boss2.imgg[bossi];
                    boss2.img=bossimg;
                    boss2.x=580;
                    boss2.y-=10;
                    if(boss2.y<=50){
                        boss2.x=650;
                        boss2.y=150;
                        bossi=0;
                    }
                }else{
                    Image bossimg=boss2.imgg[bossi++];
                    boss2.img=bossimg;
                    boss2.x-=180;
                    if(bossi==9){
                        bossi=0;
                        boss2.x=650;
                    }
                }
                
                if(ysi<=2){
                    Image ysimg=ys.imgg[ysi++];   
                    ys.img=ysimg;
                    if(ysi==2){
                        ysi=0;
                    }
                }else if(ysi>=3&&ysi<11){
                    Image ysimg=ys.imgg[ysi++];
                    ys.img=ysimg;
                    ys.x+=40;
                    if(ysi==11){
                        ysi=0;
                        ys.x=100;
                    }
                }else{
                        Image ysimg=ys.imgg[ysi++];
                        ys.img=ysimg;
                        ys.x+=120; 
                        if(ysi==15){
                            ysi=0;
                            ys.x=100;
                        }
                    }                
                texiao();
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
        
        this.aff(superjb,0,"src/photo/chaobisha.png","src/photo/chaobishaww.png");
        this.aff(jbb1,250,"src/photo/jineng1.png","src/photo/jineng1ww.png");
        this.aff(jbb2,436,"src/photo/jineng2.png","src/photo/jineng2ww.png");
        this.aff(jbb3,617,"src/photo/jineng3.png","src/photo/jineng3ww.png");
        this.aff(jbb4,800,"src/photo/jineng4.png","src/photo/jineng4ww.png");         

//        superjb.setContentAreaFilled(false);
//        this.repaint();
//        repaint();
//        SwingUtilities.updateComponentTreeUI(this);

    }
    
    private void attackbt(){
        superjb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                issuper=0;ysi=11;boo2=1;
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
                offbutton();boo=1;
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
                offbutton();ysi=3;
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
                offbutton();ysi=3;boo4=1;
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
                          
                    double shang=ys.jineng3(ys.yourattack,boss2.b1nowdefence);
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
                offbutton();boo=1;
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
            case 1:boo1=1;boo3=1;
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
            case 2:boo1=1;
                double shang=boss2.skill2(boss2.b1nowattack,ys.yourdefence);
                if((ys.yourblood-shang)>=0){
                    ys.yourblood-=shang;
                }else{
                    ys.yourblood=0;
                }               
                bossi=5;
                break;
            case 3:boo1=1;
                boss2.skill3(1, 1);
                bossi=4;
                break;
            case 4:boo1=1;boo3=1;
                double shan=boss2.skill4(boss2.b1nowattack,ys.yourdefence);
               if((ys.yourblood-shan)>=0){
                    ys.yourblood-=shan;
                }else{
                    ys.yourblood=0;
                }
                bossi=5;
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
                Image background=Toolkit.getDefaultToolkit().getImage("src/photo/fightbgm.jpg");//fightbgm.jpg
                gImage.drawImage(background, 0, 0, this);
                
                gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/photo/jnl.png"),0,370,this);
                
                gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/photo/timer.png"), 420 ,-15, this);
                
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
                
                bo.paintSelft(gImage);bo1.paintSelft(gImage);bo2.paintSelft(gImage);bo3.paintSelft(gImage);bo4.paintSelft(gImage);
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
            if(tm.level<=10)
            tm.level+=2;
            User.setProgress(3);
            User.CheckUserFrame();
            tm.update();
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
    
   private void texiao(){
        if(boo==0){
//                    Image boimg=bo.yimg[boo];
                    bo.img=null;
                }
        else{
                    Image boimg=bo.yimg[(boo++)-1];
                    bo.img=boimg;
                    if(boo==13){
                        boo=0;
                   }
        }
        
        if(boo1==0){
                    bo1.img=null;
                }
        else{
                    Image boimg=bo1.imgg[(boo1++)-1];
                    bo1.img=boimg;
                    if(boo1==9){
                        boo1=0;
                   }
        }
        
        if(boo2==0){
                    bo2.img=null;
                }
        else{
                    Image boimg=bo2.imgg1[(boo2++)-1];
                    bo2.img=boimg;
                    if(boo2==8){
                        boo2=0;
                   }
        }
        
        if(boo3==0){
                    bo3.img=null;
                }
        else{
                    Image boimg=bo3.imgg2[(boo3++)-1];
                    bo3.img=boimg;
                    if(boo3==5){
                        boo3=0;
                   }
        }
        
        if(boo4==0){
                    bo4.img=null;
                }
        else{
                    Image boimg=bo4.imgg3[(boo4++)-1];
                    bo4.img=boimg;
                    if(boo4==5){
                        boo4=0;
                   }
        }
    }
    
}

       