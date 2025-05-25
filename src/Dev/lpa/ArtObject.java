package Dev.lpa;

public class ArtObject extends  ProductForSale {

    public ArtObject(String type, Double price, String description) {
        super(type, price, description);
    }

    public void  showDetails(){
        System.out.println("This is good "+type);
        System.out.printf("Price is $%6.2f %n",price);
        System.out.println(description);
    }
}
