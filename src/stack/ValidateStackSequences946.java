package stack;

import java.util.Stack;

public class ValidateStackSequences946 {
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[count] == stack.peek()) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty();
    }
}
