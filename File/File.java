import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Field;

class File{

    String filePath;
    String type = "Chocolate";

    ArrayList<Object> list; 
    Chocolates lalala = new Chocolates();

    public File(String path, String type, ArrayList<Object> list){
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

    //Prints out object
    public void check(){
        for (Object s: list){
           //System.out.println(s);

           //sis viss if ir Chat gpt
           if (s instanceof Chocolates) {
            Chocolates chocolateObj = (Chocolates) s;
            // Use reflection to access fields
            Field[] fields = Chocolates.class.getFields(); //get fields dabū publiskos arī inherited laukus klases
            for (Field field : fields) {
                try {
                    //field.setAccessible(true); //vinam vajadzje parmainit lauka private -> public bet nez kpc to nedairja product klasei
                    System.out.println(field.getName() + ": " + field.get(chocolateObj)); 
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        }
    }

    public void getAll() throws FileNotFoundException, IOException{
        ArrayList<String> CSVrows = new ArrayList<String>();

        CSVrows = ReadFile(); //[row1, row2]

        for (String CSVrow : CSVrows){
            String[] rowParts = CSVrow.split(",");
            if(type == "Chocolate"){
                Chocolates chocolateObj = new Chocolates();
                chocolateObj.name = rowParts[0];
                chocolateObj.price = Double.parseDouble(rowParts[1]);
                chocolateObj.amountInStorage = Integer.parseInt(rowParts[2]);
                chocolateObj.description = rowParts[3];
                list.add(chocolateObj);
            }
        }
        

        //TAVS VECAIS KODS
        // for (String CSVrow : CSVrows) {
        //     //String[] rowParts = CSVrow.split(", ");
        //     //System.out.println(rowParts.length);

        //     // if(type == "Chocolate"){
        //     //     Chocolates chocolateObj = new Chocolates();
        //     //     chocolateObj.name = rowParts[0];
        //     //     chocolateObj.price = Double.parseDouble(rowParts[0]);
        //     //     chocolateObj.amountInStorage = Integer.parseInt(rowParts[0]);
        //     //     chocolateObj.description = rowParts[0];
        //     // }

        //     //list.add(chocolateObj); //krc te kkas nasegaja ka man likas ka var saiet idk es vel pacakaresu sito lkm vnk neaiztikt
        // }
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