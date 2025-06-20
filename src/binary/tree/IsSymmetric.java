package binary.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: IsSymmetric
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-19 16:12
 * @Version 1.0
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
         return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left != null && right == null) return false;
        if(left == null && right != null) return false;
        if(left.val != right.val) return false;
        boolean compareInside = compare(left.left, right.right);
        boolean compareOutside = compare(left.right, right.left);
        return compareInside && compareOutside;
    }

    // Use iterative method
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return true;
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            deque.offerFirst(leftNode.right);
            deque.offerFirst(leftNode.left);
            deque.offerLast(rightNode.left);
            deque.offerLast(rightNode.right);
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }
}
