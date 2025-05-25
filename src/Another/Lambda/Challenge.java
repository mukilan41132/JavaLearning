package Another.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class Challenge {
    private static Random random = new Random();
    public static void main(String[] args){
          String[] names = {"John","Jane","Jill","Joe","Mukilan","Ed","Fred"};

          List<UnaryOperator<String>> list = new ArrayList<>(List.of(
                  String::toUpperCase,
                  s -> s += " " + getrandomChar('D','N')+ ".",
                  Challenge::reverse,
                  String::new,
                  s-> new String("hello"+ s),
                  String::valueOf
          ));

          applyChanges(names, list);
    }

    private static void applyChanges(String[] names, List<UnaryOperator<String>> stringFunctions){

        List<String> backedByArray = Arrays.asList(names);

        for ( var function : stringFunctions ){
            backedByArray.replaceAll( s ->s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }

    private static char getrandomChar(char start, char end){
        return (char) random.nextInt((int) start, (int) end + 1);
    }
    private  static String reverse(String s){
        return reverse(s,0,s.length());
    }
    private static String reverse(String s, int start, int end){
        return new StringBuilder(s.substring(start,end)).reverse().toString();
    }
}
