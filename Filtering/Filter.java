import java.util.ArrayList;

public class Filter {
    ArrayList<Product> filteredList = new ArrayList<>();
    
    public  ArrayList<Product> FilterList(ArrayList<ArrayList<Product>> list,boolean chocolateList, boolean jellyList, boolean lollyList){
        if(chocolateList){
            for (Product s : list.get(0)) {
                filteredList.add(s);
            }
        }
        if(jellyList){
            for (Product s : list.get(1)) {
                filteredList.add(s);
            }
        }
        if(lollyList){
            for (Product s : list.get(2)) {
                filteredList.add(s);
            }
        }
        System.out.println("Chocolates: " + chocolateList);
        System.out.println("Jellys: " + jellyList);
        System.out.println("Lollys: " + lollyList);
        
        return filteredList;
    }
}
