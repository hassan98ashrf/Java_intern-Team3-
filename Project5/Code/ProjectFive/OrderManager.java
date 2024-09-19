class OrderManager {
    private User user;
    private CartManager cartManager;
    private CartCalculator cartCalculator;
    private PaymentProcessor paymentProcessor;

    public OrderManager(User user, CartManager cartManager, CartCalculator cartCalculator, PaymentProcessor paymentProcessor) {
        this.user = user;
        this.cartManager = cartManager;
        this.cartCalculator = cartCalculator;
        this.paymentProcessor = paymentProcessor;
    }

    public void processOrder() {
        double total = cartCalculator.calculateTotal(cartManager.getItems());
        boolean paymentStatus = paymentProcessor.processPayment(total);

        if (paymentStatus) {
            System.out.println("Order processed successfully!");
            System.out.println("Order summary:");
            cartManager.getItems().forEach(item -> System.out.println(item.getQuantity() + "x " + item.getProduct().getName()));
            System.out.println("Total: $" + total);
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}