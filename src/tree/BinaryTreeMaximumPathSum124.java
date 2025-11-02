package tree;

import tree.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeMaximumPathSum124 {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // рекурсивно считаем максимальный "вклад" левого и правого поддерева
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // считаем лучший путь через текущий узел
        int maxThroughNode = node.val + left + right;

        // обновляем глобальный максимум
        maxSum = Math.max(maxSum, maxThroughNode);

        // возвращаем вверх максимум из (node + left) или (node + right)
        return node.val + Math.max(left, right);
    }

    public int maxPathSum1(TreeNode root) {
        Map<TreeNode, Integer> dp = new HashMap<>(); // "возвратное значение" для каждого узла
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        int maxSum = Integer.MIN_VALUE;

        while (root != null || !stack.isEmpty()) {
            // идём влево
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.peek();

            // если правый потомок не обработан → идём вправо
            if (node.right != null && node.right != prev) {
                root = node.right;
            } else {
                stack.pop();

                int left = Math.max(0, dp.getOrDefault(node.left, 0));
                int right = Math.max(0, dp.getOrDefault(node.right, 0));

                // лучший путь через текущий узел
                int maxThroughNode = node.val + left + right;
                maxSum = Math.max(maxSum, maxThroughNode);

                // сохраняем "возвратное значение"
                dp.put(node, node.val + Math.max(left, right));

                prev = node;
            }
        }
        return maxSum;
    }

}
