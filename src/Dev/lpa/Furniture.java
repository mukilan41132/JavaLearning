package Dev.lpa;

public class Furniture extends  ProductForSale {

    public Furniture(String type, Double price, String description) {
        super(type, price, description);
    }

    public void  showDetails(){
        System.out.println("This Was manufacture in Chennai"+type);
        System.out.printf("Price is $%6.2f %n",price);
        System.out.println(description);
    }
}
