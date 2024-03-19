import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ArrayList<Chocolates> chocolateObjects = new ArrayList<Chocolates>();

        File chocolatesFile = new File("/workspaces/notspringyveikals/CSV/chocolates.csv", "'smth'", chocolateObjects);
        // ArrayList<String> smth = 
        chocolatesFile.getAll();

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