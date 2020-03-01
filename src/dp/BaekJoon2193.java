package dp;

import java.util.Scanner;

public class BaekJoon2193 {

    public static void main(String[] args) {
        long[][] dp = new long[91][2];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2;i<=n;i++) {
            dp[i][0] = dp[i-1][1] + dp[i-1][0];
            dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);

    }
}
