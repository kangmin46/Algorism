package dp;

import java.util.Scanner;

public class BaekJoon13398 {
    public static void main(String[] args) {
        // 연속합 2
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        int dp2[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }
        dp[1] = arr[1];
        dp2[1] = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int ans = dp[1];

        for(int i=2;i<=n;i++) {
            if(ans < dp[i]) ans = dp[i];
        }

        dp2[n] = arr[n];

        for (int i = n-1; i > 0; i --) {
            dp2[i] = Math.max(dp2[i+1] + arr[i], arr[i]);
        }

        for(int i=2;i<n;i++) {
            if(ans < dp[i-1] + dp2[i+1]) ans = dp[i-1] + dp2[i+1];
        }

        System.out.println(ans);
    }
}
