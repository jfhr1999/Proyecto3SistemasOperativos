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
    
    public ArrayList<File> getFiles(){
        return Files;
    }
    
    public ArrayList<Directory> getDirectories(){
        return Directories;
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
    
    public void clearContents(){
        Files.clear();
        Directories.clear();
    }
    
    @Override
    public String toString(){
        String str = "";
        for(Directory d : Directories){
            str += d.getName() + "\n";
        }
        for(File f : Files){
            str += f.getName() + "." + f.getExtention() + "\n";
        }
        return str;
    }
    
    public File getFile(String name, String extention){
        for(File f: Files){
            if(f.getName().equals(name) && f.getExtention().equals(extention)){
                return f;
            }
        }
        return new File();
    }
    
    public void setFiles(ArrayList<File> files){
        Files = files;
    }
    
    public void removeFileFromDir(String name, String extension){
        int i = 0;
        int j = 0;
        for(File f : Files){
            if(f.getName().equals(name) && f.getExtention().equals(extension)){
                j = i;
            }
            i++;
        }
        Files.remove(j);
    }
    
    public void removeDirFromDir(String name){
        int i = 0;
        int j = 0;
        for(Directory f : Directories){
            if(f.getName().equals(name)){
                j = i;
            }
            i++;
        }
        Directories.remove(j);
    }
    
}
