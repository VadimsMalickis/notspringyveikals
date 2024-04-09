import java.util.ArrayList;

public class Filter {
    ArrayList<Product> filteredList = new ArrayList<>();
    
    public  ArrayList<Product> FilterList(ArrayList<Product> list,boolean chocolateList, boolean jellyList, boolean lollyList){
        //RE-DO FILTER
        
        // if(chocolateList){
        //     for (Product s : Products.getChocolates()) {
        //         filteredList.add(s);
        //     }
        // }
        // if(jellyList){
        //     for (Product s : Products.getJelly()) {
        //         filteredList.add(s);
        //     }
        // }
        // if(lollyList){
        //     for (Product s : Products.getLollies()) {
        //         filteredList.add(s);
        //     }
        // }
        System.out.println("Chocolates: " + chocolateList);
        System.out.println("Jellys: " + jellyList);
        System.out.println("Lollys: " + lollyList);

        return filteredList;
    }
}
