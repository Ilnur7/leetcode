package tree;

import tree.traversal.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorBinaryTree236 {
    static void main() {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root; // LCA найден
        }

        return left != null ? left : right;
    }


//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//        Stack<TreeNode> stack = new Stack<>();
//        parent.put(root, null);
//        stack.push(root);
//
//        // строим parent map
//        while (!parent.containsKey(p) || !parent.containsKey(q)) {
//            TreeNode node = stack.pop();
//
//            if (node.left != null) {
//                parent.put(node.left, node);
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                parent.put(node.right, node);
//                stack.push(node.right);
//            }
//        }
//
//        // все предки p
//        Set<TreeNode> ancestors = new HashSet<>();
//        while (p != null) {
//            ancestors.add(p);
//            p = parent.get(p);
//        }
//
//        // первый общий предок q
//        while (!ancestors.contains(q)) {
//            q = parent.get(q);
//        }
//
//        return q;
//    }
}
