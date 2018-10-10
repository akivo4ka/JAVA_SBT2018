package MyCountMap;

public class Main {

    public static void main(String[] args) {
        MyCountMap<Integer> map = new MyCountMapImpl<Integer>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        int count = map.getCount(5); // 2
        System.out.println("5:" + count);

        count = map.getCount(6); // 1
        System.out.println("6:" + count);

        count = map.remove(10); // 3
        System.out.println("10:" + count);

        count = map.getCount(10); // 3
        System.out.println("10:" + count);

        MyCountMap<Integer> map2 = new MyCountMapImpl<Integer>();
        map2.add(10);
        map2.add(5);
        map2.addAll(map);
        System.out.println(map2.toMap());
    }
}
