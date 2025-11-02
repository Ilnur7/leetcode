package tree;

import tree.traversal.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree297 {

    public String serialize(TreeNode root) {
        if (root == null) return "#";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("#,");
                continue;
            } else {
                sb.append(node.val).append(",");
            }

            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;

        String[] splits = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        q.offer(root);
        int i = 1;

        while(!q.isEmpty() && i < splits.length) {
            TreeNode node = q.poll();
            if (!splits[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(splits[i]));
                q.offer(node.left);
            }
            i++;

            if (i < splits.length && !splits[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(splits[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;

    }
}
