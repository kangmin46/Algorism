package dp;

import java.util.Scanner;

public class BaekJoon14002 {
    static int[] p;
    static int[] dp;
    static int[] v;
    public static void main(String[] args) {
        // 가장 큰 부분 수열 문제 4
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        p = new int[n];
        dp = new int[n];
        v = new int[n]; // 역추적을 위한 배열
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++) {
            dp[i] = 1;
            v[i] = -1;
            for(int j=0; j<i; j++) {
                if(p[j] < p[i] && dp[j] +1 > dp[i]) {
                    dp[i] +=1;
                    v[i] = j;
                }
            }
        }

        int ans = 0;  // 최대값을 구해야 되기 때문에 반복문을 돌린다.
        int p =0;
        for(int i=0; i<n; i++) {
            if(ans < dp[i]) {
                ans = dp[i];
                p = i ;
            }
        }

        System.out.println(ans);
        go(p);
        System.out.println();
    }

    private static void go(int n) {
        if(n == -1) return;
        go(v[n]);
        System.out.print(p[n] + " ");

    }
}
