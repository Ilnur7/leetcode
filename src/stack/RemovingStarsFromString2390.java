package stack;

import java.util.Stack;

public class RemovingStarsFromString2390 {
    public static void main(String[] args) {

    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch: s.toCharArray()) {
            if (ch != '*') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
