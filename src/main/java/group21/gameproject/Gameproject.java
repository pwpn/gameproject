/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package group21.gameproject;
import account.SignInFrame;
import account.UserFrame;
/**
 *
 * @author w1505
 */
public class Gameproject {
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new SignInFrame().setVisible(true);
                        } });
    }
}
