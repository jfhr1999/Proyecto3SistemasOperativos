/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Date;

/**
 *
 * @author Gloriana
 */
public class ListItem {
    public boolean isDir;
    public String label;
    public Date creationDate;
    public Date modificationDate;
    public double size;
    
    public ListItem(String label, boolean isDir){
        this.label = label;
        this.isDir = isDir;
    }
    
    public ListItem(String label, boolean isDir, Date creation, Date modification, double size){
        this.label = label;
        this.isDir = isDir;
        this.creationDate = creation;
        this.modificationDate = modification;
        this.size = size;
    }
    
    @Override
    public String toString(){
        return this.label;
    }
}
