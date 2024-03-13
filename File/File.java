import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class File{
    
    public ArrayList<String> ReadFile(String file) throws FileNotFoundException, IOException{
            ArrayList<String> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
            while ((line = br.readLine()) != null) {
               records.add(line);
            }}
        return records;
    }

    public ArrayList<Chocolates> getAllChocolates(chocolateCsvRows){
           // mes izlasijam jellys csv
           List<String> jellyCsvRows = new ArrayList<>();

           // Atgriez ArrayList ar Jellys objektiem / return List<Jellyes>
           List<Jellys> jellysList = ProductService.getAllJellys(jellyCsvRows);
   
           String rowExample = "1, sugar, 2kg, 2 euro";
   
           String[] rowParts = rowExample.split(", ");
   
           Jellys someJelly = new Jellys();
           someJelly.setId(rowParts[0]);
           someJelly.setId(rowParts[1]);
           someJelly.setId(rowParts[2]);
           someJelly.setId(rowParts[3]);
    }
}