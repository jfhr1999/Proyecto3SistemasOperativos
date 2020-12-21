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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Gloriana
 */
public class MainWindowController implements ActionListener{
    public MainWindow view;
    public ArrayList<File> files;
    public ArrayList<Directory> directories;
    
    public MainWindowController(MainWindow pView, Directory pDirectory){
        this.view = pView;
        files = pDirectory.getFiles();
        directories = pDirectory.getDirectories();
        //setFileView();
        this.view.btnCreate.addActionListener(this);
        this.view.btnFile.addActionListener(this);
        this.view.btnMkdir.addActionListener(this);
        this.view.btnCambiardir.addActionListener(this);
        this.view.btnModfile.addActionListener(this);
        this.view.btnVerpropiedades.addActionListener(this);
        this.view.btnVerfile.addActionListener(this);
        this.view.btnCopy.addActionListener(this);
        this.view.btnMover.addActionListener(this);
        this.view.btnRemove.addActionListener(this);
        this.view.btnFind.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnCreate){
            System.out.println("Oprimió CREATE");
        }
        else if(e.getSource()==this.view.btnFile){
            System.out.println("Oprimió FILE");
        }
        else if(e.getSource() == this.view.btnMkdir){
            System.out.println("Oprimió MKDIR");
        }
        else if(e.getSource() == this.view.btnCambiardir){
            System.out.println("Cambiar a: " + view.txtPath.getText());
        }
        else if(e.getSource() == this.view.btnModfile){
            System.out.println("Oprimió ModFILE");
        }
        else if(e.getSource() == this.view.btnVerpropiedades){
            System.out.println("Oprimió VER PROPIEDADES");
        }
        else if(e.getSource() == this.view.btnVerfile){
            System.out.println("Oprimió VER FILE");
        }
        else if(e.getSource() == this.view.btnCopy){
            System.out.println("Oprimió COPY");
        }
        else if(e.getSource() == this.view.btnMover){
            System.out.println("Oprimió MOVER");
        }
        else if(e.getSource() == this.view.btnRemove){
            System.out.println("Oprimió REMOVE");
        }
        else if(e.getSource() == this.view.btnFind){
            System.out.println("Buscar: " + view.txtFind.getText());
        }
        else{
            JOptionPane.showMessageDialog(view, "Ocurrió un error con la ventana");
        }

 
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
            img.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\folder-8x.png"));
            
            img.setMaximumSize(new java.awt.Dimension(100, 32767));
            img.setMinimumSize(new java.awt.Dimension(64, 60));
            img.setPreferredSize(new java.awt.Dimension(64, 60));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
            img.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\file-8x.png"));
            
            img.setMaximumSize(new java.awt.Dimension(100, 32767));
            img.setMinimumSize(new java.awt.Dimension(64, 60));
            img.setPreferredSize(new java.awt.Dimension(64, 60));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
