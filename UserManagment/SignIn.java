import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignIn {
    
    ArrayList<User> registeredUsers;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public SignIn() throws FileNotFoundException, IOException{
        FileFunc file = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        file.GetAll();
        registeredUsers = file.usersObj;
    }

    public User CheckUser(String email){
        User check = null;
        for (User user : registeredUsers){
            if (user.email.equals(email)){
                check = user;
            } 
        }
        return check;
    }

    
       


    public void LogIn(){

    }


    public void RegisterInFile(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }
}
