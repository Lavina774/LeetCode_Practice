package binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: ConnectPointers
 * Package: binary.tree
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-18 14:25
 * @Version 1.0
 */
public class ConnectPointers {
    public Node2 connect(Node2 root) {
        Queue<Node2> queue = new LinkedList<>();
        if(root == null) return root;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node2 node = queue.poll();
                if (i == levelSize-1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }

    public Node2 connect2(Node2 root) {
        if (root == null) return null;
        Node2 current = root; // 当前层遍历的起点（总是该层第一个节点）

        while (current != null) { // 外层循环：处理每一层
            // 为下一层创建虚拟头节点和游标
            Node2 dummyHead = new Node2(0);
            Node2 prev = dummyHead;

            // 内层循环：遍历当前层的所有节点
            while (current != null) {
                // 连接左孩子（如果存在）
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }
                // 连接右孩子（如果存在）
                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }
                // 移动到当前层的下一个节点（通过已建立的next指针）
                current = current.next;
            }

            // 移动到下一层：dummyHead.next 是下一层的第一个节点
            current = dummyHead.next;
        }
        return root;
    }
}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _left, Node2 _right, Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};