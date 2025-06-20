package two.pointers;

/**
 * ClassName: MInSubArrayLen
 * Package: two.pointers
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 02:37
 * @Version 1.0
 */
public class MInSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
