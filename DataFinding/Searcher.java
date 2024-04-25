import java.util.ArrayList;

public class Searcher {
    ArrayList<Product> seachedList; //????

    public ArrayList<Product> Search(ArrayList<Product> list, String keyword){
        seachedList = new ArrayList<>();

        for(Product temp : seachedList) {
            if(temp.name.contains(keyword)){
                seachedList.add(temp);
            }
        }
        return seachedList;
    }

    // public String toString(){
    //     for(Product temp : seachedList) {
    //         String
    //     }
    //     return "";
    // }
}
