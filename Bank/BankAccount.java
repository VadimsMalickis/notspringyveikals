import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private double balance;
    private double savings;
    private Map<String, Double> currencyTypes;

    
    // CONSTRUCTOR
    public BankAccount(double startBalance, double savings) {
        setBalance(startBalance); 
        setSavings(savings); 
        currencyTypes = new HashMap<String, Double>() { 
            {
                put("USD", 1.0817052);
                put("GBP", 0.8547581);
                put("JPY", 162.91697);
            }
        };

    }


    // GET SETS
    public double getBalance() {
        return balance;
    }

    public void setBalance(double value) {
        balance = Math.round(value * 100.0) / 100.0;
        if (value < 0) {
            System.out.println("There was an error and you have a negative balance: " + balance + ". Reach out to your bank to resolve that!");
        }
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double value) {
        savings = Math.round(value * 100.0) / 100.0;
    }


    // METODES
    // naudas saņemšana - atgriež true/false atkarībā no tāi vai ir izdevies
    public boolean reciveMoney(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    // naudas samaksa (atņemšana) - atgriež true/false atkarībā no tāi vai ir izdevies (vai pietika naudas)
    public boolean payMoney(double amount) {
        if (amount > 0) {
            if (getBalance() - amount < 0) {
                return false;
            } else {
                setBalance(getBalance() - amount);
                return true;
            }
        } else {
            return false;
        }
    }

    // pievienot naudu uzkrājumā - atgriež true/false atkarībā no tāi vai ir izdevies
    public boolean addToSavings(double amount) {
        if (payMoney(amount)) {
            setSavings(getSavings() + amount);
            return true;
        } else {
            return false;
        }
    }

    // pārsūtīt naudu uz citu akauntu
    public boolean transaction(double amount, BankAccount bankAccount) {
        if (payMoney(amount)) {
            bankAccount.reciveMoney(amount);
            return true;
        } else {
            return false;
        }
    }

    // nosaka, cik esošais EUR naudas daudzums būs citā lietotāja izvēlētā valūtā
    public String changeCurrency(String toCurrency) {
        if (currencyTypes.containsKey(toCurrency)) {
            return getBalance() + " EUR is " + Math.round(currencyTypes.get(toCurrency) * getBalance() * 100.0) / 100.0 + " " + toCurrency;
        } else {
            return "Converting to this currency is not available"; // ja lietotājs ievada neeksistējošu/tādu kas nav sistēmā valūtu
        }
    }
}

