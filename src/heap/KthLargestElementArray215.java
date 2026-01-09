package heap;

import java.util.PriorityQueue;

public class KthLargestElementArray215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
