package tree;

import tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathSum112 {
    static void main() {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // если лист — проверяем сумму
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // идём дальше
        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining)
            || hasPathSum(root.right, remaining);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, targetSum));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            TreeNode node = p.node;
            int sum = p.sum;

            if (node.left == null && node.right == null) {
                if (sum == node.val) return true;
            }

            int remaining = sum - node.val;

            if (node.right != null) {
                stack.push(new Pair(node.right, remaining));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, remaining));
            }
        }

        return false;
    }

    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, targetSum));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int sum = p.sum;

            if (node.left == null && node.right == null) {
                if (sum == node.val) return true;
            }

            int remaining = sum - node.val;

            if (node.left != null) {
                q.offer(new Pair(node.left, remaining));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, remaining));
            }
        }

        return false;
    }

    static class Pair {
        TreeNode node;
        int sum;

        Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }
}
