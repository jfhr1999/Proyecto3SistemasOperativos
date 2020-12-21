/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.IconLabelListRenderer;
import View.ListItem;
import View.MainWindow;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
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
        this.view.btnVerpropiedades.addActionListener(this);
        this.view.btnVerfile.addActionListener(this);
        this.view.btnCopy.addActionListener(this);
        this.view.btnMover.addActionListener(this);
        this.view.btnRemove.addActionListener(this);
        this.view.btnFind.addActionListener(this);
        
        this.view.txtPath.setText(this.shell.getCurrentDir());
        
        DefaultListModel listModel = new DefaultListModel();
        this.itemList = this.view.jList;
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
            loadItemList();
        }
        else if(e.getSource() == this.view.btnMkdir){
            System.out.println("Oprimió MKDIR");
            //Agregar a shell
            loadItemList();
        }
        else if(e.getSource() == this.view.btnCambiardir){
            System.out.println("Cambiar a: " + view.txtPath.getText());
            if(shell.checkLocation(view.txtPath.getText())){
                shell.setCurrentDir(view.txtPath.getText());
                loadItemList();
            }
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
                listModel.addElement(new ListItem(f.getName() + "." + f.getExtention(), false));
            }
            
        }
        
        this.view.jList.setModel(listModel);
        
    }
    
    public void setFileView(){
        
        files = shell.getFiles();
        directories = shell.getDirectories();
        
        //Agrega directorios
        for(Directory d : directories){
            //Crear panel donde vamos a meter todo
            /*JPanel newPanel = new JPanel();
            newPanel.setMinimumSize(new java.awt.Dimension(100, 100));
            newPanel.setPreferredSize(new java.awt.Dimension(100, 100));
            newPanel.setLayout(new javax.swing.BoxLayout(newPanel, javax.swing.BoxLayout.Y_AXIS));
            
            
            //Crear imagen
            JLabel img = new JLabel();
            img.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\folder-2x.png"));
            
            img.setMaximumSize(new java.awt.Dimension(100, 30));
            img.setMinimumSize(new java.awt.Dimension(100, 30));
            img.setPreferredSize(new java.awt.Dimension(100, 30));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            newPanel.add(img);
            
            
            //Crear label para el nombre
            JLabel lblName = new JLabel();
            lblName.setText(d.getName());
            
            lblName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblName.setMaximumSize(new java.awt.Dimension(100, 32767));
            lblName.setMinimumSize(new java.awt.Dimension(100, 70));
            lblName.setPreferredSize(new java.awt.Dimension(100, 70));
            newPanel.add(lblName);
            
            
            view.panelMainView.add(newPanel);*/
        }
        
        //Agrega archivos
        for(File f : files){
            //Crear panel donde vamos a meter todo
            /*JPanel newPanel = new JPanel();
            newPanel.setMinimumSize(new java.awt.Dimension(100, 100));
            newPanel.setPreferredSize(new java.awt.Dimension(100, 100));
            newPanel.setLayout(new javax.swing.BoxLayout(newPanel, javax.swing.BoxLayout.Y_AXIS));
            
            
            //Crear imagen
            JLabel img = new JLabel();
            img.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\file-2x.png"));
            
            img.setMaximumSize(new java.awt.Dimension(100, 30));
            img.setMinimumSize(new java.awt.Dimension(100, 30));
            img.setPreferredSize(new java.awt.Dimension(100, 30));
            img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            newPanel.add(img);
            
            
            
            //Crear label para el nombre
            JLabel lblName = new JLabel();
            lblName.setText(f.getName() + "." + f.getExtention()); //El punto ya viene incluido?????
            
            lblName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblName.setMaximumSize(new java.awt.Dimension(100, 32767));
            lblName.setMinimumSize(new java.awt.Dimension(100, 70));
            lblName.setPreferredSize(new java.awt.Dimension(100, 70));
            newPanel.add(lblName);
            
            view.panelMainView.add(newPanel);*/
            
        }
        
        
        
        //Cambia el size del panel del scrollbar
        //Si la cantidad no abarca todo el espacio, se queda igual
        //Si abarca mas, se ajusta al tamano de los componentes
        /*int height;
        
        if(100 * roundUp(directories.size() + files.size(), 8) < view.paneMainView.getMinimumSize().height){
            height = view.paneMainView.getMinimumSize().height;
        } else{
            height = 100 * roundUp(directories.size() + files.size(), 8);
        }
        
        
        view.paneMainView.setPreferredSize(new Dimension(820, height + 20)); //20 mas en cada lado para compensar por los scrollbars
        view.paneMainView.setMinimumSize(new Dimension(820, height + 20));
        view.panelMainView.setPreferredSize(new Dimension(820, height + 20));
        view.panelMainView.setMinimumSize(new Dimension(820, height + 20));
        */
        
    }
    
    public static int roundUp(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }
}
