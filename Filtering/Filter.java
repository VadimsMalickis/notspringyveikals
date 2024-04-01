import java.util.ArrayList;

public class Filter {
    ArrayList<Products> filteredList = new ArrayList<>();
    
    public  ArrayList<Products> FilterList(ArrayList<ArrayList<Products>> list,boolean chocolateList, boolean jellyList, boolean lollyList){
        if(chocolateList){
            for (Products s : list.get(0)) {
                filteredList.add(s);
            }
        }
        if(jellyList){
            for (Products s : list.get(1)) {
                filteredList.add(s);
            }
        }
        if(lollyList){
            for (Products s : list.get(2)) {
                filteredList.add(s);
            }
        }
        System.out.println("Chocolates: " + chocolateList);
        System.out.println("Jellys: " + jellyList);
        System.out.println("Lollys: " + lollyList);
        return filteredList;
    }
}
