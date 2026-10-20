package week7Assignment;

/**
 * Problem 5: The Shopping Cart
 * Scenario: An online store's cart holds the prices of items you're about to buy.
 */
public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public boolean addItem(double price) {
        if (itemCount < prices.length && price >= 0) {
            prices[itemCount] = price;
            itemCount++;
            return true;
        }
        return false;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + (int) cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}