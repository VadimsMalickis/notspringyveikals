import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class SignIn {
    // Works all SignIn functions and checks all the input

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
        String email = InfomrmationFillIn("Email", 12, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", "Please enter an e-mail!", "Such email is already registered in our system, do you wan to try again[T] or log in[L]?: ");
        String username = InfomrmationFillIn("Username", 13, "^[A-Za-z]\\w{4,20}$", "Username should be 5 to 20 charaters long, must have letters, can contain numbers and special charater '_'", "Such username already is registered in our system, do you wan to try again[T] or log in[L]?: ");
        String name = InfomrmationFillIn("Name", 14, "[A-ZĀ-Ž][a-za-ž]*", "Please enter your name starting with capital letter", "-");
        String surname = InfomrmationFillIn("Surname", 15, "[A-ZĀ-Ž][a-za-ž]*", "Please enter your surname starting with capital letter", "-");
        String adress = InfomrmationFillIn("Adress", 16, "^[A-ZĀ-Ža-zā-ž0-9 _]*[A-ZĀ-Ža-zā-ž0-9][A-ZĀ-Ža-zā-ž0-9 _]*$", "Please enter valid adress", "-");
        String password = InfomrmationFillIn("Password", 17, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,20}$", "Your password should be 8 to 20 charaters long, have atlest one lower and upper case letter, number and special symbol", "-");

        User newUser = new User(username, email, name, surname, adress, password); // creates a new user
        loggedinUser = newUser; // sets the new user as the logged in one
        RegisterInFile(newUser); // adds the new user to the registered user file        
    }  

    // adds a user to the registered user file
    public void RegisterInFile(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }

    private String InfomrmationFillIn(String field, int row, String regex, String regexErrorMessage, String duplicateErrorMesage) throws IOException{

        while(true){ // loops till everything is filled in correctly
            console.clearOneLine(row);
            System.out.print(field + ": ");
            console.MoveCursor(row, field.length()+3);
            String userInput = reader.readLine();
            console.clearOneLine(19);

            Pattern pattern = Pattern.compile(regex); // cheks if entered info matches the regex -> cheks that entered information is in valid form
            if(pattern.matcher(userInput).matches()){

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
                                userInput = InfomrmationFillIn(field, row, regex, regexErrorMessage, duplicateErrorMesage);
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
                System.out.print(regexErrorMessage);
                continue;
            }
        }
    }
}