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
            System.out.println("> ");
            String str = sc.nextLine();
            
            if(str.equals("CREATE")){
                //no c aserlo ekisde
            }
            
            else if (str.equals("FILE")){
                System.out.println("Digite el nombre del archivo: ");
                str = sc.nextLine();
                System.out.println("STR: " + str);
                String[] data = str.split("\\.");
                String nombre = data[0];
                String extension = "." + data[1];
                
                //Crea el archivo
                System.out.println("Digite el contenido del archivo: ");
                String contenido = sc.nextLine();
                File file = new File(nombre, extension, contenido, currentDir);
                System.out.println(file.toString());
                
                if(checkExist(nombre, extension)){ //Si ya existe
                    System.out.println("Ya existe un archivo con este nombre, ¿desea reemplazarlo con este? ");
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
                System.out.println("Digite el nombre del directorio: ");
                String nombre = sc.nextLine();
                Directory dir = new Directory(nombre, currentDir + "\\" + nombre);
                if(checkDir(nombre)){
                    System.out.println("Ya existe un archivo con este nombre, ¿desea reemplazarlo con este? ");
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
                System.out.println("Digite la dirección a la que desea ir: ");
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
            
            else if (str.equals("ModFile")){}
            else if (str.equals("VerFile")){}
            else if (str.equals("CoPY")){}
            else if (str.equals("MoVer")){}
            else if (str.equals("ReMove")){}
            else if (str.equals("FIND")){}
            else if (str.equals("TREE")){}
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
            if(d.getName().equals(name) && d.getLocation().equals(currentDir)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkLocation(String desiredLocation){
        for(Directory d : Directories){
            if(d.getLocation().equals(desiredLocation)){
                return true;
            }
        }
        return false;
    }
    
    public void insertFile(File f){
        for(Directory d : Directories){
            if(d.getLocation().equals(currentDir)){
                d.insertFile(f);
            }
        }
    }
    
    public void insertDir(Directory dir){
        for(Directory d : Directories){
            if(d.getLocation().equals(currentDir)){
                d.insertDirectory(dir);
            }
        }
    }
}
