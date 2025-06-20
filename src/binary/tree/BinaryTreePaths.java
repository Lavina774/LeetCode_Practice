package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    }

    // LeetCode 113

}
