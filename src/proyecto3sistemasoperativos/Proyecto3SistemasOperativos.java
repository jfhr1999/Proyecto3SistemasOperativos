package proyecto3sistemasoperativos;

import Controllers.MainWindowController;
import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;
import View.MainWindow;
import javax.swing.JFrame;

public class Proyecto3SistemasOperativos {

    public static void main(String[] args) {
        Shell shell = new Shell();
        
        shell.readCmd();
        
        Node<String> root = createTree();
	printTree(root, " ");
        
        
        
        /*MainWindow view = new MainWindow();
        MainWindowController c = new MainWindowController(view, new Directory("Root", "\\Root"));
        c.view.setVisible(true);
        c.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        
    }
   
}
