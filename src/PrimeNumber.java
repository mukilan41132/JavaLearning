public class PrimeNumber {
    public static void main (String[] args){
       int count = 0;

       for (int i = 1 ; i<=1000; i++){
           if(isPrime(i)){
               System.out.println("prime number is"+i);
               count++;
           }

       }
        System.out.println("prime number count"+count);
    }
    public static boolean isPrime(int wholeNumber){
     if(wholeNumber <=2){
          return wholeNumber == 2;
     }
     for (int i = 2; i< wholeNumber /2; i++){
         if(wholeNumber % i==0){
             return false;
         }
     }
        return true;
    }


}
