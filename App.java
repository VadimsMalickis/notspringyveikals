import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //-------FileFunc TESTING CODE------------------

        Path filePath = Paths.get("CSV/products.csv");
        FileFunc file = new FileFunc(filePath.toString());

        //File reading test
        file.GetAll();
       
        System.out.println("Veikalā pieejamie produkti:");
        System.out.println("---------------------------------------------------");
        System.out.println("Chocolate products:");
        for (Products s : file.chocolateObj) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Jelly products:");
        for (Products s : file.jellyObj) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("Lolly products:");
        for (Products s : file.lollyObj) {
            System.out.println(s);
        }

        //File filtering test
        System.out.println("---------------------------------------------------");
        Filter filter = new Filter();

        System.out.println("--Filtering:--");
        ArrayList<Products> list = filter.FilterList(file.productsObj, true, true, true);
        

        //File sorting test
        System.out.println("---------------------------------------------------");
        Sorter sorter = new Sorter();

        System.out.println("--Price sorted ASCENDING list:--");
        sorter.SortPrice(list, false);
        System.out.println();

        System.out.println("--Price sorte DESCENDING list:--");
        sorter.SortPrice(list, true);
        System.out.println();

        System.out.println("--Name ASCENDING sorted list:--");
        sorter.SortName(list, false);
        System.out.println();

        System.out.println("--Name DESCENDING sorted list:--");
        sorter.SortName(list, true);

        System.exit(0);

        //File writing test
        Chocolates test = new Chocolates();
        test.name = "test";
        test.price = 2.34;
        test.amountInStorage = 1;
        test.type = "Chocolate";
        test.description = "Just a simple test.";

        file.chocolateObj.add(test);
        file.WriteFile();

        //------- LAKYS SHOPPING CART TEST CODE----------------
        // ArrayList<Products> smthAll = new ArrayList<Products>();

        // Products testThing = new Chocolates();
        // testThing.name = "aaaa";
        // testThing.price = 666.666;
        // testThing.amountInStorage = 2;
        // testThing.description = "fdghjkl";

        // smthAll.add(testThing);

        // ShoppingCart usersShoppingCart = new ShoppingCart(smthAll);
        // System.out.print(usersShoppingCart.getTotalPrice());
    }
}