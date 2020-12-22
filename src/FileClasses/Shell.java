/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileClasses;

import java.util.*;

/**
 *
 * @author famruizsing
 */
public class Shell {
    private String currentDir = "\\Root";
    private ArrayList<File> Files;
    private ArrayList<Directory> Directories;
    
    public Shell(){
        Files = new ArrayList();
        Directories = new ArrayList();
        Directory d = new Directory("Root", "\\Root");
        Directories.add(d);
    }
    
    public void readCmd(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("> ");
            String str = sc.nextLine();
            
            if(str.equals("CREATE")){
                //no c aserlo ekisde
            }
            
            else if (str.equals("FILE")){
                System.out.print("\nDigite el nombre del archivo: ");
                str = sc.nextLine();
                //System.out.println("STR: " + str);
                String[] data = str.split("\\.");
                String nombre = data[0];
                String extension = "." + data[1];
                
                //Crea el archivo
                System.out.print("\nDigite el contenido del archivo: ");
                String contenido = sc.nextLine();
                File file = new File(nombre, extension, contenido, currentDir);
                System.out.println(file.toString());
                
                if(checkExist(nombre, extension)){ //Si ya existe
                    System.out.print("\nYa existe un archivo con este nombre, ¿desea reemplazarlo con este? ");
                    str = sc.nextLine();
                    if(str.equals("si") || str.equals("Si")){
                        //borrar el archivo viejo
                        
                        Files.add(file);
                        
                        insertFile(file);
                    }
                } else {
                    Files.add(file);    
                    insertFile(file);
                }
            }
            
            else if (str.equals("MKDIR")){
                System.out.print("\nDigite el nombre del directorio: ");
                String nombre = sc.nextLine();
                Directory dir = new Directory(nombre, currentDir + "\\" + nombre);
                if(checkDir(nombre)){
                    System.out.println("\nYa existe un archivo con este nombre, ¿desea reemplazarlo con este? ");
                    str = sc.nextLine();
                    if(str.equals("si") || str.equals("Si")){
                        //borrar el directorio viejo
                        Directories.add(dir);
                        insertDir(dir);
                    }
                } else {
                    Directories.add(dir);
                    insertDir(dir);
                }
            }
            
            else if (str.equals("CambiarDIR")){
                System.out.print("\nDigite la dirección a la que desea ir: ");
                String dir = sc.nextLine();
                if(checkLocation(dir)){
                    currentDir = dir;
                }
            }
            
            else if (str.equals("ListarDIR")){
                for(Directory d : Directories){
                    if(d.getLocation().equals(currentDir)){
                        System.out.println(d.toString());
                    }
                }
            }
            
            else if (str.equals("ModFile")){
                System.out.print("\nDigite el nombre del archivo que desea modificar: ");
                String name = sc.nextLine();
                for(File f : Files){
                    if(f.getLocation().equals(currentDir) && f.getName().equals(name)){
                        //Desplegar textfield para que modifique el archivo
                    }
                }
            }
            
            else if (str.equals("VerPropiedades")){
                System.out.print("\nDigite el nombre del archivo que desea ver las propiedades: ");
                String name = sc.nextLine();
                for(File f : Files){
                    if(f.getLocation().equals(currentDir) && f.getName().equals(name)){
                        f.viewProperties();
                    }
                }
            }
            
            else if (str.equals("VerFile")){
                System.out.print("\nDigite el nombre del archivo que desea ver: ");
                String name = sc.nextLine();
                for(File f : Files){
                    if(f.getLocation().equals(currentDir) && f.getName().equals(name)){
                        f.getContent();
                    }
                }
            }
            
            else if (str.equals("CoPY")){
                System.out.print("\n¿Qué tipo de copy desea?\nr-v\nv-r\nv-v\n> ");
                String answer = sc.nextLine();
                if(answer.equals("r-v")){
                    
                }else if(answer.equals("v-r")){
                    
                }else{
                    
                }
            }
            
            else if (str.equals("MoVer")){
                System.out.print("\nDigite el nombre del archivo que desea mover: ");
                String name = sc.nextLine();
                System.out.print("\nDigite la nueva dirección del archivo: ");
                String newDirection = sc.nextLine();
                for(File f : Files){
                    if(f.getLocation().equals(currentDir) && f.getName().equals(name)){
                        if(getFilesFromLocation(newDirection).contains(f.getName() + "." + f.getExtention())){
                            System.out.print("\nYa hay un archivo con ese nombre en el destino, digite el nuevo nombre para su archivo: ");
                            String newName = sc.nextLine();
                            f.setName(newName);
                        }
                        f.setLocation(newDirection);
                    }
                }
            }
            
            else if (str.equals("ReMove")){
                System.out.print("\nDesea eliminar un archivo o un directorio? ");
                String answer = sc.nextLine();
                if(answer.equals("d")){
                    System.out.print("\nDigite el nombre del directorio que desea borrar: ");
                    String name = sc.nextLine();
                    deleteDir(name);
                }else{
                    System.out.print("\nDigite el nombre del archivo que desea borrar: ");
                    str = sc.nextLine();
                    String[] data = str.split("\\.");
                    String name = data[0];
                    String extension = "." + data[1];
                    deleteFile(name, extension);
                }
            }
            
            else if (str.equals("FIND")){
                System.out.print("\nDesea buscar un archivo o un directorio? ");
                String answer = sc.nextLine();
                if(answer.equals("d")){
                    System.out.print("\nDigite el nombre del directorio que desea buscar: ");
                    String name = sc.nextLine();
                    findDir(name);
                }else{
                    System.out.print("\nDigite el nombre del archivo que desea buscar: ");
                    str = sc.nextLine();
                    String[] data = str.split("\\.");
                    String name = data[0];
                    String extension = "." + data[1];
                    findFile(name, extension);
                }
            }
            
            else if (str.equals("TREE")){
                
            }
            
            else{
                System.out.println("Comando no reconocido\n>");
            }
        }
    }
    
    public boolean checkExist(String name, String extension){
        for(File f : Files){
            if(f.getName().equals(name) && f.getExtention().equals(extension) && f.getLocation().equals(currentDir)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkDir(String name){
        for(Directory d : Directories){
            if(d.getName().equals(name) && d.getLocation().equals(currentDir + "\\" + name)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkLocation(String desiredLocation){
        printDir();
        for(Directory d : Directories){
            if(d.getLocation().equals(desiredLocation)){
                return true;
            }
        }
        return false;
    }
    
    public void insertFile(File f){
        Files.add(f); //TEMPORAL
        for(Directory d : Directories){
            if(d.getLocation().equals(currentDir)){
                d.insertFile(f);
            }
        }
    }
    
    public void modifyFile(String name, String content){
        String[] data = name.split("\\.");
        String nombre = data[0];
        String extension = data[1];
        for(File f : Files){
            if(f.getName().equals(nombre) && f.getExtention().equals(extension) && f.getLocation().equals(currentDir)){
                f.setContent(content);
                f.setModificationDate(new Date());
            }
        }
    }
    
    public void overwriteFile(String name, String content){
        String[] data = name.split("\\.");
        String nombre = data[0];
        String extension = data[1];
        for(File f : Files){
            if(f.getName().equals(nombre) && f.getExtention().equals(extension) && f.getLocation().equals(currentDir)){
                f.setContent(content);
                f.setModificationDate(new Date());
                f.setCreationDate(new Date());
            }
        }
    }
    
    public void overwriteDir(String location){
        for(Directory d: Directories){
            if(d.getLocation().equals(location)){
                d.clearContents();
            }
        }
        
    }
    
    public void insertDir(Directory dir){
        Directories.add(dir); //TEMPORAL
        for(Directory d : Directories){
            if(d.getLocation().equals(currentDir)){
                d.insertDirectory(dir);
            }
        }
    }
    
    public ArrayList<String> getFilesFromLocation(String location){
        ArrayList<String> a = new ArrayList();
        for(File f : Files){
            if(f.getLocation().equals(location)){
                a.add(f.getName() + "." + f.getExtention());
            }
        }
        return a;
    }
    
    public ArrayList<File> getFileArrayFromLocation(String location){
        ArrayList<File> a = new ArrayList();
        for(File f: Files){
            if(f.getLocation().equals(location)){
                a.add(f);
            }
        }
        return a;
    }
    
    public ArrayList<Directory> getDirectoriesFromLocation(String location){
        ArrayList<Directory> dirs = new ArrayList();
        for(Directory d: Directories){
            if(d.getLocation().equals(location)){
                dirs = d.getDirectories();
            }
        }
        return dirs;
    }
    
    public void deleteDir(String name){
        for(Directory d : Directories){
            if(d.getLocation().equals(currentDir) && d.getName().equals(name)){
                Directories.remove(d);
            }
        }
    }
    
    public void deleteFile(String name, String extension){
        for(File f : Files){
            if(f.getLocation().equals(currentDir) && f.getName().equals(name) && f.getExtention().equals(extension)){
                Files.remove(f);
            }
        }
    }
    
    public void findDir(String name){
        for(Directory d : Directories){
            if(d.getName().equals(name)){
                System.out.println(d.getLocation());
            }
        }
    }
    
    public void findFile(String name, String extension){
        boolean anyName = name.equals("*");
        boolean anyExtension = extension.equals("*");
        for(File f : Files){
            if(anyName && f.getExtention().equals(extension)){
                System.out.println(f.getLocation() + "\\" + f.getName() + "." + f.getExtention());
            } else if(anyExtension && f.getName().equals(name)){
                System.out.println(f.getLocation() + "\\" + f.getName() + "." + f.getExtention());
            } else if(f.getName().equals(name) && f.getExtention().equals(extension)){
                 System.out.println(f.getLocation() + "\\" + f.getName() + "." + f.getExtention());
            } else if(anyName && anyExtension){
                System.out.println(f.getLocation() + "\\" + f.getName() + "." + f.getExtention());
            }
        }
    }
    
    public String getCurrentDir(){
        return currentDir;
    }
    
    public void setCurrentDir(String currentDir){
        this.currentDir = currentDir;
    }

    public ArrayList<File> getFiles() {
        return Files;
    }

    public void setFiles(ArrayList<File> Files) {
        this.Files = Files;
    }

    public ArrayList<Directory> getDirectories() {
        return Directories;
    }

    public void setDirectories(ArrayList<Directory> Directories) {
        this.Directories = Directories;
    }
    
    public void printDir(){
        for(Directory d : Directories){
            System.out.println(d.getLocation());
        }
    }
    
    public int getIndexOfFile(String name, String extension, String location){
        int i = 0;
        for(File f : Files){
            if(f.getName().equals(name) && f.getExtention().equals(extension) && f.getLocation().equals(location)){
                return i;
            }
            i++;
        }
        return i;
    }
}
