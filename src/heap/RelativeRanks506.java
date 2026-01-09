package heap;

import java.util.PriorityQueue;

public class RelativeRanks506 {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        PriorityQueue<Athlete> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.score, a.score) // max heap
        );

        for (int i = 0; i < n; i++) {
            pq.add(new Athlete(score[i], i));
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            Athlete a = pq.poll();

            if (rank == 1) res[a.index] = "Gold Medal";
            else if (rank == 2) res[a.index] = "Silver Medal";
            else if (rank == 3) res[a.index] = "Bronze Medal";
            else res[a.index] = String.valueOf(rank);

            rank++;
        }

        return res;
    }

    class Athlete {
        int score;
        int index;

        Athlete(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }
}
