package tree.BST;

import tree.traversal.TreeNode;

public class DeleteNodeBST450 {
    static void main() {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // узел найден

            // 0 или 1 ребёнок
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 2 ребёнка
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    public TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}
