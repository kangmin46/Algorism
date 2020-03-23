package dp;

import java.util.Scanner;

public class BaekJoon1309 {
    public static void main(String[] args) {
        // 동물원 문제
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[3][n + 1];
        int mod = 9901;
        dp[0][1] = 1;
        dp[1][1] = 1;
        dp[2][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[0][i] = (dp[0][i-1] + dp[1][i-1] + dp[2][i-1]) % mod;
            dp[1][i] = dp[0][i-1] + dp[2][i-1] % mod;
            dp[2][i] = dp[0][i-1] + dp[1][i-1] % mod;
        }

        System.out.println((dp[0][n] + dp[1][n] + dp[2][n]) % mod);
    }
}
