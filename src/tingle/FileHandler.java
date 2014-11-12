/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle;

import java.io.File;

/**
 *
 * @author Kevin Andres
 */
public class FileHandler {
    private File file;
    
    public FileHandler(File file) {
        this.file = file;
    }
    
    public void save() {
        //Saves the file
    }
    
    public void load() {
        //Loads the file; probably shouldn't be void
    }
    
    /**
     * 
     * @param file 
     */
    public void setFile(File file) {
        this.file = file;
    }
    
    /**
     * 
     * @return 
     */
    public File getFile() {
        return file;
    }
}
