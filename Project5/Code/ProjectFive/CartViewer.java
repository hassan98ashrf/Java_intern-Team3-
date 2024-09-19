import java.util.List;

public class CartViewer {
    public void viewCart(List<CartItem> items, CartCalculator calculator) {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n--- Your Cart ---");
        items.forEach(item -> System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " - $" + item.getProduct().getPrice()));
        System.out.println("Total: $" + calculator.calculateTotal(items));
    }
}
