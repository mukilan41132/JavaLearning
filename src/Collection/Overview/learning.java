package Collection.Overview;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class learning {

    public static void main(String[] args){
        Collection<String> list = new TreeSet<>();

        String[] names = {"John","Jane","Jill","Joe","Mukilan","Ed","Fred"};
        list.addAll(List.of(names));
        System.out.println(list);

        list.add("hello");
        list.addAll(Arrays.asList("George","Gary","Gregory"));
        list.removeIf(s ->  s.charAt(0) == 'M');
        System.out.println(list);
        System.out.println("Gary is in the list ? " + list.contains("Gary"));
    }
}
