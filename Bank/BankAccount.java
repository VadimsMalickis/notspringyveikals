import java.util.ArrayList;

class BankAccount {
    private double balance;
    private String bankAccountNumber;
    private String cvv;
    
    // CONSTRUCTOR
    public BankAccount(double startBalance, String bankAccountNumber, String cvv) {
        balance = startBalance;
        this.bankAccountNumber = bankAccountNumber;
        this.cvv = cvv;

    }

    public double GetBalance() {
        return SetBalance(balance);
    }

    public double SetBalance(double value) {
        if (value < 0) {
            System.out.println("There was an error and you have a negative balance: " + balance + ". Reach out to your bank to resolve that!");
        }
        return Math.round(value * 100.0) / 100.0;
    }


    // METODES
    // naudas saņemšana - atgriež true/false atkarībā no tā vai ir izdevies
    public boolean ReciveMoney(double amount) {
        if (amount > 0) {
            SetBalance( GetBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    // naudas samaksa (atņemšana) - atgriež true/false atkarībā no tā vai ir izdevies (vai pietika naudas)
    public boolean PayMoney(double amount) {
        if (amount > 0) {
            if (balance - amount < 0) {
                return false;
            } else {
                SetBalance(GetBalance() - amount);
                return true;
            }
        } else {
            return false;
        }
    }

    // pārsūtīt naudu uz citu akauntu
    public boolean Transaction(double amount, BankAccount recivingBankAccount) {
        if (PayMoney(amount)) {
            recivingBankAccount.ReciveMoney(amount);
            return true;
        } else {
            return false;
        }
    }
}