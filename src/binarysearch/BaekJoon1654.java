package binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1654 {
    public static void main(String[] args) {
        // 랜선 자르기 문제
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int lanCount = scanner.nextInt();

        long[] array = new long[n];
        long max = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLong();
            max = Math.max(max, array[i]);
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if(check(array, mid, lanCount)) {
                result = Math.max(result, mid);
                left = mid +1;
            }
            else {
                right = mid -1;
            }
        }

        System.out.println(result);
    }

    private static boolean check(long[] array, long mid, long lanCount) {
        int sum = 0;
        for(int i=0;i<array.length;i++) {
            sum += array[i] /mid;
        }

        return sum >= lanCount;
    }
}
