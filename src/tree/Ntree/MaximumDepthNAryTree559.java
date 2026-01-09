package tree.Ntree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthNAryTree559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
        }
        return depth;
    }
}
