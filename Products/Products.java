class Product{
    String name;
    double price; // eur for 1 paciņa
    int amountInStorage; // amount of paciņas in storage
    String type;
    String description;

    public String toString(){
        return name + ", " + price+ ", " + amountInStorage + ", " + type + ", " + description;
    }

    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }

    //so isti envajag vairak?
    public void Display(){
        System.out.println("Nosaukums: " + name);
        System.out.println("Cena: " + price);
        System.out.println("Daudzums noliktavā: " + amountInStorage);
        System.out.println("Kategorija: " + type);
        System.out.println("Apraksts: " +  description);
        System.out.println();
    }
}