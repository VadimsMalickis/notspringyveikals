import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileFunc{
    String filePath;
    String type;
    ArrayList<Products> list;

    public FileFunc(String path, String type, ArrayList<Products> list){
        this.type = type;
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

    public void WriteFile(ArrayList<Products> list){

        try (BufferedWriter writter = Utils.getWriter(ProductFile.CHOCOLATES.getFileName())) {
            System.out.println("aaaa");
            writter.newLine();
            writter.write("alises želejas zobi, 10.00, 70, nav īsti zobi");
            writter.flush();
            
        } catch (Exception e) {
            System.out.println("help");
            e.printStackTrace();
        }
    }

    
    // public void WriteFile(ArrayList<Products> list){
    //     try (BufferedWriter writter = Utils.getWriter("jellys.csv")) {
    //         writter.newLine();
    //         writter.write("alises želejas zobi, 10.00, 70, nav īsti zobi");
    //         writter.flush();

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    //Prints out object
    public void check(){
        for (Products s: list){
                s.Display();
        }
    }

    public void GetAll() throws FileNotFoundException, IOException{
        ArrayList<String> CSVrows = new ArrayList<String>();

        CSVrows = ReadFile(); //[row1, row2]
        
        for (String CSVrow : CSVrows){
            Products object = new Products();

            String[] rowParts = CSVrow.split(",");
            if(type == "Chocolate"){
                object = new Chocolates();
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
    }
}