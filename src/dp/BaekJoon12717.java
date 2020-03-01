package dp;

import java.util.Scanner;

public class BaekJoon12717 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 2 * dp[i-2];
            dp[i] %= 10007;
        }
        System.out.println(dp[n]);
    }
}
