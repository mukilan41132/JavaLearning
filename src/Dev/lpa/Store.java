package Dev.lpa;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class Store {
    record OrderItem(int quantity,ProductForSale product) {}
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Mona Lisa", 2.3, "A beautiful painting"));
        storeProducts.add(new ArtObject("Starry Night", 2.4, "Famous artwork by Van Gogh"));
        storeProducts.add(new ArtObject("The Scream", 2.4, "Iconic expressionist painting"));

        storeProducts.add(new Furniture("Wooden Chair", 212.3, "A comfortable wooden chair"));
        storeProducts.add(new Furniture("Office Desk", 23123.4, "Spacious desk for office use"));
        storeProducts.add(new Furniture("Dining Table", 2123.4, "Modern glass dining table"));

          ListProducts();
          System.out.println("\nOrder 1");

          var order1 = new ArrayList<OrderItem>();
          AddItemToOrder(order1 , 1 , 2);
          AddItemToOrder(order1 , 0 , 2);

          printOrder(order1);
          System.out.println("\nOrder 2");

          var order2 = new ArrayList<OrderItem>();
          AddItemToOrder(order2 , 3 , 2);
          AddItemToOrder(order2 , 4 , 10);

          printOrder(order2);
    }

    public  static void ListProducts(){
        for(var item : storeProducts){
            System.out.println("_".repeat(30));
            item.showDetails();
        }
    }

    public  static void AddItemToOrder(@NotNull ArrayList<OrderItem> order , int orderIndex, int quantity){
          order.add(new OrderItem(quantity,storeProducts.get(orderIndex)));
    }

    public static void printOrder(@NotNull ArrayList<OrderItem> order){
        double salesPriceTotal = 0;
        for(var item : order){
            item.product().PrintPricedItem(item.quantity());
            salesPriceTotal+= item.product().getSalesPrice(item.quantity());
        }
        System.out.printf("Sales Totel = $%6.2f %n",salesPriceTotal);
    }

}
