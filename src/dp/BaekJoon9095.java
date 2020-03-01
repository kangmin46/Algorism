package dp;

import java.util.Scanner;

public class BaekJoon9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=10; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for(int i=0; i<testCase; i++) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }
}
