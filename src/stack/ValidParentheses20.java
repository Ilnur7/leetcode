package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        boolean valid = isValid("[](){}");
        boolean valid1 = isValid("[)");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>(){{
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }};

        for (int i = 0; i < s.length(); i++) {
            if (brackets.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || brackets.get(stack.pop()) != s.charAt(i)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
