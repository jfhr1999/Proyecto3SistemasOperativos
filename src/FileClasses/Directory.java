package FileClasses;

import java.util.ArrayList;


public class Directory {
    
    private String Name;
    private ArrayList<File> Files;
    private ArrayList<Directory> Directories;
    private String location;
    
    public Directory(){
        Files = new ArrayList();
    }
    
    public Directory(String pName, String location){
       this.Name = pName;
       Files = new ArrayList();
       Directories = new ArrayList();
       this.location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void insertFile(File file){
        Files.add(file); 
    }
    
    public void insertDirectory(Directory dir){
        Directories.add(dir); 
    }
    
    public void printFiles(){
        for(File f : Files){
            System.out.print(f.getName());
            System.out.print("\n");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(Directory d : Directories){
            str += d.getName() + "\n";
        }
        for(File f : Files){
            str += f.getName() + f.getExtention() + "\n";
        }
        return str;
    }
    
    public void printTree(String tab){
        System.out.print(tab + getName()+"\n");
        for(Directory d: Directories){
            d.printTree(tab + tab);
        }
        
        for(File f: Files){
            f.printTree(tab + tab);
        }
        
    }
    
}
