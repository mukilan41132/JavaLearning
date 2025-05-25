import org.jetbrains.annotations.NotNull;

public class Burger extends OopsChallenge{
    private OopsChallenge extra1;
    private OopsChallenge extra2;
    private OopsChallenge extra3;

    public Burger(String name, double price) {
        super("Burger", name, price);

    }

    @Override
    public String getName() {
        return super.getName() + "BURGER";
    }

    @Override
    public double getAdjustmentPrice() {
        return getBasePrice()+((extra1 == null) ? 0 : extra1.getAdjustmentPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustmentPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustmentPrice());

    }

    public double getBasePrice(@NotNull String toppingName) {
              return switch (toppingName.toUpperCase()){
                  case "CHEESE" , "AVOCADO" -> 1.0;
                  case "BACON" , "HAMBURG" , "SALAMI" -> 2.0;
                  default -> 0.0;
              };
    }

    public void addTooping(String extra1, String extra2, String extra3) {
        this.extra1 = new OopsChallenge("TOPPINGS",extra1, getBasePrice(extra1));
        this.extra2 = new OopsChallenge("TOPPINGS",extra2, getBasePrice(extra2));
        this.extra3 = new OopsChallenge("TOPPINGS",extra3, getBasePrice(extra3));
    }

    public void printItemList() {
          printItem("BASE BURGER" , getBasePrice());

          if(extra1 != null) {
              extra1.printItem();
          }
          if(extra2 != null) {
             extra2.printItem();
          }
          if(extra3 != null) {
             extra3.printItem();
          }
    }

    @Override
    public void printItem() {
        printItemList();
        System.out.println("_".repeat(30));
        super.printItem();
    }
}
