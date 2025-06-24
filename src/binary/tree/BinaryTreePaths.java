package binary.tree;

import java.util.*;

/**
 * ClassName: BinaryTreePaths
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-20 17:26
 * @Version 1.0
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        List<Integer> paths = new ArrayList<>();
        if(root == null) return res;
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> res) {
        paths.add(node.val);
        if(node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.getLast());
            res.add(sb.toString());
        }
        if (node.left != null) {
            traversal(node.left, paths, res);
            paths.removeLast();
        }
        if (node.right != null) {
            traversal(node.right, paths, res);
            paths.removeLast();
        }

//        try {
//            if (node.left == null && node.right == null) {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < paths.size()-1; i++) {
//                    sb.append(paths.get(i)).append("->");
//                }
//                sb.append(paths.getLast());
//                res.add(sb.toString());
//            }
//
//            if (node.left != null) traversal(node.left, paths, res);
//            if (node.right != null) traversal(node.right, paths, res);
//
//        } finally {
//            paths.removeLast();
//        }
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

    // LeetCode 988

    List<Integer> res = new LinkedList<>();
    public String smallestFromLeaf(TreeNode root) {
        Deque<Integer> paths = new LinkedList<>();
        if (root == null) return "";
        findSmallest(root, paths);
        StringBuilder sb = new StringBuilder();
        for (Integer re : res) {
            sb.append((char) (re + 97));
        }
        return sb.toString();
    }

    private void findSmallest(TreeNode node, Deque<Integer> paths) {
        if(node == null) return;
        paths.addFirst(node.val);
        try {
            if (node.left == null && node.right == null) {
                List<Integer> tempPath = new LinkedList<>(paths);
                if (res.isEmpty()) {
                    res = new LinkedList<>(paths);
                } else {
                    int len = Math.min(tempPath.size(), res.size());
                    for (int i = 0; i < len; i++) {
                        if(tempPath.get(i) < res.get(i)) {
                            res = new LinkedList<>(tempPath);
                            return;
                        } else if (tempPath.get(i) > res.get(i)){
                            return;
                        }
                    }
                    if (tempPath.size() < res.size()) {
                        res = new LinkedList<>(tempPath);
                    }
                }
            }

            findSmallest(node.left, paths);
            findSmallest(node.right, paths);
        } finally {
            paths.removeFirst();
        }
    }
}
