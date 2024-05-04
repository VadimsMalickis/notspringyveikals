import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class FileFunc{
    String filePath;
    ArrayList<Product> productsObj = new ArrayList<>();
    ArrayList<User> usersObj = new ArrayList<>();

    //nevis seit iestatit bet katraa vieta kur notiek darbibas ar failiem??
    public FileFunc(String path){
        filePath = path;
    }
    
    public ArrayList<String> ReadFile() throws FileNotFoundException, IOException{
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

            if (filePath.equals(PathFile.PRODUCTS.getFileName())){
                Product object = new Product();

                String[] rowParts = CSVrow.split(","); //[nosaukums, cena, daudz, kategorija, apraksts]
                String type = rowParts[4];

                if(type.equals("Chocolate")){
                    object = new Chocolates(Integer.parseInt(rowParts[0]), rowParts[1], Double.parseDouble(rowParts[2]), Integer.parseInt(rowParts[3]), type);
                }
                if(type.equals("Jelly")){
                    object = new Jellys(Integer.parseInt(rowParts[0]),rowParts[1], Double.parseDouble(rowParts[2]), Integer.parseInt(rowParts[3]), type);
                }
                if(type.equals("Lolly")){
                    object = new Lollies(Integer.parseInt(rowParts[0]),rowParts[1], Double.parseDouble(rowParts[2]), Integer.parseInt(rowParts[3]), type);
                }

                productsObj.add(object);

            }

            if (filePath.equals(PathFile.REGISTERED_USERS.getFileName())){

                String[] rowParts = CSVrow.split(","); //[username, email, name, surname, adress, password]
                User object = new User(rowParts[0], rowParts[1], rowParts[2], rowParts[3], rowParts[4], rowParts[5]);
        
                usersObj.add(object);
            }
        }
    }


    public void WriteFile(ArrayList<Product> list){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath))) {
            for(int i = 0; i < list.size(); i++){
                    Product temp = productsObj.get(i);
                    writter.write(temp.toCSV());
                    writter.newLine();
            }
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void WriteFile(User user){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath, true))) {
            writter.write(user.toString());
            writter.newLine();
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void WriteFile(HashMap<Product, Integer> list, double finalAmount, User user){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath))) {

            writter.write("----------CHECK----------");
            writter.newLine();
            for(Map.Entry m : list.entrySet()){    
                Product temp = (Product) m.getKey();
                writter.write(String.format("%20s", temp.name) + "\n.........." + String.format("%5s", temp.price) + " x " + String.format("%3s", m.getValue()));
                writter.newLine();
            } 
            writter.write("-----------------------------------------");
            writter.newLine();
            writter.write("Total price: " + String.format("%5s", finalAmount));
            writter.newLine();
            writter.write("-----------------------------------------");
            writter.newLine();
            writter.write("Shipped to: " + user.adress + "\n" + "For: " + user.name + " " + user.surname);
            writter.newLine();
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}