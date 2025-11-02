package tree;

import tree.traversal.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreePreorderInorderTraversal105 {

    public static void main(String[] args) {
        ConstructTreePreorderInorderTraversal105 task = new ConstructTreePreorderInorderTraversal105();

        TreeNode treeNode = task.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        TreeNode root = new TreeNode(preorder[0]);

        inorderIndexMap = new HashMap<>();

        // Map value → index for inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Get root index from inorder
        int inorderIndex = inorderIndexMap.get(rootVal);

        root.left = build(left, inorderIndex - 1);
        root.right = build(inorderIndex + 1, right);
        return root;
    }
}
