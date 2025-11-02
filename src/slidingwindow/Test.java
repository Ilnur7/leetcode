package slidingwindow;

public class Test {
    public static void main(String[] args) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        monotonicQueue.push(10);
        monotonicQueue.push(15);
        monotonicQueue.push(4);
        monotonicQueue.push(21);
        monotonicQueue.push(15);
        monotonicQueue.push(3);
        int max = monotonicQueue.max();
        int pop = monotonicQueue.pop();
    }
}
