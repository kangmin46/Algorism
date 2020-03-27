package bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon14889 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] s = new int[n][n];

        int[] team = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (i < n / 2) team[i] = 0;
            else team[i] = 1;
        }

        int result = Integer.MAX_VALUE;

        do {
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (team[i] == 0) start.add(i);
                else link.add(i);
            }
            int startScore = 0;
            int linkScore = 0;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i == j) continue;
                    startScore += s[start.get(i)][start.get(j)];
                    linkScore += s[link.get(i)][link.get(j)];
                }
            }
            int diff = Math.abs(startScore - linkScore);
            if (result > diff) result = diff;
        } while (nextPermutation(team));

        System.out.println(result);
    }


    private static boolean nextPermutation(int[] array) {
        int i = array.length - 1;

        while (i > 0 && array[i] <= array[i - 1]) {
            i -= 1;
        }

        if (i <= 0) return false;

        int j = array.length - 1;

        while (array[i - 1] >= array[j]) {
            j -= 1;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;

        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }


}
