package binary.tree;

/**
 * ClassName: MorrisTraversal
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-17 17:23
 * @Version 1.0
 */
public class MorrisTraversal {
    public void inorder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.val + " "); // 访问节点
                cur = cur.right;
            } else {
                // 查找前驱节点
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur; // 建立临时链接
                    cur = cur.left;
                } else {
                    pre.right = null; // 恢复树结构
                    System.out.print(cur.val + " "); // 访问节点
                    cur = cur.right;
                }
            }
        }
    }

    public void preorder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    System.out.print(cur.val + " "); // 在建立链接前访问
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}
