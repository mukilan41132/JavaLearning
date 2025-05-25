public class MethodOverloading {
    public static void main(String[] args) {
//        System.out.println("5ft , 8in = "+ Convertion(5 ,8)+"cm");
//        System.out.println("68in = "+ Convertion(68)+"cm");
        System.out.println(area(3));
    }


    public static double area(double radius){

        return 3.14 * (radius * radius);
    }
}
