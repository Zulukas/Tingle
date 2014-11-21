/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tileselector;

/**
 *
 * @author Dallin
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TileSelector extends JPanel{
       
       public static Coordinates coord = new Coordinates();
    // Create a constructor method
    public TileSelector(){
        super();
        
    }

    @Override
     public void paintComponent (Graphics g){
         coord.setUpdated(false);

        g.setColor(Color.BLACK);
        
    BufferedImage image;
        try {

            //if(coord.xSelected.equals(-1)){
           // if(coord.xSelected < 0){
            image = ImageIO.read(new File("minecraft.png"));
            g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
           // }
            // draw the grid over the image
            for(int h = 0; h < image.getHeight()/16; h++){
            for(int w =0; w< image.getWidth()/16; w++){

            g.drawRect(w *32, h*32, 32, 32);
            //draw the selected box
            if(coord.xSelected >=0){
                g.setColor(Color.WHITE);
                g.drawRect(coord.xSelected *32, coord.ySelected *32, 32, 32);
                g.setColor(Color.BLACK);
            }
            }
            }
        } catch (IOException ex) {
            Logger.getLogger(TileSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("painted");
     }
     
     //attempt at a second paint function.
      public void repaint (Graphics g){
        g.drawLine(10,10,150,150); // Draw a line from (10,10) to (150,150)
        
        g.setColor(Color.darkGray);
        g.fillRect( 0 , 0 , 
                4000 , 4000 ); 
        
        g.setColor(Color.BLACK);
        
    BufferedImage image;
        
            for(int h = 0; h < 16; h++){
            for(int w =0; w< 16; w++){
            //g.drawImage(image.getSubimage(w *16, h*16, 16, 16), 0+(32*w),0 +(32*h), 32,32,this);
            g.drawRect(w *32, h*32, 32, 32);
            
            if(coord.xSelected >=0){
                g.setColor(Color.WHITE);
                g.drawRect(coord.xSelected *32, coord.ySelected *32, 32, 32);
                g.setColor(Color.BLACK);
            }
            }
            }
    
        
      }
      
     
    
    
    /**
     * ImagePanel
     * does shiz
     */
      public static class Coordinates{
      private static int xSelected;
      private static int ySelected;
      private  boolean updated;
      Coordinates(){
          xSelected = -1;
          ySelected = -1;
          updated = false;
      }
     public int getx(){
         return xSelected;
     }
     public int gety(){
         return ySelected;
     }
     public void setx(int input){
         xSelected = input;
     }
     public void sety(int input){
         ySelected = input;
     }
     public boolean getUpdated(){
         return updated;
     }
     public void setUpdated(boolean input){
         updated = input;
     }
     
     
      }

      
     public static class MyComponent extends JComponent implements MouseListener {

         @Override
    public void mouseClicked(MouseEvent e) {

        
        coord.setx(e.getX()/32);
        coord.sety(e.getY()/32);
        coord.setUpdated(true);
        System.out.println("There was a click at " + coord.getx() +", " + coord.gety() + "!" );
        
    }
     
        @Override
        public void mousePressed(MouseEvent e) {
           //System.out.println("here was a click ! ");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //System.out.println("here was a click ! ");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           //System.out.println("here was a click ! ");
        }

        @Override
        public void mouseExited(MouseEvent e) {
           //System.out.println("here was a click ! ");
        }
    

}

     
    public static void main(String arg[]){

          
               JFrame frame = new JFrame("Display that shhhh");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
               
               TileSelector panel = new TileSelector();
               
               JScrollPane scroll = new JScrollPane();
               scroll.getViewport().add(panel);
               
               frame.add(panel);
               frame.setContentPane(panel);

               
               frame.setSize(520,540);
               
               Component mouseClick;
               mouseClick = new MyComponent();

               panel.addMouseListener((MouseListener) mouseClick);
               frame.setVisible(true);
               
               
               
               // try to get the image loaded seperately.
              // JFrame frame2 = new JFrame("Selected");
              // frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               //frame2.setSize(128, 128);
              // frame2.setLocation(1200, 600);


               //frame2.setVisible(true);
               
               while(true)
               {
                  
                
                if (coord.getUpdated()) {
                   
                    panel.repaint();
                }  
               }  
    }
}
    
    /* graphics attempt
    public void paintIt(Graphics g){
         if(coord.xSelected < 0){
            image = ImageIO.read(new File("minecraft.png"));
            g.drawImage(image, 15, 15, 150, 50, this);
           // }
            for(int h = 0; h < image.getHeight()/16; h++){
            for(int w =0; w< image.getWidth()/16; w++){
            g.drawImage(image.getSubimage(w *16, h*16, 16, 16), 0+(32*w),0 +(32*h), 32,32,this);
    }
}
*/