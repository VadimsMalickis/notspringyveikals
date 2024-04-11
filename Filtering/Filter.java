import java.util.ArrayList;

public class Filter {
    ArrayList<Product> filteredList = new ArrayList<>();
    
    // ArrayList<Product> chocolateObj = new ArrayList<>();
    // ArrayList<Product> jellyObj = new ArrayList<>();
    // ArrayList<Product> lollyObj = new ArrayList<>();

    public  ArrayList<Product> FilterList(ArrayList<Product> list, boolean chocolateList, boolean jellyList, boolean lollyList){
        for (int i = 0; i < list.size(); i++) {
            Product s = list.get(i);
            String type = s.type;
            System.out.println(type);

            if(type == "Chocolate" && chocolateList){
                filteredList.add(list.get(i));
                System.out.println("cg");
            }
            if(type == "Jelly" && jellyList){
                filteredList.add(list.get(i));
            }
             if(type == "Lolly" && lollyList){
                filteredList.add(list.get(i));
            }
        }

        return filteredList;
    }
}
