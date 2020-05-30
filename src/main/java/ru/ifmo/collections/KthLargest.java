package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final int K;
    private final ArrayList<Integer> list;

    public KthLargest(int k, int[] numbers) {
        this.K = k;
        this.list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        Arrays.sort(numbers);
        for (int number : numbers) {
            list.add(number);
        }
    }

    public int add(int val) {
        int l = 0, r = list.size();
        while (l != r - 1) {
            int c = (l + r) / 2;
            if (list.get(c) > val) {
                r = c;
            } else {
                l = c;
            }
        }
        list.add(r, val);
        return list.get(list.size() - K);
    }
}