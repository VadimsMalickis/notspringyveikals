package lv.rvt.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lv.rvt.model.*;
import lv.rvt.ui.*;
import lv.rvt.service.*;

public class App {
    ConsoleController console;
    List<BankAccount> bankAccounts;
    Scanner scanner;
    ShoppingCart cart;
    FileManager file;
    SignIn signInService;

    User loggedInUser;
    
    List<Product> list;
    List<Product> searchedList;
    
    boolean filterChocolate;
    boolean filterJelly;
    boolean filterLolly;

    boolean sortNameA;
    boolean sortNameD;
    boolean sortPriceA;
    boolean sortPriceD;

    // Constructor -> sets up everything for work
    public App() throws Exception {   
        bankAccounts = new ArrayList<BankAccount>();
        bankAccounts.add(new BankAccount(1000, "ANNA", "31010912", "106"));
        bankAccounts.add(new BankAccount(300, "ALISE", "13030720", "231"));
        bankAccounts.add(new BankAccount(5, "JANIS", "18208970", "543");

        console = new ConsoleController();
        scanner = new Scanner(System.in);
        cart = new ShoppingCart(); //Create shopping cart
        file = new FileManager(PathFile.PRODUCTS.getFileName());
        signInService = new SignIn();

        //Save all products from CSV
        list = file.productsObj;

        //Create list for Search UI
        searchedList = new ArrayList<Product>();

        //Set default values for filter and sorter
        filterChocolate = true;
        filterJelly = true;
        filterLolly = true;
    
        sortNameA = false;
        sortNameD = false;
        sortPriceA = false;
        sortPriceD = false;

        file.GetAll();
    }

    public void start() throws Exception {
        
        while (true) {
            console.clearAll();
            console.SignInScreen();
            System.out.println("LOG IN {L} or REGISTER {R}");
            System.out.print("\nYour choice: ");
            String signInUserChoice = scanner.next();

            switch (signInUserChoice) {
                case "L": 
                    signInService.LogIn();
                    loggedInUser = signInService.loggedinUser;
                    MainCode();
                    break;

                case "R":
                    signInService.Register();
                    loggedInUser = signInService.loggedinUser;
                    MainCode();
                    break;

                default:
                    //Invalid input
                    break;
            }
            
        }
    }

    // works the Main page
    private void MainCode() throws FileNotFoundException, IOException{

        while(true) {
            console.clearAll();
            console.MainScreen(loggedInUser, list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

            System.out.print("Enter your choice:");
            String input = scanner.next();
            
            switch(input) {
                case "F":
                    System.out.print("Filter chocolates {C}, jellies {J}, lollies {L}:");
                    String filterInput = scanner.next();
                    
                    Filter filter = new Filter();
                   
                    switch(filterInput){
                        case "C":
                            filterChocolate = !filterChocolate;
                            break;
                        case "J":
                            filterJelly = !filterJelly;
                            break;
                        case "L":
                            filterLolly = !filterLolly;
                            break;
                    }
                    
                    list = filter.FilterList(file.productsObj, filterChocolate, filterJelly, filterLolly);
                    continue;
                case "SO":
                    sortNameA = false;
                    sortNameD = false;
                    sortPriceA = false;
                    sortPriceD = false;

                    System.out.print("Sort by name A-Z {NA}, name Z-A {ND}, price < {PA}, price > {PD}:");
                    String sortInput = scanner.next();

                    Sorter sorter = new Sorter();

                    switch(sortInput){
                        case "NA":
                            list = sorter.SortName(list, false);
                            sortNameA = true;
                            break;
                        case "ND":
                            list = sorter.SortName(list, true);
                            sortNameD = true;
                            break;
                        case "PA":
                            list = sorter.SortPrice(list, false);
                            sortPriceA = true;
                            break;
                        case "PD":
                            list = sorter.SortPrice(list, true);
                            sortPriceD = true;
                            break;
                    }
                    continue;
                case "S":
                    while (true) {
                        Searcher searcher = new Searcher();
                        System.out.print("Search:");
                        String keyword = scanner.next();
                        
                        searchedList = searcher.Search(file.productsObj, keyword);

                        //Clear terminal
                        console.clearAll();

                        //Re-print terminal
                        console.MainScreen(loggedInUser, searchedList, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

                        System.out.println("Search:" + keyword);
                        System.out.print("Search again{A}, quit searching{Q}:");
                        String searchInput = scanner.next();

                        switch(searchInput){
                            case "A":
                                //Clear terminal
                                console.clearAll();

                                //Re-print terminal
                                console.MainScreen(loggedInUser, list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);
                                continue;
                            case "Q":
                                list = searchedList;
                                break;
                        }
                        break; //while break
                    }
                    continue; //continue code
             
                case "SC":
                    ShoppingCartCode();
                    break;
                //Product UI
                case "P":
                    boolean whileLoop = true;
                    while(whileLoop){
                        scanner.useDelimiter("[,\\s+]"); // Used to make [Press Enter to continue] possible
                        System.out.print("Input product {ID}:");

                        if (scanner.hasNextInt()){

                            int ID = scanner.nextInt();
                            for (Product temp : list) {
                                if(temp.ID == ID){
                                    whileLoop = false;
                                    temp.selectedStatus = !temp.selectedStatus;    
                                    if(temp.selectedStatus){
                                        if (!cart.AddTo(temp)){
                                            System.out.print(TextColor.RED.getValue() + "Sorry, this item is out of stock [Press Enter to continue]" + TextColor.ANSI_RESET.getValue()); 
                                            scanner.next();
                                            temp.selectedStatus = false;
                                        } 
                                    }else{
                                        cart.RemoveFrom(temp);
                                    }                                
                                }
                            }
                            console.clearOneLine(22 + list.size());

                        } else {
                            scanner.next();
                            console.clearOneLine(22 + list.size());
                            continue;
                        }                       
                    }
                    continue;
                case "E":
                    System.exit(0);
                    break;

                default:
                    // Wrong input;
                    break;
            }
            scanner.close();             
        }
    }

    private void ShoppingCartCode() throws FileNotFoundException, IOException{
        
        boolean firstWhileloop = true;
        while(firstWhileloop){
            console.clearAll();
            console.ShoppingCartScreen(cart);
            
            System.out.print("Your choice: ");
            String SCUserChoice = scanner.next();

            switch (SCUserChoice) { // makes sure user enters a valid input
                case "E":  //Exit program
                    System.exit(0);
                    break;

                case "M": // Gose back to main page
                    MainCode();
                    break;

                //Product UI
                case "P":
                    Product product = null;
                    while(product == null){ // makes sure user enters a an existing products ID
                        System.out.print("Input the product you wan to edit {ID}:");
                        if (scanner.hasNextInt()){ // makes sure user enters a valid integer input
                            int ID = scanner.nextInt();
                            for (Product temp : cart.cartProducts.keySet()) {
                                if(temp.ID == ID){
                                    product = temp;
                                }          
                            }
                            console.clearOneLine(16 + cart.cartProducts.size());
                        } else{
                            scanner.next();
                            console.clearOneLine(16 + cart.cartProducts.size());
                            continue;
                        }
                        
                    }

                    boolean thirdWhileLoop = true;
                    while(thirdWhileLoop){ // makes sure user enters a valid input
                        console.clearOneLine(16 + cart.cartProducts.size());
                        System.out.print("REMOVE {R} this product or CHANGE AMOUNT {CA}: ");
                        String userRorCA = scanner.next();

                        switch (userRorCA) {
                            //remove product UI
                            case "R":
                                cart.RemoveFrom(product);
                                product.selectedStatus = false; // de-selects the product
                                thirdWhileLoop = false;
                                break;
                        
                            //Change product amount UI
                            case "CA":
                                boolean forthWhileLoop = true;
                                while(forthWhileLoop){ // makes sure user enters a valid input
                                    console.clearOneLine(17 + cart.cartProducts.size());
                                    System.out.print("Enter the new amount: ");

                                    if (scanner.hasNextInt()){ // makes sure user enters a valid integer input
                                        int amount = scanner.nextInt();
                                    
                                        if (!cart.SetAmount(product, amount)){ // checks if setting the amount is posible, if true - sets amount to input
                                            scanner.useDelimiter("[,\\s+]"); // Used to make [Press Enter to continue] possible
                                            System.out.print(TextColor.RED.getValue() + "Sorry, there isn't enough of this producs in the storage, try smaller amount [Press Enter to continue]" + TextColor.ANSI_RESET.getValue()); 
                                            scanner.next();
                                        }
                                        forthWhileLoop = false;
                                        break;
                                    } else {
                                        scanner.next();
                                        console.clearOneLine(17 + cart.cartProducts.size());
                                        continue;
                                    }
                                }
                                thirdWhileLoop = false;

                            default:
                                //Wrong input
                                break;
                        }
                    }
                    break;

                //Order UI
                case "O": 

                    if (cart.cartProducts.size() == 0){
                        System.out.print("\nYour cart is empty {Press Enter to continue}");
                        scanner.useDelimiter("[,\\s+]"); // Used to make [Press Enter to continue] possible
                        scanner.next();
                        // ShoppingCartCode();
                        break;
                    }

                    BankAccount bankAcc = null;

                    //Bank account information fill in UI
                    while(bankAcc == null){ // repeats till user fills in all of the fiels correctly or till exists this UI
                        console.clearAll();
                        console.ShoppingCartScreen(cart);

                        System.out.println("Please enter your information");
                        System.out.println("-----------------------------");
                        System.out.println("Bank account number: ");
                        System.out.println("Bank/Cards owner's name (IN CAPS): ");
                        System.out.println("CVV: ");

                        console.clearOneLine(17 + cart.cartProducts.size());
                        System.out.print("Bank account number: ");
                        String userBankAccNumber = scanner.next();

                        console.clearOneLine(18 + cart.cartProducts.size());
                        System.out.print("Bank/Cards owner's name (IN CAPS): ");
                        String userOwner = scanner.next();

                        console.clearOneLine(19 + cart.cartProducts.size());
                        System.out.print("CVV: ");
                        String userCVV = scanner.next();

                        for (BankAccount tempBankAcc : bankAccounts){ // Cheks if bankAcc with this infomation exists -> if exists, sets it as the one in use
                            if (userBankAccNumber.equals(tempBankAcc.GetBankAccNumber()) && userOwner.equals(tempBankAcc.GetOwner()) && userCVV.equals(tempBankAcc.GetCVV())){
                                bankAcc = tempBankAcc;
                                Filter filter = new Filter();
                                list = filter.FilterList(file.productsObj, true, true, true);
                                
                                if (cart.OrderCart(loggedInUser, bankAcc, list)){ // Orders cart (if transation is successful)
                                    System.out.print(TextColor.PURPLE.getValue() + "\nThank you for shopping with us! Your order has been placed and you can view your check. :)" + TextColor.ANSI_RESET.getValue());
                                    System.exit(0);// Exists the shop

                                } else { // Error -> if transation wasnt successful
                                    scanner.useDelimiter("[,\\s+]"); // Used to make [Press Enter to continue] possible
                                    System.out.print(TextColor.RED.getValue() + "\nSomething went wrong in the transaction, please try again! [Press Enter to continue]" + TextColor.ANSI_RESET.getValue());
                                    scanner.next();
                                    ShoppingCartCode();
                                }   
                            }
                        }

                        boolean whileLoop = true;
                        while(whileLoop){ // makes sure user enters a valid input

                            console.clearOneLine(20 + cart.cartProducts.size());
                            System.out.print(TextColor.RED.getValue() + "There is a mistake in your information. Do you want to Try again {T}, Continue shopping {C} or Exit the shop {E}: " + TextColor.ANSI_RESET.getValue());
                            String userTorCorE = scanner.next();

                            switch (userTorCorE) {
                                case "T":
                                    whileLoop = false;
                                    break;

                                case "C":
                                    whileLoop = false;
                                    ShoppingCartCode();
                                    break;

                                case "E":
                                    whileLoop = false;
                                    System.out.print(TextColor.PURPLE.getValue() + "\nThank you for shopping with us!" + TextColor.ANSI_RESET.getValue());
                                    System.exit(0);                                    
                                    break;
                            
                                default:
                                    break;
                            }
                        }
                    }                   
                    break;

                default:
                   break;
            }
        }
    }
}