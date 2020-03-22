package dp;

import java.util.Map;
import java.util.Scanner;

public class BaekJoon1149 {
    public static void main(String[] args) {
        // RGB 거리 문제
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] color = new int[4][n+1];
        int[][] dp = new int[4][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=3;j++) {
                color[j][i] = scanner.nextInt();
            }
        }

        dp[1][1] = color[1][1];
        dp[2][1] = color[2][1];
        dp[3][1] = color[3][1];

        for(int i=2;i<=n;i++) {
            dp[1][i] = Math.min(dp[2][i-1], dp[3][i-1]) + color[1][i];
            dp[2][i] = Math.min(dp[1][i-1], dp[3][i-1]) + color[2][i];
            dp[3][i] = Math.min(dp[1][i-1], dp[2][i-1]) + color[3][i];
        }

        System.out.println(Math.min(Math.min(dp[1][n], dp[2][n]) , dp[3][n]));


    }
}
