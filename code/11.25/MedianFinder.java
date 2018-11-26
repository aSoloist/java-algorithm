package cn.org.soloist.algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/27 1:26
 * @email ly@soloist.top
 * @description
 */
public class MedianFinder {

    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) max.offer(min.poll());
    }

    public double findMedian() {
        return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : (double) max.peek();
    }
}
