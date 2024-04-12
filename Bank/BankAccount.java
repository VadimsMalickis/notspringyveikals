class BankAccount {
    private double balance;
    private String bankAccountNumber;

    
    // CONSTRUCTOR
    public BankAccount(double startBalance, double savings, String bankAccountNumber) {
        balance = startBalance;
        this.bankAccountNumber = bankAccountNumber;
    }

    public double GetBalance() {
        return balance;
    }

    public void SetBalance(double value) {
        balance = Math.round(value * 100.0) / 100.0;
        if (value < 0) {
            System.out.println("There was an error and you have a negative balance: " + balance + ". Reach out to your bank to resolve that!");
        }
    }


    // METODES
    // naudas saņemšana - atgriež true/false atkarībā no tāi vai ir izdevies
    public boolean ReciveMoney(double amount) {
        if (amount > 0) {
            SetBalance( GetBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    // naudas samaksa (atņemšana) - atgriež true/false atkarībā no tāi vai ir izdevies (vai pietika naudas)
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
    public boolean transaction(double amount, BankAccount bankAccount) {
        if (PayMoney(amount)) {
            bankAccount.ReciveMoney(amount);
            return true;
        } else {
            return false;
        }
    }

}

