package binary.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: InvertTree
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 02:42
 * @Version 1.0
 */
public class InvertTree {
//    public TreeNode invertTree1(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        invertTree1(root.left);
//        invertTree1(root.right);
//        swapChildren(root);
//        return root;
//    }
//
//    private void swapChildren(TreeNode root) {
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//    }
//
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {return null;}
//        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
//        deque.offer(root);
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            while (size > 0) {
//                TreeNode node = deque.poll();
//                swap(node);
//                if (node.left != null) deque.offer(node.left);
//                if (node.right != null) deque.offer(node.right);
//                size--;
//            }
//        }
//        return root;
//    }
//
//    public void swap(TreeNode root) {
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if(node.left != null) deque.offer(node.left);
                if(node.right != null) deque.offer(node.right);
                size--;
            }
        }
        return root;
    }
}
