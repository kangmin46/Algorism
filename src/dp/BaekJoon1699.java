package dp;

import java.util.Scanner;

public class BaekJoon1699 {
    public static void main(String[] args) {
        // 제곱수의 합
        //dp를 풀 때에는 항상 마지막의 수를 주목해서 풀어보자.
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] dp = new int[n + 1];

        for(int i=1;i<=n; i++) { //0으로 초기화 하면 밑에서 min값으로 항상 0이 들어가기 때문에 MAX_VALUE로 초기화 한다.
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = 1;
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i - (j*j)] + 1, dp[i]);
            }
        }

        System.out.println(dp[n]);

    }

}
