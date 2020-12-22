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
        shell.insertFile(new File("hola", "txt", "swraea", "\\Root"));
        Directory dir = new Directory("uno", shell.getCurrentDir() + "\\" + "uno");
        shell.insertDir(dir);
        System.out.println("Original location" + dir.getLocation());
        shell.insertFile(new File("dos", "txt", "dwasdew", "\\Root\\uno"));
        //shell.readCmd();
        
        
        
        MainWindow view = new MainWindow();
        MainWindowController c = new MainWindowController(view, shell);
        c.view.setVisible(true);
        c.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }    
}
