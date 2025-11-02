package twoPointers.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {


    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final DoublyLinkedList list;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        list.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            list.moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            list.addToHead(newNode); //кладем в начала, так как там самые недавно используемые

            if (cache.size() > capacity) {
                Node tail = list.removeTail();
                cache.remove(tail.key);
            }
        }
    }

    class DoublyLinkedList {
        private Node head;
        private Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addToHead(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public void moveToHead(Node node) {
            if (node == head) return;

            // Disconnect node
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;

            // Update tail if needed
            if (node == tail) tail = node.prev;

            // Reattach node at head
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        public Node removeTail() {
            if (tail == null) return null;

            Node removedNode = tail;

            if (tail.prev != null) {
                tail.prev.next = null;
            } else {
                head = null;
            }

            tail = tail.prev;
            return removedNode;
        }
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}


