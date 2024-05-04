import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import Console.ConsoleController;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        // ConsoleController console = new ConsoleController();

        // //Get products from CSV
        // FileFunc file = new FileFunc(PathFile.PRODUCTS.getFileName());
        // file.GetAll();

        // //Save all products from CSV
        // ArrayList<Product> list = file.productsObj;

        // //Create shopping cart
        // ShoppingCart cart = new ShoppingCart();

        // //Set default values
        // boolean filterChocolate = false;
        // boolean filterJelly = false;
        // boolean filterLolly = false;

        // boolean sortNameA = false;
        // boolean sortNameD = false;
        // boolean sortPriceA = false;
        // boolean sortPriceD = false;

        // while(true){
        //     //Clear terminal
        //     console.clearAll();

        //     //Re-print terminal
        //     MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

        //     //Read input
        //     System.out.print("Enter your choice:");
        //     Scanner scanner = new Scanner(System.in);
        //     String input = scanner.nextLine();
            
        //     switch(input){
        //         //Filter UI
        //         case "F":
        //             System.out.print("Filter chocolates {C}, jellies {J}, lollies {L}:");
        //             String filterInput = scanner.nextLine();
                    
        //             Filter filter = new Filter();
                   

        //             switch(filterInput){
        //                 case "C":
        //                     filterChocolate = !filterChocolate;
        //                     break;
        //                 case "J":
        //                     filterJelly = !filterJelly;
        //                     break;
        //                 case "L":
        //                     filterLolly = !filterLolly;
        //                     break;
        //             }
                    
        //             list = filter.FilterList(file.productsObj, filterChocolate, filterJelly, filterLolly);
        //             continue;
        //         //Sorter UI
        //         case "SO":
        //             sortNameA = false;
        //             sortNameD = false;
        //             sortPriceA = false;
        //             sortPriceD = false;

        //             System.out.print("Sort by name A-Z {NA}, name Z-A {ND}, price < {PA}, price > {PD}:");
        //             String sortInput = scanner.nextLine();

        //             Sorter sorter = new Sorter();

        //             switch(sortInput){
        //                 case "NA":
        //                     list = sorter.SortName(list, false);
        //                     sortNameA = true;
        //                     break;
        //                 case "ND":
        //                     list = sorter.SortName(list, true);
        //                     sortNameD = true;
        //                     break;
        //                 case "PA":
        //                     list = sorter.SortPrice(list, false);
        //                     sortPriceA = true;
        //                     break;
        //                 case "PD":
        //                     list = sorter.SortPrice(list, true);
        //                     sortPriceD = true;
        //                     break;
        //             }
        //             continue;
        //         //Search UI
        //         case "S":
        //             while (true) {
        //                 Searcher searcher = new Searcher();
        //                 System.out.print("Search:");
        //                 String keyword = scanner.nextLine();  // Read user input
                        
        //                 list = searcher.Search(file.productsObj, keyword);

        //                 //Clear terminal
        //                 console.clearAll();

        //                 //Re-print terminal
        //                 MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

        //                 System.out.println("Search:" + keyword);
        //                 System.out.print("Search again{A}, quit searching{Q}:");
        //                 String searchInput = scanner.nextLine();

        //                 switch(searchInput){
        //                     case "A":
        //                         //Clear terminal
        //                         console.clearAll();

        //                         //Re-print terminal
        //                         MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);
        //                         continue;
        //                     case "Q":
        //                         break;
        //                 }
        //                 break; //whiel break
        //             }
        //             continue; //continue code
        //         //Shopping cart UI
        //         case "SC":
        //             System.out.println("Shopping cart");
        //             continue;
        //         //Product UI
        //         case "P":
        //             while(true){
        //                 scanner.useDelimiter("[,\\s+]"); //Delimeter comma either space
        //                 System.out.println(cart.cartProducts);
        //                 System.out.print("Input product {ID}:");
        //                 int ID = scanner.nextInt();
    
        //                 for (Product temp : file.productsObj) {
        //                     if(temp.ID == ID){
        //                         System.out.println("test");
        //                         temp.selectedStatus = !temp.selectedStatus;
    
        //                         if(temp.selectedStatus){
        //                             if (cart.AddTo(temp)){
        //                                 //idk what to say, it works yipee!
        //                             } else{
        //                                 System.out.print("Sorry this item is out of stock :("); // have to figure out how to show this
        //                             }
        //                         }else{
        //                             cart.RemoveFrom(temp);
        //                         }
        //                         break;
        //                     }
        //                 }
        //                 break;
        //             }
        //             continue;
        //         case "E":
        //             break;
        //     }
        //     break;    
        // }

        
        //-------ALISES TESTING CODE------------------

    //     System.out.print("aaaaaaaaa");
    //     // System.out.print("\033[H\033[2J");  
    //     // System.out.print("\033[2J");
    //     System.out.print("\033[2J\033[1;1H");
         
    //     System.out.println("teehee");
    //     System.out.println("1ouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    //     System.out.println("2ouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    //     System.out.println("3ouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    //     System.out.println("4ouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    //     System.out.println("5ouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    //     char escCode = 0x1B;
    // int row = 3; int column = 5;
    // System.out.print(String.format("%c[%d;%df",escCode,row,column));

        //Registration write test timee
        // Registration reg = new Registration();
        // User user = new User("alisetoca", "alise.toc@kk.com", "Alise", "Toča", "Valdemāra 7", "gribumajas");
        // reg.Register(user);

        // // File writing test
        // Chocolates test = new Chocolates("test", 2.34, 1, "Chocolate", "Just a simple test.");
        // file.productsObj.add(test);
        // file.WriteFile(file.productsObj);

        //------- LAKYS SHOPPING CART TEST CODE----------------
        // ArrayList<Product> smthAll = new ArrayList<Product>();

        // Product testThing1 = new Chocolates(, 66.666, 0, "Chocolate", "sdfsdsd");
        // Product testThing2 = new Jellys("test2", 5.66, 2, "Jelly", "sdfsdsd");
        // Product testThing3 = new Lollies("test3", 1, 20, "Lolly", "sdfsdsd");

        // ShoppingCart usersShoppingCart = new ShoppingCart();
        // System.out.println(usersShoppingCart.GetTotalPrice()); // 0

        // usersShoppingCart.AddTo(testThing3, 3);
        // System.out.println(usersShoppingCart.GetTotalPrice()); // 3

        // usersShoppingCart.AddTo(testThing1, 1); // out of stock -> doesnt add anythng
        // System.out.println(usersShoppingCart.GetTotalPrice()); // 3

        // System.out.println(usersShoppingCart.cartProducts);

        // usersShoppingCart.SetAmount(testThing3, 15); // amount is 15 not 18
        // System.out.println(usersShoppingCart.GetTotalPrice()); // 15

        // usersShoppingCart.SetAmount(testThing3, 0); 
        // System.out.println(usersShoppingCart.GetTotalPrice()); // 0

        // System.out.println(usersShoppingCart.cartProducts);

        // System.out.println(usersShoppingCart.GetTotalPrice());
        // System.out.println(usersShoppingCart.cartProducts);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            SignIn signIn = new SignIn();

            boolean signInActive = true;
            do{
                System.out.print("\nYour choice: ");
                String signInUserChoice = reader.readLine();

                switch (signInUserChoice) {
                    case "LI":

                        
                        System.out.print("login"); 
                        signIn.LogIn();
                        System.out.print(signIn.loggedinUser);

                        signInActive = false;
                        break;
    
                    case "R":
                        signIn.Register();
                        System.out.print(signIn.loggedinUser);
                    
                        signInActive = false;
                        break;
                
                    default:
                        System.out.print("Invalid input, try again");
                        break;
                }
            } while(signInActive);
        
        
        
        
    }


    public static void LogInScreen(){

    }

    public static void MainScreen(ArrayList<Product> list, boolean filterChocolate, boolean filterJelly, boolean filterLolly, boolean sortNameA, boolean sortNameD, boolean sortPriceA, boolean sortPriceD){
        String chocolates = (filterChocolate)? "X" : " ";
        String jellies = (filterJelly)? "X" : " ";
        String lollies = (filterLolly)? "X" : " ";

        String nameA = (sortNameA)? "X" : " ";
        String nameD = (sortNameD)? "X" : " ";
        String priceA = (sortPriceA)? "X" : " ";
        String priceD = (sortPriceD)? "X" : " ";
        
        System.out.println(" _____                 _         _____ _                       ");
        System.out.println("/  __ \\               | |       /  ___| |                    ___      .-\"\"-.      ___");
        System.out.println("| /  \\/ __ _ _ __   __| |_   _  \\ `--.| |__   ___  _ __      \\  \"-.  /      \\  .-\"  /");
        System.out.println("| |    / _` | '_ \\ / _` | | | |  `--. \\ '_ \\ / _ \\| '_ \\      > -=.\\/        \\/.=- <");
        System.out.println("| \\__/\\ (_| | | | | (_| | |_| | /\\__/ / | | | (_) | |_) |     > -='/\\        /\\'=- <");
        System.out.println(" \\____/\\__,_|_| |_|\\__,_|\\__, | \\____/|_| |_|\\___/| .__/     /__.-'  \\      /  '-.__\\");
        System.out.println("                          __/ |                   | |                 '-..-'");
        System.out.println("                         |___/                    |_|          ");

        System.out.println("MAIN/PRODUCTS                                                                           EXIT APP {E}");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("FILTER {F}    \t\t SORT {SO}    \t\t SEARCH {S}    \t\t VIEW SHOPPING CART{SC}");
        System.out.println("["+ chocolates +"] Chocolates\t\t ["+ nameA +"] Name A-Z");
        System.out.println("["+ jellies +"] Jellies   \t\t ["+ nameD +"] Name Z-A");
        System.out.println("["+ lollies +"] Lollies   \t\t ["+ priceA +"] Price <");
        System.out.println("              \t\t ["+ priceD +"] Price >");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("ADD PRODUCT TO SHOPPING CART{P}");
        System.out.println(String.format("%4s", "ID") + "|" +  String.format("%20s", "Name") + "|" + String.format("%11s", "Type") + "|" + String.format("%7s", "Price"));
        System.out.println("----------------------------------------------");
        for (Product temp : list) {
            System.out.println(temp);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}