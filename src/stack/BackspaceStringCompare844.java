package stack;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class BackspaceStringCompare844 {
    public static void main(String[] args) {

    }

    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    public String getString(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch: s.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);
            } else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return stack.stream().map(Objects::toString).collect(Collectors.joining(""));
    }
}
