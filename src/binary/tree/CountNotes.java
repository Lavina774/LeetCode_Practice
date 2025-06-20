package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: CountNotes
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-19 19:46
 * @Version 1.0
 */
public class CountNotes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1+left+right;
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            left = left.left;
            leftDepth += 1;
        }
        while (right != null) {
            right = right.right;
            rightDepth += 1;
        }
        if (leftDepth == rightDepth) {
            return (2<<leftDepth)-1;
        }
        return countNodes2(root.left)+countNodes2(root.right)+1;
    }

    public int countNodes3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                TreeNode node = queue.poll();
                count++;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                levelSize--;
            }
        }
        return count;
    }
}
