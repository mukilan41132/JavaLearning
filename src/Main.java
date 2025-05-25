import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main extends Object {
    public static void main(String[] args) {
        LinkedListChallenge place1 = new LinkedListChallenge("Paris", 500);
        LinkedListChallenge place2 = new LinkedListChallenge("London", 800);
        LinkedListChallenge place3 = new LinkedListChallenge("Berlin", 1000);

        place1.addPlaceVisit(place2);
        place1.addPlaceVisit(place3);
        place1.addPlaceVisit(place1);

        place1.printPlaces(); // This prints the visited places in a structured list

//        int[] returnedArray = readintegers();
//
//        System.out.println(Arrays.toString(returnedArray));
//
//        int minArray = findmin(returnedArray);
//
//        System.out.println("min " + minArray);

        int [] unsortedarray = getRabdomArray(5);
        System.out.println("ARRAY "+ Arrays.toString(unsortedarray));


        MealOrder mealOrder = new MealOrder();
       // mealOrder.printItemList();

        mealOrder.addBurgerToppings("BACON" ,"CHEESE","VADA");
        mealOrder.setDrinkSize("LARGE");
        mealOrder.printItemList();
        OopsChallenge coke = new OopsChallenge("DRINK","coke",1.50);
        //coke.PrintItem();
        coke.setSize("LARGE");
        coke.printItem();
        Burger burger = new Burger("regular", 4.00);
        burger.addTooping("BACON", "SALAMI", "AVOCADO");
        burger.printItem();
        Printer printed = new Printer(20 , true);
        System.out.println("Total Count"+ " "+printed.getPagesPrinted());

        int pages = printed.printPages(5);
        System.out.printf("curren job pages %d , Total Pages %d %n", pages, printed.getPagesPrinted());


        CompossitionChallenge kitchen = new CompossitionChallenge();
        kitchen.getApple().setHaveCoffee( true );
        kitchen.getInstantcoffee().setHaveCoffee(true);
        kitchen.getWash().setHaveCoffee(true);
        kitchen.getApple().Fridgeitems();
        kitchen.getInstantcoffee().MakeCoffee();
        kitchen.getWash().Dishwaserwash();
        Employee employee = new Employee("mukilan" , "31/10/2002",  "20/08/2023");
        System.out.println(employee);
        System.out.println(employee.getAge());
        System.out.println(employee.collectPayment());
        SalariedEmployee salaryemp = new SalariedEmployee(
                "mukilan2" ,
                "31/10/2002",
                "20/08/2023" ,
                2000000.00
        );
        System.out.println(salaryemp.toString());
        Students students = new Students( "Mukilan" , 22);
        System.out.println(students.toString());

        PrimarySchool primarySchool = new PrimarySchool("mukil" , 50 , "ram");
        System.out.println(primarySchool.toString());
        AnimalsInheritance animals = new AnimalsInheritance("generic animal" , "huge", 400);
        doanimalsstuff(animals , "slow");

        Dog dog = new Dog();
        dog.Move("slow");

    }
    public static void reverse(int[] array) {
       int MaxIndex = array.length - 1;
       int halfindex = array.length / 2;
       for(int i = 0; i < halfindex; i++) {
           int temp = array[i];
           array[i] = array[MaxIndex - i];
           array[MaxIndex - i] = temp;
           System.out.println("--->"+Arrays.toString(array));
       }
    }

    public static int [] reverseCopy(int[] array) {
        int [] newArray = new int[array.length];
        int maxIndex = array.length - 1;
        for(int el : array) {
            newArray[maxIndex--] = el;
        }
        return newArray;
    }

    public static int[] readintegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        String input = scanner.nextLine();
        String[] splits = input.split(",");
        int[] numbers = new int[splits.length];

        for (int i = 0; i < splits.length; i++) {
            numbers[i] = Integer.parseInt(splits[i].trim());
        }

        return numbers;
    }

    public static int findmin(int [] array) {

        int min = Integer.MAX_VALUE;
        for(int el :array) {
            if(el < min){
                min = el;
            }
        }
        return min;
    }


    public static int[]getRabdomArray(int length){
        Random rand = new Random();
        int[] array = new int[length];
        for(int i=0; i<length; i++){
            array[i] = rand.nextInt(1000);
        }

        return array;
    }


    public static void doanimalsstuff( AnimalsInheritance animal ,String speed) {
            animal.MakeNoise();
            animal.Move(speed);
            System.out.println(animal);
            System.out.println("_______");
    }
}

class Students {
    private String name;
    private int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name+ " is "+ age;
    }
}

class PrimarySchool extends Students {

    private String ParentName;

    public PrimarySchool(String name , int age ,String parentName) {
        super(name,age );
        this.ParentName = parentName;
    }

    public String toString() {
        return ParentName+" is "+ super.toString();
    }
}