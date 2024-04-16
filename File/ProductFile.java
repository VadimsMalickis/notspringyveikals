public enum ProductFile {
    PRODUCTS("CSV/products.csv");

    private final String fileName;

    ProductFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}