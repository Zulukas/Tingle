/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingleGUI;

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

public class TileSelector extends JPanel {

    public static TileCoordinates coord = new TileCoordinates();

    // Create a constructor method

    public TileSelector() {
        super();

    }

    @Override
    public void paintComponent(Graphics g) {
        coord.setUpdated(false);
        g.drawLine(10, 10, 150, 150); // Draw a line from (10,10) to (150,150)

        g.setColor(Color.darkGray);
        g.fillRect(0, 0,
                4000, 4000);

        g.setColor(Color.BLACK);

        BufferedImage image;
        try {
            //image = ImageIO.read(new File("tiles.bmp"));

            //if(coord.xSelected.equals(-1)){
            // if(coord.xSelected < 0){
            image = ImageIO.read(new File("minecraft.png"));
            g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), this);
            // }
            for (int h = 0; h < image.getHeight() / 16; h++) {
                for (int w = 0; w < image.getWidth() / 16; w++) {
                    //g.drawImage(image.getSubimage(w *16, h*16, 16, 16), 0+(32*w),0 +(32*h), 32,32,this);
                    g.drawRect(w * 32, h * 32, 32, 32);

                    if (coord.xSelected >= 0) {
                        g.setColor(Color.WHITE);
                        g.drawRect(coord.xSelected * 32, coord.ySelected * 32, 32, 32);
                        g.setColor(Color.BLACK);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TileSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("paint");
    }

    public void repaint(Graphics g) {
        g.drawLine(10, 10, 150, 150); // Draw a line from (10,10) to (150,150)

        g.setColor(Color.darkGray);
        g.fillRect(0, 0,
                4000, 4000);

        g.setColor(Color.BLACK);

        BufferedImage image;

        for (int h = 0; h < 16; h++) {
            for (int w = 0; w < 16; w++) {
                //g.drawImage(image.getSubimage(w *16, h*16, 16, 16), 0+(32*w),0 +(32*h), 32,32,this);
                g.drawRect(w * 32, h * 32, 32, 32);

                if (coord.xSelected >= 0) {
                    g.setColor(Color.WHITE);
                    g.drawRect(coord.xSelected * 32, coord.ySelected * 32, 32, 32);
                    g.setColor(Color.BLACK);
                }
            }
        }

    }

    /**
     * ImagePanel does shiz
     */
    
    public static class TileCoordinates {

        private static int xSelected;
        private static int ySelected;
        private boolean updated;

        TileCoordinates() {
            xSelected = -1;
            ySelected = -1;
            updated = false;
        }

        public int getx() {
            return xSelected;
        }

        public int gety() {
            return ySelected;
        }

        public void setx(int input) {
            xSelected = input;
        }

        public void sety(int input) {
            ySelected = input;
        }

        public boolean getUpdated() {
            return updated;
        }

        public void setUpdated(boolean input) {
            updated = input;
        }

    }
}
