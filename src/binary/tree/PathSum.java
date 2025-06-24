package binary.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: PathSum
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-24 18:34
 * @Version 1.0
 */
public class PathSum {

    // LeetCode 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            if (hasPathSum(root.left, targetSum)) return true;
        }
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) return true;
        }
        return false;
    }


    // LeetCode 113
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> paths = new LinkedList<>();
        if (root == null) return res;
        pathTraversal(root, paths, res, 0, targetSum);
//        dfs(root, paths, res, targetSum);
        return res;
    }

    private void pathTraversal(TreeNode node, Deque<Integer> paths, List<List<Integer>> res, int sum, int targetSum) {
        paths.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                List<Integer> pathRes = new ArrayList<>(paths);
                res.add(pathRes);
            }
        }
        if (node.left != null) {
            pathTraversal(node.left, paths, res, sum, targetSum);
            paths.removeLast();
        }
        if (node.right != null) {
            pathTraversal(node.right, paths, res, sum,targetSum);
            paths.removeLast();
        }
        // The final paths will contain the root node
    }

    private void dfs(TreeNode node, Deque<Integer> path, List<List<Integer>> res, int remain) {
        if (node == null) return;

        path.addLast(node.val);
        remain -= node.val;

        try {
            if (node.left == null && node.right == null && remain == 0) {
                res.add(new ArrayList<>(path));
            }

            dfs(node.left, path, res, remain);
            dfs(node.right, path, res, remain);
        } finally {
            path.removeLast();
            // remove current node (So the final paths will be null)
        }
    }
}
