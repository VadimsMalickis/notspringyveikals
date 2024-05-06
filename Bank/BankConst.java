public enum BankConst {
    // Enum class with constant Bank variables/fields
    
    SHOPS_BANK_ACCOUNT(new BankAccount(0, "CANDYSHOP", "13033101", "606")); // Shops bank account

    private final BankAccount bankAcc;

    BankConst(BankAccount bankAcc) {
        this.bankAcc = bankAcc;
    }

    public BankAccount GetBankAccount() {
        return this.bankAcc;
    }
}
