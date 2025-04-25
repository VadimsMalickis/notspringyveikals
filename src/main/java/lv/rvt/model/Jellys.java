package src.main.java.lv.rvt.model;
class Jellys extends Product{
    // Child class of Produc
    public Jellys(int ID, String name, double price, int amountInStorage, String type){
        super(ID, name, price, amountInStorage, type); // uses parent class constructor
    }   
}