import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    HashMap<Product, Integer> cartProducts;
    private double totalPrice;
    private BankAccount SHOPS_BANK_ACCOUNT = new BankAccount(0, "12345678", "214");

    public ShoppingCart(){ // constructor - when user has NO previously saved shopping cart
        cartProducts = new HashMap<Product, Integer>();
        totalPrice = 0;        
    }


    public double GetTotalPrice() { // updtaes and fixes the price
        totalPrice = 0;
        for (Map.Entry<Product, Integer> product : cartProducts.entrySet()){
            totalPrice += product.getKey().price * product.getValue();
        }
        totalPrice = Double.parseDouble(new DecimalFormat("##.##").format(totalPrice));
        return totalPrice;
    }


    public boolean AddTo(Product product){ // you can add the product only if its not in the cart, otherways u have to increase/decrease the value 

        if (product.amountInStorage == 0){
            return false; 
        } else {

            cartProducts.put(product, 1);

            totalPrice = GetTotalPrice(); // price updates
            return true; // added succesfully            
        }
    }

    public void RemoveFrom(Product product){
        cartProducts.remove(product);
        totalPrice = GetTotalPrice(); // price updates
    }

    public void SetAmount(Product product, int amountValue){ // gets triggered when user chooses the product ID and enters an amount value on ALREADY ADDED PRODUCT 
                                                            // -> it happnes in cart window not main window
        if(amountValue <=0){
            RemoveFrom(product);
        }else{
            cartProducts.put(product, amountValue);
        }
        totalPrice = GetTotalPrice();
    }


    public boolean OrderCart(User user, BankAccount usersBankAccount){ // adress - gets form logged in user, accnumber, cvv - user input
        if(usersBankAccount.Transaction(totalPrice, SHOPS_BANK_ACCOUNT)){
            FileFunc usersCheckfile = new FileFunc("Checks/" + user.username + ".csv");
            usersCheckfile.WriteFile(cartProducts, totalPrice, user);
            return true;
        } else {
            return false;
        }
    }



} // end of class