import java.math.BigDecimal;

class BankAccount {
    private double balance;
    private String owner;
    private String bankAccountNumber;
    private String cvv;
    
    // CONSTRUCTOR
    public BankAccount(double startBalance, String owner, String bankAccountNumber, String cvv) {
        balance = startBalance;
        this.owner = owner;
        this.bankAccountNumber = bankAccountNumber;
        this.cvv = cvv;

    }

    // GET METHODES -> to access private variables

    public String GetOwner(){
        return owner;
    }

    public String GetBankAccNumber(){
        return bankAccountNumber;
    }

    public String GetCVV(){
        return cvv;
    }

    public double GetBalance() {
        return SetBalance(balance);
    }

    public double SetBalance(double value) { // Checks, fixes and updates the total price
        if (value < 0) {
            System.out.println("There was an error and you have a negative balance: " + balance + ". Reach out to your bank to resolve that!");
        }
        return Math.round(value * 100.0) / 100.0;
    }


    // METODES/METHODES
    // naudas saņemšana -> atgriež true/false atkarībā no tā vai ir izdevies
    public boolean ReciveMoney(double amount) {
        if (amount > 0) {
            SetBalance( GetBalance() + amount);
            return true;
        } else {
            return false;
        }
    }

    // naudas samaksa (atņemšana) -> atgriež true/false atkarībā no tā vai ir izdevies (vai pietika naudas)
    public boolean PayMoney(BigDecimal amount) {
        if (amount.doubleValue() > 0) {
            if (balance - amount.doubleValue() < 0) {
                return false;
            } else {
                SetBalance(GetBalance() - amount.doubleValue());
                return true;
            }
        } else {
            return false;
        }
    }

    // pārsūtīt naudu uz citu akauntu -> atgriež true/false atkarībā no tā vai ir izdevies
    public boolean Transaction(BigDecimal amount, BankAccount recivingBankAccount) {
        if (PayMoney(amount)) {
            recivingBankAccount.ReciveMoney(amount.doubleValue());
            return true;
        } else {
            return false;
        }
    }
}