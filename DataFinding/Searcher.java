import java.util.ArrayList;

public class Searcher {
    public void Search(ArrayList<Product> list, String keyword){
        for(Product temp : list) {
            if(temp.name.contains(keyword)){
                System.out.println(temp);
            }
        }
    }
}
