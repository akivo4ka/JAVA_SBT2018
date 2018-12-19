package countmap;

import java.util.HashMap;
import java.util.Map;

public class MyCountMapImpl<E> implements MyCountMap<E> {
    private int size;
    private Map<E, Integer> map;

    MyCountMapImpl() {
        map = new HashMap<>();
        size = 0;
    }

    public void add(E o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, 1);
        }
        size++;
    }

    public int getCount(E o) {
        if (map.containsKey(o)) {
            return map.get(o);
        }
        return 0;
    }

    public int remove(E o) {
        int count = getCount(o);
        map.remove(o);
        size--;
        return count;
    }

    public int size() {
        return size;
    }

    public void addAll(MyCountMap<E> source) {
        for (E key : source.toMap().keySet()) {
            if (map.containsKey(key)) {
                map.put(key, source.getCount(key) + getCount(key));
            } else {
                map.put(key, source.getCount(key));
                size++;
            }
        }
    }

    public Map<E, Integer> toMap() {
        return map;
    }

    public void toMap(Map<E, Integer> destination) {
        for (E key : map.keySet()) {
            destination.put(key, getCount(key));
        }
    }

}
