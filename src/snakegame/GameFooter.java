/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

/**
 *
 * @author User
 */
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class GameFooter extends JPanel{
    
    JButton exit = new JButton("Exit");
    
    public GameFooter(JFrame frame, Timer timer) { 
        UtilityClass.styelPanel(this, 900, 40, new Color(241, 241, 241));
        
        //Exit Button 
        UtilityClass.styleButton(exit, new Color(241, 241, 241),
                "Tahoma", "bold", 15, 75, 30,
                new Color(0, 0, 0));
        
        this.add(exit);
        
        exit.addActionListener(
        new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
               timer.cancel();
               Game.timer.stop();
               frame.dispose();
            }
            
        }
        );
    }
}
