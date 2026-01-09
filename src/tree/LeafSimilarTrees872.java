package tree;

import tree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees872 {
    static void main() {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }


//    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        return getLeaves(root1).equals(getLeaves(root2));
//    }
//
//    public List<Integer> getLeaves(TreeNode root) {
//        Stack<TreeNode> s = new Stack<>();
//        s.push(root);
//        List<Integer> res = new ArrayList<>();
//
//        while(!s.isEmpty()) {
//            TreeNode node = s.pop();
//
//            if(node.left == null && node.right == null) {
//                res.add(node.val);
//            }
//
//            if (node.left != null) {
//                s.push(node.left);
//            }
//
//            if (node.right != null) {
//                s.push(node.right);
//            }
//        }
//        return res;
//    }
}
