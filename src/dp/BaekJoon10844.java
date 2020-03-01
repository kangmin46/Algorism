package dp;

import java.util.Scanner;

public class BaekJoon10844 {
    static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long dp[][] = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                if(j-1 >= 0) {
                    dp[i][j] += dp[i - 1][j-1];
                }

                if(j+1 <= 9)  {
                    dp[i][j] += dp[i - 1][j + 1];
                }

                dp[i][j] %= mod;
            }
        }


        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[n][i];
        }
        System.out.println(result % mod);

    }
}
