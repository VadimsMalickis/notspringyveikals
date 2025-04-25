package lv.rvt.model;

public class User {

    //User atributes
    String username;
    String email;
    String name;
    String surname;
    String adress;
    String password;

    public User(String username, String email, String name, String surname, String adress, String password){ // creates a new user
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.password = password;
    }

    public String toString(){
        return username + "," + email + "," + name + "," + surname + "," + adress + "," + password;
    }
}
