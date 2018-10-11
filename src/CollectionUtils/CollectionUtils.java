package CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils<Integer> {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        for (T e : source) {
            destination.add(e);
        }
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, T o) {
        int index = -1;
        int currentIndex = 0;
        for (T e : source) {
            if (e.equals(o)) {
                index = currentIndex;
                break;
            }
            currentIndex++;
        }
        return index;
    }

    public static<T> List<T> limit(List<? extends T> source, int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(source.get(i));
        }
        return list;
    }

    public static<T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T e : c2) {
            if (removeFrom.contains(e)) {
                removeFrom.remove(e);
            }
        }
    }

    public static<T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        boolean contains = true;
        for (T e : c2) {
            if (!c1.contains(e)) {
                contains = false;
            }
        }
        return contains;
    }

    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        boolean contains = false;
        for (T e : c2) {
            if (c1.contains(e)) {
                contains = true;
            }
        }
        return contains;
    }

    public static<T extends Comparable<T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> range = new ArrayList<>();
        for (T e : list) {
            if (e.compareTo(min) >= 0 && e.compareTo(max) <= 0) {
                range.add(e);
            }
        }
        return range;
    }

    public static<T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> range = new ArrayList<>();
        for (T e : list) {
            if (comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0) {
                range.add(e);
            }
        }
        return range;
    }
}