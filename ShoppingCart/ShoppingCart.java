
import java.text.DecimalFormat;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    Map<Products, Integer> cartProducts;
    private double totalPrice;


    public ShoppingCart(HashMap<Products, Integer> cartProducts){ // constructor - when user has previously saved shopping cart
        this.cartProducts = cartProducts;
        totalPrice = GetTotalPrice();

    }

    public ShoppingCart(){ // constructor - when user has NO previously saved shopping cart
        this(new HashMap<Products, Integer>());
        totalPrice = 0;
    }


    public double GetTotalPrice() { // updtaes and fixes the price
        totalPrice = 0;
        for (Map.Entry<Products, Integer> addedProduct : cartProducts.entrySet()){
            totalPrice += addedProduct.getKey().price * addedProduct.getValue();
        }
        totalPrice = Double.parseDouble(new DecimalFormat("##.##").format(totalPrice));
        return totalPrice;
    }


    public void AddTo(Products product, int amount){ // you can add the product only if its not in the cart, otherways u have to increase/decrease the value 

        if (product.amountInStorage == 0){
             System.out.println("This product is out of stock! :(");
        } else 
        
        if (amount <= product.amountInStorage && amount > 0){
                cartProducts.put(product, amount);
        } else {
            System.out.println("Invalid amount entered");
        }

        // might have to add GetTotalPrice() so price updates
    }



    public void SetAmount(Products product, int amountValue){ // gets triggered when user preses +/- or enters an amount value on ALREADY ADDED PRODUCT 
                                                             // -> it happnes in cart window not main search/product window

        // first it needs to get/accses the value entered in the websites field and assign it to a variable(amountValue) <- cant do that yet cuz no web

        // then it just sets the specifics products(hashmap key) amount in cart(hasmap value) to that acsesed number(amountValue)

        if (amountValue == 0){
            cartProducts.remove(product);
        }if (amountValue <= product.amountInStorage){
            cartProducts.replace(product, amountValue);
        }else{
            System.out.println("Invalid amount entered");
        }
        // might have to add GetTotalPrice() so price updates
    }



} // end of class