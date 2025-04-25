package lv.rvt.service;

import java.util.ArrayList;

public class Searcher {
    //Create list
    ArrayList<Product> searchedList = new ArrayList<>();

    //Search function
    public ArrayList<Product> Search(ArrayList<Product> list, String keyword){
        for(Product temp : list) {
            if(temp.name.toLowerCase().contains(keyword.toLowerCase())){
                searchedList.add(temp);
            }
        }
        return searchedList;
    }
}