public enum TextColor {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    PURPLE("\u001B[35m"),  
    ANSI_RESET("\u001B[0m");
    
    private final String colour;
    
    TextColor(String colour) {
        this.colour = colour;
    }
    
    public String getValue() {
        return this.colour;
    }
}