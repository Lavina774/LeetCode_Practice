package listnode.practice;

/**
 * ClassName: DoubleLinkedList
 * Package: listnode.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-04-22 12:31
 * @Version 1.0
 */
class DoubleLinkedList {
    private int size;
    private DoubleListNode head;
    private DoubleListNode tail;

    DoubleLinkedList() {
        this.size = 0;
        this.head = new DoubleListNode(0);
        this.tail = new DoubleListNode(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        DoubleListNode cur = head;
        if(index < size/2) {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = size-1; i >= index ; i--) {
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        DoubleListNode newNode = new DoubleListNode(val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        DoubleListNode newNode = new DoubleListNode(val);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;

        DoubleListNode cur;
        if (index < size / 2) {
            cur = head;
            for (int i = 0; i < index; i++) cur = cur.next;
        } else {
            cur = tail;
            for (int i = 0; i < size - index; i++) cur = cur.prev;
        }

        DoubleListNode newNode = new DoubleListNode(val);
        newNode.prev = cur;
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        DoubleListNode cur;
        if(index < size / 2) {
            cur = head;
            for(int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for(int i = 0; i < size - index; i++) {
                cur = cur.prev;
            }
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }

}

class DoubleListNode {
    int val;
    DoubleListNode prev, next;

    DoubleListNode () {}

    DoubleListNode (int val) {
        this.val = val;
    }

    DoubleListNode (int val, DoubleListNode prev, DoubleListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
