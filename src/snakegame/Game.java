/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*; 

public class Game extends JPanel implements ActionListener{
    private final int  screenWidth =  580; 
    private final int screenHeight =510;
    private final int unit =15;  
    private final int unitNumber =  (screenWidth * screenHeight)/ unit;
    private int applex; 
    private int appleY;
    private int snakeBody =  6;  
    private int baseSize = 6; 
    final int x[] =  new int[unitNumber];
    final int y[] = new int[unitNumber]; 
    public static Timer timer;
    private boolean isRunning = true;
    private int delay = 175;
    private char dir = 'D';
    private JPanel gameOver = new JPanel(); 
    private JButton startAgain = new JButton("Again"); 
    
    public Game() { 
        UtilityClass.styelPanel(this, screenWidth, screenHeight, new Color(0, 0, 0));
        this.setBorder(BorderFactory.createLineBorder(new Color(241, 241, 241), 2, false));
        this.setLayout(null); 
        this.addKeyListener(new MyKeyAdapter());
        this.setFocusable(true);
        startGame();   
        
        startAgain.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame(); 
            }
            
        });
        
    }
    
    public void newGame() { 
                isRunning = true;
                gameOver.setVisible(!isRunning);
                GameInformation.setScore(0);
                GameInformation.setLabelFontColor(new Color(241, 241, 241));
                snakeBody =6; 
                baseSize = 6;
                delay  =175; 
                timer.setDelay(delay);
                dir = 'R';
                GameInformation.startTIme();
                GameInformation.restartTime();
                newApple(); 
    }
    
    public  void restartTheGame() { 
        for (int i = 0; i < x.length; i++) {
            x[i] = unit;
            y[i] = unit;
        }
        GameInformation.setScore(0);
        GameInformation.setLabelFontColor(new Color(241, 241, 241));
        snakeBody = 6;
        baseSize = 6;
        delay = 175;
        timer.setDelay(delay);
        dir = 'R';
        newApple();
    }
    
    @Override
    public  void  paintComponent(Graphics g) { 
        super.paintComponent(g);
        draw(g);
    }
    
    public void  draw(Graphics g) { 
            Graphics2D shape = (Graphics2D) g; 
        
        if(isRunning) {
   
            for(int i = 0; i <= screenHeight/unit ; i++ ){ 

                  shape.drawLine(0, unit *i ,screenWidth,unit * i );
            } 

            for(int i = 0 ; i <= screenWidth/unit ; i++) { 

                shape.drawLine(unit*i, 0, unit*i, screenHeight);
            }

            //apple 
            Image image = new ImageIcon("apple.png").getImage(); 
            shape.drawImage(image, applex, appleY, unit, unit, null);


            //snake 
            for (int i = 0; i < snakeBody; i++) {
                if (i == 0) {
                    shape.setColor(new Color(238 ,149 ,149));
                    shape.fillRect(x[i], y[i], unit, unit);
                } else {
                    shape.setColor(new Color(255,0,0));
                    shape.fillRect(x[i], y[i], unit, unit);
                }
            }
        }else { 
            for(int i=0; i < x.length; i++){ 
                x[i] = unit;
                y[i] =unit;
            }
            repaint();
        }
    }
    

    
    public void newApple() { 
        applex = new Random().nextInt((int)(screenWidth /unit) ) * unit;
        appleY = new Random().nextInt((int)(screenHeight/unit))* unit;
    }

   //start method 
    public void startGame() { 
        newApple();
        timer = new Timer(delay, this);
        timer.start();
    }
    
    public void move() {
        for(int i = snakeBody; i > 0 ; i--) { 
            x[i] = x[i-1]; 
            y[i]= y[i-1];
        }
        
        switch (dir) {
            case 'R':
                x[0] += unit;
                break;
            case 'L':
                x[0] -= unit;
                break;
            case 'U':
                y[0] -= unit;
                break;
            case 'D':
                y[0] += unit;
                break;
        }

    }
    
    public void  gameOver() { 
        final int panelHeight = 300; 
        final int panelWidth = 400;
 
        gameOver.setBounds( screenWidth/2  - (panelWidth/2) , screenHeight/2 - (panelHeight/2),  panelWidth, panelHeight);
        gameOver.setBackground(new Color(241, 241 ,241));
        gameOver.setLayout(null);
        gameOver.setVisible(!isRunning);
        add(gameOver);
        
        JLabel label  = new JLabel("GAME OVER..");  
        UtilityClass.sytleLabel(label, 0, 0, Color.black , "Tahoma", "blod", 30);
        label.setBounds( (panelWidth/2) - 100 , (panelHeight/2) - 50, 200, 50);
        gameOver.add(label);
        
       
         UtilityClass.styleButton( startAgain, new Color(241, 241, 241),
                "Tahoma", "bold", 15, 75, 30,
                new Color(0, 0, 0));
         startAgain.setBounds( (panelWidth/2) - 35, panelHeight - 50, 75, 30);
         gameOver.add(startAgain);
          GameInformation.StopTime();
          GameInformation.setLabelFontColor(Color.red);
         
    }
    
    public void cross() { 
       //if the snake touch itself 
       for(int i= 1; i< snakeBody ;i++) { 
           if(x[i] == x[0] && y[i] == y[0]) { 
               isRunning = false;
           }
       }
       
      //if head touch the right wall 
      if(x[0] < 0) { 
          isRunning = false;
      }
      
      //if head tiuch the left wall 
      if(x[0] > screenWidth) { 
          isRunning = false;
      }
      
      //if head touch the up wall 
      if(y[0] < unit) { 
          isRunning = false;
      }
       //if head touch the down wall 
        if (y[0] > screenHeight ) {
            isRunning = false;
        }
        
        if(x[0] == applex && y[0] == appleY) { 
            snakeBody++;
            GameInformation.setScore(snakeBody -6);
            newApple();
        }
    }
    
    public void increaseSpeed() { 
        if(delay > 25) { 
            if(snakeBody - baseSize == 5) { 
                baseSize = snakeBody;
                delay -= 25;
                timer.setDelay(delay);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isRunning) { 
            move();
            cross();
            increaseSpeed();
        }else  { 
            gameOver();
        }
        
        repaint();
    }
    
    public class MyKeyAdapter extends KeyAdapter{ 
      
         @Override
         public void keyPressed(KeyEvent e) { 

             switch(e.getKeyCode()) { 
                 case KeyEvent.VK_RIGHT: 
                     if(dir != 'L'){ 
                         dir = 'R'; 
                     }
                     break; 
                  case KeyEvent.VK_LEFT:
                     if (dir != 'R') {
                         dir = 'L';
                     }
                     break;
                  case KeyEvent.VK_UP: 
                      if(dir !='D') {
                         dir= 'U';
                         
                      }
                      break; 
                  case KeyEvent.VK_DOWN: 
                      if(dir != 'U') { 
                          dir = 'D';
                      }
                      break;
                  case KeyEvent.VK_ENTER: 
                      if(!isRunning) { 
                          newGame();
                      }
             }
         }
    
    }
        
 }


