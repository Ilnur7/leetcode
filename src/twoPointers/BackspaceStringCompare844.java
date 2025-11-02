package twoPointers;

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

    //TODO second solution
    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {


            int skipS = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;
                }
            }
            int skipT = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (s.charAt(i) != t.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }
}
