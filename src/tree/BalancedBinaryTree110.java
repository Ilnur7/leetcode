package tree;

import tree.traversal.TreeNode;

public class BalancedBinaryTree110 {
    static void main() {

    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        if (left == -1) return -1;

        int right = dfs(root.right);
        if(right == -1) return -1;

        if (Math.abs(right - left) > 1) {
            return - 1;
        }
        return 1 + Math.max(left, right);
    }

//    n^2
//    public boolean isBalanced1(TreeNode root) {
//        if (root == null) return true;
//
//        int left = height(root.left);
//        int right = height(root.right);
//
//        if (Math.abs(left - right) > 1) return false;
//
//        return isBalanced1(root.left) && isBalanced1(root.right);
//    }
//
//    private int height(TreeNode node) {
//        if (node == null) return 0;
//        return 1 + Math.max(height(node.left), height(node.right));
//    }
}
