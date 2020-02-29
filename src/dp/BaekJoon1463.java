package dp;

import java.util.Scanner;

public class BaekJoon1463 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n+1];
        System.out.println(go(n));
    }

    private static int go(int i) {
        if (i == 1) {
            return 0;
        }

        if (dp[i] > 0) {
            return dp[i];
        }

        dp[i] = go(i-1) +1;

        if(i%2 ==0) {
            int temp = go(i/2) +1;
            if(dp[i] > temp) dp[i] = temp;
        }

        if (i % 3 == 0) {
            int temp = go(i/3) +1;
            if(dp[i] > temp) dp[i] = temp;
        }

        return dp[i];
    }
}
