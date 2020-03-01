package dp;

import java.util.Scanner;

public class BaekJoon15990 {
    static long mod = 1000000009;
    static int limit = 100000;
    static long [][]dp= new long[limit +1][4];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int j=1;j<=limit; j++) {
            if(j-1 >= 0) {
                dp[j][1] = dp[j-1][2] + dp[j-1][3];
                if(j==1) {
                    dp[j][1] = 1;
                }
            }
            if(j-2 >= 0) {
                dp[j][2] = dp[j-2][1] + dp[j-2][3];
                if(j==2) {
                    dp[j][2] = 1;
                }
            }
            if(j-3 >= 0) {
                dp[j][3] = dp[j-3][1] + dp[j-3][2];
                if(j==3) {
                    dp[j][3] = 1;
                }
            }

            dp[j][1] %= mod;
            dp[j][2] %= mod;
            dp[j][3] %= mod;
        }


        int testCase = scanner.nextInt();
        for(int i=0; i<testCase; i++) {
            int n = scanner.nextInt();
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) %  mod);
        }
    }
}
