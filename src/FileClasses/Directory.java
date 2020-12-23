package FileClasses;

import java.util.ArrayList;
import java.io.FileWriter;

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
    
    public Directory getDirectory(String name){
        for(Directory d: Directories){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return new Directory();
    }
    
    public void setFiles(ArrayList<File> files){
        Files = files;
    }
    
    public void setDirectories(ArrayList<Directory> dirs){
        Directories = dirs;
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
    
    public String getTreeText(String tab){
        String res = tab + getName() + "\n";
        for(Directory d: Directories){
            res += d.getTreeText(tab + tab);
        }
        
        for(File f: Files){
            res += f.getTreeText(tab + tab);
        }
        
        return res;
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
    
    
    public void writeAll(String path){
        
        java.io.File file = new java.io.File(path);
        file.mkdir();
        
        for(FileClasses.File f: Files){
            System.out.println("Entrando a files de " + path);
            try{
                FileWriter fw = new FileWriter(path + "\\" + f.getName() + "." + f.getExtention());

                fw.write(f.getContent());
                fw.close();

            } catch(Exception exc){
                System.out.println("Problema en el writeAll: " + exc);
            }
        }
        
        for(Directory d: Directories){
            System.out.println("Entrando a directorios de " + path);
            if(!d.getDirectories().isEmpty()){
                d.writeAll(path + "\\" + d.getName());
            } else{
                java.io.File file2 = new java.io.File(path + "\\" + d.getName());
                file2.mkdir();
                for(FileClasses.File f: d.getFiles()){
                    try{
                        FileWriter fw = new FileWriter(path + "\\" + d.getName() + "\\" + f.getName() + "." + f.getExtention());

                        fw.write(f.getContent());
                        fw.close();

                    } catch(Exception exc){
                        System.out.println("Problema en el writeAll: " + exc);
                    }
                }
            }
        }
    }
    
    public void changeAllPaths(String path){
        setLocation(path);
        
        for(FileClasses.File f : Files){
            f.setLocation(path);
        }
        
        for(Directory d : Directories){
            if(!d.getDirectories().isEmpty()){
                d.changeAllPaths(path + "\\" + d.getName());
            } else{
                d.setLocation(path  + "\\" + d.getName());
                for(FileClasses.File f : d.getFiles()){
                    f.setLocation(path + "\\" + d.getName());
                }
            }
        }
    }
}
