import java.util.ArrayList;

public class Filter {
    ArrayList<Product> filteredList = new ArrayList<>();
    
    public  ArrayList<Product> FilterList(ArrayList<Product> list,boolean chocolateList, boolean jellyList, boolean lollyList){
        if(chocolateList){
            AddList(list);
        }
        if(jellyList){
            AddList(list);
        }
        if(lollyList){
            AddList(list);
        }
        
        System.out.println("Chocolates: " + chocolateList);
        System.out.println("Jellys: " + jellyList);
        System.out.println("Lollys: " + lollyList);

        return filteredList;
    }

    private void AddList(ArrayList<Product> list){
        for (Product s : list) {
            filteredList.add(s);
        }
    }
}
