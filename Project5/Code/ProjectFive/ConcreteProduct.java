class ConcreteProduct implements Product {
    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    public ConcreteProduct(String name, String description, double price, int stockQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public void reduceStock(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
        } else {
            throw new IllegalArgumentException("Not enough stock available.");
        }
    }

    @Override
    public String toString() {
        return name + " - " + description + " - $" + price + " - In stock: " + stockQuantity;
    }
}