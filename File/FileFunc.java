import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class FileFunc{
    String filePath;

    public ArrayList<Products> chocolateObj= new ArrayList<>();
    public ArrayList<Products> jellyObj= new ArrayList<>();
    public ArrayList<Products> lollyObj= new ArrayList<>();
    public ArrayList<ArrayList<Products>> productsObj = new ArrayList<ArrayList<Products>>();

    public FileFunc(String path){
        filePath = path;

        productsObj.add(chocolateObj);
        productsObj.add(jellyObj);
        productsObj.add(lollyObj);
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

    public void GetAll() throws FileNotFoundException, IOException{
        ArrayList<String> CSVrows = new ArrayList<String>();

        CSVrows = ReadFile(); //[row1, row2]
        
        for (String CSVrow : CSVrows){
            Products object = new Products();

            String[] rowParts = CSVrow.split(","); //[nosaukums, cena, daudz,kategorija, apraksts]
            String type = rowParts[3];

            if(type.equals("Chocolate")){
                object = new Chocolates();
                chocolateObj.add(object);
            }
            if(type.equals("Jelly")){
                object = new Jellys();
                jellyObj.add(object);
            }
            if(type.equals("Lolly")){
                object = new Lollies();
                lollyObj.add(object);
            }

            object.name = rowParts[0];
            object.price = Double.parseDouble(rowParts[1]);
            object.amountInStorage = Integer.parseInt(rowParts[2]);
            object.type = type;
            object.description = rowParts[4];
        }
    }

    public void WriteFile(){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter("CSV/products.csv"))) {
            for(int i = 0; i < productsObj.size(); i++){
                for(int i2 = 0; i2 < productsObj.get(i).size(); i2++){
                    Products temp = productsObj.get(i).get(i2);
                    writter.write(temp.name + "," + temp.price + ","+ temp.amountInStorage + ","+ temp.type + ","+ temp.description);
                    writter.newLine();
                }
            }
            writter.close();         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}