package dp;

import java.util.Scanner;

public class BaekJoon2156 {
    public static void main(String[] args) {
        // 포도주 시식 문제
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] podo = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++) {
            podo[i] = scanner.nextInt();
        }

        dp[1] = podo[1];
        if(n>=2) {
            dp[2] = podo[2] + podo[1];
        }


        for(int i=3;i<=n;i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2] + podo[i]), dp[i-3] + podo[i-1] + podo[i]);
        }

        System.out.println(dp[n]);

    }
}
