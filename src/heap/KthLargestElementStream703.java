package heap;

import java.util.PriorityQueue;

public class KthLargestElementStream703 {

    private final PriorityQueue<Integer> heap;
    private final int k;

    public KthLargestElementStream703(int k, int[] nums) {
        this.k = k;
            heap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        heap.offer(val);

        if (heap.size() > k) {
            heap.poll(); // удаляем минимальный
        }

        return heap.peek();
    }
}
