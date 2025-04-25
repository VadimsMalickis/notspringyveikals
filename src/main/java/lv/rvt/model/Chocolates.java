package lv.rvt.model;

class Chocolates extends Product{
    // Child class of Product 
    public Chocolates(int ID, String name, double price, int amountInStorage, String type){
        super(ID, name, price, amountInStorage, type); // uses parent class constructor
    }   
}