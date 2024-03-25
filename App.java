import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        //Chocolates
        ArrayList<Object> chocolateObjects = new ArrayList<Object>();

        Path file = Paths.get("CSV/chocolates.csv");
        String path = file.toAbsolutePath() + "";

        File chocolatesFile = new File(path, "Chocolates", chocolateObjects);

        chocolatesFile.getAll();

        System.out.println("Veikalā pieejamie produkti:");
        System.out.println("----------------------------------");
        chocolatesFile.check();

        //Jellys
        file = Paths.get("CSV/jellys.csv");
        path = file.toAbsolutePath() + "";

        ArrayList<Object> jellysObjects = new ArrayList<Object>();
        File jellysFile = new File(path, "Jellys", jellysObjects);

        jellysFile.getAll();
        jellysFile.check();

        
        // mes izlasijam jellys csv
        // List<String> jellyCsvRows = new ArrayList<>();

        // // Atgriez ArrayList ar Jellys objektiem / return List<Jellyes>
        // List<Jellys> jellysList = ProductService.getAllJellys(jellyCsvRows);

        // String rowExample = "1, sugar, 2kg, 2 euro";

        // String[] rowParts = rowExample.split(", ");

        // Jellys someJelly = new Jellys();
        // someJelly.setId(rowParts[0]);
        // someJelly.setId(rowParts[1]);
        // someJelly.setId(rowParts[2]);
        // someJelly.setId(rowParts[3]);

        // for (List<String> x : smth){
        //     Chocolates chocolates = new Chocolates();
            
        //     chocolates.name = x.get(0);
        //     chocolates.price = Double.parseDouble(x.get(1));
        //     chocolates.amountInStorage = Integer.parseInt(x.get(2));
        //     chocolates.description = x.get(3);

        //     chocolateObjects.add(chocolates);
        // }
    }
}