import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Chocolates
        ArrayList<Object> chocolateObjects = new ArrayList<Object>();

        // Path file = Paths.get("CSV/chocolates.csv");
        // String path = file.toAbsolutePath() + "";

        try (BufferedWriter writter = Utils.getWriter(ProductFile.CHOCOLATES.getFileName())) {
            writter.newLine();
            writter.write("Kikas special šokolāde,1000000.00," + new Random().nextInt(99));
            writter.flush();
        
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader reader = Utils.getReader("CSV/chocolates.csv")) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        File chocolatesFile = new File(ProductFile.CHOCOLATES.getFileName(), "Chocolates", chocolateObjects);
        chocolatesFile.WriteFile();

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