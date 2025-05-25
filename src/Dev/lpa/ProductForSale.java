package Dev.lpa;

public abstract class ProductForSale {

    protected String type;
    protected Double price;
    protected String description;

    public ProductForSale(String type, Double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public  double getSalesPrice(int quantity) {
         return price * quantity;
    }

    public void PrintPricedItem(int quantity){
        System.out.printf("%2d qty At $%8.2f each,  %-15s %-35s %n",quantity,price,type,description);
    }

    public abstract void showDetails();
}
