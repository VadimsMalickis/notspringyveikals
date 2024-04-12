import java.util.ArrayList;

public class Filter {
    ArrayList<Product> filteredList = new ArrayList<>();

    public  ArrayList<Product> FilterList(ArrayList<Product> list, boolean chocolateList, boolean jellyList, boolean lollyList){
        for (int i = 0; i < list.size(); i++) {
            String type =  list.get(i).type;

            if(type.equals("Chocolate") && chocolateList){
                filteredList.add(list.get(i));
            }
            if(type.equals("Jelly") && jellyList){
                filteredList.add(list.get(i));
            }
             if(type.equals( "Lolly") && lollyList){
                filteredList.add(list.get(i));
            }
        }

        return filteredList;
    }
}
