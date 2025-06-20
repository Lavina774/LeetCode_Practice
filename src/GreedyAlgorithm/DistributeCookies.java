package GreedyAlgorithm;

import java.util.Arrays;

/**
 * ClassName: DistributeCookies
 * Package: GreedyAlgorithm
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 03:20
 * @Version 1.0
 */
public class DistributeCookies {
    // 思路1：优先考虑饼干，小饼干先喂饱小胃口
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    // 思路2：优先考虑胃口，先喂饱大胃口
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if(start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }
}
