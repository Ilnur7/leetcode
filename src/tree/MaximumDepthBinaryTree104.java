package tree;

import tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthBinaryTree104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            depth++; // пройдён один уровень
        }
        return depth;
    }


    private static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode n, int d) { node = n; depth = d; }
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 1;

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;

            maxDepth = Math.max(maxDepth, pair.depth);

            if (node.left != null) {
                stack.push(new Pair(node.left, pair.depth + 1));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, pair.depth + 1));
            }
        }
        return maxDepth;
    }
}
