package dp;

import java.util.Scanner;

public class BaekJoon11057 {
    public static void main(String[] args) {
        // 오름차순 dp 문
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[n + 1][10];
        int mod = 10007;

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += (dp[i - 1][k] % mod);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        System.out.println(result % mod);

    }
}
