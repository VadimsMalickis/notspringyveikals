class Product{
    // Parent class of all products
    int ID;
    String name;
    double price; // Price for 1 paciņa
    int amountInStorage; // amount of paciņas in storage
    String type;
    boolean selectedStatus;    

    //CONSTRUCTOR
    public Product(int ID, String name, double price, int amountInStorage, String type){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.amountInStorage = amountInStorage;
        this.type = type;
    }

    //CONSTRUCTOR
    public Product(){}  

    //Automatic output format
    public String toString(){
        String selected = (selectedStatus)? "X" : " ";
        String outOfStock = (amountInStorage <= 0)? "Out of stock" : "";

        return String.format("%4s", ID) + "|" +  String.format("%20s", name) + "|" + String.format("%11s", type) + "|" + String.format("%7.2f", price) + "   [" + selected +"] " + outOfStock;
    }

    //Formatt product to be written in CSV
    public String toCSV(){
        return ID + "," + name + "," + price+ "," + amountInStorage + "," + type;
    }

    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
}