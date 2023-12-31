/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package account;

import static account.UserFrame.user;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w1505
 */
public class SignInFrame extends javax.swing.JFrame {
    /**
     * Creates new form SignUpFrame
     */
    public SignInFrame() {
        if(User.isOnline){
            User.uf.setVisible(true);
            dispose();
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PasswordField = new javax.swing.JPasswordField();
        UserNameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SignInButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SignUpLabel = new javax.swing.JLabel();
        HintLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sign In");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(100, 100));
        setName("SignInFrame"); // NOI18N
        setResizable(false);

        PasswordField.setInheritsPopupMenu(true);

        UserNameText.setToolTipText("");

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        SignInButton.setLabel("Sign In");
        SignInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel4.setText("SIGN IN");

        jLabel5.setText("Don't have an account yet?");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setFocusable(false);
        jLabel5.setIconTextGap(0);
        jLabel5.setRequestFocusEnabled(false);
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        SignUpLabel.setForeground(new java.awt.Color(0, 0, 242));
        SignUpLabel.setText("Sign up");
        SignUpLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        SignUpLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignUpLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignUpLabelMouseClicked(evt);
            }
        });

        HintLabel.setText("     ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SignUpLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HintLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SignInButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PasswordField)
                                .addComponent(UserNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)))))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SignInButton)
                            .addComponent(HintLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SignUpLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(66, 66, 66)))
                .addGap(66, 66, 66))
        );

        UserNameText.getAccessibleContext().setAccessibleName("");
        HintLabel.getAccessibleContext().setAccessibleName("HintLabel");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignUpLabelMouseClicked

            //Open the SignUpFrame
            java.awt.EventQueue.invokeLater(() -> {
                new SignUpFrame().setVisible(true);
            });
            //Close this frame
            this.dispose();
    }//GEN-LAST:event_SignUpLabelMouseClicked

    private void SignInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButtonActionPerformed
       SignCheck sc=new SignCheck();
        //Check The Input
       String Username=this.UserNameText.getText();
       String Password=sc.PasswordTrans(PasswordField);
       if(sc.CheckTexts(UserNameText, "abcdefghijklmnopqrstuvwxyz12345667890", 3, 10)+sc.CheckTexts(PasswordField, null, 6, 20)>0){
           this.HintLabel.setText("Please check your input");
           this.HintLabel.setForeground(new Color(255,0,0));
       }else{
           this.HintLabel.setText("Connecting to the server...");
           this.HintLabel.setForeground(new Color(0,0,0));
           if(User.Dbu.Connect()&&User.Dbu.StatementCreate()){
               try {
                ResultSet rs = User.Dbu.getStatement().executeQuery("select count(username) from account where username='"+Username+"'");
                rs.next();
                if(rs.getInt(1)==0){
                    this.HintLabel.setText("Invaild Username");
                    this.HintLabel.setForeground(new Color(255,0,0));
                }else{
                rs=User.Dbu.getStatement().executeQuery("select availability from account where username="+User.Dbu.Quote(Username, 0));
                rs.next();
                if(!rs.getBoolean(1)){
                    this.HintLabel.setText("The account has been banned");
                    this.HintLabel.setForeground(new Color(255,0,0));}
                    else
                    {
                        //Check the password
                        rs = User.Dbu.getStatement().executeQuery("select password from account where username="+User.Dbu.Quote(Username, 0));
                        rs.next();
                        if(rs.getString(1) == null ? Password == null : rs.getString(1).equals(Password)){
                        //Login successfully
                        this.HintLabel.setText("Sign in successfully");
                        this.HintLabel.setForeground(new Color(34,177,76));
                        rs = User.Dbu.getStatement().executeQuery("select userid from account where username="+User.Dbu.Quote(Username, 0));
                        rs.next();
                        User.UserID=rs.getInt(1);
                        User.UserName=Username;
                        User.Password=Password;
                        User.isOnline=true;
                        rs = User.Dbu.getStatement().executeQuery("select Progress,Level from account where userid="+String.valueOf(User.UserID));
                        rs.next();
                        User.Progress=rs.getInt(1);
                        User.Level=rs.getInt(2);
                        User.CheckUserFrame();
                        this.dispose();
                        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            User.uf.setVisible(true);
                        } });
                    }
                    else{
                        this.HintLabel.setText("Wrong Password");
                        this.HintLabel.setForeground(new Color(255,0,0));
 
                    }
                }
                }   
               } catch (SQLException ex) {
                   Logger.getLogger(SignInFrame.class.getName()).log(Level.SEVERE, "Failed while seeking", ex);
               }
           }else{
           this.HintLabel.setText("Connection Failed");
           this.HintLabel.setForeground(new Color(255,0,0));
           }
       }
    }//GEN-LAST:event_SignInButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new SignInFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HintLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton SignInButton;
    private javax.swing.JLabel SignUpLabel;
    private javax.swing.JTextField UserNameText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
