package heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords692 {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Word> heap = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq) {
                    return a.freq - b.freq; // меньше частота → хуже
                }
                return b.word.compareTo(a.word); // лексикографически больше → хуже
            }
        );

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            heap.offer(new Word(entry.getKey(), entry.getValue()));

            if (heap.size() > k) {
                heap.poll();
            }
        }

        LinkedList<String> res = new LinkedList<>();
        while (!heap.isEmpty()) {
            res.addFirst(heap.poll().word);
        }

        return res;
    }

    class Word {
        String word;
        int freq;

        Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
