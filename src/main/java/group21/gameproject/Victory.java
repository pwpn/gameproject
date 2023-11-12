/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Lenovo
 */
public class Victory extends JFrame{ 
    
    private Image backscreen=null;
    private JFrame jff=new JFrame();
//    private JPanel jpp=new JPanel();
    private backgrou bg=new backgrou();
    

    public Victory(){
//        
        
        this.setBounds(400, 150, 500, 350);
        this.setIconImage(new ImageIcon("src/photo/008.png").getImage());
//        bg.setLayout(null);
//        this.setLayout(null);


        this.setBackground(Color.yellow);  
//        jpp.setBounds(50,50,50,50);
//        jpp.add(beibei());
//        jpp.setVisible(true);
//        this.add(jpp);
      
        
        this.add(bg);
        /*
        ImageIcon bg=new ImageIcon("src/photo/beibao.png");
	JLabel label=new JLabel(bg);
	label.setSize(bg.getIconWidth(),bg.getIconHeight());
	jff.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel pan=(JPanel)jff.getContentPane();
	pan.setOpaque(false);*/
                
//        this.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setVisible(true);

        
//        bg.repaint();
////        jpp.repaint();
        this.repaint();
//        SwingUtilities.updateComponentTreeUI(this);
    }
    
    
    class backgrou extends JPanel{
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            if(backscreen==null){
                backscreen=this.createImage(500,350);
            }
         
            Graphics gImage=backscreen.getGraphics();
            
            Image img=Toolkit.getDefaultToolkit().getImage("src/photo/victory.jpg");
            gImage.drawImage(img, 0, 0, this);

            g.drawImage(backscreen, 0, 0, null);
            
            System.out.println("setVisible");
        }
    }
}
