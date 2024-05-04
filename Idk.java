import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Idk {
    ConsoleController console = new ConsoleController();
    Scanner scanner1 = new Scanner(System.in);
    User loggedInUser;

    ShoppingCart cart = new ShoppingCart();
    FileFunc file = new FileFunc(PathFile.PRODUCTS.getFileName());

    public void LogInCode() throws FileNotFoundException, IOException{
        
        SignIn signIn = new SignIn();

        console.clearAll();
        while(true){
            console.SignInScreen();
            System.out.println("LOG IN {L} or REGISTER {R}");
            System.out.print("\nYour choice: ");
            String signInUserChoice = scanner1.nextLine();

            switch (signInUserChoice) {
                case "L": 
                    signIn.LogIn();
                    loggedInUser = signIn.loggedinUser;
                    break;

                case "R":
                    signIn.Register();
                    loggedInUser = signIn.loggedinUser;
                    break;

                default:
                    System.out.print("Invalid input, try again");
                    break;
            }
            break;
        }
    }

    public void MainCode() throws FileNotFoundException, IOException{
        //Get products from CSV
        
        file.GetAll();

        //Save all products from CSV
        ArrayList<Product> list = file.productsObj;

        //Create shopping cart
        

        //Set default values
        boolean filterChocolate = false;
        boolean filterJelly = false;
        boolean filterLolly = false;

        boolean sortNameA = false;
        boolean sortNameD = false;
        boolean sortPriceA = false;
        boolean sortPriceD = false;

        while(true){
            //Clear terminal
            console.clearAll();

            //Re-print terminal
            console.MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

            //Read input
            System.out.print("Enter your choice:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            
            switch(input){
                //Filter UI
                case "F":
                    System.out.print("Filter chocolates {C}, jellies {J}, lollies {L}:");
                    String filterInput = scanner.nextLine();
                    
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
                //Sorter UI
                case "SO":
                    sortNameA = false;
                    sortNameD = false;
                    sortPriceA = false;
                    sortPriceD = false;

                    System.out.print("Sort by name A-Z {NA}, name Z-A {ND}, price < {PA}, price > {PD}:");
                    String sortInput = scanner.nextLine();

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
                //Search UI
                case "S":
                    while (true) {
                        Searcher searcher = new Searcher();
                        System.out.print("Search:");
                        String keyword = scanner.nextLine();  // Read user input
                        
                        list = searcher.Search(file.productsObj, keyword);

                        //Clear terminal
                        console.clearAll();

                        //Re-print terminal
                        console.MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

                        System.out.println("Search:" + keyword);
                        System.out.print("Search again{A}, quit searching{Q}:");
                        String searchInput = scanner.nextLine();

                        switch(searchInput){
                            case "A":
                                //Clear terminal
                                console.clearAll();

                                //Re-print terminal
                                console.MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);
                                continue;
                            case "Q":
                                break;
                        }
                        break; //whiel break
                    }
                    continue; //continue code
                //Shopping cart UI
                case "SC":
                    ShoppingCartCode();
                    break;
                //Product UI
                case "P":
                    boolean whileLoop = true;
                    while(whileLoop){
                        scanner.useDelimiter("[,\\s+]"); //Delimeter comma either space
                        System.out.print("Input product {ID}:");
                        int ID = scanner.nextInt();
    
                        for (Product temp : file.productsObj) {
                            if(temp.ID == ID){
                                whileLoop = false;
                                temp.selectedStatus = !temp.selectedStatus;    
                                if(temp.selectedStatus){
                                    if (!cart.AddTo(temp)){
                                        System.out.print("Sorry, this item is out of stock [Press Enter to continue]"); 
                                        scanner.next();
                                        temp.selectedStatus = false;
                                    } 
                                }else{
                                    cart.RemoveFrom(temp);
                                }                                
                            }
                        }
                        console.clearOneLine(28);                        
                    }
                    continue;
                case "E":
                    System.exit(0);
                    break;
            }
            break;    
        }
    }




    public void ShoppingCartCode(){
        
        // Shopping cart
        boolean firstWhileloop = true;
        while(firstWhileloop){
            console.clearAll();
            console.ShoppingCartScreen(cart.cartProducts);
            
            System.out.print("Your choice: ");
            String SCUserChoice = scanner1.next();

            switch (SCUserChoice) {
                case "E": 
                    System.exit(0);
                    break;

                case "P":
                    Product product = null;
                    while(product == null){
                        System.out.print("Input the product you wan to edit {ID}:");
                        int ID = scanner1.nextInt();
                        for (Product temp : cart.cartProducts.keySet()) {
                            if(temp.ID == ID){
                                product = temp;
                            }          
                        }
                        console.clearOneLine(18);
                    }
                    
                    System.out.print("REMOVE {R} this product or CHANGE AMOUNT {CA}: ");
                                String userRorCA = scanner1.next();

                                boolean thirdWhileLoop = true;
                                while(thirdWhileLoop){
                                    switch (userRorCA) {
                                        case "R":
                                            cart.RemoveFrom(product);
                                            thirdWhileLoop = false;
                                            break;
                                    
                                        case "CA":
                                            console.clearOneLine(19);
                                            System.out.print("Enter the new amount: ");
                                            int amount = scanner1.nextInt();
                                            cart.SetAmount(product, amount);
                                            thirdWhileLoop = false;
                                            break;
                                        default:
                                            System.out.print("Wrong input");
                                            break;
                                    }
                                }
                        
                




                // console.clearOneLine(20);
                //     console.clearOneLine(19);
                //     System.out.print("Your choice: ");
                //     System.out.print("Your choice: ");
                //     String SCproductsUserChoice = scanner1.nextLine();

                //     switch (SCproductsUserChoice) {
                //         case "":
                            
                //             break;
                    
                //         default:
                //             break;
                //     }
                    break;

                case "O":
                    
                    break;
                default:
                    System.out.print("Invalid input, try again");
                    break;
            }
        }
    }



}
