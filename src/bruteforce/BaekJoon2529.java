package bruteforce;

import java.util.Scanner;

public class BaekJoon2529 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        char[] a = new char[n];
        int[] small = new int[n + 1];
        int[] big = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().charAt(0);
        }

        for (int i = 0; i <= n; i++) {
            small[i] = i;
            big[i] = 9 - i;
        }

        do {
            if (check(big, a)) break;
        } while (prePermutation(big));

        do {
            if (check(small, a)) break;
        } while (nextPermutation(small));



        for (int i = 0; i < big.length; i++) {
            System.out.print(big[i]);
        }
        System.out.println();

        for (int i = 0; i < small.length; i++) {
            System.out.print(small[i]);
        }
        System.out.println();


    }

    private static boolean prePermutation(int[] big) {
        int i = big.length - 1;

        while (i >= 0 && big[i - 1] <= big[i]) {
            i -= 1;
        }

        if (i <= 0) return false;

        int j = big.length - 1;

        while (big[i - 1] <= big[j]) {
            j -= 1;
        }

        int temp = big[i - 1];
        big[i - 1] = big[j];
        big[j] = temp;

        j = big.length - 1;

        while (i < j) {
            temp = big[i];
            big[i] = big[j];
            big[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }

    private static boolean check(int[] arr, char[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '<' && arr[i] > arr[i + 1]) return false;
            if (a[i] == '>' && arr[i] < arr[i + 1]) return false;
        }
        return true;
    }

    private static boolean nextPermutation(int[] small) {
        int i = small.length - 1;

        while (i > 0 && small[i] <= small[i - 1]) {
            i -= 1;
        }

        if (i <= 0) return false;

        int j = small.length - 1;

        while (small[i - 1] >= small[j]) {
            j -= 1;
        }

        int temp = small[i - 1];
        small[i - 1] = small[j];
        small[j] = temp;

        j = small.length - 1;

        while (i < j) {
            temp = small[i];
            small[i] = small[j];
            small[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
