package linkedlist;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache146 {

    static void main(String[] args) {

    }

    class LRUCache {

        class Node {
            Node next;
            Node prev;
            int val;
            int key;

            public Node() {
            }

            public Node(int key, int val) {
                this.val = val;
                this.key = key;
            }
        }

        private Map<Integer, Node> cache;
        private Node head;
        private Node tail;
        private int capacity;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.head = new Node();
            this.tail = new Node();
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;

            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                node.val = value;
                moveToHead(node);
                return;
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);

            if (cache.size() > capacity) {
                Node last = removeTail();
                cache.remove(last.key);
            }
        }

        public void moveToHead(Node node) {
            remove(node);
            addToHead(node);
        }

        public void addToHead(Node newNode) {
            newNode.next = head.next;
            newNode.prev = head;

            head.next.prev = newNode;
            head.next = newNode;

        }

        public Node removeTail() {
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }


    static class LRUCache2 {
        private final Map<Integer, Integer> cache;

        public LRUCache2(int capacity) {
            this.cache = new LinkedHashMap<>(capacity, 1f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity; // Удаляем самый старый элемент, если превышена емкость
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1); // Возвращаем значение или -1
        }

        public void put(int key, int value) {
            cache.put(key, value); // Добавляем или обновляем ключ
        }
    }
}


