/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingleData;

/**
 * The tile class holds information relevant to an individual tile
 */
public class Tile {
    private Coordinates tileCoordinates;    //Grid location of tile
    private int tileProperties;             //bit masked property holder
    
    /**
     * 
     * @param coordinates
     * @param properties 
     */
    public Tile(Coordinates coordinates, int properties) {
        if (coordinates == null) {
            tileCoordinates = new Coordinates(-1, -1);
        } else {
            this.tileCoordinates = coordinates;
        }
        
        this.tileProperties = properties;
    }
    
    /**
     * 
     * @return 
     */
    public Coordinates getTileCoordinates() {
        return tileCoordinates;
    }
    
    /**
     * 
     * @param coordinates 
     */
    public void setTileCoordinates(Coordinates coordinates) {
        this.tileCoordinates = coordinates;
    }
    
    /**
     * 
     * @return 
     */
    public int getTileProperties() {
        return tileProperties;
    }
    
    /**
     * 
     * @param properties 
     */
    public void setTileProperties(int properties) {
        this.tileProperties = properties;
    }
    
    /**
     * 
     * @return coordinates:properties
     */
    @Override
    public String toString() {
        return String.format(tileCoordinates + ":" + tileProperties);
    }
}
