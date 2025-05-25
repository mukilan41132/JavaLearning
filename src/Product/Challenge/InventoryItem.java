package Product.Challenge;

public class InventoryItem {
    private Product product;
    private double price;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;

    public InventoryItem(Product product, double price, int qtyTotal, int qtyLow, int qtyReorder) {
        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReorder = qtyReorder;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public boolean reserveItem(int qty) {
        if ((qtyTotal - qtyReserved) >= qty) {
            qtyReserved += qty;
        }
        return false;
    }

    public void releaseItem(int qty) {
        qtyReserved -= qty;
    }

    public boolean sellItems(int qty) {
        if (qtyTotal >= qty) {
            qtyTotal -= qty;
            qtyReserved -= qty;
            if (qtyTotal <= qtyLow) {
                placeInventoryOrder();
            }
            return true;
        }
        return false;
    }


    private void placeInventoryOrder(){
        System.out.printf("Inventory qty %d : %s%n", qtyReorder, product);
    }

    public  String toString(){
        return "%s, $%.2f : [%04d, % 2d]".formatted(product, price, qtyTotal, qtyReserved);
    }
}
