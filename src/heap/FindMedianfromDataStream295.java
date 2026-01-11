package heap;

import java.util.PriorityQueue;

public class FindMedianfromDataStream295 {
    class MedianFinder {
        private PriorityQueue<Integer> maxHeap; //самые маленькие
        private PriorityQueue<Integer> minHeap; //самые большие

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) { // если меньше середины
                maxHeap.offer(num); // то кладем к маленьким
            } else {
                minHeap.offer(num);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            return maxHeap.peek();
        }
    }


    class MedianFinder1 {

        // левая часть (max-heap)
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // правая часть (min-heap)
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public MedianFinder1() {}

        public void addNum(int num) {
            // 1. кладём в maxHeap
            maxHeap.offer(num);

            // 2. поддерживаем порядок
            minHeap.offer(maxHeap.poll());

            // 3. баланс размеров
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
