import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

        
        System.out.print("Enter email: ");
        String email = reader.readLine();

        User logInUser = CheckUser(email);
        if (logInUser != null){
            
            if(logInUser.password.equals(password)){
                System.out.print("user logged in sucsefuly, should have a wait time and then switch to main screen)");
                break;
            } else {
                System.out.print("incorect password");
                break;
            }
        } else {
            System.out.println("there is no such email in the system");
            while(true){
            System.out.println("Try again{T} or registre{R}?: ");
            String answerTorR = reader.readLine();
                if(answerTorR == "T"){
                    break;
                    LogIn();
                } else if(answerTorR == "R"){
                    break;
                    // Register();
                } else{System.out.print("Wrong input");}
            }
        }

        
    }


    public void RegisterInFile(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }
}
