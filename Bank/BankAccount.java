import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private double balance;
    private double savings;

    
    // CONSTRUCTOR
    public BankAccount(double startBalance, double savings) {
        balance = startBalance;
        this.savings = savings;
    }

    public double GetBalance(){
        balance = Double.parseDouble(new DecimalFormat("##.##").format(balance));
        return balance;
    }

    public double GetSavings(){
        savings = Double.parseDouble(new DecimalFormat("##.##").format(savings));
        return savings;
    }

    // METODES
    // naudas saņemšana - atgriež true/false atkarībā no tāi vai ir izdevies
    public boolean reciveMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    // naudas samaksa (atņemšana) - atgriež true/false atkarībā no tāi vai ir izdevies (vai pietika naudas)
    public boolean payMoney(double amount) {
        if (amount > 0) {
            if (balance - amount < 0) {
                return false;
            } else {
                setBalance(GetBalance() - amount);
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

