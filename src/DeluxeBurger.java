public class DeluxeBurger extends Burger{

    OopsChallenge Deluxe1;
    OopsChallenge Deluxe2;

    public DeluxeBurger(String name, double price) {
        super(name, price);
    }


    public void addTooping(String extra1, String extra2, String extra3 , String extra4 , String extra5) {
        super.addTooping(extra1, extra2, extra3);
        Deluxe1 = new OopsChallenge("TOPPINGS",extra4, 0.0 );
        Deluxe1 = new OopsChallenge("TOPPINGS",extra5, 0.0 );
    }

    @Override
    public void printItemList() {
        super.printItemList();
        if(Deluxe1 != null){
            Deluxe1.printItem();
        }
        if(Deluxe2 != null){
            Deluxe2.printItem();
        }
    }

    public double getExtraprice(String toppingName){
       return 0;
    }
}
