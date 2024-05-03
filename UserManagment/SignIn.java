import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Console.ConsoleController;

public class SignIn {

    ConsoleController console = new ConsoleController();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<User> registeredUsers;
    // String username;
    // String email;

    // String name;
    // String surname;
    // String adress;

    // String password;

    public SignIn() throws FileNotFoundException, IOException{
        FileFunc file = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        file.GetAll();
        registeredUsers = file.usersObj;

        String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        String usernameRegex = "^[A-Za-z]\\w{5,20}$";
        Pattern usernamePattern = Pattern.compile(usernameRegex);
    }

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

    public User CheckUsername(String email){
        User check = null;
        for (User user : registeredUsers){
            if (user.email.equals(email)){
                check = user;
            } 
        }
        return check;
    }

    
       


    public void LogIn() throws IOException{
        console.clearAll();
        System.out.print("\nEmail/Username: ");
        System.out.print("\nPassword: ");

        console.MoveCursor(2, "Email/Username: ".length()+1);
        String email = reader.readLine();

        User user = Check(email);
        if(user != null){
            while(true){
                console.clearOneLine(3);
                System.out.print("Password: ");
                console.MoveCursor(3, 11);

                String password = reader.readLine();

                if (password.equals(user.password)){
                    System.out.print("\nyipee u pass");
                    break;
                } else {
                    System.out.print("\nincorect password");
                    continue;
                }
            }
        } else{
            
            while(true){
                console.clearOneLine(5);
                System.out.print("Such email does not exist, do you wan to try again[T] or register[R]?: ");
                console.MoveCursor(5, "Such email does not exist, do you wan to try again[T] or register[R]?: ".length()+1);
                String userinputTorR = reader.readLine();
                if(userinputTorR.equals("T")){
                    LogIn();
                    break;
                }else if(userinputTorR.equals("R")){
                    //Register();
                    break;
                }else{
                    continue;
                }
            }
        
        }
    }


    public void Register() throws IOException{
        console.clearAll();
        System.out.print("\nEmail: ");
        System.out.print("\nUsername: ");
        System.out.print("\nName: ");
        System.out.print("\nSurname: ");
        System.out.print("\nAdress: ");
        System.out.print("\nPassword: ");

        String email = InfomrmationFillIn("Email", 2, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", "Please enter an e-mail!", "Such email is already registered in our system, do you wan to try again[T] or log in[LI]?: ");
        String username = InfomrmationFillIn("Username", 3, "^[A-Za-z]\\w{5,20}$", "Username should be 5 to 20 charaters long, can only contain letters, numbers and special charater '_'", "Such username already is registered in our system, do you wan to try again[T] or log in[LI]?: ");
        String name = InfomrmationFillIn("Name", 4, "[A-Z][a-z]*", "Please enter your name starting with capital letter", "-");
        String surname = InfomrmationFillIn("Surname", 5, "[A-Z][a-z]*", "Please enter your surname starting with capital letter", "-");
        String adress = InfomrmationFillIn("Adress", 6, "^([a-zA-z0-9/\\''(),-\\s]{2,255})$", "Please enter valid adress", "-");
        String password = InfomrmationFillIn("Name", 4, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]).{8,20}$", "Your password should be 8 to 20 charaters long, have atlest one lower and upper case letter, number and special symbol", "-");

        System.out.print(email + " " + username + " " +  name + " " +  surname + " " +  adress + " " +  password);
        
    }  


    public void RegisterInFile(User user){
        FileFunc registerFile = new FileFunc(PathFile.REGISTERED_USERS.getFileName());
        registerFile.WriteFile(user);
    }





    private String InfomrmationFillIn(String field, int row, String regex, String regexErrorMessage, String duplicateErrorMesage) throws IOException{

        while(true){
            console.clearOneLine(row);
            System.out.print(field + ": ");
            console.MoveCursor(row, field.length()+3);
            String userInput = reader.readLine();
            console.clearOneLine(9);

            Pattern pattern = Pattern.compile(regex);
            if(pattern.matcher(userInput).matches()){

                if(field.equals("Email") || field.equals("Username")){
                    User user = Check(userInput);
                    if(user == null){
                        return userInput;
                    }else{
                        while(true){
                            console.clearOneLine(9);
                            System.out.print(duplicateErrorMesage);
                            console.MoveCursor(9, duplicateErrorMesage.length()+1);
                            String userinputTorLI = reader.readLine();
                            if(userinputTorLI.equals("T")){
                                InfomrmationFillIn(field, row, regex, regexErrorMessage, duplicateErrorMesage);
                                break;
                            }else if(userinputTorLI.equals("LI")){
                                LogIn();
                                break;
                            }else{
                                continue;
                            }
                        }
                    }
                } else{
                    return userInput;
                }

            } else{
                console.MoveCursor(9, 0);
                System.out.print(regexErrorMessage);
                continue;
            }
        } // end of email while

    }



    // private void Email() throws IOException{
    //     // while loop for proper email input
    //     while(true){
    //         console.clearOneLine(2);
    //         System.out.print("Email: ");
    //         console.MoveCursor(2, "Email: ".length()+1);
    //         email = reader.readLine();
    //         console.clearOneLine(9);

    //         if(emailPattern.matcher(email).matches()){
    //             User userEmail = CheckEmail(email);
    //             if(userEmail == null){
    //                 break;
    //             }else{
    //                 while(true){
    //                     console.clearOneLine(9);
    //                     System.out.print("Such email already is registered in our system, do you wan to try again[T] or log in[LI]?: ");
    //                     console.MoveCursor(9, "Such email already is registered in our system, do you wan to try again[T] or log in[LI]?: ".length()+1);
    //                     String userinputTorLI = reader.readLine();
    //                     if(userinputTorLI.equals("T")){
    //                         Email();
    //                         break;
    //                     }else if(userinputTorLI.equals("LI")){
    //                         LogIn();
    //                         break;
    //                     }else{
    //                         continue;
    //                     }
    //                 }
    //             }
    //         } else{
    //             console.MoveCursor(9, 0);
    //             System.out.print("Please enter an e-mail!");
    //             continue;
    //         }
    //     } // end of email while

    // }


    // private void Username() throws IOException{
    //     while(true){
    //         console.clearOneLine(3);
    //         System.out.print("Username: ");
    //         console.MoveCursor(3, "Username: ".length()+1);
    //         username = reader.readLine();
    //         System.out.print(username);
    //         console.clearOneLine(9);

    //         if(usernamePattern.matcher(username).matches()){
    //             User userUsername = CheckUsername(username);
    //             if(userUsername == null){
    //                 System.exit(0);
    //                 break;
    //             }else{
    //                 while(true){
    //                     console.clearOneLine(9);
    //                     System.out.print("Such username already is registered in our system, do you wan to try again[T] or log in[LI]?: ");
    //                     console.MoveCursor(9, "Such username already is registered in our system, do you wan to try again[T] or log in[LI]?: ".length()+1);
    //                     String userinputTorLI = reader.readLine();
    //                     if(userinputTorLI.equals("T")){
    //                         Username();
    //                         break;
    //                     }else if(userinputTorLI.equals("LI")){
    //                         LogIn();
    //                         break;
    //                     }else{
    //                         continue;
    //                     }
    //                 }
    //             }
    //         } else{
    //             console.MoveCursor(9, 0);
    //             System.out.print("Username should be 3 to 9 charaters long, can only contain special charaters _ and -");
    //             continue;
    //         }
    //     } // end of username while
    // }
}
