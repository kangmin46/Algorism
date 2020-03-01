package dp;

import java.util.Scanner;

public class BaekJoon11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] +1 ) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int ans = dp[0];

        for(int i=0; i<n; i++) {
            if(ans < dp[i]) {
                ans = dp[i];
            }
        }

        System.out.println(ans);
    }
}
