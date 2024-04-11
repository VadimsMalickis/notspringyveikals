
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //-------FileFunc TESTING CODE------------------

        // Path filePath = Paths.get();
        // FileFunc file = new FileFunc(filePath.toString());
        FileFunc file = new FileFunc(ProductFile.PRODUCTS.getFileName());

        //File reading test
        file.GetAll();
        System.out.println("Veikalā pieejamie produkti:");
        System.out.println("---------------------------------------------------");
        System.out.println("Products:");
        for (Product s : file.productsObj) {
            System.out.println(s);
        }

        // //File filtering test
        // System.out.println("---------------------------------------------------");
        // Filter filter = new Filter();

        // System.out.println("--Filtering:--");
        // ArrayList<Products> list = filter.FilterList(file.productsObj, true, true, true);
        

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

        // //File writing test
        // Chocolates test = new Chocolates();
        // test.name = "test";
        // test.price = 2.34;
        // test.amountInStorage = 1;
        // test.type = "Chocolate";
        // test.description = "Just a simple test.";

        // file.chocolateObj.add(test);
        // file.WriteFile();

        //------- LAKYS SHOPPING CART TEST CODE----------------
        // ArrayList<Product> smthAll = new ArrayList<Product>();

        // Product testThing1 = new Chocolates();
        // testThing1.name = "aaaa";
        // testThing1.price = 666.666;
        // testThing1.amountInStorage = 0;
        // testThing1.description = "fdghjkl";
        
        // Product testThing2 = new Jellys();
        // testThing2.name = "bbbbb";
        // testThing2.price = 5.66;
        // testThing2.amountInStorage = 2;
        // testThing2.description = "fdghjkl";

        // Product testThing3 = new Jellys();
        // testThing3.name = "bbbbb";
        // testThing3.price = 1;
        // testThing3.amountInStorage = 20;
        // testThing3.description = "fdghjkl";




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