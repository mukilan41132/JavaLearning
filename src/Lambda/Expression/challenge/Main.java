package Lambda.Expression.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args){

        String[] names = {"John","Jane","Jill","Joe","Mukilan","Ed","Fred"};

        Arrays.setAll(names,i-> names[i].toUpperCase());
        System.out.println(Arrays.toString(names));

        List<String> list = Arrays.asList(names);

        list.replaceAll(s-> s += " " + getRandomChar('A','D')+".");
        System.out.println("---> Add random middle initial");
        Arrays.asList(names).forEach(s-> System.out.println(s));
        List<String> newList = new ArrayList<>(List.of(names));

         newList.removeIf(s -> {
         String first = s.substring(0,s.indexOf(" "));
         String last = s.substring(s.lastIndexOf(" ") + 1 );
           return first.equals(last);
         });


    }

    public static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    public static String getReversedName(String firstname){
        return new StringBuilder(firstname).reverse().toString();
    }

}
