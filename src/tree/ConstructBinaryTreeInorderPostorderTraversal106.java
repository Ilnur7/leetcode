package tree;

import tree.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorderTraversal106 {
    static void main() {

    }

    private int postIndex;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        // корень из postorder
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = inMap.get(rootVal);

        // ВАЖНО: сначала правое поддерево!
        root.right = build(postorder, mid + 1, inRight);
        root.left = build(postorder, inLeft, mid - 1);

        return root;
    }
}
