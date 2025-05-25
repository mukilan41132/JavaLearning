public class SumThreeAndFive {
    public static void main(String[] args){
        int SumOfMatch = 0 ;
        int Count = 0;

        for(int loopNumber = 1; loopNumber <=100 ; loopNumber++){
            if(loopNumber %3 ==0 && loopNumber%5 == 0){
                Count++;
                SumOfMatch += loopNumber;
                System.out.println("found a match"+loopNumber);
            }
            if(Count == 5){
                break;
            }

        }
        System.out.println("Sum of three and five matches"+SumOfMatch);
    }
}
