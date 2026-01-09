package tree;

import tree.traversal.TreeNode;

import java.util.Stack;

public class MergeTwoBinaryTrees617 {
    static void main() {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode node = new TreeNode(root1.val + root2.val);

        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});

        while (!stack.isEmpty()) {
            TreeNode[] pair = stack.pop();
            TreeNode n1 = pair[0];
            TreeNode n2 = pair[1];

            // суммируем значения прямо в root1
            n1.val += n2.val;

            // левый ребёнок
            if (n1.left != null && n2.left != null) {
                stack.push(new TreeNode[]{n1.left, n2.left});
            } else if (n1.left == null) {
                n1.left = n2.left;
            }

            // правый ребёнок
            if (n1.right != null && n2.right != null) {
                stack.push(new TreeNode[]{n1.right, n2.right});
            } else if (n1.right == null) {
                n1.right = n2.right;
            }
        }
        return root1;
    }
}
