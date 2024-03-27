
import java.util.ArrayList;

class ShoppingCart {
    ArrayList<Products> cartProducts;
    double totalPrice;


    public ShoppingCart(ArrayList<Products> cartProducts){ // constructor - when user has previously saved shopping cart
        this.cartProducts = cartProducts;
        totalPrice = 0;



    }

    public ShoppingCart(){ // constructor - when user has NO previously saved shopping cart
        this(new ArrayList<Products>());

    }


    public double getTotalPrice() {
        return totalPrice;
    }

    // Setter method for savings
    public void setTotalPrice(double value) {

        for (Products product : cartProducts){
            totalPrice =+ product.price;
        }

        totalPrice = Math.round(value * 100.0) / 100.0;
    }
}
