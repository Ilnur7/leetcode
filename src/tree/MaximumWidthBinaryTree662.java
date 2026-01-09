package tree;

import tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthBinaryTree662 {
    static void main() {
        // создаём узлы
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        // проверка
        int width = widthOfBinaryTree1(root);
        System.out.println(width);
    }


    public static int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        Queue<State> q = new LinkedList<>();
        q.offer(new State(root, 0, 0));
        long res = 0;
        long prevIdx = 0;
        int prevLevel = 0;

        while (!q.isEmpty()) {
            State cur = q.poll();
            TreeNode node = cur.node;

            if (cur.level > prevLevel) {
                prevLevel = cur.level;
                prevIdx = cur.index;
            }

            long idx = cur.index - prevIdx;
            res = Math.max(res, idx + 1);

            if (node.left != null) {
                q.offer(new State(node.left, 2 * idx, cur.level + 1));
            }
            if (node.right != null) {
                q.offer(new State(node.right, 2 * idx + 1, cur.level + 1));
            }

        }
        return (int) res;
    }

    static class State {
        TreeNode node;
        long index;
        int level;

        State(TreeNode node, long index, int level) {
            this.node = node;
            this.index = index;
            this.level = level;
        }
    }

    //    public static int widthOfBinaryTree(TreeNode root) {
    //        if (root == null) return 0;
    //
    //        long maxWidth = 0;
    //        Queue<Pair> queue = new LinkedList<>();
    //        queue.offer(new Pair(root, 0L));
    //
    //        while (!queue.isEmpty()) {
    //            int size = queue.size();
    //            long minIndex = queue.peek().index; // чтобы избежать overflow
    //            long first = 0, last = 0;
    //
    //            for (int i = 0; i < size; i++) {
    //                Pair pair = queue.poll();
    //                long idx = pair.index - minIndex; // нормализация
    //                TreeNode node = pair.node;
    //
    //                if (i == 0) {
    //                    first = idx;
    //                }
    //                if (i == size - 1) {
    //                    last = idx;
    //                }
    //
    //                if (node.left != null) {
    //                    queue.offer(new Pair(node.left, 2 * idx));
    //                }
    //                if (node.right != null) {
    //                    queue.offer(new Pair(node.right, 2 * idx + 1));
    //                }
    //            }
    //            maxWidth = Math.max(maxWidth, last - first + 1);
    //        }
    //        return (int) maxWidth;
    //    }
    //
    //    static class Pair {
    //        TreeNode node;
    //        long index;
    //
    //        Pair(TreeNode node, long index) {
    //            this.node = node;
    //            this.index = index;
    //        }
    //    }


    //    private long maxWidth = 0;
    //    private Map<Integer, Long> leftMost = new HashMap<>();
    //
    //    public int widthOfBinaryTree1(TreeNode root) {
    //        dfs(root, 0, 0L);
    //        return (int) maxWidth;
    //    }
    //
    //    private void dfs(TreeNode node, int depth, long index) {
    //        if (node == null) return;
    //
    //        leftMost.putIfAbsent(depth, index);
    //        maxWidth = Math.max(maxWidth, index - leftMost.get(depth) + 1);
    //
    //        dfs(node.left, depth + 1, 2 * index);
    //        dfs(node.right, depth + 1, 2 * index + 1);
    //    }
}
