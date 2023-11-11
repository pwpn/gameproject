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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Lenovo
 */
public class Tujian extends JFrame{

    private Image backscreen=null;
    private JFrame jff=new JFrame();
//    private JPanel jpp=new JPanel();
    private backgrou bg=new backgrou();
    private JButton bo1=new JButton();
    private JButton bo2=new JButton();
    private JButton bo3=new JButton();
    private JButton bo4=new JButton();    
    
    public static void main(String[] args){
        new Tujian();
    }
    
    public Tujian(){
//        
        
        this.setBounds(500, 150, 400, 711);
        this.setIconImage(new ImageIcon("src/photo/008.png").getImage());
//        bg.setLayout(null);
//        this.setLayout(null);


        this.setBackground(Color.yellow);  
//        jpp.setBounds(50,50,50,50);
//        jpp.add(beibei());
//        jpp.setVisible(true);
//        this.add(jpp);
        bg.setLayout(null);
        
        this.aff(bo1, 1, 10, "src/photo/6401.png");
        this.aff(bo2, 2, 180, "src/photo/6411.png");
        this.aff(bo3, 3, 350, "src/photo/6421.png");
        this.aff(bo4, 4, 520, "src/photo/6431.png");
        
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

    private void aff(JButton jb,int who,int y,String name){
        jb.setIcon(new ImageIcon(name));
        jb.setBounds(40, y, 300, 130);
        jb.setRolloverIcon(new ImageIcon("src/photo/tujian1.png"));
        
        bg.add(jb);
        
        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new bosss(who);
            }
        });        
    }
    
    
    class backgrou extends JPanel{
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            if(backscreen==null){
                backscreen=this.createImage(400,711);
            }
         
            Graphics gImage=backscreen.getGraphics();
            
            Image img=Toolkit.getDefaultToolkit().getImage("src/photo/beijin2.png");
            gImage.drawImage(img, 0, 0, this);
            
            gImage.setFont(new Font("仿宋",Font.BOLD,20));
            gImage.setColor(Color.red);
                    
            g.drawImage(backscreen, 0, 0, null);
            
            System.out.println("setVisible");
        }
    }    
}





class bosss extends JFrame{ 
    
    private Theman tm=new Theman("",0,0,new JFrame());
    private Boss1 boss1=new Boss1("",0,0,new JFrame()); 
    private Boss2 boss2=new Boss2("",0,0,new JFrame());
    private Boss3 boss3=new Boss3("",0,0,new JFrame());
    private Boss4 boss4=new Boss4("",0,0,new JFrame());
    private Image backscreen=null;
    private JFrame jff=new JFrame();
//    private JPanel jpp=new JPanel();
    private backgrou bg=new backgrou();
    private JButton tujian=new JButton();

    private int who=0;
    
    public bosss(int i){
//        
        this.who=i;
        this.setBounds(400, 150, 400, 508);
        this.setIconImage(new ImageIcon("src/photo/008.png").getImage());
//        bg.setLayout(null);
//        this.setLayout(null);


        this.setBackground(Color.yellow);  
//        jpp.setBounds(50,50,50,50);
//        jpp.add(beibei());
//        jpp.setVisible(true);
//        this.add(jpp);
        bg.setLayout(null);
        
        switch(who){
            case 1:
                bg.add(beibei(20,"剑击"+"\n"+"威力120"+"\n"+"回复10血"));
                bg.add(beibei(130,"升华"+"\n"+"威力0"+"\n"+"回复50点生命，提升攻击两级"));
                bg.add(beibei(240,"剑落"+"\n"+"威力120"+"\n"+"提升攻击力一级"));
                bg.add(beibei(350,"光华"+"\n"+"威力0"+"\n"+"回复300血量"));                
                break;
            case 2:
                bg.add(beibei(20,"黑魂"+"\n"+"威力0"+"\n"+"回复50血,降低己方攻防两级"));
                bg.add(beibei(130,"崩坏"+"\n"+"威力100"+"\n"+"提升攻击两级"));
                bg.add(beibei(240,"星穹指环"+"\n"+"威力0"+"\n"+"提升攻击力四级"));
                bg.add(beibei(350,"乱披风锤罚"+"\n"+"威力150"+"\n"+"回复50血量"));                
                break;
            case 3:
                bg.add(beibei(20,"誓约胜利之剑"+"\n"+"威力150"+"\n"+"提升攻击一级，50%概率双倍伤害"));
                bg.add(beibei(130,"阿瓦隆"+"\n"+"威力0"+"\n"+"回复500点生命，提升攻击一级"));
                bg.add(beibei(240,"王权"+"\n"+"威力0"+"\n"+"提升攻防两级"));
                bg.add(beibei(350,"Ex击杀"+"\n"+"威力50"+"\n"+"20%秒杀对手"));                
                break;
            case 4:
                bg.add(beibei(20,"祖魂"+"\n"+"威力0"+"\n"+"回复400血，提升攻防两级"));
                bg.add(beibei(130,"王神一击"+"\n"+"威力150"+"\n"+"回复50点生命，提升攻击两级"));
                bg.add(beibei(240,"祖龙刀"+"\n"+"威力120"+"\n"+"降低己方攻防两级"));
                bg.add(beibei(350,"尼德霍格"+"\n"+"威力20"+"\n"+"提升攻防一级，当己方生命低于20%秒杀"));                
                break;
            default:break;
        }
        
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

        skill1.setBounds(160, y, 200, 100);//skill1.setVisible(true);
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
            
            Image img=Toolkit.getDefaultToolkit().getImage("src/photo/beibao.png");
            gImage.drawImage(img, 0, 0, this);
            
            gImage.drawImage(Toolkit.getDefaultToolkit().getImage("src/photo/b"+who+"t.jpg"), 20, 20, this);
            gImage.setFont(new Font("仿宋",Font.BOLD,20));            
                    
            switch(who){
                case 1:
                    gImage.setColor(Color.red);
                    gImage.drawString("精灵名：烬琉", 10, 150);
                    gImage.setColor(Color.green);
                    gImage.drawString("攻击力:"+boss1.b1attack,10,200);
                    gImage.drawString("防御力:"+boss1.b1defence,10,250);
                    gImage.drawString("血量:"+boss1.b1blood,10,300);
                    break;
                case 2:
                    gImage.setColor(Color.red);
                    gImage.drawString("精灵名：赫拓", 10, 150);
                    gImage.setColor(Color.green);
                    gImage.drawString("攻击力:"+boss2.b1attack,10,200);
                    gImage.drawString("防御力:"+boss2.b1defence,10,250);
                    gImage.drawString("血量:"+boss2.b1blood,10,300);
                    break;
                case 3:
                    gImage.setColor(Color.red);
                    gImage.drawString("精灵名：亚瑟", 10, 150);
                    gImage.setColor(Color.green);
                    gImage.drawString("攻击力:"+boss3.b1attack,10,200);
                    gImage.drawString("防御力:"+boss3.b1defence,10,250);
                    gImage.drawString("血量:"+boss3.b1blood,10,300);
                    break;
                case 4:
                    gImage.setColor(Color.red);
                    gImage.drawString("精灵名：祖龙", 10, 150);
                    gImage.setColor(Color.green);
                    gImage.drawString("攻击力:"+boss4.b1attack,10,200);
                    gImage.drawString("防御力:"+boss4.b1defence,10,250);
                    gImage.drawString("血量:"+boss4.b1blood,10,300);
                    break;        
            }
                    
            g.drawImage(backscreen, 0, 0, null);
            
            System.out.println("setVisible");
        }
    }
}