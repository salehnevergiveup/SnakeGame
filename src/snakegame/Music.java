/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.io.File; 
import javax.sound.sampled.*; 
import javax.swing.JOptionPane;
public class Music {
    
    private File file;
    private Clip clip; 
    private static  boolean status = true;
    public Music(String filePath) { 
        file = new File(filePath);
    }
    
    
    public void musicStart(){ 
        if(clip == null  || !clip.isActive()) { 
            try { 
                status = true; 
                AudioInputStream audio = AudioSystem.getAudioInputStream(file); 
                clip = AudioSystem.getClip(); 
                clip.open(audio);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
                clip.start();
                
            }catch(Exception ex) { 
                JOptionPane.showMessageDialog(null, "asdasda");
            }
            
            
        }
    }
    
    
    public  void closeMusic() { 
        status = false; 
        if(clip != null) clip.stop();
    }
    
    public  boolean getStatus() { 
        return status;
    }
    
    
    

}
