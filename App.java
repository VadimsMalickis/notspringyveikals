import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Get products from CSV
        FileFunc file = new FileFunc(PathFile.PRODUCTS.getFileName());
        file.GetAll();

        //Save all products from CSV
        ArrayList<Product> list = file.productsObj;

        //Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        //Set default values
        boolean filterChocolate = true;
        boolean filterJelly = true;
        boolean filterLolly = true;

        boolean sortNameA = false;
        boolean sortNameD = false;
        boolean sortPriceA = false;
        boolean sortPriceD = false;

        while(true){
            //Clear terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            //Re-print terminal
            MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

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
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        //Re-print terminal
                        MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);

                        System.out.println("Search:" + keyword);
                        System.out.println("Search again{A}, exit search{Q}:");
                        String searchInput = scanner.nextLine();

                        switch(searchInput){
                            case "A":
                                //Clear terminal
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                //Re-print terminal
                                MainScreen(list, filterChocolate, filterJelly, filterLolly, sortNameA, sortNameD, sortPriceA, sortPriceD);
                                continue;
                            case "Q":
                                break;
                        }
                        break;
                    }
                    continue;
                //Shopping cart UI
                case "SC":
                    System.out.println("Shopping cart");
                    continue;
                //Product UI
                case "P":
                    //ADD REGEX
                    // String regex = "^[0-9]";
                    // System.out.println(data.matches(regex));

                    scanner.useDelimiter("[,\\s+]"); //Delimeter comma either space

                    System.out.print("Input product {ID, amount}:");
                    int ID = scanner.nextInt();
                    int amount = scanner.nextInt();


                    for (Product temp : file.productsObj) {
                        if(temp.ID == ID){
                            System.out.println("test");
                            temp.selectedStatus = !temp.selectedStatus;
                            if(temp.selectedStatus){
                                cart.AddTo(temp, amount);
                            }else{
                                //RaWR ;)
                            }
                        }
                    }
                    continue;
                case "E":
                    break;
            }
            break;    
        }

        
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
    
    //-------------SEARCHER TEST------------------
    // System.out.print("\033[2K\033[1G");
    // System.out.flush(); 

    // ArrayList<Product> listTest = new ArrayList<>();

    // String keyword, input, ID;

    // listTest.add(new Product(1, "kika", 2, 2, "Chocolate", "..."));
    // listTest.add(new Product(2, "kaija", 3.4, 9, "Chocolate", "..."));
    // listTest.add(new Product(3, "lapa", 1, 3, "Jelly", "..."));

    // Searcher searcher = new Searcher();

    // Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    // while (true) {
    //     System.out.print("Search:");
    //     keyword = scanner.nextLine();  // Read user input

    //     searcher.Search(listTest, keyword);

    //     System.out.println();
    //     System.out.println("Choose product {P, ID}, search agn{S}, exit search{Q}?");
    //     input = scanner.nextLine();
    //     switch(input){
    //         case "P":
    //             System.out.println("Enter product ID");
    //             ID = scanner.nextLine();
    //             break;
    //         case "S":
    //             continue;
    //         case "Q":
    //             break;
    //     }
    //     break;
    // }
    //------------------------------------------
    //  Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    
        // while (true) {
        //     System.out.print("Search:");
        //     System.out.print(keyword);
        //     keyword = keyword + scanner.next();  // Read user input

        //     for(Product temp : listTest) {
        //         if(temp.name.contains(keyword)){
        //             System.out.println(temp);
        //         }
        //     }
        //     System.out.print("\033[H\033[2J");
        //     System.out.flush();
        // }

        //Registration write test timee
        // Registration reg = new Registration();
        // User user = new User("alisetoca", "alise.toc@kk.com", "Alise", "Toča", "Valdemāra 7", "gribumajas");
        // reg.Register(user);

        // FileFunc file = new FileFunc(PathFile.PRODUCTS.getFileName());

        // // File reading test
        // file.GetAll();

        // System.out.println("Veikalā pieejamie produkti:");
        // System.out.println("---------------------------------------------------");
        // System.out.println("Products:");
        // for (Product s : file.productsObj) {
        //     System.out.println(s);
        // }

        // //File filtering test
        // System.out.println("---------------------------------------------------");
        // Filter filter = new Filter();

        // System.out.println("--Filtering:--");
        // boolean chocolateList = false;
        // boolean jellyList = true;
        // boolean lollyList = true;
        // ArrayList<Product> list = filter.FilterList(file.productsObj, chocolateList, jellyList, lollyList);
        // System.out.println("Chocolates:" + chocolateList + "\nJelly:" + jellyList + "\nLolly:" + lollyList);

        // //File sorting test
        // System.out.println("---------------------------------------------------");
        // Sorter sorter = new Sorter();

        // System.out.println("--Price sorted ASCENDING list:--");
        // sorter.SortPrice(list, false);
        // System.out.println();

        // System.out.println("--Price sorte DESCENDING list:--");
        // sorter.SortPrice(list, true);
        // System.out.println();

        // System.out.println("--Name ASCENDING sorted list:--");
        // sorter.SortName(list, false);
        // System.out.println();

        // System.out.println("--Name DESCENDING sorted list:--");
        // sorter.SortName(list, true);

        // System.exit(0);

        // // File writing test
        // Chocolates test = new Chocolates("test", 2.34, 1, "Chocolate", "Just a simple test.");
        // file.productsObj.add(test);
        // file.WriteFile(file.productsObj);

        //------- LAKYS SHOPPING CART TEST CODE----------------
        // ArrayList<Product> smthAll = new ArrayList<Product>();

        // Product testThing1 = new Chocolates("test1", 66.666, 0, "Chocolate", "sdfsdsd");
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

        // SignIn aaa = new SignIn();
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // System.out.print("Enter email: ");
        // String email = reader.readLine();
        // do{
        //     System.out.print("Enter password: ");
        //     String password = reader.readLine();

        //     aaa.LogIn(email, password);
        // } while(true);
        
        
        
    }

    public static void MainScreen(ArrayList<Product> list, boolean filterChocolate, boolean filterJelly, boolean filterLolly, boolean sortNameA, boolean sortNameD, boolean sortPriceA, boolean sortPriceD){
        String chocolates = (filterChocolate)? "X" : " ";
        String jellies = (filterJelly)? "X" : " ";
        String lollies = (filterLolly)? "X" : " ";

        String nameA = (sortNameA)? "X" : " ";
        String nameD = (sortNameD)? "X" : " ";
        String priceA = (sortPriceA)? "X" : " ";
        String priceD = (sortPriceD)? "X" : " ";

        System.out.println("""
              _____                _        _____ _                 
             / ____|              | |      / ____| |                
             | |    __ _ _ __   __| |_   _| (___ | |__   ___  _ __ 
             | |    / _` | \'_ \\ / _` | | | |\\___ \\| \'_ \\ / _ \\| \'_ \\ 
             | |___| (_| | | | | (_| | |_| |____) | | | | (_) | |_) |
              \\_____\\__,_|_| |_|\\__,_|\\__, |_____/|_| |_|\\___/| .__/ 
                                       __/ |                  | |
                                      |___/                   |_|       
                """);
        System.out.println("MAIN/PRODUCTS");
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