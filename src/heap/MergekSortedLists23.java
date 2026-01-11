package heap;

import linkedlist.ListNode;

import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Добавляем головы списков
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> heap =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Кладём ВСЕ узлы в кучу
        for (ListNode node : lists) {
            while (node != null) {
                heap.offer(node);
                node = node.next;
            }
        }

        // Если все списки пустые
        if (heap.isEmpty()) return null;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;

            // ❗ разрываем старую связь
            cur.next = null;
        }

        return dummy.next;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
