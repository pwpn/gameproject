/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group21.gameproject;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Lenovo
 */
public class Soundbgm {
    private String path="music";
    private String file="bgm.wav";
    
    void loadSound() throws UnsupportedAudioFileException{
        File soundFile = new File("src/data/music/bgm.wav");
        try {
        System.out.println("music");
           URL url = soundFile.toURL();
           	if (!soundFile.exists()) {
			System.err.println("Wave file not found:" );
			return;
		}
            AudioInputStream as=null;    
            try {
                AudioClip ap = Applet.newAudioClip(url);
                as = AudioSystem.getAudioInputStream(soundFile);
            } catch (IOException ex) {
                Logger.getLogger(Soundbgm.class.getName()).log(Level.SEVERE, null, ex);
            }
//            ap.play();
//           ap.loop();
//            ap.play();
//           ap.loop();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
}
