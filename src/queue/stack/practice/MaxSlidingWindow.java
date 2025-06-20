package queue.stack.practice;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * ClassName: MaxSlidingWindow
 * Package: queue.stack.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-11 15:04
 * @Version 1.0
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] data = line.split("\\s+");
        int[] nums = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            nums[i] = Integer.parseInt(data[i]);
        }
        int k = sc.nextInt();
        int[] maxNumWindow = maxSlidingWindow(nums, k);
        System.out.print("[");
        for (int i = 0; i < maxNumWindow.length; i++) {
            System.out.println(maxNumWindow[i] + (i < maxNumWindow.length-1 ? "," : "]"));
        }
        sc.close();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i-k+1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);

            if(i >= k-1) {
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
