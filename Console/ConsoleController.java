import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleController {
    // Class with methodes for proper console output

    public void clearAll(){ // clears the whole console
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }

    public void MoveCursor(int row, int column){ // Moves cursor to requested line/row and column
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df", escCode, row, column));
    }

    public void clearOneLine(int row){ // Clears only the requested line/row
        MoveCursor(row, 0);
        System.out.print("\033[2K\033[1G");
        System.out.flush(); 
    }

    public void Title(){ 
        System.out.println(" _____                 _         _____ _                       " + TextColor.ANSI_RESET.getValue());
        System.out.println("/  __ \\               | |       /  ___| |       " + TextColor.PURPLE.getValue() + "              ___      .-\"\"-.      ___" + TextColor.ANSI_RESET.getValue());
        System.out.println("| /  \\/ __ _ _ __   __| |_   _  \\ `--.| |__   ___  _ __     " + TextColor.PURPLE.getValue() + "  \\  \"-.  /      \\  .-\"  /" + TextColor.ANSI_RESET.getValue());
        System.out.println("| |    / _` | '_ \\ / _` | | | |  `--. \\ '_ \\ / _ \\| '_ \\  " + TextColor.PURPLE.getValue() + "     > -=.\\/        \\/.=- <"+ TextColor.ANSI_RESET.getValue());
        System.out.println("| \\__/\\ (_| | | | | (_| | |_| | /\\__/ / | | | (_) | |_) |  " + TextColor.PURPLE.getValue() + "    > -='/\\        /\\'=- <"+ TextColor.ANSI_RESET.getValue());
        System.out.println( " \\____/\\__,_|_| |_|\\__,_|\\__, | \\____/|_| |_|\\___/| .__/  " + TextColor.PURPLE.getValue() + "    /__.-'  \\      /  '-.__\\"+ TextColor.ANSI_RESET.getValue());
        System.out.println("                          __/ |                   | |            " + TextColor.PURPLE.getValue() + "      '-..-'" + TextColor.ANSI_RESET.getValue());
        System.out.println("                         |___/                    |_|          " + TextColor.ANSI_RESET.getValue());
    }

    public void SignInScreen(){
        Title();
        System.out.println( "SIGN IN");
        System.out.println(TextColor.PURPLE.getValue() + "+".repeat(100) + TextColor.ANSI_RESET.getValue());

    }

    // Prints out nessesary things for main screen
    public void MainScreen(User user, List<Product> list, boolean filterChocolate, boolean filterJelly, boolean filterLolly, boolean sortNameA, boolean sortNameD, boolean sortPriceA, boolean sortPriceD){
        // Sets the values to checked or not checked
        String chocolates = (filterChocolate)? "X" : " ";
        String jellies = (filterJelly)? "X" : " ";
        String lollies = (filterLolly)? "X" : " ";

        String nameA = (sortNameA)? "X" : " ";
        String nameD = (sortNameD)? "X" : " ";
        String priceA = (sortPriceA)? "X" : " ";
        String priceD = (sortPriceD)? "X" : " ";
        
        Title();

        System.out.println("MAIN/PRODUCTS                         You are logged in as: " + String.format("%-20s", user.username)  + "        EXIT APP {E}");
        System.out.println(TextColor.PURPLE.getValue() + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + TextColor.ANSI_RESET.getValue());
        System.out.println("FILTER {F}    \t\t SORT {SO}    \t\t SEARCH {S}    \t\t VIEW SHOPPING CART{SC}");
        System.out.println("["+ chocolates +"] Chocolates\t\t ["+ nameA +"] Name A-Z");
        System.out.println("["+ jellies +"] Jellies   \t\t ["+ nameD +"] Name Z-A");
        System.out.println("["+ lollies +"] Lollies   \t\t ["+ priceA +"] Price <");
        System.out.println("              \t\t ["+ priceD +"] Price >");
        System.out.println(TextColor.PURPLE.getValue() + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + TextColor.ANSI_RESET.getValue());

        System.out.println("ADD PRODUCT TO SHOPPING CART{P}");
        System.out.println(String.format("%4s", "ID") + "|" +  String.format("%20s", "Name") + "|" + String.format("%11s", "Type") + "|" + String.format("%7s", "Price"));
        System.out.println("----------------------------------------------");
        for (Product temp : list) { // Prints out all items available in shop + [ ] if they are in the shopping cart
            System.out.println(temp);
        }
        System.out.println(TextColor.PURPLE.getValue() + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + TextColor.ANSI_RESET.getValue());
    }

    // Prints out nessesary things for Shopping Cart screen
    public void ShoppingCartScreen(ShoppingCart cart){

        Map<Product, Integer> cartProducts = cart.cartProducts;
        Title();

        System.out.println("YOUR SHOPPING CART                                       GO TO MAIN PAGE {M}            EXIT APP {E}");
        System.out.println(TextColor.PURPLE.getValue() +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + TextColor.ANSI_RESET.getValue());
        System.out.println("EDIT PRODUCTS {P}                                          TOTAL PRICE: " + String.format("%4s", cart.GetTotalPrice())  + "        PAY & ORDER {O}");
        System.out.println(String.format("%4s", "ID") + "|" +  String.format("%20s", "Name") + "|" + String.format("%11s", "Type") + "|" + String.format("%7s", "Price") + "|" + String.format("%17s", "Amount in cart") + "|");
        System.out.println("------------------------------------------------------------------");
        for (Map.Entry<Product, Integer> product : cartProducts.entrySet()){ // Prints out all items in shopping cart + amount of them
            System.out.print(product.getKey());
            System.out.println(String.format("%12s", product.getValue()) + "|");
        }
        
        System.out.println(TextColor.PURPLE.getValue() +"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ TextColor.ANSI_RESET.getValue());
    }

}