public class CompossitionChallenge {
    private CoffeeMaker Instantcoffee;
    private Fridge Apple;
    private Dishwaser Wash;
    public  CompossitionChallenge(){
        Instantcoffee = new CoffeeMaker();
        Apple = new Fridge();
        Wash = new Dishwaser();
    }

    public CoffeeMaker getInstantcoffee() {
        return Instantcoffee;
    }

    public Fridge getApple() {
        return Apple;
    }

    public Dishwaser getWash() {
        return Wash;
    }
}


 class CoffeeMaker{
    private Boolean HaveCoffee;

    public void setHaveCoffee(Boolean HaveCoffee){
        this.HaveCoffee = HaveCoffee;
    }

    public void MakeCoffee(){
        if(HaveCoffee){
            System.out.println("CoffeeMaker: MakeCoffee");
            HaveCoffee = false;
        }
    }
}
class Fridge{
    private Boolean HaveCoffee;

    public void setHaveCoffee(Boolean HaveCoffee){
        this.HaveCoffee = HaveCoffee;
    }

    public void Fridgeitems(){
        if(HaveCoffee){
            System.out.println("cake: juice");
            HaveCoffee = false;
        }
    }
}
class Dishwaser{
    private Boolean HaveCoffee;

    public void setHaveCoffee(Boolean HaveCoffee){
        this.HaveCoffee = HaveCoffee;
    }

    public void Dishwaserwash(){
        if(HaveCoffee){
            System.out.println("clean plates");
            HaveCoffee = false;
        }
    }
}