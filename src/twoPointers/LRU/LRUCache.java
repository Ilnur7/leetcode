package twoPointers.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 1f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity; // Удаляем самый старый элемент, если превышена емкость
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
