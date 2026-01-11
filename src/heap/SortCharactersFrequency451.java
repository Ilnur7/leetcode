package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersFrequency451 {

    public String frequencySort(String s) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<CharFreq> heap = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq // max-heap
        );

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            heap.offer(new CharFreq(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            CharFreq cf = heap.poll();
            for (int i = 0; i < cf.freq; i++) {
                sb.append(cf.ch);
            }
        }

        return sb.toString();
    }

    class CharFreq {
        char ch;
        int freq;

        CharFreq(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
