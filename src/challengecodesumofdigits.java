public class challengecodesumofdigits {

    public static void main(String[] args) {
        System.out.println("Hello World " + hasSameLastDigit(21 ,444 ,42));

    }

    public static boolean hasSameLastDigit(int a , int b , int c){
        int num1 = a % 10;
        int num2 = b % 10;
        int num3 = c % 10;

        if(isValid( a , b , c )){
            
            return false ;
        }
        return num1 == num2 || num1 == num3 ;

    }

    public static boolean isValid( int a , int b , int c){

        if (a < 10 || a > 99 || b < 10 || b > 99 || c < 10 || c > 99) {
            return false;
        }

        return true;
    }
}
