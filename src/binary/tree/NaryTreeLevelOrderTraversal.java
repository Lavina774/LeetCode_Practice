package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: NaryTreeLevelOrderTraversal
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-17 20:16
 * @Version 1.0
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node tempNode = queue.poll();
                tempList.add(tempNode.val);
                List<Node> children = tempNode.children;
                if (!children.isEmpty()) {
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(tempList);
        }
        return result;
    }
}
