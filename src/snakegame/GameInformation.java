package snakegame;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameInformation extends JPanel {
    private JLabel logo  = new JLabel(); 
    private JLabel timeTitle  = new JLabel("Time: "); 
    private static JLabel time = new JLabel("00 : 00 : 00"); 
    private static int  timeCounter =0; 
    private static int seconds = 0; 
    private int mins = 0; 
    private int hours = 0; 
    Timer  timer = new Timer(); 
    private String stringSeconds = String.format("%02d", seconds); 
    private String stringMins = String.format("%02d", mins); 
    private String stringHours = String.format("%02d", hours); 
    private JLabel scoreTitle = new JLabel("Score: ");
    private static JLabel score = new  JLabel("0");
    private JButton rest = new JButton("Restart");
    private static boolean timeStoped = false; 
    
    GameInformation(Game game) { 
        UtilityClass.styelPanel(this, 286, 510, new Color(0,0,0));
        this.setBorder(BorderFactory.createLineBorder(new Color(241, 241, 241), 2));
        
        //ADD LOGO 
        JPanel container= new JPanel(); 
        UtilityClass.styelPanel(container,  280, 40, new Color(0,0,0));
        logo.setPreferredSize(new Dimension(40, 40));
        logo.setIcon(new ImageIcon("snake.png"));
        container.add(logo);
        this.add(container);
        
        //space 
        JPanel p =   new JPanel (); 
         UtilityClass.styelPanel(p,  280, 60, new Color(0,0,0));
        this.add(p);
        
        //time counter  
        JPanel timeContainer  = new JPanel(); 
        timeContainer.setLayout(new BorderLayout());
        UtilityClass.styelPanel(timeContainer, 280, 50, new Color(0,0,0));
        
        UtilityClass.sytleLabel(timeTitle, 100, 40, new Color(241, 241, 241), "Tahoma", "bold", 15);
        timeTitle.setVerticalAlignment(JLabel.CENTER);
        timeTitle.setHorizontalAlignment(JLabel.CENTER);
        
        UtilityClass.sytleLabel(time , 50, 40, new Color(241, 241, 241), "Tahoma", "bold", 20);
        time.setVerticalAlignment(JLabel.CENTER);
        time.setHorizontalAlignment(JLabel.CENTER);
        time.setBorder(BorderFactory.createLineBorder( new Color(241, 241, 241), 1 ));
        
        timeContainer.add(timeTitle, BorderLayout.WEST);
        timeContainer.add(time, BorderLayout.CENTER);     
        timeContainer.add(Box.createHorizontalStrut(40), BorderLayout.EAST);
        add(timeContainer);
        
        //space 
        JPanel p2 = new JPanel();
        UtilityClass.styelPanel(p2, 280, 60, new Color(0, 0, 0));
        this.add(p2);
        
        //Score continer  
        //time counter  
        JPanel scoreContainer = new JPanel();
        scoreContainer.setLayout(new BorderLayout());
        UtilityClass.styelPanel(scoreContainer, 280, 50, new Color(0, 0, 0));

        UtilityClass.sytleLabel(scoreTitle, 100, 40, new Color(241, 241, 241), "Tahoma", "bold", 15);
        scoreTitle.setVerticalAlignment(JLabel.CENTER);
        scoreTitle.setHorizontalAlignment(JLabel.CENTER);

        UtilityClass.sytleLabel(score, 50, 40, new Color(241, 241, 241), "Tahoma", "bold", 20);
        score.setVerticalAlignment(JLabel.CENTER);
        score.setHorizontalAlignment(JLabel.CENTER);
        score.setBorder(BorderFactory.createLineBorder(new Color(241, 241, 241), 1));

        scoreContainer.add(scoreTitle, BorderLayout.WEST);
        scoreContainer.add(score, BorderLayout.CENTER);
        scoreContainer.add(Box.createHorizontalStrut(40), BorderLayout.EAST);
        add(scoreContainer);

        
        //space 
        JPanel p3 = new JPanel();
        UtilityClass.styelPanel(p3, 280, 60, new Color(0, 0, 0));
        this.add(p3);
        
        //Rest Button  
        //Button Container 
        JPanel buttonContainer = new JPanel();
        UtilityClass.styelPanel(buttonContainer, 280, 50, new Color(0, 0, 0));
        
        UtilityClass.styleButton(rest, new Color(0,0,0), "tahoma", TOOL_TIP_TEXT_KEY, 20, 100, 40, new Color(241, 241, 241));
        buttonContainer.add(Box.createHorizontalStrut(50));
        buttonContainer.add(rest);
        add(buttonContainer);
        
        countTime();
        
        rest.addActionListener(
          
            new ActionListener() { 
               @Override
               public void actionPerformed(ActionEvent e) {
                  score.setText("0"); 
                  seconds = 0;
                  timeCounter =0;
                  time.setText("00 : 00 : 00");
                  game.restartTheGame();
               }
                    
            }
        
        );
        
        
        
    }
    
    
    public  void countTime() { 
        
        TimerTask task = new  TimerTask() { 
            @Override
            public void run() {
                if(timeStoped == false) {
                timeCounter += 1000;
                seconds = (timeCounter / 1000) % 60;
                mins = (timeCounter / (60 * 1000)) % 60;
                hours = timeCounter / 3600000;
                stringHours = String.format("%02d", hours);
                stringMins = String.format("%02d", mins);
                stringSeconds = String.format("%02d", seconds);
                time.setText(stringHours + " : " + stringMins + " : " + stringSeconds);
                }
            }
            
        };
        
        timer.schedule(task, 1,1000);
    }
    
    public Timer getTimer() { 
        return timer;
    }
    
    public static void setScore( int points) { 
         score.setText("" + points);
    }
    
    public static void setLabelFontColor(Color color) { 
        time.setForeground(color);
        score.setForeground(color);
    }

    public static  void StopTime() { 
        timeStoped =true;
    }
    
    public static void startTIme() { 
        timeStoped = false;
    }
    
    public static void  restartTime() { 
        seconds = 0;
        timeCounter = 0;
        time.setText("00 : 00 : 00");
    }
}
