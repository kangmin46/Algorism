package binarysearch;

import java.util.Scanner;

public class BaekJoon1790 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();

        if (calc(n) < k) {
            System.out.println("-1");
            System.exit(0);
        }

        int left = 1;
        int right = n;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long len = calc(mid);
            if (len < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        String s = Integer.toString(ans);
        long a = calc(ans);
        System.out.println(s.charAt(s.length() - (int) (a - k) - 1));
    }

    private static long calc(int n) {
        long ans = 0;

        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > n) {
                end = n;
            }
            ans += (long) (end - start + 1) * len;
        }
        return ans;
    }
}
