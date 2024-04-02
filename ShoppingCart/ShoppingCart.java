
import java.text.DecimalFormat;
import java.util.ArrayList;

class ShoppingCart {
    ArrayList<Products> cartProducts;
    private double totalPrice;


    public ShoppingCart(ArrayList<Products> cartProducts){ // constructor - when user has previously saved shopping cart
        this.cartProducts = cartProducts;
        for (Products product : cartProducts){
            totalPrice += product.price;
        }
    }

    public ShoppingCart(){ // constructor - when user has NO previously saved shopping cart
        this(new ArrayList<Products>());
        totalPrice = 0;
    }


    public double GetTotalPrice() {
        totalPrice = Double.parseDouble(new DecimalFormat("##.##").format(totalPrice));
        return totalPrice;
    }


    public void AddTo(Products product, int amount){

        for (int i = 0; i < amount; i++) {
            cartProducts.add(product);
            totalPrice += product.price;
        }


    }

    public void RemoveFrom(Products product, int amount){

        for (int i = 0; i < amount; i++) {
            cartProducts.remove(product);
            totalPrice -= product.price;
        }

    }

}
