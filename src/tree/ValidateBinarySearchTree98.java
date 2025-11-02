package tree;

import tree.traversal.TreeNode;

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return validateBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //binary search tree
    public boolean validateBst(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validateBst(node.left, min, node.val) && validateBst(node.right, node.val, max);
    }

}
