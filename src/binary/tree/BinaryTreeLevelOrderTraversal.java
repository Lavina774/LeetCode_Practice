package binary.tree;

import java.util.*;

/**
 * ClassName: BinaryTreeLevelOrderTraversal
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-12 17:16
 * @Version 1.0
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun1(root, 0);

        return resList;
    }

    public void checkFun1(TreeNode node, int depth) {
        if(node == null) return;
        depth++;

        if(resList.size() < depth) {
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(depth-1).add(node.val);

        checkFun1(node.left, depth);
        checkFun1(node.right, depth);
    }

    public void checkFun2(TreeNode node) {
        if(node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);

                if(tempNode.left != null) queue.offer(tempNode.left);
                if(tempNode.right != null) queue.offer(tempNode.right);
                len--;
            }

            resList.add(tempList);
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        if(root == null) return resultList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                tempList.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
            resultList.addFirst(tempList);
        }
        return resultList;
    }
}
