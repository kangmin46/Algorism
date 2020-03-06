package dp;

import java.util.Scanner;

public class BaekJoon2225 {
    static long mod = 1000000000L;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[][] dp = new long[n + 1][k + 1];

        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= k ; j++) {
                for (int l = 0; l <= i; l++) {
                    dp[i][j] += dp[i - l][j - 1];
                    dp[i][j] %= mod;
                }
            }
        }


        System.out.println(dp[n][k]);
    }
}
