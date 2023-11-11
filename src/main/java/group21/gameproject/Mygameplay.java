/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import account.User;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.text.View;

/**
 *
 * @author Lenovo
 */
public class Mygameplay extends JFrame{
    
    
        
    private JFrame jf;
    JButton butt;
     painti newi=null;
     
     static Mygameplay output=null;
    
    public static void main(String[] args){
        //Try to login here
        User.stateCheck();
        output=new Mygameplay();
   }
    
     public Mygameplay(){

         SoundBG sbg=new SoundBG("src/data/music/startbgm.wav");
         sbg.start();

//        newi=new painti();
//        newi.add(butt);  
//        butt.setBounds(50, 50, 100, 100);
//        butt.setBackground(Color.red);
        init();
//        this.getLayeredPane().add(newi,new Integer(Integer.MIN_VALUE));
        this.setIconImage(new ImageIcon("src/data/pic/photo/008.png").getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        this.add(newi);
        
        this.setBounds(200, 100, 200,200);
        this.setSize(651,472);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
        
        butt.addActionListener(new ActionListener() {
	    @Override
            @SuppressWarnings("CallToThreadStopSuspendOrResumeManager")
		public void actionPerformed(ActionEvent e)
		{   int prog=0;
                    User.isPlaying=true;
                    //Get Save when start
                    User.GetSave();
                    if(!User.isOnline())
                        JOptionPane.showMessageDialog(null,"未登录，游戏记录将不会记载！","Guest",0);
                    else
                        prog=User.getProgress();
                    //Dispose the frame anyway.
                    System.out.print(User.isOnline());
                    User.DisposeSignInFrame();
                    System.out.println("yes");
                    output.dispose();
                    sbg.stop();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mygameplay.class.getName()).log(Level.SEVERE, null, ex);
                } 
                     new GameFirstP(new Theman("src/data/pic/photo/actor_d.gif",0,0,new JFrame()),1+prog);
		}			
	} );
        
//       butt.repaint();
     }
     
     public void init(){
        ImageIcon icon = new ImageIcon("src/data/pic/photo/009.png");
        butt=new JButton("Wake Up!",icon);
         
        newi=new painti();
        
        newi.setLayout(null);
        newi.add(butt);
        
        butt.setBounds(275, 300, 100, 40);
        Font font = new Font("Arial", Font.ITALIC, 16);
//        butt.setBorderPainted(false);
        newi.setForeground(Color.WHITE);

        butt.setFont(font);
//        butt.setBackground(Color.black);
//                newi.add(butt); 
//        butt.setContentAreaFilled(false);//消除背景
//        butt.setFocusPainted(false);//消除选择
//        butt.setVisible(true);   
     }
        
class painti extends JPanel{  
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Image start=Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/start.png");      
        g.drawImage(start, 0, 0, this);
        
        g.drawLine(10,10,300,300);
        
        g.fillRect(60, 60, 10, 100);

        Image im=Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/actor_d.gif");

        g.drawImage(im, 400, 300, this);

//        im.getGraphics();
        g.setColor(Color.RED);
        g.setFont(new Font("华文彩云",Font.BOLD,20));
        g.drawString( "你好！欢迎进入原神的世界", 200, 370);
        g.setColor(Color.BLUE);
        g.drawString( "按按钮以继续", 250, 400);
     
        butt.repaint();
    }
}
     
}


