package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones) {
            pq.add(s);
        }

        while (pq.size() > 1) {
            int y = pq.poll(); // самый тяжёлый
            int x = pq.poll(); // второй

            if (y != x) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
