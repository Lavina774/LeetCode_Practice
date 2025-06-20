package binary.tree;

import java.util.*;

/**
 * ClassName: NaryTreePreorderTraversal
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-17 17:45
 * @Version 1.0
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if(node != null) {
                stack.pop();
                List<Node> children = node.children;
                if(children.size() > 1) {
                    for (int i = children.size()-1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                } else if(children.size() == 1) {
                    stack.push(children.getLast());
                }
                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                result.add(stack.pop().val);
            }
        }
        return result;
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder3(root,result);
        return result;
    }

    private void preorder3(Node root, List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            preorder3(child, result);
        }
    }
}
