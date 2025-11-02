package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {
        LinkedList<Integer> objects = new LinkedList<>();
        objects.peek();
        new HashMap<>(10);
    }

    class MyQueue {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1= new Stack<>();
            stack2= new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int res = stack2.pop();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return res;
        }

        public int peek() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int res = stack2.peek();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return res;
        }

        public boolean empty() {
            if (stack1.size() == 0) {
                return true;
            }
            return false;
        }
    }

    class MyQueue2 {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue2() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        public void push(int x) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(x);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public int pop() {
            return stack1.pop();
        }

        public int peek() {
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
