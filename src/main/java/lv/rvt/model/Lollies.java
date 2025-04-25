package lv.rvt.model;

class Lollies extends Product{
    // Child class of Product
    public Lollies(int ID, String name, double price, int amountInStorage, String type){
        super(ID, name, price, amountInStorage, type); // uses parent class constructor
    }   
}