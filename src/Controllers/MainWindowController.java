/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import FileClasses.Directory;
import FileClasses.File;
import View.MainWindow;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Gloriana
 */
public class MainWindowController {
    public MainWindow view;
    public ArrayList<File> files;
    public ArrayList<Directory> directories;
    
    public MainWindowController(MainWindow pView, Directory pDirectory){
        view = pView;
        files = pDirectory.getFiles();
        directories = pDirectory.getDirectories();
        //setFileView();
        
    }
    
    public void setFileView(){
        
        //Agrega directorios
        for(Directory d : directories){
            //Crear panel donde vamos a meter todo
            JPanel newPanel = new JPanel();
            newPanel.setMinimumSize(new java.awt.Dimension(100, 100));
            newPanel.setPreferredSize(new java.awt.Dimension(100, 100));
            newPanel.setLayout(new javax.swing.BoxLayout(newPanel, javax.swing.BoxLayout.Y_AXIS));
            
            
            //Crear imagen
            JLabel img = new JLabel();
            //imagenAtaque.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\nombreDeImagen"));
            
            img.setMaximumSize(new java.awt.Dimension(100, 32767));
            img.setMinimumSize(new java.awt.Dimension(100, 60));
            img.setPreferredSize(new java.awt.Dimension(100, 60));
            newPanel.add(img);
            
            
            //Crear label para el nombre
            JLabel lblName = new JLabel();
            lblName.setText(d.getName());
            
            lblName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            lblName.setMaximumSize(new java.awt.Dimension(100, 32767));
            lblName.setMinimumSize(new java.awt.Dimension(100, 40));
            lblName.setPreferredSize(new java.awt.Dimension(100, 40));
            newPanel.add(lblName);
            
            
            view.panelMainView.add(newPanel);
        }
        
        //Agrega archivos
        for(File f : files){
            //Crear panel donde vamos a meter todo
            JPanel newPanel = new JPanel();
            newPanel.setMinimumSize(new java.awt.Dimension(100, 100));
            newPanel.setPreferredSize(new java.awt.Dimension(100, 100));
            newPanel.setLayout(new javax.swing.BoxLayout(newPanel, javax.swing.BoxLayout.Y_AXIS));
            
            
            //Crear imagen
            JLabel img = new JLabel();
            //imagenAtaque.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\nombreDeImagen"));
            
            img.setMaximumSize(new java.awt.Dimension(100, 32767));
            img.setMinimumSize(new java.awt.Dimension(100, 60));
            img.setPreferredSize(new java.awt.Dimension(100, 60));
            newPanel.add(img);
            
            
            
            //Crear label para el nombre
            JLabel lblName = new JLabel();
            lblName.setText(f.getName() + f.getExtention()); //El punto ya viene incluido?????
            
            lblName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            lblName.setMaximumSize(new java.awt.Dimension(100, 32767));
            lblName.setMinimumSize(new java.awt.Dimension(100, 40));
            lblName.setPreferredSize(new java.awt.Dimension(100, 40));
            newPanel.add(lblName);
            
            view.panelMainView.add(newPanel);
            
        }
        
        
        
        //Cambia el size del panel del scrollbar
        //Si la cantidad no abarca todo el espacio, se queda igual
        //Si abarca mas, se ajusta al tamano de los componentes
        int height;
        
        if(100 * roundUp(directories.size() + files.size(), 8) < view.paneMainView.getMinimumSize().height){
            height = view.paneMainView.getMinimumSize().height;
        } else{
            height = 100 * roundUp(directories.size() + files.size(), 8);
        }
        
        
        view.paneMainView.setPreferredSize(new Dimension(820, height + 20)); //20 mas en cada lado para compensar por los scrollbars
        view.paneMainView.setMinimumSize(new Dimension(820, height + 20));
        view.panelMainView.setPreferredSize(new Dimension(820, height + 20));
        view.panelMainView.setMinimumSize(new Dimension(820, height + 20));
        
    }
    
    public static int roundUp(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }
}
