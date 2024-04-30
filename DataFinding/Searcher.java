import java.util.ArrayList;

public class Searcher {
    ArrayList<Product> searchedList = new ArrayList<>();

    public ArrayList<Product> Search(ArrayList<Product> list, String keyword){
        for(Product temp : list) {
            if(temp.name.contains(keyword)){
                searchedList.add(temp);
            }
        }
        return searchedList;
    }
}
