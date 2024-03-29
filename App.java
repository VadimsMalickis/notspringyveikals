import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Chocolates
        // ArrayList<Products> chocolateObjects = new ArrayList<Products>();

        // Path file = Paths.get("CSV/chocolates.csv");
        // String path = file.toAbsolutePath() + "";

        // File chocolatesFile = new File(path, "Chocolate", chocolateObjects);
        // chocolatesFile.GetAll();

        // System.out.println("Veikalā pieejamie produkti:");
        // System.out.println("----------------------------------");
        // chocolatesFile.Check();

        // //Jellys
        // file = Paths.get("CSV/jellys.csv");
        // path = file.toAbsolutePath() + "";

        // ArrayList<Products> jellysObjects = new ArrayList<Products>();
        // File jellysFile = new File(path, "Jellys", jellysObjects);

        // jellysFile.GetAll();

        // System.out.println("----------------------------------");
        // jellysFile.check();
        // System.out.println();

        // //Check if Lollies obejcts were made
        // Jellys hihi = new Jellys();
        // System.out.println(hihi.count() - 1);

        //--------------------------------------
        // try (BufferedWriter writter = Utils.getWriter(ProductFile.CHOCOLATES.getFileName())) {
        //     writter.newLine();
        //     writter.write("Kikas special šokolāde,1000000.00," + new Random().nextInt(99));
        //     writter.flush();
        
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


        // try (BufferedReader reader = Utils.getReader(ProductFile.CHOCOLATES.getFileName())) {
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println(line);
        //     }

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}