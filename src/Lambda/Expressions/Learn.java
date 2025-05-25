package Lambda.Expressions;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Learn {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha","beta","gamma","delta"
        ));
        for(String s: list){
            System.out.println(s);
        }
        Consumer<String> printTheparts = new Consumer<String>() {
              @Override
            public void accept(String sentence){
                  String[] parts = sentence.split(" ");
                  for(String part : parts){
                      System.out.println(part);
                  }
              }

        };
        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < source.length(); i++){;
            returnVal.append(source.charAt(i));
            }

            return returnVal.toString();
        };


    }

}