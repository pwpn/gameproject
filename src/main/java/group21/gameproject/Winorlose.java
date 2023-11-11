/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

/**
 *
 * @author Lenovo
 */
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Winorlose {
    
    /**
     *
     * @param tm
     * @param boss1
     */
    
    private Image backscreen=null;
    
    private Image win=Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/vic.jpg");
    private Image lose=Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/lose.jpg");    
    static int i=0;  
    int x=0;
    backgrou bg=new backgrou();
    
    public Winorlose(Theman tm,int i,int next){

        this.i=i;
        JFrame frame = new JFrame("战斗结束");
        frame.setIconImage(new ImageIcon("src/data/pic/photo/008.png").getImage());

        /*
        JDialog d1 = new JDialog(frame, "模式对话框", true);
        JDialog d2 = new JDialog(frame, "非模式对话框", false);
        d1.setBounds(20,30,300,400);
        d2.setBounds(20,30,300,400);
*/
        if(i==1){
            bg.setLayout(null);
            JButton b1 = new JButton("在对抗与纷争的尽头，有我！");
            JButton b2 = new JButton("前面的路以后再来探索吧");
            b1.setBounds(10, 110, 330, 70);
            b2.setBounds(10, 190, 330, 70);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x=1;
//                    new Beibao(tm);
                    GameFirstP gameFirstP = new GameFirstP(tm,next);
                    frame.dispose();
                }
            });
            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x=1;
                    frame.dispose();
                    GameFirstP gameFirstP=new GameFirstP(tm,next-1);
                }
            });        
            bg.add(b1);
            bg.add(b2);
            frame.setBounds(350, 200, 357,300);
        }
        else{
            frame.setBounds(350, 200, 268,147);
        }
        frame.add(bg);
        //把按钮添加到frame中
        frame.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowClosing(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                x=1;
            }

            @Override
            public void windowClosed(WindowEvent e) {
                x=1;
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowIconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowActivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });        

        //设置frame最佳大小并可见
        frame.setVisible(true);
        frame.setDefaultCloseOperation(2);
    }

    class backgrou extends JPanel{
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            if(backscreen==null&&i==1){
                backscreen=this.createImage(400,508);
            }
            if(backscreen==null&&i==2){
                backscreen=this.createImage(400,508);
            }
         
            Graphics gImage=backscreen.getGraphics();
            
            if(i==1)
                gImage.drawImage(win, 0, 0, this);
            else
                gImage.drawImage(lose, 0, 0, this);               
                    
            g.drawImage(backscreen, 0, 0, null);
            
            System.out.println("setVisible");
        }
    }    
    public int returnx(){
        return x;
    }
}
