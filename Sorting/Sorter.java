import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {
    public void SortName(ArrayList<Products> list){
        // Collections.sort(list, Comparator.comparingString(Products::getName));

        // for (Products temp: list) {
        //     System.out.println(temp);
        // }
    }

    public void SortPrice(ArrayList<Products> list){
        Collections.sort(list, Comparator.comparingDouble(Products::getPrice));

        for (Products temp: list) {
            System.out.println(temp);
        }
    }
}
