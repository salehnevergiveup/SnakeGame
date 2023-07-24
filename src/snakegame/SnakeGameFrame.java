/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javax.swing.*; 
import java.awt.*; 

public class SnakeGameFrame extends JFrame {
    
    JPanel container = new JPanel();
    GameHeader header; 
    JPanel body = new JPanel();
    JPanel gameContent = new JPanel();
    GameInformation gameInfo;
    Game game;
    GameFooter footer;
    Music music = new Music("LobbyTime.wav");
    
    public SnakeGameFrame() { 
        
        UtilityClass.styleFrame(this, 900,600);
      
        UtilityClass.styelPanel(container, 900,600, new Color(0,0,0));
        container.setLayout(new BorderLayout());
        this.add(container);
        this.pack();

        
        //Add The Body 
        body.setBackground(new Color(0,0,0));
        body.add(gameContent);
        container.add(body);
        
        
        //Game Content  
        UtilityClass.styelPanel(gameContent, 880,  510, new Color(0,0,0));
        gameContent.setLayout(new BorderLayout());
        

        
        //Game 
        game = new Game(); 
        gameContent.add(game, BorderLayout.WEST);
        
                
        //Game Information 
        gameInfo = new  GameInformation(game);
        gameContent.add(gameInfo, BorderLayout.EAST);
        
        
        //Add the  header 
        header = new GameHeader(this , gameInfo.getTimer(), music);
        container.add(header, BorderLayout.NORTH);
        
        //Add the footer 
        footer = new GameFooter(this, gameInfo.getTimer());
        container.add(footer, BorderLayout.SOUTH);
        
        
        //Action
        music.musicStart();
        
        
    }
    
}
