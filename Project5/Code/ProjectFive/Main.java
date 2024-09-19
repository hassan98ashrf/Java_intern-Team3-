
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product laptop = new ConcreteProduct("Laptop", "High-end gaming laptop", 1500.00, 10);
        Product phone = new ConcreteProduct("Smartphone", "Flagship smartphone", 800.00, 20);
        Product headphones = new ConcreteProduct("Headphones", "Noise-cancelling headphones", 200.00, 15);

        // Create catalog
        Product[] catalog = {laptop, phone, headphones};

        // Create user and cart manager
        User user = new User("Hassan Ashraf", "hassan@gmail.com");
        CartManager cartManager = new CartManager();
        CartCalculator cartCalculator = new CartCalculator();
        CartViewer cartViewer = new CartViewer();
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        OrderManager orderManager = new OrderManager(user, cartManager, cartCalculator, paymentProcessor);

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 7) {
            System.out.println("\n----- Shopping Cart Menu -----");
            System.out.println("1. List of Products");
            System.out.println("2. Remove Item");
            System.out.println("3. Add Item");
            System.out.println("4. View Cart");
            System.out.println("5. Apply Discounts");
            System.out.println("6. Order Summary");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1-7): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listProducts(catalog);
                    break;
                case 2:
                    removeItem(cartManager, scanner);
                    break;
                case 3:
                    addItem(catalog, cartManager, scanner);
                    break;
                case 4:
                    cartViewer.viewCart(cartManager.getItems(), cartCalculator);
                    break;
                case 5:
                    applyDiscount(cartManager, cartCalculator);
                    break;
                case 6:
                    orderManager.processOrder();
                    break;
                case 7:
                    System.out.println("Exiting... Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid number.");
            }
        }

        scanner.close();
    }

    private static void listProducts(Product[] catalog) {
        System.out.println("\n--- Product List ---");
        for (Product product : catalog) {
            System.out.println(product);
        }
    }

    private static void addItem(Product[] catalog, CartManager cartManager, Scanner scanner) {
        System.out.print("Enter product name to add: ");
        String productName = scanner.nextLine();
        for (Product product : catalog) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                cartManager.addItem(product, quantity);
                System.out.println("Added " + quantity + " of " + product.getName() + " to cart.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    private static void removeItem(CartManager cartManager, Scanner scanner) {
        System.out.print("Enter product name to remove: ");
        String productName = scanner.nextLine();
        for (CartItem item : cartManager.getItems()) {
            if (item.getProduct().getName().equalsIgnoreCase(productName)) {
                cartManager.removeItem(item.getProduct());
                System.out.println("Removed " + productName + " from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    private static void applyDiscount(CartManager cartManager, CartCalculator cartCalculator) {
        Discount discount = new PercentageDiscount(10); // Applying 10% discount
        double total = cartCalculator.calculateTotal(cartManager.getItems());
        total = discount.applyDiscount(total);
        System.out.println("Discount applied. New total: $" + total);
    }
}
