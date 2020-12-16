
package FileClasses;


public class File {
    private String Name;
    private String Extention;
    private String Content;
    
    public File(){
    
    }
    public File( String pName, String pExtention, String pContent){
        this.Name = pName;
        this.Extention = pExtention;
        this.Content = pContent;
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
    
    
    
}
