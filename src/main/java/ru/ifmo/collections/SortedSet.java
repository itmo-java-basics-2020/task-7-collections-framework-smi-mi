package ru.ifmo.collections;

import javax.lang.model.type.ArrayType;
import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    private final TreeMap<T, Object> map;
    private static final Object PRESENT = new Object();

    private SortedSet() {
        this. map = new TreeMap<>();
    }

    private SortedSet(Comparator<T> comparator) {
        this. map = new TreeMap<>(comparator);
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return map.navigableKeySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(T t) {
        return map.put(t, PRESENT)==null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return super.addAll(c);
    }

    public List<T> getSorted() {
        Vector<T> sorted = new Vector<>(map.size());
        for (T entry : map.keySet()) {
            sorted.addElement(entry);
        }
        return sorted;
    }

    public List<T> getReversed() {
        List<T> reversed = this.getSorted();
        Collections.reverse(reversed);
        return reversed;
    }
}
