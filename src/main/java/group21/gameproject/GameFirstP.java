/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.AncestorListener;
import javax.swing.text.View;

/**
 *
 * @author Lenovo
 */

public class GameFirstP extends JFrame{
    
    SoundBG sbg=new SoundBG("src/music/placebgm.wav");
    
    private static int bosswho=1;
    
    Image offScreemImage;//=this.createImage(800, 499);
//    Graphics gImage;
    
    Theman tm;
//    
    Boss boss;
    
    JButton jbb=new JButton();

//    GameFirstP gp;
    
    private JFrame basedi=new JFrame();
    private paintt pa=new paintt();
    
    int jindu=0;
    
    
    public GameFirstP(Theman tm,int jindu){
        this.jindu=jindu;System.out.println("jinduis"+jindu);
        switch(jindu){
            case 1:
                boss=new Boss1("src/photo/boss1.png",500,50,this);break;
            case 2:
                boss=new Boss2("src/photo/boss2.png",500,10,this);break;
            case 3:
                boss=new Boss3("src/photo/boss3.png",500,50,this);break;
            case 4:
                boss=new Boss4("src/photo/boss4.png",500,10,this);break;
        }
        this.tm=tm;
        sbg.start();
        inti();
        basedi.add(pa);
        basedi.setIconImage(new ImageIcon("src/photo/008.png").getImage());
        basedi.setLocationRelativeTo(null);
        basedi.setResizable(false);
//        basedi.setVisible(true);
        jbb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Beibao bbg=new Beibao(tm);
            }
        });
        basedi.addMouseListener(new MymouseListener());
//        pa.addMouseListener(new MymouseListener());
        basedi.addKeyListener(new Keyhappen());
    }

    private void inti() {
        pa.setLayout(null);
        this.addJB();
        basedi.setBounds(100, 100, 800, 449);
        basedi.setVisible(true);
        basedi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        jbb.setPreferredSize(new Dimension(30,30));
        pa.add(jbb);
//        repaint();
//        pa.repaint();
        basedi.repaint();
            	
        try {
		Thread.sleep(25);
	} catch (Exception e) {
		e.printStackTrace();
	}
    }
    
    private void addJB(){
        jbb.setIcon(new ImageIcon("src/photo/truebutton.png"));
        jbb.setBounds(30, 280, 90, 90);
        jbb.setBorderPainted(false);
        jbb.setBorder(null);
        jbb.setContentAreaFilled(false);
        jbb.setRolloverIcon(new ImageIcon("src/photo/button.png"));
    }

    private class Keyhappen implements KeyListener {
        
        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
            tm.keyPressed(e);
            try {               
                    Thread.sleep(10);
            } catch (InterruptedException ex) {
//                    Logger.getLogger(GameFirstP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(e.getKeyChar());
            switch(e.getKeyChar()){
                case'd':
                    System.out.println("hellod");
                    break;
                case'w':
                    System.out.println("hellow");
                    break;
                case's':
                    System.out.println("hellos");
                    break;
                case'a':
                    System.out.println("helloa");
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try {               
                    Thread.sleep(10);
            } catch (InterruptedException ex) {
//                    Logger.getLogger(GameFirstP.class.getName()).log(Level.SEVERE, null, ex);
            }
            pa.repaint();
            basedi.repaint();
        }
    }

    private class MymouseListener extends MouseAdapter{
        
        @Override
        public void mousePressed(MouseEvent e){
            System.out.println(e.getX()+"   "+e.getY());
            tm.mousePressed(e);
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            tm.mousePressed(e);

////          System.out.println(tm.isinit());
//            while(tm.isinit()==false){
////              System.out.print("truetrue");
//                tm.move();
//            
//                paintre();
////              System.out.print("in the mid");
//                try {               
//                      Thread.sleep(10);
//                } catch (InterruptedException ex) {
////                      Logger.getLogger(GameFirstP.class.getName()).log(Level.SEVERE, null, ex);
//                }
////              System.out.println("false");
//            }
            int timerDelay = 60;
            
            new Timer(timerDelay, (ActionEvent e1) -> {
                tm.move();
                //                System.out.println(666);
                paintre();
            }).start();
            
            System.out.println(tm.x);            System.out.println(boss.x);
            if(tm.getRec().intersects(boss.getRec())){
                tm.setistouched(true);
                IsFight isfight=new IsFight(tm,jindu,basedi);
//              sbg.wait();
//                sbg.stop();
                sbg.suspend();
                sbg.isplay=false;
            }else{
                tm.setistouched(false);
                if(!sbg.isplay){
                    sbg.isplay=true;
//                    sbg.run();
//                    sbg.start();
                      sbg.resume();
                }
            }
            
//            if(tm.getistouched()){
//                IsFight isfight=new IsFight(tm,boss1);
////              sbg.isplay=false;    
//            }
        }
    }
    
    private void paintre(){
        pa.repaint();
        basedi.repaint();
    }
    
class paintt extends JPanel{    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(offScreemImage==null) {
//               Image background=Toolkit.getDefaultToolkit().getImage("src/photo/111.png");
//               g.drawImage(background, 0, 0, this);
//System.out.println("ooooooooooooooooo");
            offScreemImage=this.createImage(800, 499);
        }
//        	 获得图片画笔
        Graphics gImage =offScreemImage.getGraphics();
        Image background;
        switch(jindu){
            case 1:background=Toolkit.getDefaultToolkit().getImage("src/photo/111.png");
                break;
            case 2:background=Toolkit.getDefaultToolkit().getImage("src/photo/222.png");
                break;
            case 3:background=Toolkit.getDefaultToolkit().getImage("src/photo/333.png");
                break;
            case 4:background=Toolkit.getDefaultToolkit().getImage("src/photo/444.png");
                break;
            default:background=Toolkit.getDefaultToolkit().getImage("src/photo/111.png");break;
        }
        gImage.drawImage(background, 0, 0, this);
        
        
//        tm= new Theman("src/photo/actor_d.gif",0,0,gp,gImage);
//        System.out.println("???");
       
        boss.paintSelft(gImage); tm.paintSelft(gImage);
        //?

        g.drawImage(offScreemImage, 0, 0, null);
    }
}

}

/*
class paintt extends JPanel{
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Image background=Toolkit.getDefaultToolkit().getImage("src/photo/111.png");
        g.drawImage(background, 0, 0, this);

    }
}
*/

//
//protected void paintComponent(Graphics g) {
//    super.paint(g);
//    g.drawImage(image, this.xpos, this.ypos, this);
//}
