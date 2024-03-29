class Products{
    String name;
    double price;
    int amountInStorage;
    String description;

    // public Products(String name, double price, int amountInStorage, String description){
    //     this.name = name;
    //     this.price = price;
    //     this.amountInStorage = amountInStorage;
    //     this.description = description;
    // }


    public String toString(){
        return "{name},{price},{amountInSotrage},{description}";
    }

    public void Display(){
        System.out.println("Nosaukums: " + name);
        System.out.println("Cena: " + price);
        System.out.println("Daudzums noliktavā: " + amountInStorage);
        System.out.println("Apraksts: " +  description);
        System.out.println();
    }
}