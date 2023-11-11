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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class IsFight {
    
    /**
     *
     * @param tm
     * @param boss1
     */
    public static void main(String[] args){
        new IsFight(new Theman("src/data/rsc/pic/actor_d.gif",0,0,new JFrame()),1);
    }
    
    static int i=0;
    
    public IsFight(Theman tm,int i){

        this.i=i;
        JFrame frame = new JFrame("是否挑战？");
        frame.setBounds(400, 300, 400, 100);
        frame.setIconImage(new ImageIcon("src/data/rsc/pic/008.png").getImage());

        /*
        JDialog d1 = new JDialog(frame, "模式对话框", true);
        JDialog d2 = new JDialog(frame, "非模式对话框", false);
        d1.setBounds(20,30,300,400);
        d2.setBounds(20,30,300,400);
*/

        JButton b1 = new JButton("在对抗与纷争的尽头，有我！");
        JButton b2 = new JButton("前面的路以后再来挑战吧！");


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Tatakai(tm,i);//(tm,boss1);
//                tata.repaint();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        //把按钮添加到frame中
        frame.add(b1);
        frame.add(b2,BorderLayout.SOUTH);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(2);

    }
}
