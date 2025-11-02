package linkedlist;

public class SwapNodesPairs24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            ListNode first = cur;
            ListNode second = cur.next;

            prev.next = second;
            first.next = first.next.next;
            second.next = first;

            prev = first;
            cur = first.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        ListNode first;
        ListNode second;
        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = cur.next.next;


            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }
}
