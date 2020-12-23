/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.RenameWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Gloriana
 */
public class RenameWindowController implements ActionListener{
    
    RenameWindow view;
    Shell shell;
    MoveWindowController moveController;
    boolean isDir;
    String oldFullName;
    String targetPath;
    
    RenameWindowController(RenameWindow view, Shell shell, MoveWindowController moveController, boolean isDir, String oldName, String targetPath){
        this.view = view;
        this.shell = shell;
        this.moveController = moveController;
        this.view.btnSave.addActionListener(this);
        this.isDir = isDir;
        this.oldFullName = oldName;
        this.targetPath = targetPath;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnSave){
            String fullName = this.view.txtName.getText();
            if(isDir){
                //Hace lo del dir
            } else{

                Directory dir = this.shell.getDir(this.shell.getCurrentDir());
                Directory targetDir = this.shell.getDir(targetPath);
                
                String[] oldData = oldFullName.split("\\.");
                String oldName = oldData[0];
                String oldExtention = oldData[1];
                
                
                boolean fileExists = false;
                for(File f: targetDir.getFiles()){
                    if((f.getName() + "." + f.getExtention()).equals(fullName + "." + oldExtention)){
                        fileExists = true;
                    }
                }
                
                if(fileExists){
                    JOptionPane.showMessageDialog(view, "Este nombre ya existe, intente con otro.");
                } else{
                    //Se hace el rename
                    
                    File varFile = dir.getFile(oldName, oldExtention);
                    
                    varFile.setName(fullName);
                    varFile.setModificationDate(new Date());
                    
                    ArrayList<File> files = targetDir.getFiles();
                    
                    files.add(varFile);
                    targetDir.setFiles(files);
                    
                    
                    dir.removeFileFromDir(fullName, oldExtention);
                    
                    for(File f: this.shell.getFiles()){ //REvisar si cuando modifico aldo con getFiles, cambia también en el shell
                        if(f.getName().equals(fullName) && f.getExtention().equals(oldExtention) && f.getLocation().equals(this.shell.getCurrentDir())){
                            System.out.println("HOLA");
                            f.setName(fullName);
                            f.setModificationDate(new Date());
                            f.setLocation(targetDir.getLocation());
                            this.shell.printFile();
                        }
                    }
                    
                    this.moveController.mainController.updateWindow();
                    
                    closeWindow();
                    
                }
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
