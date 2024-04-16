package UserManagment;

public class User {
    String username;
    String email;

    String name;
    String surname;
    String adress;
    int age; 

    String password;

    public User(String username, String email, String name, String surname, String adress, int age, String password){
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.age = age;
        this.password = password;
    }
}
