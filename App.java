import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //-------ALISES TESTING CODE------------------

        ArrayList<Product> listTest = new ArrayList<>();
        String keyword;

        listTest.add(new Product("kika", 2, 2, "Chocolate", "..."));
        listTest.add(new Product("kaija", 3.4, 9, "Chocolate", "..."));
        listTest.add(new Product("lapa", 1, 3, "Jelly", "..."));

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Search:");
        while (true) {
            keyword = System.in.read();  // Read user input

            for(Product temp : listTest) {
                if(temp.name.contains(keyword)){
                    System.out.println(temp);
                }
            }
        }

        //Registration write test timee
        // Registration reg = new Registration();
        // User user = new User("alisetoca", "alise.toc@kk.com", "Alise", "Toča", "Valdemāra 7", "gribumajas");
        // reg.Register(user);

        // FileFunc file = new FileFunc(PathFile.PRODUCTS.getFileName());

        //File reading test
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

        //File writing test
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
    }
}