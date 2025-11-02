package linkedlist;

public class SwappingNodesinLinkedList1721 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = swapNodes(listNode, 2);
        System.out.println(listNode1);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
        }
        ListNode second = head;
        ListNode cur = first;
        while (cur.next != null) {
            cur = cur.next;
            second = second.next;
        }

        int tmp1 = first.val;
        int tmp2 = second.val;
        first.val = tmp2;
        second.val = tmp1;
        return head;

    }
}
