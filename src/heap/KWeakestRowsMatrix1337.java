package heap;

import java.util.PriorityQueue;

public class KWeakestRowsMatrix1337 {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>( //max heap
            (a, b) -> {
                if (a.soldiers != b.soldiers) return b.soldiers - a.soldiers;
                return b.index - a.index;
            }
        );

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count++;
                else break;
            }
            pq.offer(new Pair(count, i));

            if (pq.size() > k) {
                pq.poll(); // всегда удаляем максимальные элементы, чтобы оставалось k min
            }
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().index;
        }
        return res;
    }



    public int[] kWeakestRows1(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.soldiers != b.soldiers) return a.soldiers - b.soldiers; // меньше солдат → слабее
                return a.index - b.index; // меньший индекс → слабее
            }
        );

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count++;
                else break;
            }
            pq.offer(new Pair(count, i));
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().index;
        }

        return res;
    }

        class Pair {
            int soldiers;
            int index;

            Pair(int soldiers, int index) {
                this.soldiers = soldiers;
                this.index = index;
            }
        }
}
