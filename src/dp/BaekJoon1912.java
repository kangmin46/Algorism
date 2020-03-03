package dp;

import java.util.Scanner;

public class BaekJoon1912 {
    public static void main(String[] args) {
        // 최소 합을 구하는 문제

        // 10
        // 10 -4 3 1 5 6 -35 12 21 -1

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            p[i] = scanner.nextInt();
        }

        dp[0] = p[0];
        for(int i=1;i<n; i++) {
            dp[i] = Math.max(dp[i-1] + p[i], p[i]);
        }

        int ans = dp[0];

        for(int i=1;i<n; i++) {
            if(ans < dp[i]) {
                ans = dp[i];
            }
        }

        System.out.println(ans);
    }
}
