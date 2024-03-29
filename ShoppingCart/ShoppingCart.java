
import java.text.DecimalFormat;
import java.util.ArrayList;

class ShoppingCart {
    ArrayList<Products> cartProducts;
    private double totalPrice;


    public ShoppingCart(ArrayList<Products> cartProducts){ // constructor - when user has previously saved shopping cart
        this.cartProducts = cartProducts;
        for (Products product : cartProducts){
            totalPrice =+ product.price;
        }
    }

    public ShoppingCart(){ // constructor - when user has NO previously saved shopping cart
        this(new ArrayList<Products>());

    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice() {

        for (Products product : cartProducts){
            totalPrice =+ product.price;
        }

        totalPrice = Double.parseDouble(new DecimalFormat("##.##").format(totalPrice));
    }
}
