/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package account;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author w1505
 */
public class UserFrame extends javax.swing.JFrame {
    public static User user;
    /**
     * Creates new form UserFrame
     */
    public UserFrame() {
            initComponents();
            idlabel.setText(String.valueOf(User.UserID));
            namelabel.setText(User.UserName);
            proglabel.setText(String.valueOf(User.Progress));
            lvlabel.setText(String.valueOf(User.Level));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        WelcomeLabel = new java.awt.Label();
        idlabel = new javax.swing.JLabel();
        namelabel = new javax.swing.JLabel();
        LogoutLabel = new java.awt.Label();
        jLabel3 = new javax.swing.JLabel();
        proglabel = new javax.swing.JLabel();
        lvlabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        SaveHint = new javax.swing.JLabel();
        PswdChange = new java.awt.Label();
        datelabel = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User");

        jLabel1.setText("UserID");

        jLabel2.setText("Name");

        WelcomeLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        WelcomeLabel.setText("Welcome!");

        idlabel.setText("UserID");

        namelabel.setText("Name");

        LogoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutLabel.setForeground(new java.awt.Color(0, 0, 255));
        LogoutLabel.setText("Log out");
        LogoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutLabelMouseClicked(evt);
            }
        });

        jLabel3.setText("Progress");

        proglabel.setText("Progress");

        lvlabel.setText("Level");

        jLabel6.setText("Level");

        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        label1.setForeground(new java.awt.Color(0, 0, 255));
        label1.setText("Savedata");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });

        SaveHint.setText("     ");

        PswdChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PswdChange.setForeground(new java.awt.Color(0, 0, 255));
        PswdChange.setText("Change Password");
        PswdChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PswdChangeMouseClicked(evt);
            }
        });

        datelabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveHint, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idlabel)
                                    .addComponent(namelabel)
                                    .addComponent(proglabel)
                                    .addComponent(lvlabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PswdChange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idlabel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namelabel))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(proglabel))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lvlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaveHint, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PswdChange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LogoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(datelabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        WelcomeLabel.getAccessibleContext().setAccessibleName("WelcomeLabel");
        LogoutLabel.getAccessibleContext().setAccessibleName("LogoutLabel");
        label1.getAccessibleContext().setAccessibleName("Save Data");
        label1.getAccessibleContext().setAccessibleDescription("");
        SaveHint.getAccessibleContext().setAccessibleName("SaveHint");
        PswdChange.getAccessibleContext().setAccessibleName("PswdChange");
        PswdChange.getAccessibleContext().setAccessibleDescription("");
        datelabel.getAccessibleContext().setAccessibleName("dateLabel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutLabelMouseClicked
        if(!User.isPlaying)
            {User.UserID=0;
            User.isOnline=false;
            dispose();
            new SignInFrame().setVisible(true);}
        else
            JOptionPane.showMessageDialog(null,"You can not logout while playing","Failed to logout",1);
    }//GEN-LAST:event_LogoutLabelMouseClicked

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        try {
            User.SaveData();        // TODO add your handling code here:
            Date date=new Date();
            SaveHint.setText("Save Successfully");
            datelabel.setText("Last save time:"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
            SaveHint.setForeground(new Color(34,177,76));
        } catch (SQLException ex) {
            Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
            SaveHint.setForeground(Color.red);
            SaveHint.setText("Save Failed");
        }
    }//GEN-LAST:event_label1MouseClicked
    public void CheckData(){
        namelabel.setText(User.UserName);
        idlabel.setText(String.valueOf(User.UserID));
        proglabel.setText(String.valueOf(User.Progress));
        lvlabel.setText(String.valueOf(User.Level));
    }
    private void PswdChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PswdChangeMouseClicked
        SaveHint.setText("");
        String oldpswd=JOptionPane.showInputDialog(null,"Please Input The Old Password:","Hint",3);
        
        if(oldpswd.equals(User.Password))//Actually unsafe to check offline. However, it may not be that important when the whole system keeps defenseless
        {
            //So now we can check the new one.
            String newpswd=JOptionPane.showInputDialog(null,"Please Input The New Password:","Hint",3);
            SignCheck sc=new SignCheck();
            int result=sc.CheckTexts(newpswd, null, 6, 20);
            switch(result){
                case 0:String newpswd2=JOptionPane.showInputDialog(null,"Please Input The New Password Again:","Hint",3);
                if(newpswd2.equals(newpswd)){
                    DerbyUser Dbu=new DerbyUser(User.UserName,User.Password);
                try {
                    Dbu.UpdateData("Account", "Password", newpswd);
                    Dbu.Recheck();
                    JOptionPane.showMessageDialog(null,"Change successfully!","Success",1);
                } catch (SQLException ex) {
                    Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, "Update Failed", ex);
                    JOptionPane.showMessageDialog(null,"Update Failed!","Failed",0);
                }
                
                }
                else
                    JOptionPane.showMessageDialog(null,"Please confirm your password","Failed",2);
                break;
                case 1:JOptionPane.showMessageDialog(null,"Password can not be null","Failed",2);
                break;
                case 2:JOptionPane.showMessageDialog(null,"Password should be at a length of 6 to 20","Failed",2);
                break;
                case 3:JOptionPane.showMessageDialog(null,"Illegal characters checked!","Failed",2);
                
            }
        }
        else
        {JOptionPane.showMessageDialog(null,"Wrong Input!","Failed",2);}
    }//GEN-LAST:event_PswdChangeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label LogoutLabel;
    private java.awt.Label PswdChange;
    private javax.swing.JLabel SaveHint;
    private java.awt.Label WelcomeLabel;
    private java.awt.Label datelabel;
    private static javax.swing.JLabel idlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private java.awt.Label label1;
    private javax.swing.JLabel lvlabel;
    private static javax.swing.JLabel namelabel;
    private javax.swing.JLabel proglabel;
    // End of variables declaration//GEN-END:variables
}
