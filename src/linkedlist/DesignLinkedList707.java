package linkedlist;

public class DesignLinkedList707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 11);
        myLinkedList.addAtIndex(2, 12);
        myLinkedList.addAtIndex(3, 13);
        myLinkedList.addAtIndex(1, 14);
        for (int i = 0; i < myLinkedList.size; i++) {
            System.out.println(myLinkedList.get(i));
        }
    }

    static class Node {

        public int val;
        public Node next;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {

        public Node head;
        public int size;

        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            Node newNode = new Node(val);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else if(index == size) {
                Node cur = head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                cur.next = newNode;
            } else {
                Node cur = head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }

                newNode.next = cur.next;
                cur.next = newNode;
            }

            size++;
        }

        public void deleteAtIndex(int index) {
            if (head == null || index < 0 || index >= size) {
                return;
            }

            if (size == 1) {
                head = null;
            } else if (index == 0) {
                head = head.next;
            } else {
                Node cur = head;
                for (int i = 0; i < index - 1 ; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
            }

            size--;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}


