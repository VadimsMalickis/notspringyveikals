package src.main.java.lv.rvt.service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class FileManager {
    String filePath;
    ArrayList<Product> productsObj;
    ArrayList<User> usersObj;

    public FileManager(String path) {
        filePath = path;
        productsObj = new ArrayList<>();
        usersObj = new ArrayList<>();
    }
    
    public void GetAll() throws FileNotFoundException, IOException{
        ArrayList<String> csvRows = new ArrayList<String>();
        csvRows = readFile();
        
        for (String CSVrow : csvRows){

            if (filePath.equals(PathFile.PRODUCTS.getFileName())) {
                Product object = new Product();
                String[] rowParts = CSVrow.split(",");
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

            if (filePath.equals(PathFile.REGISTERED_USERS.getFileName())){ // Users

                String[] rowParts = CSVrow.split(",");
                User object = new User(rowParts[0], rowParts[1], rowParts[2], rowParts[3], rowParts[4], rowParts[5]);
        
                usersObj.add(object);
            }
        }
    }

    // Updates/Writes the file with products
    public void WriteFile(List<Product> list){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath))) {
            for (Product temp : list){
                writter.write(temp.toCSV());
                writter.newLine();
            }            
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Updates/Writes the file with registered users
    public void WriteFile(User user){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath, true))) {
            writter.write(user.toString());
            writter.newLine();
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    // Writes the check for the user
    public void WriteFile(Map<Product, Integer> list, BigDecimal finalAmount, User user){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(filePath))) {

            writter.write("----------CHECK----------");
            writter.newLine();
            for(Map.Entry<Product, Integer> m : list.entrySet()){  // Writes all the purchased items
                Product temp = (Product) m.getKey();
                writter.write(String.format("%20s", temp.name) + "\n.........." + String.format("%5s", temp.price) + " x " + String.format("%3s", m.getValue()));
                writter.newLine();
            } 
            writter.write("-----------------------------------------");
            writter.newLine();
            writter.write("Total price: " + String.format("%5s", finalAmount)); // The final price
            writter.newLine();
            writter.write("-----------------------------------------");
            writter.newLine();
            writter.write("Shipped to: " + user.adress + "\n" + "For: " + user.name + " " + user.surname); // Uers infomation -> Name and adress
            writter.newLine();
            writter.close(); 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> readFile() throws FileNotFoundException, IOException{
        ArrayList<String> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            records.add(line);
        }
        br.close();
           
        return records;
    }
}