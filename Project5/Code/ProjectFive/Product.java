interface Product {
    String getName();
    String getDescription();
    double getPrice();
    int getStockQuantity();
    void reduceStock(int quantity);
}