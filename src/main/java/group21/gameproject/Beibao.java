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
public class Beibao extends JFrame{ 
    
    private Theman tm;
    private Image backscreen=null;
    private JFrame jff=new JFrame();
//    private JPanel jpp=new JPanel();
    private backgrou bg=new backgrou();
    private JButton tujian=new JButton();
    
    public static void main(String[] args){
        new Beibao(new Theman("src/data/pic/photo/actor_d.gif",0,0,new JFrame()));
    }
    
    public Beibao(Theman tm){
        this.tm=tm;
//        
        
        this.setBounds(400, 150, 400, 508);
        this.setIconImage(new ImageIcon("src/data/pic/photo/008.png").getImage());
//        bg.setLayout(null);
//        this.setLayout(null);


        this.setBackground(Color.yellow);  
//        jpp.setBounds(50,50,50,50);
//        jpp.add(beibei());
//        jpp.setVisible(true);
//        this.add(jpp);
        bg.setLayout(null);
        bg.add(beibei(20,"超必杀：真红爆炎地狱"+"\n"+"威力160（四魂触发）"+"\n"+"全属性提升2级，降低对手攻防一级"));
        
        bg.add(beibei(110,"剑来"+"\n"+"威力0(提升一魂)"+"\n"+"先发，提升攻防两级"));
        bg.add(beibei(200,"万剑齐发"+"\n"+"威力80(提升一魂)"+"\n"+"先发，回复50点生命，降低对手防御一级"));
        bg.add(beibei(290,"剑刃归宗"+"\n"+"威力120(提升一魂)"+"\n"+"提升攻击力一级"));
        bg.add(beibei(380,"无限杀戮"+"\n"+"威力0(提升一魂)"+"\n"+"回复200血量，三回合内每回合提升攻击一级"));
        
        tujian.setIcon(new ImageIcon("src/data/pic/photo/tujian.png"));
        tujian.setBounds(20, 350, 80, 80);
        tujian.setRolloverIcon(new ImageIcon("src/data/pic/photo/tujian1.png"));
        
        bg.add(tujian);
        
        tujian.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tujian();
            }
            
        });
        
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
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setVisible(true);

        
//        bg.repaint();
////        jpp.repaint();
        this.repaint();
//        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public JTextPane beibei(int y,String x){
        Font f=new Font("华文行楷",Font.BOLD,17);
        JTextPane skill1 = new JTextPane();
        skill1.setFont(f);
        skill1.setEditable(false);

//        StyledDocument doc = skill1.getStyledDocument();
//        Style style = skill1.addStyle("MyHilite", null);
//        StyleConstants.setForeground(style, Color.GREEN.darker());

        skill1.setBounds(160, y, 200, 80);//skill1.setVisible(true);
        skill1.setText(x); 
        return skill1;
    }
    
    
    class backgrou extends JPanel{
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            if(backscreen==null){
                backscreen=this.createImage(400,508);
            }
         
            Graphics gImage=backscreen.getGraphics();
            
            Image img=Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/beibao.png");
            gImage.drawImage(img, 0, 0, this);
            gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/data/pic/photo/jinlin.png"), 10, 10, this);
            
            gImage.setFont(new Font("仿宋",Font.BOLD,20));
            gImage.setColor(Color.red);
            gImage.drawString("精灵名：元神", 10, 150);
            gImage.setColor(Color.green);
            gImage.drawString("等级:"+tm.level, 10, 200);
            gImage.drawString("攻击力:"+tm.attack,10,230);
            gImage.drawString("防御力:"+tm.defence,10,260);
            gImage.drawString("血量:"+tm.blood,10,290);
                    
            g.drawImage(backscreen, 0, 0, null);
            
            System.out.println("setVisible");
        }
    }
}
