package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LFUCache460V2 {

    public static void main(String[] args) {

    }

    class LFUCache {
        int capacity;
        int minFreq =0;
        Map<Integer, DoublyLinkedList> freqToList = new HashMap<>();
        Map<Integer, Node> cache = new HashMap<>();

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;

            updateFreq(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            Node node = cache.get(key);
            if (node != null) {
                node.val = value;
                updateFreq(node);
                return;
            }

            if (cache.size() == capacity) {
                DoublyLinkedList minList = freqToList.get(minFreq);
                Node removed = minList.removeTail();
                cache.remove(removed.key);
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);

            DoublyLinkedList list = freqToList.computeIfAbsent(1, k -> new DoublyLinkedList());
            list.addToHead(newNode);

            minFreq = 1;
        }

        private void updateFreq(Node node) {
            int freq = node.freq;
            DoublyLinkedList list = freqToList.get(freq);
            list.remove(node);
            node.freq++;
            if (freq == minFreq && list.size == 0) {
                minFreq = node.freq;
            }
            freqToList.computeIfAbsent(node.freq, k -> new DoublyLinkedList())
                .addToHead(node);
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.freq = 1;
        }
    }
}


