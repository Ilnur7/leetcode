package linkedlist;

public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(listNode1);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // Пустой список или список из одного узла является палиндромом
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode last = reverse(slow);

        ListNode cur1 = head;
        ListNode cur2 = last;
        while (cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
