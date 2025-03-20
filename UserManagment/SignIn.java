import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SignIn {
    // Works all SignIn functions and checks all the input
    public static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String USERNAME_REGEX = "^[A-Za-z]\\w{4,20}$";
    public static final String NAME_REGEX = "[A-ZĀ-Ž][a-za-ž]*";
    public static final String SURNAME_REGEX = "[A-ZĀ-Ž][a-za-ž]*";
    public static final String ADRESS_REGEX ="^[A-ZĀ-Ža-zā-ž0-9 _]*[A-ZĀ-Ža-zā-ž0-9][A-ZĀ-Ža-zā-ž0-9 _]*$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,20}$";

    ConsoleController console;
    BufferedReader reader;
    ArrayList<User> registeredUsers;
    User loggedinUser;

    public SignIn() throws FileNotFoundException, IOException{ // CONSTRUCTOR -> sets everything up

        console = new ConsoleController();
        reader = new BufferedReader(new InputStreamReader(System.in));
        registeredUsers = new ArrayList<User>();

        FileFunc file = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        file.GetAll();
        registeredUsers = file.usersObj;        
    }

    // Checks if user with this username/email already exists
    public User Check(String userInput){
        User check = null;
        for (User user : registeredUsers){
            if (user.email.equals(userInput)){
                check = user;
            } 
            if (user.username.equals(userInput)){
                check = user;
            }
        }
        return check;
    }

    // Works the LogIn page
    public void LogIn() throws IOException{
        console.clearAll();
        console.SignInScreen();
        System.out.print("\nEmail/Username: ");
        System.out.print("\nPassword: ");

        console.MoveCursor(12, "Email/Username: ".length()+1);
        String email = reader.readLine();

        User user = Check(email);
        if(user != null){ // Checks if the user exists
            while(true){ // Loops till the password is entered correctly
                console.clearOneLine(13);
                System.out.print("Password: ");
                console.MoveCursor(13, "Password: ".length()+1);

                String password = reader.readLine();

                if (password.equals(user.password)){
                    loggedinUser = user;
                    break;
                } else {
                    System.out.print("\nIncorect password, try again!");
                    continue;
                }
            }
        } else { // if such user doesn't exist

            while(true){ // Loops till user enters a valid response
                console.clearOneLine(15);
                System.out.print("Such email does not exist, do you wan to try again[T] or register[R]?: ");
                console.MoveCursor(15, "Such email does not exist, do you wan to try again[T] or register[R]?: ".length()+1);
                String userinputTorR = reader.readLine();
                if(userinputTorR.equals("T")){
                    LogIn();
                    break;
                }else if(userinputTorR.equals("R")){
                    Register();
                    break;
                }else{
                    continue;
                }
            }
        }
    }

    // Works the register page
    public void Register() throws IOException{
        console.clearAll();
        console.SignInScreen();
        System.out.print("\nEmail: ");
        System.out.print("\nUsername: ");
        System.out.print("\nName: ");
        System.out.print("\nSurname: ");
        System.out.print("\nAdress: ");
        System.out.print("\nPassword: ");

        // Fills in all the infomation
        String email = infomrmationFillIn("Email", 12, SignIn.EMAIL_REGEX, "Please enter an e-mail!", "Such email is already registered in our system, do you wan to try again[T] or log in[L]?: ");
        String username = infomrmationFillIn("Username", 13, SignIn.USERNAME_REGEX, "Username should be 5 to 20 charaters long, must have letters, can contain numbers and special charater '_'", "Such username already is registered in our system, do you wan to try again[T] or log in[L]?: ");
        String name = infomrmationFillIn("Name", 14, SignIn.NAME_REGEX, "Please enter your name starting with capital letter", "-");
        String surname = infomrmationFillIn("Surname", 15, SignIn.SURNAME_REGEX, "Please enter your surname starting with capital letter", "-");
        String adress = infomrmationFillIn("Adress", 16, SignIn.ADRESS_REGEX, "Please enter valid adress", "-");
        String password = infomrmationFillIn("Password", 17, SignIn.PASSWORD_REGEX, "Your password should be 8 to 20 charaters long, have atlest one lower and upper case letter, number and special symbol", "-");

        User newUser = new User(username, email, name, surname, adress, password); // creates a new user
        loggedinUser = newUser; // sets the new user as the logged in one
        RegisterInFile(newUser); // adds the new user to the registered user file        
    }  

    // adds a user to the registered user file
    public void RegisterInFile(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }

    private String infomrmationFillIn(String field, int row, String regex, String regexErrorMessage, String duplicateErrorMesage) throws IOException{

        while (true) { // loops till everything is filled in correctly
            console.clearOneLine(row);
            System.out.print(field + ": ");
            console.MoveCursor(row, field.length()+3);
            String userInput = reader.readLine();
            console.clearOneLine(19);

            if(userInput.matches(regex)){

                if(field.equals("Email") || field.equals("Username")){ // for checking already existing useraname/email, if already exists -> user has an option to log in
                    User user = Check(userInput);
                    if(user == null){
                        return userInput;
                    } else{
                        while(true) {
                            console.clearOneLine(19);
                            System.out.print(duplicateErrorMesage);
                            console.MoveCursor(19, duplicateErrorMesage.length()+1);
                            String userinputTorLI = reader.readLine();
                            if(userinputTorLI.equals("T")){
                                userInput = infomrmationFillIn(field, row, regex, regexErrorMessage, duplicateErrorMesage);
                                break;
                            }else if(userinputTorLI.equals("L")){
                                LogIn();
                                break;
                            }else{
                                continue;
                            }
                        }
                        return userInput;
                    }
                } else{
                    return userInput;
                }

            } else{
                console.MoveCursor(19, 0);
                System.out.print(TextColor.RED.getValue() + regexErrorMessage + TextColor.ANSI_RESET.getValue());
                continue;
            }
        }
    }
}