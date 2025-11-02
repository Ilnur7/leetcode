package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {
    private Deque<Integer> queue;

    public MonotonicQueue() {
        queue = new ArrayDeque<>();
    }

    // Pushes the element onto the queue and maintains monotonicity
    public void push(int x) {
        while (!queue.isEmpty() && queue.peekLast() < x) {
            queue.pollLast();
        }
        queue.offerLast(x);
    }

    // Pops the first element from the queue
    public int pop() {
        return queue.pollFirst();
    }

    // Gets the maximum (or minimum) element from the queue
    public int max() {
        return queue.peekFirst();
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

