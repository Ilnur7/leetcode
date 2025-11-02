package stack;

import java.util.LinkedList;
import java.util.List;

class MyStack {

    private List<Integer> stack;
    private Integer size;

    public MyStack() {
        stack = new LinkedList<>();
        size = 0;
    }

    public void push(int x) {
        stack.add(0, x);
        size++;
    }

    public int pop() {
        Integer remove = stack.remove(0);
        size--;
        return remove;
    }

    public int top() {
        return stack.get(0);
    }

    public boolean empty() {
        return size == 0;
    }
}
