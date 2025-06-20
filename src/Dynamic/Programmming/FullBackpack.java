package Dynamic.Programmming;

import java.util.Scanner;

/**
 * ClassName: FullBackpack
 * Package: Dynamic.Programmming
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 04:03
 * @Version 1.0
 */
public class FullBackpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagWeight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][bagWeight + 1];

        // 初始化
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        // 动态规划
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n - 1][bagWeight]);
        scanner.close();
    }
}
