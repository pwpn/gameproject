/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author w1505
 */
public class User {
   static int UserID=0;
   static String UserName;
   static String Password;
   static int Level=0;
   static int Progress=0;
   static boolean isOnline=false;
   static SignInFrame sf=new SignInFrame();
   static UserFrame uf=new UserFrame();
    User(int userid,String username,String password){
        UserID=userid;
        UserName=username;
        Password=password;
    }
    public static boolean isOnline(){return isOnline;}
    public static int getUserID(){return UserID;}
    public static int getProgress(){return Progress;}
    public static void setProgress(int progress){User.Progress=progress;User.CheckUserFrame();}
    public static int getLevel(){return Level;}
    public static void setLevel(int level){User.Level=level;User.CheckUserFrame();}
    public static void SaveData() throws SQLException{
        DerbyUser Dbu=new DerbyUser(UserName,Password);
        Dbu.UpdateData("Account", "Level", User.Level);
        Dbu.UpdateData("Account", "Progress", User.Progress);
    }
    public static int GetSave(){
        uf.CheckData();
        if(!isOnline)
            return 1;
       DerbyUser Dbu=new DerbyUser();
       try {
           Dbu.Recheck();
       } catch (SQLException ex) {
           Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, "Failed when check the save", ex);
       }
       return 0;
    }
    public static void stateCheck(){
        if(isOnline){
             GetSave();
             //new UserFrame().setVisible(true);
             uf.setVisible(true);
        }
        else
        {
            sf.setVisible(true);
        }
    }
    public static void DisposeSignInFrame(){
        sf.dispose();
    }
    public static void DisposeUserFrame(){
        uf.dispose();
    }
    public static void CheckUserFrame(){
           uf.CheckData();
    }
}
