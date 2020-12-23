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
import View.DirectoryWindow;
import View.FileWindow;
import View.IconLabelListRenderer;
import View.ListItem;
import View.ListWindow;
import View.MainWindow;
import View.MoveWindow;
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
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
        this.view.btnTREE.addActionListener(this);
        
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
            CopyWindow copyWindow = new CopyWindow();
            CopyWindowController copyWindowC = new CopyWindowController(copyWindow, this.shell, this);
            copyWindowC.view.setVisible(true);
        }
        else if(e.getSource() == this.view.btnMover){
            System.out.println("Oprimió MOVER");
            DefaultListModel listModel = (DefaultListModel) this.view.jList.getModel();
            try{
                ListItem selectedItem = (ListItem) listModel.getElementAt(this.view.jList.getSelectedIndex());
                String selectedValue = selectedItem.toString();
                
                MoveWindow moveWindow = new MoveWindow();
                MoveWindowController moveWindowC = new MoveWindowController(moveWindow, this.shell, this, selectedValue);
                moveWindowC.view.setVisible(true);
            } catch(Exception exc){
                JOptionPane.showMessageDialog(view, "Seleccione un elemento de la lista para realizar esta operación");
            }
        }
        else if(e.getSource() == this.view.btnRemove){
            System.out.println("Oprimió REMOVE");
            DefaultListModel listModel = (DefaultListModel) this.view.jList.getModel();
            try{
                ListItem selectedItem = (ListItem) listModel.getElementAt(this.view.jList.getSelectedIndex());
                String selectedValue = selectedItem.toString();

                if(selectedValue.contains(".")){ //Si es un archivo, es decir, si tiene un punto
                    int i = -1;
                    int iterator = -1;
                    String location = "";
                    String name = "";
                    String extension = "";
                    for(File f: this.shell.getFiles()){
                        i++;
                        if((f.getName() + "." + f.getExtention()).equals(selectedValue) && f.getLocation().equals(this.shell.getCurrentDir())){
                            iterator = i;
                            location = f.getLocation();
                            name = f.getName();
                            extension = f.getExtention();
                        }
                    }
                    if(iterator >= 0) this.shell.getFiles().remove(iterator);
                    for(Directory d : this.shell.getDirectories()){
                        if(d.getLocation().equals(location)){
                            d.removeFileFromDir(name, extension);
                        }
                    }
                } else {
                    ArrayList<File> filesToDelete = new ArrayList();
                    int i = -1;
                    int iterator = -1;
                    for(Directory d: this.shell.getDirectories()){
                        i++;
                        if(d.getName().equals(selectedValue) && d.getLocation().equals(this.shell.getCurrentDir() + "\\" + d.getName())){
                            int p = d.getLocation().lastIndexOf("\\");
                            String k = d.getLocation().substring(0, p);
                            for(Directory z : this.shell.getDirectories()){
                                if(z.getLocation().equals(k)){
                                    z.removeDirFromDir(selectedValue);
                                }
                            }
                            iterator = i;
                            for(File f : this.shell.getFiles()){
                                if(f.getLocation().equals(d.getLocation())){
                                    filesToDelete.add(f);
                                }
                            }
                        }
                    }
                    
                    if(iterator >= 0) this.shell.getDirectories().remove(iterator);
                    this.shell.printDir();
                    for(File f : filesToDelete){
                        int j = this.shell.getIndexOfFile(f.getName(), f.getExtention(), f.getLocation());
                        this.shell.getFiles().remove(j);
                    }
                }
                this.loadItemList();
            } catch(Exception exc){
                JOptionPane.showMessageDialog(view, "Seleccione un elemento de la lista para realizar esta operación");
            }
        }
        else if(e.getSource() == this.view.btnFind){
            
            ListWindow listWindow = new ListWindow();
            ListWindowController listWindowC = new ListWindowController(listWindow, this.shell, this, view.txtFind.getText());
            listWindowC.view.setVisible(true);
            this.loadItemList();
        }
        
        else if(e.getSource() == this.view.btnTREE){
            this.shell.printTree();
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
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultTreeModel model = new DefaultTreeModel(root);
        
        DefaultListModel listModel = (DefaultListModel)this.view.jList.getModel();
        listModel.removeAllElements();
        
        ArrayList<Directory> dirs = this.shell.getDirectoriesFromLocation(this.shell.getCurrentDir());
        for(Directory d: dirs){
            listModel.addElement(new ListItem(d.getName(), true));
        }
        
        for(File f: files){
            if(f.getLocation().equals(this.shell.getCurrentDir())){
                listModel.addElement(new ListItem(f.getName() + "." + f.getExtention(), false, f.getCreationDate(), f.getModificationDate(), f.getSize()));
            }
            
        }
        
        for(Directory d: this.shell.getDirectories()){
            
        }
        
        this.view.jList.setModel(listModel);
        this.view.jTree1.setModel(model);
        
        
        
    }
    
    
}
