package dp;

import java.util.Scanner;

public class BeakJoon16194 {
    static int[] dp;
    static int maxCount;
    static int[] prize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        maxCount = scanner.nextInt();
        prize = new int[maxCount + 1];
        dp = new int[maxCount + 1];
        for (int i = 1; i <= maxCount; i++) {
            prize[i] = scanner.nextInt();
        }
        for(int i=1; i<=maxCount; i++) {
            dp[i] = 1000 * 10000;
        }
        dp[0] = 0;

        for(int i=1; i<=maxCount; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.min(dp[i],dp[i-j] + prize[j]);
            }
        }

        System.out.println(dp[maxCount]);
    }

}
