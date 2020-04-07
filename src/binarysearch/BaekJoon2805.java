package binarysearch;

import java.util.Scanner;

public class BaekJoon2805 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long M = scanner.nextLong();
        long[] array = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            max = Math.max(max, array[i]);
        }

        long left = 0;
        long right = max;
        long ans  = 0;
        long mid;
        while (left <= right) {
            mid = (left + right) /2;
            if(check(array, mid, M)) {
                ans = Math.max(ans, mid);
                left = mid +1;
            }
            else {
                right = mid -1;
            }
        }

        System.out.println(ans);
    }

    private static boolean check(long[] array, long mid, long M) {
        long sum = 0;
        for(int i=0;i<array.length;i++) {
            if(array[i] - mid > 0) {
                sum+= array[i] - mid;
            }
        }
        return sum >= M;
    }

}
