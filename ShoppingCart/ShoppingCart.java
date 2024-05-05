import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    FileFunc file;
    HashMap<Product, Integer> cartProducts;
    private double totalPrice;

    public ShoppingCart(){ // constructor
        file = new FileFunc(PathFile.PRODUCTS.getFileName());
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

    public boolean SetAmount(Product product, int amountValue){ // gets triggered when user chooses the product ID and enters an amount value on ALREADY ADDED PRODUCT 
                                                            // -> it happnes in cart window not main window
        if(amountValue <=0){
            RemoveFrom(product);
            totalPrice = GetTotalPrice();
            return true;
        }else if (product.amountInStorage < amountValue){
            return false;
        } else {
            cartProducts.put(product, amountValue);
            totalPrice = GetTotalPrice();
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