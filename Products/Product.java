class Product{
    int ID;
    String name;
    double price; // eur for 1 paciņa
    int amountInStorage; // amount of paciņas in storage
    String type;
    boolean selectedStatus;
    

    public Product(int ID, String name, double price, int amountInStorage, String type){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.amountInStorage = amountInStorage;
        this.type = type;
    }

    public Product(){} //!!!!!!!!!!!!!!!

    public String toString(){
        return String.format("%4s", ID) + "|" +  String.format("%20s", name) + "|" + String.format("%7.2f", price);
    }

    public String toCSV(){
        return ID + "," + name + "," + price+ "," + amountInStorage + "," + type;
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