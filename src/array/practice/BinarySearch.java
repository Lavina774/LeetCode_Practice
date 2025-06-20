package array.practice;

import java.util.Scanner;

/**
 * ClassName: BinarySearch
 * Package: array.practice
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-05-07 16:49
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String[] lineData = line.split("\\s+");
        int[] data = new int[lineData.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(lineData[i]);
        }
        int target = scanner.nextInt();
        int[] result = searchRange(data, target);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i == result.length - 1 ? "]" : ", "));
        }
        scanner.close();
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int start = findFirst(nums, target);
        int end = findLast(nums, target);
        return new int[]{start, end};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left >= nums.length || nums[left] != target) return -1;
        return left;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) return -1;
        return right;
    }
}
