/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle;

/**
 *
 * @author Kevin Andres
 */
class Tile {
    //Coordinate Variables
    private int x;
    private int y;
    
    private int properties;
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getProperties() {
        return properties;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setProperties(int properties) {
        this.properties = properties;
    }
}
