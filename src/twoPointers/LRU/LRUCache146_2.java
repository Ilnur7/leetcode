package twoPointers.LRU;

import java.util.*;

class LRUCache146_2 {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList list;

    // Инициализация
    public LRUCache146_2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList();
    }

    // Получение значения по ключу
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        list.removeNode(node); // Удаляем из текущего положения
        list.addToHead(node); // Перемещаем к голове
        return node.value;
    }

    // Вставка/обновление значения
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Если ключ существует, обновляем его значение и перемещаем к голове
            Node node = cache.get(key);
            node.value = value;
            list.removeNode(node);
            list.addToHead(node);
        } else {
            // Если ключ новый
            if (cache.size() == capacity) {
                // Удаляем наименее недавно использованный элемент
                Node tailNode = list.removeTail();
                cache.remove(tailNode.key);
            }
            // Добавляем новый элемент
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            list.addToHead(newNode);
        }
    }

    // Узел двусвязного списка
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Двусвязный список для управления порядком
    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1); // Голова (фиктивный узел)
            tail = new Node(-1, -1); // Хвост (фиктивный узел)
            head.next = tail;
            tail.prev = head;
        }

        // Добавить узел к голове списка
        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Удалить узел из списка
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Удалить узел из хвоста и вернуть его
        Node removeTail() {
            Node tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }


}

