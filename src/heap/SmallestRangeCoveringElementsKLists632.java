package heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsKLists632 {

    static void main() {
        smallestRange(List.of(List.of(4,10,15,24,26), List.of(0,9,12,20),  List.of(5,18,22,30)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        PriorityQueue<int[]> heap =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int currentMax = Integer.MIN_VALUE;

        // инициализация
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            heap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        while (heap.size() == k) {
            int[] cur = heap.poll();
            int minVal = cur[0];
            int listIdx = cur[1];
            int elemIdx = cur[2];

            // обновляем лучший диапазон
            if (currentMax - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = currentMax;
            }

            // двигаемся в том же списке
            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                heap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
                currentMax = Math.max(currentMax, nextVal);
            } else {
                break; // один список закончился
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
