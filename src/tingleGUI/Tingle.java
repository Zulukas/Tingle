/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingleGUI;

import java.awt.Graphics;
import tingleData.TingleDataManager;
import java.io.File;
import java.util.List;
import tingleData.Tile;

/**
 *
 * @author Kevin Andres
 */
public class Tingle {
    private MapGridGUI myMapGridGUI;        //The part of the GUI containing the map
    private PropertiesBox myPropertiesBox;  //The part of the GUI relating to which properties a tile has
    private TileSelector myTileSelector;    //The part of the GUI which contains placeable tiles
    private TingleDataManager myTingleDataManager;

    public Tingle(String filename) {
        myTingleDataManager = new TingleDataManager(new File(filename));        
    }
    
    
    public void start() {
        myTingleDataManager.loadFile();
        
        List<Tile> myTiles = myTingleDataManager.getMapTiles();
        System.out.println(myTiles);
        
        //myTileSelector = new TileSelector();
        //myTileSelector.paintComponent();
        
        //GUI will go in here
        
    }
    
    public void end() {
        //Do we need a stop function?
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tingle tingle = new Tingle("M:\\Netbeans\\Tingle\\src\\resources\\testLoad.tingle");
        tingle.start();
        tingle.end();
    }    
}