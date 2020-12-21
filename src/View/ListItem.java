/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Gloriana
 */
public class ListItem {
    public boolean isDir;
    public String label;
    
    public ListItem(String label, boolean isDir){
        this.label = label;
        this.isDir = isDir;
    }
}
