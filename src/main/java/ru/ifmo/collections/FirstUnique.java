package ru.ifmo.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private static final int NO_UNIQUES = -1;
    private final List<Integer> list;
    private int firstUnique = NO_UNIQUES;

    public FirstUnique(int[] numbers) {
        this.list = new LinkedList<>();
        for (int number : numbers) {
            list.add(number);
        }
        findFirstUnique();
    }

    public int showFirstUnique() {
        return firstUnique;
    }

    public void add(int value) {
        list.add(value);
        if (value == firstUnique || firstUnique == NO_UNIQUES) {
            findFirstUnique();
        }
    }

    private void findFirstUnique() {
        HashMap<Integer, Integer> amounts = new HashMap<>();
        for (Integer number : list) {
            Integer currentAmount = amounts.getOrDefault(number, 0);
            amounts.put(number, currentAmount + 1);
        }
        for (Integer number : list) {
            if (amounts.get(number) == 1) {
                firstUnique = number;
                return;
            }
        }
        firstUnique = NO_UNIQUES;
    }
}
