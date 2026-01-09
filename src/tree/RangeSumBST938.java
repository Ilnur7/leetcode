package tree;

import tree.traversal.TreeNode;

import java.util.Stack;

public class RangeSumBST938 {
    static void main() {

    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val
            + rangeSumBST(root.left, low, high)
            + rangeSumBST(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;

            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            if (node.val > low) {
                stack.push(node.left);
            }

            if (node.val < high) {
                stack.push(node.right);
            }
        }

        return sum;
    }
}
