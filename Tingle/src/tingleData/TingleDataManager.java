/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingleData;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * The TingleDataManager class will hold information relevant to the GUI.
 */
public class TingleDataManager {
    private List<Tile> mapTiles;          //Tiles currently on the map grid
    private List<Graphics> tileGraphics;    //Graphics for the tile selector
    private File mapFile = null;          //The file of the map
    
    /**
     * TingleDataManager constructor builds from a map file.
     * @param fileIn 
     */
    public TingleDataManager(File fileIn) {
        this.mapFile = fileIn;
        mapTiles = new ArrayList<>();
        tileGraphics = new ArrayList<>();
    }
    
    /**
     * save the mapFile variable of the TingleDataManager class.
     */
    public void saveFile() {
        BufferedWriter writer;
        
        try {
            checkFile(getMapFile());
            writer = new BufferedWriter(new FileWriter(getMapFile()));
            
            for (Tile currentTile : getMapTiles()) {
                writer.write(currentTile.toString());
            }
            
            writer.close();
        } catch (Exception ex) {
            System.err.println("FILE ERROR: " + ex);
        }
    }
    
    /**
     * load the mapFile variable of the TingleDataManager class.
     */
    public void loadFile() {
        BufferedReader reader;
        
        try {
            checkFile(getMapFile());
            
            reader = new BufferedReader(new FileReader(getMapFile()));
            String currentLine = reader.readLine();
            int counter = 1;
            
            while (currentLine != null) {   
                String[] mainParts = currentLine.split("[,:]");
                checkFormatting(counter, currentLine, mainParts);
                Tile newTile = new Tile(new Coordinates(Integer.parseInt(mainParts[0]), Integer.parseInt(mainParts[1])), Integer.parseInt(mainParts[2]));
                mapTiles.add(newTile);
                
                currentLine = reader.readLine();
                counter++;
            }
        } catch (Exception ex) {
            System.err.println("FILE ERROR: " + ex);
            setMapTiles(null);
        }                       
    }
    
    /**
     * checkFormatting scans for invalid tile formats and throws exceptions
     * 
     * @param lineNumber
     * @param line
     * @param partsToCheck
     * @throws Exception 
     */
    private void checkFormatting(int lineNumber, String line, String[] partsToCheck) throws Exception {
        String baseMessage = "On line " + lineNumber + ": Invalid formatting found - ";
        String pFound = findIllegalPunctuation(line);
        
        if (pFound != null) {
            throw new Exception(baseMessage + "Illegal punctuation: " + pFound);
        }
        
        if (partsToCheck.length != 3)
            throw new Exception(baseMessage + "punctuation must be in format of \"xCoord,yCoord:propertiesValues\"");
        
        
        for (int i = 0; i < 3; i++) {
            if (partsToCheck[i].toUpperCase().contains("[A-Z]")) {
                throw new Exception(baseMessage + " non-numeric characters found in part " + i + ": (" + partsToCheck[i] + ")");
            }
            
            int number = Integer.parseInt(partsToCheck[i]);
            
            if (number >= 64 && i < 2) { //IMPLEMENT A WAY TO CHECK FOR MAP SIZE
                String message = (baseMessage + " coordinate component (");
                
                if (i == 0) {
                    message += "x = " + number + ") ";
                } else if (i == 1) {
                    message += "y = " + number + ") ";
                }
                
                message += "goes out of bounds of limits (64x64) for this map.";
                
                throw new Exception(message);
            }
        }
    }
    
    /**
     * checkFile checks to see if the file can be located and then if it is the
     * correct extension type.
     * 
     * @param fileIn
     * @throws Exception 
     */
    private void checkFile(File fileIn) throws Exception {
        if (!fileIn.exists()) {
            throw new Exception("Could not locate file: " + fileIn);
        }
        
        String fileName = fileIn.getPath();
        String extension = "";
        
        int i = fileName.lastIndexOf(".");
        if (i > 0) 
            extension = fileName.substring(i + 1);
        
        if (!extension.equals("tingle")) {
            throw new Exception("ERROR: illegal file extension type, \"." + extension + "\", file must be of extension type \".tingle\"");
        }
    }

    /**
     * find illegal punctuation characters in a line for read in.
     * 
     * @param line
     * @return 
     */
    private String findIllegalPunctuation(String line) {
        String[] punct = {" ", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", "-", ".", "/", ";", "<", "=", ">", "?", "@", "[", "]", "\\", "^", "_", "`", "{", "}", "~"};
        
        for (String p : punct) 
            if (line.contains(p)) {
                return p;
            }
        
        return null;
    }
    
    /**
     * @return the mapTiles
     */
    public List<Tile> getMapTiles() {
        return mapTiles;
    }

    /**
     * @param mapTiles the mapTiles to set
     */
    public void setMapTiles(List<Tile> mapTiles) {
        this.mapTiles = mapTiles;
    }

    /**
     * @return the tileGraphics
     */
    public List<Graphics> getTileGraphics() {
        return tileGraphics;
    }

    /**
     * @param tileGraphics the tileGraphics to set
     */
    public void setTileGraphics(List<Graphics> tileGraphics) {
        this.tileGraphics = tileGraphics;
    }

    /**
     * @return the mapFile
     */
    public File getMapFile() {
        return mapFile;
    }

    /**
     * @param mapFile the mapFile to set
     */
    public void setMapFile(File mapFile) {
        this.mapFile = mapFile;
    }
}
