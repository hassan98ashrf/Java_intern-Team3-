import java.util.List;

public class CartCalculator {
    public double calculateTotal(List<CartItem> items) {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}

