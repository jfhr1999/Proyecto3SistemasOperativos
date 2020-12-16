package FileClasses;

import java.util.ArrayList;


public class Directory {
    
    private String Name;
    private ArrayList<File> Files;
    
    public Directory(){
        Files = new ArrayList();
    }
    
    public Directory(String pName){
       this.Name = pName;
       Files = new ArrayList();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void insertFile(String FileName, String FileExtention){
        File nFile = new File(FileName, FileExtention);
        Files.add(nFile);
           
    }
    
    public void printFiles(){
        for(File f : Files){
            System.out.print(f.getName());
            System.out.print("\n");
        }
    }
    
    
    
}
