/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FileClasses.Directory;
import FileClasses.Shell;
import View.DirectoryWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloriana
 */
public class DirectoryWindowController implements ActionListener  {
    public DirectoryWindow view;
    public Shell shell;
    public MainWindowController mainController;
    
    public DirectoryWindowController(DirectoryWindow pView, Shell pShell, MainWindowController mainController){
        this.view = pView;
        this.shell = pShell;
        this.view.btnSave.addActionListener(this);
        this.mainController = mainController;
    }
    
     @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnSave){
            Directory dir = new Directory(this.view.txtDirectoryName.getText(), this.shell.getCurrentDir() + "\\" + this.view.txtDirectoryName.getText());
            
            if(this.shell.checkDir(this.view.txtDirectoryName.getText())){
                if(JOptionPane.showConfirmDialog(null, "Ya existe un directorio con este nombre, ¿desea reemplazarlo con este?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    
                    int i = -1;
                    int iterator = -1;
                    for(Directory d: this.shell.getDirectories()){
                        i++;
                        if(d.getName().equals(this.view.txtDirectoryName.getText()) && d.getLocation().equals(this.shell.getCurrentDir() + "\\" + this.view.txtDirectoryName.getText())){
                            i = iterator;
                        }
                    }
                    if(i >= 0) this.shell.getDirectories().remove(i);
                    
                    this.mainController.updateWindow();
                    
                    this.shell.insertDir(dir);
                    this.mainController.updateWindow();
                    this.view.setVisible(false);
                    this.view.dispose();
                }
            } else{
                this.shell.insertDir(dir);
                this.mainController.updateWindow();
                this.view.setVisible(false);
                this.view.dispose();
            }
        } else{
            JOptionPane.showMessageDialog(view, "Ocurrió un error con la ventana");
        }
    }
}
