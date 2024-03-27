import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class File{

    String filePath;
    String type;
    ArrayList<Object> list;

    public File(String path, String type, ArrayList<Object> list){
        this.type = type;
        filePath = path;
        this.list = list; //Padodam tukdu lidt or jua aizpilditu?? aizpilditu ar ko? (bet anyway i think tuksu jo nav isti jegas no aizpildita)
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
                ((Products) s).Display();
        }
    }

    public void getAll() throws FileNotFoundException, IOException{
        ArrayList<String> CSVrows = new ArrayList<String>();

        CSVrows = ReadFile(); //[row1, row2]
        
        for (String CSVrow : CSVrows){
            Products object = new Products();

            String[] rowParts = CSVrow.split(",");
            if(type == "Chocolate"){
                object = new Chocolates();
                // Chocolates chocolateObj = new Chocolates();
                // chocolateObj.name = rowParts[0];
                // chocolateObj.price = Double.parseDouble(rowParts[1]);
                // chocolateObj.amountInStorage = Integer.parseInt(rowParts[2]);
                // chocolateObj.description = rowParts[3];
                // list.add(chocolateObj);
            }
            if(type == "Jellys"){
                object = new Jellys();
            }
            if(type == "Lollies"){
                object = new Lollies();
            }

            object.name = rowParts[0];
            object.price = Double.parseDouble(rowParts[1]);
            object.amountInStorage = Integer.parseInt(rowParts[2]);
            object.description = rowParts[3];
            list.add(object);
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