class Product{
    int ID;
    String name;
    double price; // eur for 1 paciņa
    int amountInStorage; // amount of paciņas in storage
    String type;
    String description;
    boolean selectedStatus;
    

    public Product(int ID, String name, double price, int amountInStorage, String type, String description){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.amountInStorage = amountInStorage;
        this.type = type;
        this.description = description;
    }

    public Product(){} //!!!!!!!!!!!!!!!

    public String toString(){
        return ID + "," + name + "," + price+ "," + amountInStorage + "," + type + "," + description;
    }

    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }

    // public void Display(){
    //     System.out.println("Nosaukums: " + name);
    //     System.out.println("Cena: " + price);
    //     System.out.println("Daudzums noliktavā: " + amountInStorage);
    //     System.out.println("Kategorija: " + type);
    //     System.out.println("Apraksts: " +  description);
    //     System.out.println();
    // }
}