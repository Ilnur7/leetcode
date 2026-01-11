package heap;

import java.util.PriorityQueue;

public class KthSmallestElementinSortedMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n = matrix.length;

        // кладём первый элемент каждой строки
        for (int i = 0; i < n; i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }

        int val = 0;

        for (int i = 0; i < k; i++) {
            int[] arr = heap.poll();
            val = arr[0];
            int row = arr[1];
            int col = arr[2];

            // ✅ правильная проверка
            if (col + 1 < matrix[0].length) {
                heap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }

        return val;
    }



    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length, count = 0;
        int row = n - 1, col = 0; // start bottom-left

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

}
