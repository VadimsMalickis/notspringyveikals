public enum ProductFile {
    CHOCOLATES("CSV/chocolates.csv"),
    JELLYS("CSV/jellys.csv"),
    LOLLIES("CSV/lollies.csv");

    private final String fileName;

    ProductFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}