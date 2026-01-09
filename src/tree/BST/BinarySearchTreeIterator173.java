package tree.BST;

import tree.traversal.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator173 {
    static void main() {

    }

    static class BSTIterator {
        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        public void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                pushLeft(node.right);
            }
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
