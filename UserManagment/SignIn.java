import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SignIn {
    
    ArrayList<User> registeredUsers;

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

    public void LogIn(String email, String password){

        User logInUser = CheckUser(email);
        if (logInUser != null){
            while(true){
                if(logInUser.password.equals(password)){
                    System.out.print("slay (user logged in sucsefuly, idk kam talak janotiek)");
                    break;
                } else {
                    System.out.print("try again u stupid ");
                    break;
                }
            }
        } else{System.out.print("nauh");}

        
    }


    public void RegisterInFile(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }
}
