public enum BankConst {
    
    SHOPS_BANK_ACCOUNT(new BankAccount(0, "13033101", "600")),

    private final BankAccount bankAcc;

    BankConst(BankAccount bankAcc) {
        this.bankAcc = bankAcc;
    }

    public BankAccount getFileName() {
        return this.bankAcc;
    }
}
