package queue;

public class DesignCircularQueue622 {
    public static void main(String[] args) {

    }

    static class MyCircularQueue {

        int[] arr;
        private int front;
        private int rear;
        private int size;

        public MyCircularQueue(int k) {
            size = 0;
            arr = new int[k];
            front = 0;
            rear = 0;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;

            arr[rear] = value;
            rear++;
            rear = rear % arr.length;
            size++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;

            front++;
            front = front % arr.length;
            size--;
            return true;
        }

        public int Front() {
            if(isEmpty()) return -1;
            return arr[front];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            int index = (rear -1 + arr.length) % arr.length;
            return arr[index];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == arr.length;
        }
    }
}
