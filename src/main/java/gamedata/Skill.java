/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedata;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author w1505
 */
public class Skill {
    
    private final int SkillID;
    int Damage=0;
    String Name="Unknown";
    String Description="Unknown";
    private Image SkillIcon=Toolkit.getDefaultToolkit().getImage("src/data/rsc/icon/UnknownIcon.png");
        Image getSkillIcon(){return SkillIcon;}
    //Like increase the spped or something else.
    private boolean ifSpecial=false;
    Skill(){this.SkillID=0;String Name="Unknown";String Description="Unknown";SkillIcon=Toolkit.getDefaultToolkit().getImage("src/data/rsc/icon/UnknownIcon.png");}
    //What a simplist skill should have 
    Skill(int id,int dmg,String description,Image icon){
        this.SkillID=id;
        this.Damage=dmg;
        this.Description=description;
        this.SkillIcon=icon;
    }
    //What a 
}
