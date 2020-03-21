package dp;

import java.util.Scanner;

public class BaekJoon15988 {
    static long dp[];
    static long mod = 1000000009L;

    public static void main(String[] args) {
        // 1 2 3 더하기 문제
        Scanner scanner = new Scanner(System.in);
        dp = new long[1000001];
        dp[0] = 1;

        for(int i=1;i<=1000000;i++) {
            for(int j=1;j<=3;j++) {
                if(i>= j) {
                    dp[i] += dp[i-j];
                }
            }
            dp[i] %= mod;
        }
        int testCase = scanner.nextInt();

        for(int i=0;i<testCase;i++) {
            int n  = scanner.nextInt();
            System.out.println(dp[n]);
        }
        }
    }

