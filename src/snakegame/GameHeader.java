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
import java.awt.event.*; 
import java.util.Timer;
public class GameHeader extends JPanel{
    
    private JPanel buttonContainer = new JPanel();
    private JButton close = new JButton("X"); 
    private JButton min = new JButton("-"); 
    private JButton music  = new JButton("Sound");
    
    public GameHeader(JFrame frame, Timer timer ,Music song){ 
        UtilityClass.styelPanel(this, 900, 40, new Color(241, 241 ,241));
        this.setBackground(new Color(241, 241 ,241));
        this.setLayout(new BorderLayout());

        //Button container 
        UtilityClass.styelPanel(buttonContainer, 125, 40, new Color(241, 241 ,241));
        buttonContainer.setLayout(new BorderLayout());
        this.add(buttonContainer, BorderLayout.EAST);

        //Buttons close ,  min
        UtilityClass.styleButton(close ,  new Color(241, 241 ,241),
                 "Tahoma", "bold", 20, 60, 30, 
                 new Color(0,0,0));
        close.setBorder(BorderFactory.createLineBorder(new Color(241, 241 ,241), 5) );
         
        UtilityClass.styleButton(min, new Color(241, 241, 241),
                "Tahoma", "bold", 20, 60, 30,
                new Color(0, 0, 0));
        buttonContainer.add(close, BorderLayout.EAST); 
        min.setBorder(BorderFactory.createLineBorder(new Color(241, 241 ,241), 5) );
        buttonContainer.add(min, BorderLayout.WEST);
         
         //Music Button 
        UtilityClass.styleButton(music, new Color(241, 241, 241),
                "Tahoma", "bold", 15, 75, 30,
                new Color(0, 0, 0));
        music.setBorder(BorderFactory.createLineBorder(new Color(241, 241 ,241), 5) );
        this.add(music , BorderLayout.WEST);
          
        //Actions 
        close.addActionListener(
        new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.cancel();
                Game.timer.stop();
                frame.dispose();
            }
        }
        );
        
        min.addActionListener(
        new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setState(frame.ICONIFIED);
            }
        }
        );
        
        music.addActionListener(
        new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                if(song.getStatus()) { 
                    song.closeMusic();
                    music.setText("<HTML><strike>" + music.getText() + "</strike> </HTML>");
                }else { 
                   song.musicStart();
                   music.setText("Sound");
               }
               
            }
        }
        );
    }
}


