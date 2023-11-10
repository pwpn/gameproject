/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

/**
 *
 * @author w1505
 */
public class User {
   public static int UserID=0;
   static String UserName;
   static String Password;
   static boolean isOnline=false;
    User(int userid,String username,String password){
        UserID=userid;
        UserName=username;
        Password=password;
    }
}
