package bruteforce;

import java.util.Scanner;
public class BaekJoon1182 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int count = go(array, s, 0, 0);
        if (s == 0) {
            count -= 1;
        }
        System.out.println(count);

    }

    private static int go(int[] array, int s, int index, int sum) {
        if (index == array.length) {
            if (sum == s) return 1;
            else return 0;
        }

        return go(array, s,index + 1, sum + array[index]) + go(array, s, index + 1, sum);
    }
}
