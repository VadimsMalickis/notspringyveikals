import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    FileFunc file;
    HashMap<Product, Integer> cartProducts;
    private double totalPrice;

    public ShoppingCart(){ // CONSTRUCTOR
        file = new FileFunc(PathFile.PRODUCTS.getFileName());
        cartProducts = new HashMap<Product, Integer>();
        totalPrice = 0;        
    }

    public double GetTotalPrice() { // updtaes and fixes the price, used to access the totalPrice
        totalPrice = 0;
        for (Map.Entry<Product, Integer> product : cartProducts.entrySet()){
            totalPrice += product.getKey().price * product.getValue();
        }
        totalPrice = Double.parseDouble(new DecimalFormat("##.##").format(totalPrice));
        return totalPrice;
    }

    // Adds the product to cart -> returns true/false if addition was successful
    public boolean AddTo(Product product){ // called only if the product is NOT in the cart (otherways use SetAmount methode)
        if (product.amountInStorage == 0){ // Checks if there is any product available in storage
            return false; 
        } else {
            cartProducts.put(product, 1);
            totalPrice = GetTotalPrice(); // price updates
            return true; // added successfully            
        }
    }

    // Removes product from the cart
    public void RemoveFrom(Product product){
        cartProducts.remove(product);
        totalPrice = GetTotalPrice(); // price updates
    }

    // Sets new amount to the product -> returns true/false if addition was successful
    public boolean SetAmount(Product product, int amountValue){ // gets triggered when user chooses the product ID and enters an amount value on ALREADY ADDED PRODUCT
                                                            // -> it happnes in cart window (not main window)
        if(amountValue <=0){ // Automaticaly removes product if the amount entered is 0 or below
            RemoveFrom(product);
            totalPrice = GetTotalPrice(); // price updates
            return true;
        }else if (product.amountInStorage < amountValue){ // Checks if enough of this product is available in the storage
            return false;
        } else {
            cartProducts.put(product, amountValue);
            totalPrice = GetTotalPrice(); // price updates
            return true;
        }
        
    }

    public boolean OrderCart(User user, BankAccount usersBankAccount, ArrayList<Product> list){ // adress - gets form logged in user, accnumber, cvv - user input
        if(usersBankAccount.Transaction(totalPrice, BankConst.SHOPS_BANK_ACCOUNT.GetBankAccount())){
            FileFunc usersCheckfile = new FileFunc("Checks/" + user.username + ".csv");
            usersCheckfile.WriteFile(cartProducts, totalPrice, user);

            for (Map.Entry<Product, Integer> product : cartProducts.entrySet()){
                product.getKey().amountInStorage -= product.getValue();
            }
            file.WriteFile(list);
            return true;
        } else {
            return false;
        }
    }



} // end of class