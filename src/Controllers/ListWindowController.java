/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.ListWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloriana
 */
public class ListWindowController{
    ListWindow view;
    Shell shell;
    MainWindowController mainController;
    String query;
    
    public ListWindowController(ListWindow view, Shell shell, MainWindowController mainController, String query){
        this.view = view;
        this.shell = shell;
        this.mainController = mainController;
        this.query = query;
        
        ArrayList<String> res = new ArrayList();
        
        if(query.contains(".")){
            String[] data = query.split("\\.");
            String name = data[0];
            String extention = data[1];
            res = this.shell.findFiles(name, extention);
        } else{
            res = this.shell.findDirs(query);
        }
        
        String str = "";
        for(String s: res){
            str += s + "\n";
        }
        
        this.view.jTextArea1.setText(str);
        this.view.jTextArea1.setEditable(false);
        
    }
    
    public void closeWindow(){
        this.view.setVisible(false);
        this.view.dispose();
    }
    
}
