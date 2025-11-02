package linkedlist;

public class IntersectionTwoLinkedLists160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Если хотя бы один из списков пуст, пересечения быть не может
        if (headA == null || headB == null) return null;

        // Инициализируем два указателя
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Цикл будет работать, пока указатели не встретятся
        while (pointerA != pointerB) {
            // Если указатель A дошел до конца, переключаем его на начало списка B
            pointerA = (pointerA == null) ? headB : pointerA.next;

            // Если указатель B дошел до конца, переключаем его на начало списка A
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Если есть пересечение, оно будет найдено. Иначе вернется null
        return pointerA;
    }
}
