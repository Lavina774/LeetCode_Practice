package binary.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: FIndBottomLeftValue
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-24 17:37
 * @Version 1.0
 */
public class FIndBottomLeftValue {
    // iteration
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int leftmost = root.val;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) leftmost = node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return leftmost;
    }

    // recursion
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue2(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(deep > Deep) {
                Deep = deep;
                value = root.val;
            }
        }
        if (root.left != null) findLeftValue(root.left, deep+1);
        if (root.right != null) findLeftValue(root.right, deep+1);
    }
}
