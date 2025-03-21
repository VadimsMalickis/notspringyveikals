import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShoppingCart {
    FileFunc file;
    Map<Product, Integer> cartProducts;
    private BigDecimal totalPrice;

    public ShoppingCart(){ // CONSTRUCTOR
        file = new FileFunc(PathFile.PRODUCTS.getFileName());
        cartProducts = new HashMap<Product, Integer>();
        totalPrice =new BigDecimal(0);        
    }

    public BigDecimal GetTotalPrice() { // updtaes and fixes the price, used to access the totalPrice
        for (Map.Entry<Product, Integer> product : cartProducts.entrySet()){
            totalPrice.add(new BigDecimal(product.getKey().price * product.getValue()));
        }
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

    // Oredrs evrything in the cart -> returns tre/false if ordering was successful (had enough money, right bank accounts ect)
    public boolean OrderCart(User user, BankAccount usersBankAccount, List<Product> list){ 
        if(usersBankAccount.Transaction(totalPrice, BankConst.SHOPS_BANK_ACCOUNT.GetBankAccount())){ // checks if transation was successful
            FileFunc usersCheckfile = new FileFunc("Checks/" + user.username + ".txt"); // Creates a new check file with the users username
            usersCheckfile.WriteFile(cartProducts, totalPrice, user); // Writes the check file

            for (Map.Entry<Product, Integer> product : cartProducts.entrySet()){ // updates every products amountInStorage
                product.getKey().amountInStorage -= product.getValue(); 
            }

            file.WriteFile(list); // updates the product csv file with the new amounts in storage
            return true;
        } else { // if the transation fails
            return false;
        }
    }
} 