/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.CopyWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloriana
 */
public class CopyWindowController implements ActionListener {
    CopyWindow view;
    Shell shell;
    MainWindowController mainController;
    
    CopyWindowController(CopyWindow view, Shell shell, MainWindowController mainController){
        this.view = view;
        this.shell = shell;
        this.mainController = mainController;
        this.view.btnCopy.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnCopy){
            String selection = this.view.comboBoxType.getSelectedItem().toString();
            
            String sourcePath = this.view.txtSourcePath.getText();
            String targetPath = this.view.txtTargetPath.getText();
            
            if(selection.equals("Real - Virtual")){
            
            } else if(selection.equals("Virtual - Real")){ //La ruta de destino física tiene que NO tener el nombre del archivo (y directorio??)
                
                if(sourcePath.contains(".")){
                    
                    int p = sourcePath.lastIndexOf("\\");
                    String k = sourcePath.substring(p+1);
                    String fileLocation = sourcePath.substring(0, p);
                    System.out.println("k: " + k + " fileLocation: " + fileLocation);
                    boolean fileExists = false;
                    
                    for(File f: this.shell.getFiles()){
                        if((f.getName() + "." + f.getExtention()).equals(k) && f.getLocation().equals(fileLocation)){
                            fileExists = true;
                        }
                    }
                    
                    if(fileExists){
                        try{
                            FileWriter fw = new FileWriter(targetPath + "\\" + k);
                            for(File f: this.shell.getFiles()){
                                if((f.getName() + "." + f.getExtention()).equals(k) && f.getLocation().equals(fileLocation)){
                                    fw.write(f.getContent());
                                }
                            }
                            fw.close();
                            
                            this.mainController.updateWindow();
                            closeWindow();
                            
                            
                        } catch(Exception exc){
                            JOptionPane.showMessageDialog(view, exc);
                        }
                    } else{
                        JOptionPane.showMessageDialog(view, "El path de origen no es válido");
                    }
                    
                } else{ //Si es un directorio
                    
                    
                    int p = sourcePath.lastIndexOf("\\");
                    String dirName = sourcePath.substring(p+1);
                    String dirLocation = sourcePath.substring(0, p);
                    System.out.println("dirName: " + dirName + " fileLocation: " + dirLocation);
                    boolean fileExists = false;
                    
                    boolean dirExists = false;
                    
                    for(Directory d: this.shell.getDirectories()){
                        if(d.getLocation().equals(sourcePath)){
                            dirExists = true;
                        }
                    }
                    
                    if(dirExists){
                        
                        this.shell.getDir(sourcePath).writeAll(targetPath + "\\" + dirName);
                    
                        this.mainController.updateWindow();
                        closeWindow();
                        
                    } else{
                        JOptionPane.showMessageDialog(view, "El path de origen no es válido");
                    }
                    
                    
                }
            } else{ //Virtual - Virtual
            
            }
            
        } else{
            JOptionPane.showMessageDialog(view, "Ocurrió un error con la ventana");
        }
    }
    
    public void closeWindow(){
        this.view.setVisible(false);
        this.view.dispose();
    }
}
