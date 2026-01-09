package tree;

import tree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueEachTreeRow515 {
    static void main() {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            res.add(max);
        }

        return res;
    }

//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, 0, res);
//        return res;
//    }
//
//    private void dfs(TreeNode node, int level, List<Integer> res) {
//        if (node == null) return;
//
//        if (res.size() == level) {
//            res.add(node.val);
//        } else {
//            res.set(level, Math.max(res.get(level), node.val));
//        }
//
//        dfs(node.left, level + 1, res);
//        dfs(node.right, level + 1, res);
//    }
}
