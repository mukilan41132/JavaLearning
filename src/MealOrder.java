public class MealOrder {
    private  Burger burger;
    private  OopsChallenge drink;
    private  OopsChallenge side;

    public MealOrder() {
        this("regular", "coke", "fries");
    }

    public MealOrder(String burgerType, String drinkType, String sideType) {
        this.drink = new OopsChallenge("drink" , drinkType , 200.0);
        if(burgerType.equalsIgnoreCase("deluxe")) {
            this.burger = new DeluxeBurger(burgerType, 8.00);
        }else{
            this.burger = new Burger(burgerType, 4.00);
        }

        this.side = new OopsChallenge("side" , sideType , 100.0);
    }

    public double getTotalPrice() {
        return side.getAdjustmentPrice() + drink.getAdjustmentPrice() + burger.getAdjustmentPrice();
    }

    public void printItemList() {
         burger.printItem();
         side.printItem();
         drink.printItem();

         System.out.println("-".repeat(30));

         OopsChallenge.printItem("Total Price" , getTotalPrice());

    }

    public void addBurgerToppings(String extra1, String extra2 , String extra3) {
        burger.addTooping(extra1, extra2, extra3);
    }

    public void addBurgerToppings(String extra1, String extra2 , String extra3 , String extra4 , String extra5) {
      if(burger instanceof DeluxeBurger db) {
          db.addTooping(extra1, extra2, extra3, extra4, extra5);
      }else {
          burger.addTooping(extra1, extra2, extra3);
      }
    }

    public void setDrinkSize(String size){
           drink.setSize(size);
    }
}
