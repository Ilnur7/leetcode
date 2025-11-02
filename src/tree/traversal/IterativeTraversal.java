package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {
    static List<Integer> result;

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        result = new ArrayList<Integer>();
        System.out.println("Preorder Traversal : " + preorderTraversal(root));
        result = new ArrayList<Integer>();
        System.out.println("Inorder Traversal : " + inorderTraversal(root));
        result = new ArrayList<Integer>();
        System.out.println("Postorder Traversal : " + postorderTraversal(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while(true) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            if(stack.isEmpty()) break;
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while(true) {
            while(current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }
            if(stack.isEmpty()) break;
            current = stack.pop();
            current = current.right;
        }
        return result;
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        TreeNode previous = null;
        while(true){
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            if(stack.isEmpty()) break;
            while(current == null && !stack.isEmpty()) {
                current = stack.peek();
                if(current.right == null || current.right == previous) {
                    result.add(current.val);
                    stack.pop();
                    previous = current;
                    current = null;
                }
                else {
                    current = current.right;
                }
            }
        }
        return result;
    }
}



