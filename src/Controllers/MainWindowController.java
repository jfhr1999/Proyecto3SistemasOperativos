/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.DirectoryWindow;
import View.FileWindow;
import View.IconLabelListRenderer;
import View.ListItem;
import View.MainWindow;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Gloriana
 */
public class MainWindowController extends JFrame implements ActionListener{
    public MainWindow view;
    public ArrayList<File> files;
    public ArrayList<Directory> directories;
    public Shell shell;
    private JList itemList;
    
    public MainWindowController(MainWindow pView, Shell shell){        
        this.view = pView;
        this.shell = shell;
        this.files = this.shell.getFiles();
        this.directories = this.shell.getDirectories();
        this.view.btnCreate.addActionListener(this);
        this.view.btnFile.addActionListener(this);
        this.view.btnMkdir.addActionListener(this);
        this.view.btnCambiardir.addActionListener(this);
        this.view.btnModfile.addActionListener(this);
        this.view.btnVerfile.addActionListener(this);
        this.view.btnCopy.addActionListener(this);
        this.view.btnMover.addActionListener(this);
        this.view.btnRemove.addActionListener(this);
        this.view.btnFind.addActionListener(this);
        
        this.view.txtPath.setText(this.shell.getCurrentDir());
        
        DefaultListModel listModel = new DefaultListModel();
        this.itemList = this.view.jList;
        this.view.jList.setFixedCellHeight(20);
        this.view.jList.setBorder(new EmptyBorder(0, 5, 0, 0));
        this.view.jList.setModel((ListModel) listModel);
        this.view.jList.setCellRenderer(new IconLabelListRenderer());
        
        this.loadItemList();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(e.getSource()==this.view.btnCreate){
            System.out.println("Oprimió CREATE");
        }
        else if(e.getSource()==this.view.btnFile){
            System.out.println("Oprimió FILE");
            //Agregar a shell
            FileWindow fileWindow = new FileWindow();
            FileWindowController fileWindowC = new FileWindowController(fileWindow, this.shell, this);
            fileWindowC.view.setVisible(true);
            this.loadItemList();
        }
        else if(e.getSource() == this.view.btnMkdir){
            System.out.println("Oprimió MKDIR");
            //Agregar a shell
            DirectoryWindow dirWindow = new DirectoryWindow();
            DirectoryWindowController dirWindowC = new DirectoryWindowController(dirWindow, this.shell, this);
            dirWindowC.view.setVisible(true);
            this.loadItemList();
        }
        else if(e.getSource() == this.view.btnCambiardir){
            System.out.println("Cambiar a: " + view.txtPath.getText());
            if(shell.checkLocation(view.txtPath.getText())){
                shell.setCurrentDir(view.txtPath.getText());
                this.loadItemList();
            } else{
                JOptionPane.showMessageDialog(view, "Path no válido");
            }
        }
        else if(e.getSource() == this.view.btnModfile){
            System.out.println("Oprimió ModFILE");
            
            DefaultListModel listModel = (DefaultListModel) this.view.jList.getModel();
            try{
                ListItem selectedItem = (ListItem) listModel.getElementAt(this.view.jList.getSelectedIndex());
                String selectedValue = selectedItem.toString();

                if(selectedValue.contains(".")){ //Si es un archivo, es decir, si tiene un punto
                    FileWindow fileWindow = new FileWindow();
                    FileWindowController fileWindowC = new FileWindowController(fileWindow, this.shell, this, selectedValue, false);
                    fileWindowC.view.setVisible(true);
                    this.loadItemList();
                } else {
                    JOptionPane.showMessageDialog(view, "Esta operación no es válida para directorios.");
                }
            } catch(Exception exc){
                JOptionPane.showMessageDialog(view, "Seleccione un elemento de la lista para realizar esta operación");
            }
        }
        else if(e.getSource() == this.view.btnVerfile){
            System.out.println("Oprimió VER FILE");
            DefaultListModel listModel = (DefaultListModel) this.view.jList.getModel();
            try{
                ListItem selectedItem = (ListItem) listModel.getElementAt(this.view.jList.getSelectedIndex());
                String selectedValue = selectedItem.toString();

                if(selectedValue.contains(".")){ //Si es un archivo, es decir, si tiene un punto
                    FileWindow fileWindow = new FileWindow();
                    FileWindowController fileWindowC = new FileWindowController(fileWindow, this.shell, this, selectedValue, true);
                    fileWindowC.view.setVisible(true);
                    //this.loadItemList();
                } else {
                    JOptionPane.showMessageDialog(view, "Esta operación no es válida para directorios.");
                }
            } catch(Exception exc){
                JOptionPane.showMessageDialog(view, "Seleccione un elemento de la lista para realizar esta operación");
            }
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
            if(this.view.txtFind.getText().equals("")){ //No hay nada que buscar, resetea, hace un listarDir
                this.loadItemList();
            } 
            //Meter aqui if else para las opciones de busqueda
            else{
                JOptionPane.showMessageDialog(view, "Búsqueda para '" + this.view.txtFind.getText() + "' no habilitada aún");
            }
        }
        else{
            JOptionPane.showMessageDialog(view, "Ocurrió un error con la ventana");
        }

 
    }
    
    public void updateWindow(){
        loadItemList();
    }
    
    private void loadItemList(){
        
        this.files = this.shell.getFiles();
        this.directories = this.shell.getDirectories();
        
        DefaultListModel listModel = (DefaultListModel)this.view.jList.getModel();
        listModel.removeAllElements();
        for(Directory d: directories){
            if(d.getLocation().equals(this.shell.getCurrentDir())){
                listModel.addElement(new ListItem(d.getName(), true));
            }
        }
        
        for(File f: files){
            if(f.getLocation().equals(this.shell.getCurrentDir())){
                listModel.addElement(new ListItem(f.getName() + "." + f.getExtention(), false, f.getCreationDate(), f.getModificationDate(), f.getSize()));
            }
            
        }
        
        this.view.jList.setModel(listModel);
        
    }
    
    
}
