/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author w1505
 */
public class SignCheck {
    public SignCheck(){}
    //Translate the password
    public String PasswordTrans(JPasswordField f){
        String Password="";
        for(char x:f.getPassword())
                Password+=x;
        return Password;
    }
    //Compare two texts inside the field
    public boolean CompareTexts(JPasswordField a,JPasswordField b){
        return this.PasswordTrans(a).equals(PasswordTrans(b));
    }
    public boolean CompareTexts(JTextField a,JTextField b){
        return a.equals(b);
    }
    //Check the inside
    public int CheckTexts(JTextField a,String AllowedChars,int Minimum,int Maximum){
        String Text=a.getText();
        
        if(Text.isBlank())
            return 1;
        if(Text.length()<Minimum||Text.length()>Maximum)
            return 2;
        if(AllowedChars!=null)
            for(int i=0;i<Text.length();i++)
                if(AllowedChars.indexOf(Text.toLowerCase().charAt(i))==-1)
                    return 3;
        return 0;
    }
    public int CheckTexts(JPasswordField a,String AllowedChars,int Minimum,int Maximum){
        String Text=this.PasswordTrans(a);
        if(Text.isBlank())
            return 1;
        if(Text.length()<Minimum||Text.length()>Maximum)
            return 2;
        if(AllowedChars!=null)
            for(int i=0;i<Text.length();i++)
                if(AllowedChars.indexOf(Text.toLowerCase().charAt(i))==-1)
                    return 3;
        return 0;
    }
}
