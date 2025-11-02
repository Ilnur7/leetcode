package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        //int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] arr = {1,-1};
        int[] ints = maxSlidingWindow4(arr, 1);
        for (int i: ints) {
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindow4(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && deque.peek() < right - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.add(right);

            if (right - k + 1 >= 0) {
                res[right - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // удаляем элементы, если вышли за пределы окна
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }


        }
        return res;
    }















    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(k);
        int left = 0;
        int right = 0;
        while (right < n) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.add(right);

            if (left > queue.peek()) {
                queue.poll();
            }

            if (right - left >= k - 1) {
                res[left] = nums[queue.peek()];
                left++;
            }
            right++;
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove indices of smaller elements as they are no longer useful
            if (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.add(i);

            // Add maximum to result if window size >= k
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static int[] maxSlidingWindowSlow(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
