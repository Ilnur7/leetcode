package tree.BST;

import tree.traversal.TreeNode;

public class SearchBinarySearchTree700 {
    static void main() {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
