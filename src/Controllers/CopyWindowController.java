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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
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
                
                if(sourcePath.contains(".")){
                    
                    boolean dirExists = false;
                    
                    for(Directory d: this.shell.getDirectories()){
                        if(d.getLocation().equals(targetPath)){
                            dirExists = true;
                        }
                    }
                    
                    if(dirExists){
                        
                        String firstRoute = this.shell.getCurrentDir();
                        this.shell.setCurrentDir(targetPath);
                        
                        try{
                            java.io.File a = new java.io.File(sourcePath);
                            Scanner myReader = new Scanner(a);
                            String data = "";
                            while (myReader.hasNextLine()){
                                data += myReader.nextLine() + "\n";
                            }
                            myReader.close();
                            
                            int p = sourcePath.lastIndexOf("\\");
                            String k = sourcePath.substring(p+1);
                            String[] str = k.split("\\.");
                            String name = str[0];
                            String extention = str[1];
                            File f = new File(name, extention, data, targetPath);
                            this.shell.insertFile(f);
                        }catch(FileNotFoundException exc){
                            System.out.println("An error occurred.");
                            exc.printStackTrace();
                        }
                        this.mainController.updateWindow();
                        closeWindow();
                        this.shell.setCurrentDir(firstRoute);
                        
                    }else{
                        JOptionPane.showMessageDialog(view, "El path de origen no es válido");
                    }
                
                }else{
                    
                    boolean dirExists = false;
                    
                    for(Directory d: this.shell.getDirectories()){
                        if(d.getLocation().equals(targetPath)){
                            dirExists = true;
                        }
                    }
                    
                    if(dirExists){
                        
                        int p = sourcePath.lastIndexOf("\\");
                        String k = sourcePath.substring(p+1);
                        Directory ddd = new Directory(k, targetPath + "\\" + k);
                        String firstRoute = this.shell.getCurrentDir();
                        this.shell.setCurrentDir(targetPath);
                        this.shell.insertDir(ddd);
                        this.shell.setCurrentDir(targetPath + "\\" + k);
                        List<java.io.File> list = new ArrayList();
                        listf(sourcePath, list);
                        ArrayList<String> paths = new ArrayList();
                        ArrayList<String> contents = new ArrayList();
                        for (java.io.File file : list) {      
                            if (file.isFile()) {
                                //System.out.println(file.getAbsolutePath());
                                paths.add(file.getAbsolutePath().replace(sourcePath + "\\", ""));
                                try{
                                    java.io.File a = new java.io.File(file.getAbsolutePath());
                                    Scanner myReader = new Scanner(a);
                                    String data = "";
                                    while (myReader.hasNextLine()){
                                        data += myReader.nextLine() + "\n";
                                    }
                                    myReader.close();
                                    contents.add(data);
                                }catch(FileNotFoundException exc){
                                    System.out.println("An error occurred.");
                                    exc.printStackTrace();
                                }
                            } else if (file.isDirectory()) {
                                //System.out.println(file.getAbsolutePath());
                                //System.out.println(file.getAbsolutePath().replace(sourcePath + "\\", ""));
                                paths.add(file.getAbsolutePath().replace(sourcePath + "\\", ""));
                                contents.add(" ");
                            }
                        }
                        
                        for(int i = 0; i < paths.size(); i++){
                            //System.out.println(paths.get(i));
                            if(!paths.get(i).contains("\\")){
                                if(paths.get(i).contains(".")){
                                    String[] data = paths.get(i).split("\\.");
                                    String name = data[0];
                                    String extention = data[1];
                                    File f = new File(name, extention, contents.get(i), targetPath + "\\" + k);
                                    //String aux = this.shell.getCurrentDir();
                                    //this.shell.setCurrentDir(targetPath);
                                    this.shell.insertFile(f);
                                    //this.shell.setCurrentDir(aux);
                                }else{
                                    Directory d = new Directory(paths.get(i), targetPath + "\\" + k + "\\" + paths.get(i));
                                    //String aux = this.shell.getCurrentDir();
                                    //this.shell.setCurrentDir(targetPath);
                                    this.shell.insertDir(d);
                                    //this.shell.setCurrentDir(aux);
                                }
                                //System.out.println(paths.get(i));
                                paths.remove(i);
                                contents.remove(i);
                                i--;
                            }
                        }
                        
                        for(int j = 0; j < paths.size(); j++){
                            String[] data = paths.get(j).split("\\\\");
                            String newDir = this.shell.getCurrentDir();
                            //System.out.println("aiuda jesus " + data.length);
                            for(int i = 0; i < data.length - 1; i++){
                                newDir += "\\" + data[i];
                            }
                            String aux = this.shell.getCurrentDir();
                            this.shell.setCurrentDir(newDir);
                            if(data[data.length - 1].contains(".")){
                                String[] data2 = data[data.length - 1].split("\\.");
                                String name = data2[0];
                                String extention = data2[1];
                                File f = new File(name, extention, contents.get(j), newDir);
                                this.shell.insertFile(f);
                                this.shell.setCurrentDir(aux);
                            }else{
                                Directory d = new Directory(data[data.length - 1], newDir + "\\" + data[data.length - 1]);
                                this.shell.insertDir(d);
                                this.shell.setCurrentDir(aux);
                            }
                        }
                        this.shell.setCurrentDir(firstRoute);
                        this.mainController.updateWindow();
                        closeWindow();
                    } else{
                        JOptionPane.showMessageDialog(view, "El path de origen no es válido");
                    }
                }
            
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
    
    public void listf(String directoryName, List<java.io.File> files) {
        java.io.File directory = new java.io.File(directoryName);

        // Get all files from a directory.
        java.io.File[] fList = directory.listFiles();
        if(fList != null){
            for (java.io.File file : fList) {      
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.add(file);
                    listf(file.getAbsolutePath(), files);
                }
            }
        }
    }
}
