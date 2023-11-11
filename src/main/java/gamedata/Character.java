/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gamedata;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author w1505
 */
public abstract class Character {
    //If the character's stats are fixed, not weak immunity
    private boolean ifFixedStats=false;
    //The ba
    //The original stats of the character;
    private int ATK;
    private int DEF;
    private int SPD;
    private int HP;
    private int LV;
    //The current stats of the character, influenced by 
    private int attack;
    private int defence;
    private int speed;
    private int healthpoint;
    private int level;
    //The skills it may use, maximum 4.
    private Skill[] Skillset=new Skill[4];
    
    public void SkillRelease(){
        Random rnd=new Random();
    
    }
}
