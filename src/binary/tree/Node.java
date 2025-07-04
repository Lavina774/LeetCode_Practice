package binary.tree;

import java.util.List;

/**
 * ClassName: Node
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-17 17:46
 * @Version 1.0
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
