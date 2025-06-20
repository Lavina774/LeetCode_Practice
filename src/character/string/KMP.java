package character.string;

import java.util.Scanner;

/**
 * ClassName: KMP
 * Package: character.string
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-05-07 20:22
 * @Version 1.0
 */
public class KMP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.nextLine().trim();
        String needle = scanner.nextLine().trim();
        int index = basicKMP(haystack, needle);
        System.out.println(index);
        scanner.close();
    }

    private static int basicKMP(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        int[] next = nextArr(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            if(j == needle.length() - 1) {
                return (i- j);
            }
        }
        return -1;
    }

    private static int[] nextArr(String needle) {
        int[] next = new int[needle.length()];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            while (j >= 0 && needle.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(needle.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static boolean repeatSubstringPattern(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        int l = next[s.length()-1];
        return s.length() % (s.length() - l) == 0 && l > 0;
    }

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder();
        int times = 0;
        while (repeatedA.length() <= b.length()) {
            repeatedA.append(a);
            times++;
        }
        repeatedA.append(a);
        times++;
        int[] next = createNext(b);
        int j = -1;
        for (int i = 0; i < repeatedA.length(); i++) {
            while (j >=0 && repeatedA.charAt(i) != b.charAt(j+1)) {
                j = next[j];
            }
            if (repeatedA.charAt(i) == b.charAt(j+1)) {
                j++;
            }
            if(j == b.length()-1) {
                if(repeatedA.length()-i-1 == 2*a.length()) return times-2;
                if(repeatedA.length()-i-1 >= a.length() && repeatedA.length()-i-1 < 2*a.length()) return times-1;
                return times;
            }
        }
        return -1;
    }

    private static int[] createNext(String needle) {
        int[] next = new int[needle.length()];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            while (j>=0 && needle.charAt(i) != needle.charAt(j+1)) {
                j = next[j];
            }
            if(needle.charAt(i) == needle.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static String shortestPalindrome(String s) {
        StringBuilder sPlus = new StringBuilder();
        sPlus.append(s).append("#");
        for (int i = s.length()-1; i >= 0; i--) {
            sPlus.append(s.charAt(i));
        }
        int[] lps = new int[sPlus.length()];
        int j = -1;
        lps[0] = j;
        for (int i = 1; i < sPlus.length(); i++) {
            while (j>=0 && sPlus.charAt(i) != sPlus.charAt(j+1)){
                j = lps[j];
            }
            if(sPlus.charAt(i) == sPlus.charAt(j+1)) {
                j++;
            }
            lps[i] = j;
        }
        int index = lps[sPlus.length()-1];
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i > index; i--) {
            result.append(s.charAt(i));
        }
        return result.append(s).toString();
    }
}
