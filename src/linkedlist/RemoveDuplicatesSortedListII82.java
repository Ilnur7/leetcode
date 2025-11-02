package linkedlist;

public class RemoveDuplicatesSortedListII82 {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;


        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                prev = prev.next;

            } else {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
