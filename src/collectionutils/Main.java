package collectionutils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        CollectionUtils.add(c, 2);
        CollectionUtils.add(c, 1);
        CollectionUtils.add(c, 3);
        CollectionUtils.add(c, 4);
        CollectionUtils.add(c, 5);
        System.out.println(c);

        List<Integer> c2 = new ArrayList<>();
        CollectionUtils.add(c2, 3);
        CollectionUtils.removeAll(c, c2);
        List<Integer> c1 = CollectionUtils.range(c, 2, 4);
        System.out.println(c1);

        System.out.println(CollectionUtils.containsAll(c1, c));
        System.out.println(CollectionUtils.containsAny(c1, c));
    }
}
