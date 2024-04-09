import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class FileFunc{
    private String filePath;

    public FileFunc(String path){
        filePath = path;
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
            Product object = new Product();

            String[] rowParts = CSVrow.split(","); //[nosaukums, cena, daudz, kategorija, apraksts]
            String type = rowParts[3];

            if(type.equals("Chocolate")){
                object = new Chocolates();
            }
            if(type.equals("Jelly")){
                object = new Jellys();
            }
            if(type.equals("Lolly")){
                object = new Lollies();
            }

            //sis nevar but vnk consturcotr????
            object.name = rowParts[0];
            object.price = Double.parseDouble(rowParts[1]);
            object.amountInStorage = Integer.parseInt(rowParts[2]);
            object.type = type;
            object.description = rowParts[4];

            
        }
    }

    public void WriteFile(ArrayList<Product> list){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath))) {
            for(int i = 0; i < list.size(); i++){
                    Product temp = productsObj.get(i);
                    writter.write(temp.name + "," + temp.price + ","+ temp.amountInStorage + ","+ temp.type + ","+ temp.description);
                    writter.newLine();
            }
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WriteFile(HashMap<Product, Integer> list){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath))) {
            for(int i = 0; i < list.size(); i++){
                    //!!!!!!!!!!!!!!!!!!!!!!!!!!!

                    // Product temp = productsObj.get(i);
                    // writter.write(temp.name + "," + temp.price + ","+ temp.amountInStorage + ","+ temp.type + ","+ temp.description);
                    // writter.newLine();
            }
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//{products: integer
// products2 : integer}