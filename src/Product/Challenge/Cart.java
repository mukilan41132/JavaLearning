package Product.Challenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    enum CartType {PHYSICAL, VIRTUAL,g};

    private static int lastId = 1;

    private int id;

    private LocalDate cartDate;

    private CartType cartType;

    private Map<String, Integer> products;

    public Cart(CartType cartType, int days) {
        this.cartType = cartType;
        id = lastId++;
        cartDate = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }

    public Cart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCartDate() {
        return cartDate;
    }

    public void setCartDate(LocalDate cartDate) {
        this.cartDate = cartDate;
    }

    public void addItem(InventoryItem items, int qty) {

        products.merge(items.getProduct().sku(), qty, Integer::sum);

        if (!items.reserveItem(qty)) {
            System.out.println("ouch, something went wrong, could not add item");
        }
    }

    public void removeItem(InventoryItem items, int qty) {
        int current = products.get(items.getProduct().sku());
        if (current <= qty) {
            qty = current;
            products.remove(items.getProduct().sku());
            System.out.printf("Item [%s] removed from cart%n", items.getProduct().name());
        } else {
            products.merge(items.getProduct().sku(), qty, (oldval, newval) -> oldval - newval);
            System.out.printf("%d [%s]s removed%n", qty, items.getProduct().name());
        }

        items.releaseItem(qty);
    }

    public void printSalesSlip(Map<String, InventoryItem> items) {
        double total = 0;
        System.out.println("_______________________________________________");
        System.out.println("Thank You for your sale: ");

        for (var cartItem : products.entrySet()) {
            var item = items.get(cartItem.getKey());
            int qty = cartItem.getValue();
            double itemPrice = item.getPrice();
            total += qty * itemPrice;
            System.out.printf("\t%s %-10s (%d) $%.2f = $%.2f%n",
                    cartItem.getKey(),
                    item.getProduct().name(),
                    qty, item.getPrice(),
                    itemPrice);
        }

        System.out.printf("Total sales slip: %.2f%n", total);
        System.out.println("_______________________________________________");
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartDate=" + cartDate +
                ", products=" + products +
                '}';
    }
}
