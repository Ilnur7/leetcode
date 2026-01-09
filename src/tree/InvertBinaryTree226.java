package tree;

import tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> q = new Stack<>();
        q.push(root);

        while (!q.isEmpty()) {
            TreeNode node = q.pop();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                q.push(node.left);
            }
            if (node.right != null) {
                q.push(node.right);
            }
        }
        return root;
    }
}
