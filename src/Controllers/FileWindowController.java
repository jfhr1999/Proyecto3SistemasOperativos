/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import FileClasses.File;
import FileClasses.Shell;
import View.FileWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gloriana
 */
public class FileWindowController implements ActionListener {
    public FileWindow view;
    public Shell shell;
    public MainWindowController mainController;
    public boolean isModifying; //Si esta modificando un archivo exitente o no
    public boolean isViewing; //Si es el comando VerFILE o no
    
    public FileWindowController(FileWindow pView, Shell pShell, MainWindowController mainController){
        this.view = pView;
        this.shell = pShell;
        this.view.btnSave.addActionListener(this);
        this.mainController = mainController;
        this.isModifying = false;
        this.isViewing = false;
    }
    
    public FileWindowController(FileWindow pView, Shell pShell, MainWindowController mainController, String fullName, boolean isViewing){
        this.view = pView;
        this.shell = pShell;
        this.view.btnSave.addActionListener(this);
        this.mainController = mainController;
        if(!isViewing) this.isModifying = true;
        else this.isModifying = false;
        
        String[] data = fullName.split("\\.");
        String name = data[0];
        String extention = data[1];
        
        this.view.txtFileName.setText(name + "." + extention);
        for(File f : this.shell.getFiles()){
            if(f.getLocation().equals(this.shell.getCurrentDir()) && f.getName().equals(name)){
                this.view.txtFileContents.setText(f.getContent());
            }

        }
        
        this.view.txtFileName.setEditable(false);
        if(isViewing){
            this.view.txtFileContents.setEditable(false);
            this.view.btnSave.setVisible(false);
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnSave){
            String fileName = view.txtFileName.getText();
            String[] data = fileName.split("\\.");
            String nombre = data[0];
            String extension = data[1];
            File file = new File(nombre, extension, this.view.txtFileContents.getText(), shell.getCurrentDir());
            if(!isModifying){ //Si esta creando el archivo
                if(this.shell.checkExist(nombre, extension)){ //Si ya existe, pregunta si se quiere sobreescribir
                    if(JOptionPane.showConfirmDialog(null, "Ya existe un archivo con este nombre, ¿desea reemplazarlo con este?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        this.shell.insertFile(file);
                        this.mainController.updateWindow();
                        this.view.setVisible(false);
                        this.view.dispose();
                    }

                } else{
                    this.shell.insertFile(file);
                    this.mainController.updateWindow();
                    this.view.setVisible(false);
                    this.view.dispose();
                }
            } else { //Si esta modificando el archivo
                this.shell.modifyFile(fileName, this.view.txtFileContents.getText());
                this.mainController.updateWindow();
                this.view.setVisible(false);
                this.view.dispose();
            }
            
        } else{
            JOptionPane.showMessageDialog(view, "Ocurrió un error con la ventana");
        }
    }
    
    public String getFileName(){
        return view.txtFileName.getText();
    }
    
    public String getFileContents(){
        return view.txtFileContents.getText();
    }
    
    public void setFileName(String name){
        view.txtFileName.setText(name);
    }
    
    public void setFileContents(String contents){
        view.txtFileContents.setText(contents);
    }
}
