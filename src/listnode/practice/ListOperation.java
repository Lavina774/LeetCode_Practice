package listnode.practice;

import java.util.Scanner;

/**
 * ClassName: removeElements
 * Package: listnode.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-04-22 11:20
 * @Version 1.0
 */
public class ListOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            try {
                String data = scanner.nextLine().trim();
                if (data.isEmpty()) break;

                String[] parts = data.split("\\s+");
                int[] arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i]);
                }
                int val = scanner.nextInt();
                scanner.nextLine(); // 读掉回车，避免下次 hasNextLine 出错

                ListNode head = createList(arr);

                // 先复制原链表一份（深拷贝）
                ListNode copiedHead = copyList(head);
                ListNode copiedHead2 = copyList(head);
                ListNode copiedHead3 = copyList(head);

                // 删除元素
                ListNode newHead = removeElements(head, val);

                // 反转的是原始的副本
                ListNode reversedList = reverseList(copiedHead);

                ListNode swapList = SwapPairs(copiedHead2);

                ListNode removeNthEnd = deleteNthFromEnd(copiedHead3, 7);

                printList(newHead);
                printList(reversedList);
                printList(swapList);
                printList(removeNthEnd);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
        scanner.close();
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static ListNode SwapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstNode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondNode; // 临时节点，保存两个节点之中的第二个节点
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            // 节点1 和 节点2
            firstNode = cur.next;
            secondNode = cur.next.next;

            // 开始交换
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            cur.next = secondNode;

            // 向前走两步
            cur = firstNode;
        }
        return dummy.next;
    }

    public static ListNode createList(int[] arr) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        for (int value : arr) {
            cur.next = new ListNode(value);
            cur = cur.next;
        }

        return dummyHead.next;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode copyList(ListNode head) {
        if (head == null) return null;

        ListNode newHead = new ListNode(head.val);
        ListNode current = newHead;
        ListNode original = head.next;

        while (original != null) {
            current.next = new ListNode(original.val);
            current = current.next;
            original = original.next;
        }

        return newHead;
    }

    public static ListNode deleteNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
