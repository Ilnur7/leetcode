package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber414 {

    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) continue;

            seen.add(num);
            heap.offer(num);

            if (heap.size() > 3) {
                heap.poll(); // удаляем минимальный
            }
        }

        if (heap.size() < 3) {
            // если 3-го максимума нет — вернуть максимум
            while (heap.size() > 1) {
                heap.poll();
            }
        }

        return heap.peek();
    }

    public int thirdMax1(int[] nums) {
        Long first = null, second = null, third = null;

        for (int n : nums) {
            // Skip duplicates
            if ((first != null && n == first) ||
                (second != null && n == second) ||
                (third != null && n == third)) {
                continue;
            }

            if (first == null || n > first) {
                third = second;
                second = first;
                first = (long) n;
            } else if (second == null || n > second) {
                third = second;
                second = (long) n;
            } else if (third == null || n > third) {
                third = (long) n;
            }
        }

        return third == null ? first.intValue() : third.intValue();
    }
}
