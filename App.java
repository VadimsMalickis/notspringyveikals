import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class App{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ArrayList cholotaes = new ArrayList<String>();

        File objFile = new File();
        List<List<String>> smth = objFile.ReadFile("/workspaces/notspringyveikals/CSV/chocolates.csv");


        for (List<String> x : smth){
            Chocolates chocolates = new Chocolates();
            chocolates.name = x.get(0);
            chocolates.price = Double.parseDouble(x.get(1));
            chocolates.amountInStorage = Integer.parseInt(x.get(2));
            chocolates.description = x.get(3);
        }
    }
}