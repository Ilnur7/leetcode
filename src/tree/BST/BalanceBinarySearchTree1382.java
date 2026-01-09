package tree.BST;

import tree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree1382 {

    static void main() {

    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return build(values, 0, values.size() - 1);
    }

    // inorder traversal: BST -> sorted list
    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    // build balanced BST from sorted list
    private TreeNode build(List<Integer> values, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        root.left = build(values, left, mid - 1);
        root.right = build(values, mid + 1, right);

        return root;
    }
}
