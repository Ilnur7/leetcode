package linkedlist;

public class LinkedListCycle141 {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    static class ListNode {

        public int val;
        public ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }
    }
}
