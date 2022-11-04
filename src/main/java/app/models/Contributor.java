package app.models;

public class Contributor {
    public String firstname;
    public String lastname;
    public String photoPath;
    public String alt;

    public Contributor(String firstname, String lastname, String photoPath, String alt){
            this.firstname = firstname;
            this.lastname = lastname;
            this.photoPath = photoPath;
            this.alt = alt;
    }

    public String getFirstname(){
        return  this.firstname;
    }

    public String getLastname(){
        return  this.lastname;
    }

    public String getPhotoPath(){
        return  this.photoPath;
    }

    public String getAlt(){
        return  this.alt;
    }
}
