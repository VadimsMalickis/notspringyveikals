import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Chocolates
        ArrayList<Products> chocolateObjects = new ArrayList<Products>();

        // Path file = Paths.get("CSV/chocolates.csv");
        // String path = file.toAbsolutePath() + "";

        // try (BufferedWriter writter = Utils.getWriter(ProductFile.CHOCOLATES.getFileName())) {
        //     writter.newLine();
        //     writter.write("Kikas special šokolāde,1000000.00," + new Random().nextInt(99));
        //     writter.flush();
        
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


        // try (BufferedReader reader = Utils.getReader("CSV/chocolates.csv")) {
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println(line);
        //     }

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }


        // LAKYS SHOPPING CART TEST CODE
        // ArrayList<Products> smthAll = new ArrayList<Products>();

        // Products testThing = new Chocolates();
        // testThing.name = "aaaa";
        // testThing.price = 666.666;
        // testThing.amountInStorage = 2;
        // testThing.description = "fdghjkl";

        // smthAll.add(testThing);

        // ShoppingCart usersShoppingCart = new ShoppingCart(smthAll);
        // System.out.print(usersShoppingCart.getTotalPrice());
        







































        // File chocolatesFile = new File(path, "Chocolates", chocolateObjects);

        // chocolatesFile.GetAll();

        // System.out.println("Veikalā pieejamie produkti:");
        // System.out.println("----------------------------------");
        // chocolatesFile.check();

        // //Jellys
        // file = Paths.get("CSV/jellys.csv");
        // path = file.toAbsolutePath() + "";

        // ArrayList<Object> jellysObjects = new ArrayList<Object>();
        // File jellysFile = new File(path, "Jellys", jellysObjects);

        // jellysFile.GetAll();

        // System.out.println("----------------------------------");
        // jellysFile.check();
        // System.out.println();

        // //Check if Lollies obejcts were made
        // Jellys hihi = new Jellys();
        // System.out.println(hihi.count() - 1);
    }
}