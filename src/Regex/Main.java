package Regex;

public class Main {

    public static void main(String[] args) {
        String testString = "Anyone can Learn abc's, 123's an any regular expression";
        String replacement = "(-)";
        String[] patterns = {
                "[abs]",
                "[123]",
                "[A]",
                "A|b"
        };

        for(String pattern : patterns){
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("pattern: " + pattern + " =>" +  output);
        }
    }
}
