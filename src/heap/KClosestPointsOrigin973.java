package heap;

import java.util.PriorityQueue;

public class KClosestPointsOrigin973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Element> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int dist = point[0] * point[0] + point[1] * point[1];
            heap.offer(new Element(dist, i));

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            int index = heap.poll().index;
            res[i] = points[index];
        }
        return res;
    }
}

class Element {
    int dist;
    int index;

    Element(int dist, int index) {
        this.dist = dist;
        this.index = index;
    }
}
