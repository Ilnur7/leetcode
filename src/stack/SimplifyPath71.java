package stack;

import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath71 {
    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");


        for (String part : parts) {
            if (!stack.isEmpty() && part.equals("..")) {
                stack.pop();
            } else if (part.equals(".") || part.equals("") || part.equals("..")) {
                continue;
            } else {
                stack.push(part);
            }
        }

        return "/" + String.join("/", stack);
    }
}
