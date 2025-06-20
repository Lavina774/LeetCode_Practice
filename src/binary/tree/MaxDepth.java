package binary.tree;

import java.util.*;

/**
 * ClassName: MaxDepth
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-18 14:48
 * @Version 1.0
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.offer(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }

    public int maxDepth3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Deque<Integer> depth = new ArrayDeque<>();
        if(root == null) return 0;
        stack.push(root);
        depth.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depth.pop();
            max = Math.max(max, currentDepth);
            if(node.right != null) {
                stack.push(node.right);
                depth.push(currentDepth+1);
            }
            if(node.left != null) {
                stack.push(node.left);
                depth.push(currentDepth+1);
            }
        }
        return max;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return depth(root);
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        if(left == 0 || right == 0) {
            return 1+left+right;
        }

        return 1+Math.min(left,right);
    }

    public int minDepth2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Deque<Integer> depth = new ArrayDeque<>();
        if (root == null) return 0;
        stack.push(root);
        depth.push(1);
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depth.pop();
            if (node.left == null && node.right == null) {
                min = Math.min(min, currentDepth);
            }
            if (node.right != null) {
                stack.push(node.right);
                depth.push(currentDepth + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depth.push(currentDepth + 1);
            }
        }
        return min;
    }

    public int minDepth3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }

//    public int maxDepth2(Node root) {
//        if (root == null) return 0;
//        return maxDep(root, 1);
//    }
//
//    public int maxDep(Node node, int depth) {
//        if(node == null) return 0;
//        List<Node> children = node.children;
//        if(children.isEmpty()) return depth;
//        for (Node child : children) {
//            depth = Math.max(maxDep(child, depth+1), depth);
              // depth是这个函数中的函数参数，所以一旦更新就会更新所有的depth值
    // 在同一个函数调用中，局部变量`depth`被循环中的赋值修改了，导致后续递归调用使用了错误的深度值。
    // 但并不是全局变量，而是局部变量在同一个函数调用中被修改而影响了后续操作。
//        }
//        return depth;
//    }  // 当处理第一个子节点后，depth可能被更新为较大的值（例如子树深度），此时处理第二个子节点时，传入的深度参数变为(更新后的depth) + 1而非预期的(原始depth) + 1

    // 函数式编程的不可变性原则——递归函数的参数应被视为不可变输入，而不是可修改的工作变量。
    public int maxDepth3(Node root) {
        if (root == null) return 0;
        return maxDep(root, 1);
    }

    public int maxDep(Node node, int depth) {
        if (node == null) return 0;
        if (node.children.isEmpty()) return depth;

        int maxChildDepth = 0; // 新建临时变量，记录所有子树的最大深度
        for (Node child : node.children) {
            // 递归时传递固定值 depth+1（不修改depth）
            int childDepth = maxDep(child, depth + 1);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }
        return maxChildDepth; // 返回临时变量
    }

    public int maxDepth2(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        for (Node child : root.children) {
            int childDepth = maxDepth2(child);
            maxDepth = Math.max(childDepth, maxDepth);
        }
        return maxDepth+1;
    }

    public int maxDepth4(Node root) {
        Stack<Node> stack = new Stack<>();
        Deque<Integer> depth = new LinkedList<>();
        if (root == null) return 0;
        stack.push(root);
        depth.push(1);
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            List<Node> children = node.children;
            int currentDepth = depth.pop();
            maxDepth = Math.max(currentDepth, maxDepth);
            for (int i = children.size()-1; i >= 0; i--) {
                stack.push(children.get(i));
                depth.push(currentDepth+1);
            }
        }
        return maxDepth;
    }
}
