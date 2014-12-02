//What is this file and what does it do?  I will be sending out an email about this file, it will be deleted if no one has a reason for it to be kept

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

public class BasicPanel extends JPanel{

       // tyson's change

       public static Coordinates coord = new Coordinates();
    // Create a constructor method
    public BasicPanel(){
        super();
    }

    @Override
     public void paintComponent (Graphics g){

        g.setColor(Color.BLACK);
        
    BufferedImage image;
        try {

            
           //load in the image
            image = ImageIO.read(new File("minecraft.png"));

           //draw each individual tile from the image
            for(int h = 0; h < image.getHeight()/16; h++){
            for(int w =0; w< image.getWidth()/16; w++){
            g.drawImage(image.getSubimage(w *16, h*16, 16, 16), 0+(32*w),0 +(32*h), 32,32,this);
            // draw black grid (for some reason it is behind the image)
            // but at least the transparency works
            g.drawRect(w *64, h*64, 64, 64);
            //determine where to draw a white rectangle.
            if(coord.xSelected >=0){
                g.setColor(Color.WHITE);
                g.drawRect(coord.xSelected *64, coord.ySelected *64, 64, 64);
                g.setColor(Color.BLACK);
            }
            }
            }
       
        } catch (IOException ex) {
            Logger.getLogger(BasicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     
    
    
    /**
     * Coordinates
     * stores the coordinates for the selected tile.
     **/
      public static class Coordinates{
      private static int xSelected;
      private static int ySelected;
      Coordinates(){
          xSelected = -1;
          ySelected = -1;
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
      }

     public static class MyComponent extends JComponent implements MouseListener {
        
         @Override
    public void mouseClicked(MouseEvent e) {

        // Set the coordinates for the selected tile.
        coord.setx(e.getX()/64);
        coord.sety(e.getY()/64);
        System.out.println("There was a click at " + coord.getx() +", " + coord.gety() + "!");
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

               // create a jframe and set it up
               JFrame frame = new JFrame("Display that shhhh");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setSize(1024,708);
               
               //add the panel itself
               BasicPanel panel = new BasicPanel();
               
               //tried to make it scroll, doesn't work yet.
               JScrollPane scroll = new JScrollPane();
               scroll.getViewport().add(panel);
               
               frame.add(panel);
               frame.setContentPane(panel);

               
               
               //add a mouse listener
               Component mouseClick;
               mouseClick = new MyComponent();
               panel.addMouseListener((MouseListener) mouseClick);
               
               frame.setVisible(true);
               
               
              
               //loop the repaint
               //NOTE: happens as fast as it can. EXTREMELY inefficient.
               while(true)
               {
                  

                frame.repaint();
               }  
    }
}
