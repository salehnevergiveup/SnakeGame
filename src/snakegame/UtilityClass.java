/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

/**
 *
 * @author User
 */
import java.awt.*; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public abstract class UtilityClass {
    
   //custome button
   public static void styleButton(JButton obj, Color fontColor,String font, 
                          String weight, int size ,int width , int height, Color backgroundColor ){ 
       obj.setBorder(new EmptyBorder(0, 0, 0, 0));
       obj.setFocusable(false);
       obj.setForeground(fontColor);
       obj.setPreferredSize(new Dimension(width, height));
       obj.setMaximumSize(new Dimension(width, height));
       obj.setBackground(backgroundColor);
       if (weight.equalsIgnoreCase("Bold"))
           obj.setFont(new Font(font, Font.BOLD, size));
       else
           obj.setFont(new Font(font, Font.BOLD, size));
   }
   
   
   //costome frame
   public static void styleFrame(JFrame obj, int width, int height) { 
      obj.setSize(width, height);
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      obj.setLocationRelativeTo(null);
      obj.setUndecorated(true);
      
   }
   
   
   //custome Panel 
   public static void styelPanel(JPanel obj , int width , int height , Color backgroundColor) { 
       obj.setPreferredSize(new Dimension(width, height));
       obj.setBackground(backgroundColor);
   }
   
   
   //customr Label  
   public static void sytleLabel(JLabel label, int width , int height ,Color fontColor,String font,
                                 String weight,int  size) { 
       
       label.setPreferredSize(new Dimension(width, height));
       label.setForeground(fontColor);
       if (weight.equalsIgnoreCase("Bold"))
           label.setFont(new Font(font, Font.BOLD, size));
       else
           label.setFont(new Font(font, Font.BOLD, size));
       
       
   }
 
}
