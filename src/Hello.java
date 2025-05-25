public class Hello {
    public static void main(String[] args){
        System.out.println("hello");

        boolean isTrue = false;
           if(!isTrue) {
               System.out.println("hello1");
               System.out.println("hello2");
           }

        double no1 = 20.00d;
        double no2 = 80.00d;
        double num3 = ((no1 + no2 )* 100.00d);
        System.out.println("hello3 "+" " + num3);
        double num4 = num3 % 40.00d;
        System.out.println("hello4" +" " +num4);
    }
}
