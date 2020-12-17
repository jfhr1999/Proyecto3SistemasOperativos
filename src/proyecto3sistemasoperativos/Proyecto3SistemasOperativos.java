package proyecto3sistemasoperativos;

import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Shell;

public class Proyecto3SistemasOperativos {

    public static void main(String[] args) {
        Shell shell = new Shell();
        
        System.out.print(dir.getName());
        System.out.print("\n");
        
        dir.insertFile("Pelos", ".txt");
        dir.insertFile("Presentacion", ".pdf");
        dir.insertFile("proyecto", ".py");
        
        
        
        System.out.print("Archivos");
        System.out.print("\n");
        dir.printFiles();
        System.out.print("\n");
    }
    
}
