public enum BankConst {
    
    SHOPS_BANK_ACCOUNT(new BankAccount(0, "CANDYSHOP", "13033101", "606"));

    private final BankAccount bankAcc;

    BankConst(BankAccount bankAcc) {
        this.bankAcc = bankAcc;
    }

    public BankAccount GetBankAccount() {
        return this.bankAcc;
    }
}
