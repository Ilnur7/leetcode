package heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {

    private PriorityQueue<Integer> small; // max heap
    private PriorityQueue<Integer> large; // min heap
    private Map<Integer, Integer> delayed;
    private int smallSize = 0, largeSize = 0;
    private int k;

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        delayed = new HashMap<>();

        double[] result = new double[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);

            if (i >= k - 1) {
                result[idx++] = getMedian();
                removeNum(nums[i - k + 1]);
            }
        }
        return result;
    }

    // Add number
    private void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }
        balance();
    }

    // Lazy remove
    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()){
                prune(small);
            }
        } else {
            largeSize--;
            if (!large.isEmpty() && num == large.peek()){
                prune(large);
            }
        }
        balance();
    }

    // Balance two heaps
    private void balance() {
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        } else if (smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

    // Remove invalid (delayed) elements from heap top
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    // Get median
    private double getMedian() {
        if (k % 2 == 1) {
            return small.peek();
        } else {
            return ((long) small.peek() + (long) large.peek()) / 2.0;
        }
    }
}
