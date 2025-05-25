public class WhileLoopChallenge {

    public static void main(String[] args) {

        int i = 4;

        int finalnum = 20;
        while( i <= finalnum){
            i++;
            if(isEvenNumber(i)){
                System.out.println(i);
            }

        }
    }

    public static boolean isEvenNumber(int num){

        return num% 2 == 0;
    }


}
