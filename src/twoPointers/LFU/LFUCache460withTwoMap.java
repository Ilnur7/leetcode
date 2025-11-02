package twoPointers.LFU;

import java.util.*;

public class LFUCache460withTwoMap {
    private final int capacity;
    private int minFreq = 0; // Минимальная частота
    private final Map<Integer, Node> cache; // Кэш: ключ -> узел
    private final Map<Integer, LinkedHashSet<Node>> freqToNodes; // Частоты: частота -> множество узлов

    // Узел кэша
    static class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // Новые элементы всегда имеют частоту 1
        }
    }

    public LFUCache460withTwoMap(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqToNodes = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFrequency(node); // Обновляем частоту
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Обновляем значение
            updateFrequency(node);
        } else {
            if (cache.size() == capacity) {
                evict(); // Удаляем наименее часто используемый элемент
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode); // Добавляем новый узел
            freqToNodes.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1; // Частота нового узла
        }
    }

    private void updateFrequency(Node node) {
        int freq = node.freq;
        freqToNodes.get(freq).remove(node); // Удаляем узел из текущей частоты
        if (freqToNodes.get(freq).isEmpty()) {
            freqToNodes.remove(freq);
            if (freq == minFreq) minFreq++; // Обновляем минимальную частоту
        }
        node.freq++; // Увеличиваем частоту
        freqToNodes.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node); // Добавляем в новую частоту
    }

    private void evict() {
        LinkedHashSet<Node> nodes = freqToNodes.get(minFreq); // Получаем список узлов с минимальной частотой
        Node nodeToRemove = nodes.iterator().next(); // Берем самый старый узел
        nodes.remove(nodeToRemove); // Удаляем узел из частотной карты
        if (nodes.isEmpty()) freqToNodes.remove(minFreq); // Удаляем частоту, если она пустая
        cache.remove(nodeToRemove.key); // Удаляем узел из кэша
    }
}
