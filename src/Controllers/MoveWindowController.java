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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloriana
 */
public class MoveWindowController implements ActionListener {
    public MoveWindow view;
    public Shell shell;
    public MainWindowController mainController;
    
    public MoveWindowController(MoveWindow view, Shell shell, MainWindowController mainController){
        this.view = view;
        this.shell = shell;
        this.mainController = mainController;
        this.view.btnSave.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnSave){
            String fullPath = this.view.txtTargetPath.getText();
            int p = fullPath.lastIndexOf("\\");
            String location = fullPath.substring(0, p);
            String name = fullPath.substring(p+1, fullPath.length()-1);
            if(this.shell.checkDir(fullPath)){
                if(fullPath.contains(".")){ //Si es un archivo
                    for(File f: this.shell.getFileArrayFromLocation(location)){
                        if(name.equals(f.getName() + "." + f.getExtention()) && f.getLocation().equals(this.shell.getCurrentDir())){
                            JOptionPane.showMessageDialog(view, "Escriba un nombre válido para su archivo");
                        } else{
                            //Elimina el archivo de donde está y lo agrega a la ubicación nueva con el nombre que escribio
                        }
                    }
                } else{ //Si es un directorio
                    for(Directory d: this.shell.getDirectoriesFromLocation(location)){
                        if(d.getName().equals(name) && d.getLocation().equals(fullPath)){
                            JOptionPane.showMessageDialog(view, "Escriba un nombre válido para su directorio");
                        }
                    }
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
    
}
