package binary.tree;

import java.util.Arrays;

/**
 * ClassName: BuildTree
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-24 19:39
 * @Version 1.0
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        TreeNode root = new TreeNode();
        if(length > 0) {
            root.val = postorder[length-1];
        } else {
            return null;
        }
        for (int i = 0; i < length; i++) {
            if (inorder[i] == root.val) {
                int[] leftTreeInorder = Arrays.copyOfRange(inorder, 0, i);
                int[] leftTreePostorder = Arrays.copyOfRange(postorder, 0, i);
                int[] rightTreeInorder = Arrays.copyOfRange(inorder, i+1, length);
                int[] rightTreePostorder = Arrays.copyOfRange(postorder, i, length-1);
                root.left = buildTree(leftTreeInorder, leftTreePostorder);
                root.right = buildTree(rightTreeInorder, rightTreePostorder);
            }
        }
        return root;
    }

    // Use Map

}
