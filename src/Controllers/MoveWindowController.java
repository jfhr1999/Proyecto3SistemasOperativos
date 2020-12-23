/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.MoveWindow;
import View.RenameWindow;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloriana
 */
public class MoveWindowController implements ActionListener {
    public MoveWindow view;
    public Shell shell;
    public MainWindowController mainController;
    public String selectedValue;
    
    public MoveWindowController(MoveWindow view, Shell shell, MainWindowController mainController, String selectedValue){
        this.view = view;
        this.shell = shell;
        this.mainController = mainController;
        this.selectedValue = selectedValue;
        this.view.btnSave.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnSave){
            String fullPath = this.view.txtTargetPath.getText();
            if(this.shell.checkLocation(fullPath)){
                
                Directory dir = this.shell.getDir(fullPath);
                
                boolean isFile = selectedValue.contains(".");
                
                if(isFile){
                    boolean fileExists = false;
                    for(File f: dir.getFiles()){
                        System.out.println("Selected value: " + selectedValue);
                        System.out.println("Name: " + f.getName() + " Extention: " + f.getExtention());
                        if((f.getName() + "." + f.getExtention()).equals(selectedValue)){
                            fileExists = true;
                            if(JOptionPane.showConfirmDialog(null, "Ya existe un archivo con este nombre en el destino, ¿desea renombrarlo?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                                RenameWindow renameWindow= new RenameWindow();
                                RenameWindowController renameWindowC = new RenameWindowController(renameWindow, this.shell, this, false, selectedValue, fullPath);
                                renameWindowC.view.setVisible(true);
                                
                            }
                        }
                    }
                    if(!fileExists){
                        
                        String[] oldData = selectedValue.split("\\.");
                        String oldName = oldData[0];
                        String oldExtention = oldData[1];
                        
                        Directory oldDir = this.shell.getDir(this.shell.getCurrentDir());
                        
                        File varFile = oldDir.getFile(oldName, oldExtention);
                    
                        varFile.setModificationDate(new Date());

                        Directory targetDir = this.shell.getDir(fullPath);
                        
                        ArrayList<File> files = targetDir.getFiles();

                        files.add(varFile);
                        targetDir.setFiles(files);


                        oldDir.removeFileFromDir(oldName, oldExtention);

                        for(File f: this.shell.getFiles()){
                            if(f.getName().equals(oldName) && f.getExtention().equals(oldExtention) && f.getLocation().equals(this.shell.getCurrentDir())){
                                f.setModificationDate(new Date());
                                f.setLocation(fullPath);
                            }
                        }

                        this.mainController.updateWindow();
                    }
                } else{
                    
                    
                }
                
                
                this.mainController.updateWindow();
                this.view.setVisible(false);
                this.view.dispose();
                
            } else{
                JOptionPane.showMessageDialog(view, "Path no válido");
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
