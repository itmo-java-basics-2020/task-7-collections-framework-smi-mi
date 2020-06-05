package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final int K;
    private final PriorityQueue<Integer> kLargest;

    public KthLargest(int k, int[] numbers) {
        this.K = k;
        this.kLargest = new PriorityQueue<>(numbers.length);
        for (Integer number : numbers) {
            kLargest.add(number);
        }
        while (kLargest.size() > this.K) {
            kLargest.remove();
        }
    }

    public int add(int val) {
        kLargest.add(val);
        kLargest.remove();
        assert kLargest.peek() != null;
        return kLargest.peek();
    }
}