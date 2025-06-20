package character.string;

/**
 * ClassName: ReverseArrayString
 * Package: character.string
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-04-25 16:31
 * @Version 1.0
 */
public class ReverseArrayString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            int right = Math.min(left + k - 1, arr.length - 1);
            while (left < right) {
                char temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}
