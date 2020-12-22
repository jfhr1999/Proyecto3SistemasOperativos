
package FileClasses;

import java.util.Date;



public class File {
    private String Name;
    private String Extention;
    private String Content;
    private String location;
    private Date creationDate;
    private Date modificationDate;
    private double size;
    
    public File(){
    
    }
    public File( String pName, String pExtention, String pContent, String location){
        this.Name = pName;
        this.Extention = pExtention;
        this.Content = pContent;
        this.location = location;
        this.creationDate = new Date();
        this.modificationDate = new Date();
    }
    
    public File (String pName, String pExtention){
        this.Name = pName;
        this.Extention = pExtention;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getExtention() {
        return Extention;
    }

    public void setExtention(String Extention) {
        this.Extention = Extention;
    }

    public String getContent() {
        return Content;
    }
    
    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    
    
    
    @Override
    public String toString(){
        String str = "";
        str += Name + Extention + "\n";
        return str;
    }
    
    public String viewProperties(){
        String str = "";
        str += "Nombre: " + Name + "\nExtensión: " + Extention + "\n";
        str += "Fecha de creación: " + creationDate + "\n";
        str += "Fecha de modificación: " + modificationDate + "\n";
        str += "Contenido: " + Content;
        return str;
    }
}
