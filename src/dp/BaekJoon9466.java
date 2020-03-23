package dp;

import java.util.Scanner;

public class BaekJoon9466 {
    public static void main(String[] args) {
        // 스티커 문제
        Scanner scanner = new Scanner(System.in);
        int testCase  = scanner.nextInt();
        for(int k=0;k<testCase;k++) {
            int n = scanner.nextInt();
            int[][] sticker = new int[3][n + 1];
            int[][] dp = new int[4][n + 1];

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= n; j++) {
                    sticker[i][j] = scanner.nextInt();
                }
            }

            dp[1][1] = sticker[1][1];
            dp[2][1] = sticker[2][1];
            dp[3][1] = 0;
            for (int i = 2; i <= n; i++) {
                dp[1][i] = Math.max(dp[2][i-1], dp[3][i-1]) + sticker[1][i];
                dp[2][i] = Math.max(dp[1][i-1], dp[3][i-1])  + sticker[2][i];
                dp[3][i] = Math.max(dp[1][i-1], dp[2][i-1]);
            }

            System.out.println(Math.max(dp[1][n] , dp[2][n]));
        }
    }
}
