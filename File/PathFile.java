public enum PathFile {
    PRODUCTS("CSV/products.csv"),
    REGISTERED_USERS("CSV/registeredUsers.csv");

    private final String fileName;

    PathFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}