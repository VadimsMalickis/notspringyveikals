import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {
    //Sort based on price
    public void SortPrice(ArrayList<Products> list, boolean reversed){
        if(!reversed){
            Collections.sort(list, Comparator.comparingDouble(Products::getPrice));
        }else{
            Collections.sort(list, Comparator.comparingDouble(Products::getPrice).reversed());
        }
        
        for (Products temp: list) {
            System.out.println(temp);
        }
    }

    //Sort based on name
    public void SortName(ArrayList<Products> list, boolean reversed){
        if(!reversed){
            list.sort((o1, o2) -> o1.getName().compareTo(o2.getName())); //lambda   (parameters) -> expression
        }else{
            list.sort(Collections.reverseOrder((o1, o2) -> o1.getName().compareTo(o2.getName())));
        }
    
        for (Products temp: list) {
            System.out.println(temp);
        }
    }
}