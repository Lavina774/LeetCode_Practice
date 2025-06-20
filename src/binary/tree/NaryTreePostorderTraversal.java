package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: NaryTreePostorderTraversal
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-17 18:42
 * @Version 1.0
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if(node != null) {
                stack.pop();
                List<Node> children = node.children;
                stack.push(node);
                stack.push(null);
                if (!children.isEmpty()) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }
            } else {
                stack.pop();
                result.add(stack.pop().val);
            }
        }
        return result;
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder3(root, result);
        return result;
    }

    private void postorder3(Node root, List<Integer> result) {
        if(root == null) return;
        List<Node> children = root.children;
        for (Node child : children) {
            postorder3(child, result);
        }
        result.add(root.val);
    }
}
