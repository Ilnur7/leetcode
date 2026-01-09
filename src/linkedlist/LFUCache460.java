package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LFUCache460 {

    public static void main(String[] args) {

    }

    public static class LFUCache {
        private final int size;
        private int minFreq;

        private final Map<Integer, Integer> keyToFreq;
        private final Map<Integer, Node> keyToNode;
        private final Map<Integer, DoublyLinkedList> freqToLinkedList;

        public LFUCache(int capacity) {
            this.size = capacity;
            this.keyToFreq = new HashMap<>();
            this.keyToNode = new HashMap<>();
            this.freqToLinkedList = new HashMap<>();
            this.minFreq = 1;
        }

        public Integer get(int key) {
            if (!keyToNode.containsKey(key)) {
                return -1;
            }
            Node node = keyToNode.get(key);
            updateFrequency(node);
            return node.val;
        }

        private void updateFrequency(Node node) {
            int counter = keyToFreq.get(node.key);

            DoublyLinkedList list = freqToLinkedList.get(counter);
            Node removedNode = list.removeNode(node);

            if (list.isEmpty() && counter == minFreq) {
                minFreq++;
            }

            DoublyLinkedList nextList = freqToLinkedList.getOrDefault(counter + 1, new DoublyLinkedList());
            nextList.addToHead(removedNode);
            freqToLinkedList.put(counter + 1, nextList);
            keyToFreq.put(node.key, counter + 1);
        }

        public void put(int key, int value) {
            if (this.size == 0) return;

            if (keyToNode.containsKey(key)) {
                Node node = keyToNode.get(key);
                node.val = value;
                updateFrequency(node);
                return;
            }

            if (keyToNode.size() == this.size) {
                removeLeastFreqUsed();
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            keyToFreq.put(key, 1);
            freqToLinkedList.computeIfAbsent(1, k -> new DoublyLinkedList()).addToHead(newNode);
            minFreq = 1;

        }

        private void removeLeastFreqUsed() {
            DoublyLinkedList doublyLinkedList = freqToLinkedList.get(minFreq);
            Node node = doublyLinkedList.removeTail();

            if (doublyLinkedList.isEmpty()) freqToLinkedList.remove(minFreq);
            keyToNode.remove(node.key);
            keyToFreq.remove(node.key);
        }


        class Node {
            private Node next;
            private Node prev;
            private int key;
            private int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        class DoublyLinkedList {
            Node head;
            Node tail;

            public boolean isEmpty() {
                return head.next == tail;
            }

            public DoublyLinkedList() {
                this.head = new Node(-1, - 1);
                this.tail = new Node(-1, - 1);
                head.next = tail;
                tail.prev = head;
            }

            public Node removeNode(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return node;
            }

            public void addToHead(Node node) {
                node.next = head.next;
                node.prev = head;
                head.next.prev = node;
                head.next = node;
            }

            public void addToTail(Node node) {
                node.next = tail;
                node.prev = tail.prev;
                tail.prev.next = node;
                tail.prev = node;
            }

            public Node removeTail() {
                if (tail.prev == head) return null;
                Node removedNode = tail.prev;
                removeNode(removedNode);

                return removedNode;
            }
        }
    }
}


