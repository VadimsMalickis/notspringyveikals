import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class File{

    String filePath;
    String type = "Chocolate";
    ArrayList list;
    Chocolates lalala = new Chocolates();
    public File(String path, String type, ArrayList list){
        filePath = path;
        this.list = list;
        
    }
    
    private ArrayList<String> ReadFile() throws FileNotFoundException, IOException{
            ArrayList<String> records = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
            while ((line = br.readLine()) != null) {
               records.add(line);
            }}
        return records;
    }


    public void getAll() throws FileNotFoundException, IOException{
        ArrayList<String> CSVrows = new ArrayList<String>();

        CSVrows = ReadFile();
        System.out.print(CSVrows);


        for (String CSVrow : CSVrows) {
            String[] rowParts = CSVrow.split(", ");

            if(type == "Chocolate"){
                Chocolates chocolateObj = new Chocolates();
                chocolateObj.name = rowParts[0];
                chocolateObj.price = Double.parseDouble(rowParts[0]);
                chocolateObj.amountInStorage = Integer.parseInt(rowParts[0]);
                chocolateObj.description = rowParts[0];
            }

            list.add(chocolateObj); //krc te kkas nasegaja ka man likas ka var saiet idk es vel pacakaresu sito lkm vnk neaiztikt
        }
        

        
        
    }

    // NEKADA GADIJUM NE_ATKOMNETE SITO HUINU SAVADK VISS SAPLIST

    // public ArrayList<Chocolates> getAllChocolates(chocolateCsvRows){
    //        // mes izlasijam jellys csv
    //        List<String> jellyCsvRows = new ArrayList<>();

    //        // Atgriez ArrayList ar Jellys objektiem / return List<Jellyes>
    //        List<Jellys> jellysList = ProductService.getAllJellys(jellyCsvRows);
   
    //        String rowExample = "1, sugar, 2kg, 2 euro";
   
    //        String[] rowParts = rowExample.split(", ");
   
    //        Jellys someJelly = new Jellys();
    //        someJelly.setId(rowParts[0]);
    //        someJelly.setId(rowParts[1]);
    //        someJelly.setId(rowParts[2]);
    //        someJelly.setId(rowParts[3]);
    // }

    
}