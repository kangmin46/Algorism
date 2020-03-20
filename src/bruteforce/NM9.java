package bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NM9 {
    static int n;
    static int m;
    static int[] inputs;
    static int[] results;
    static boolean[] check;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        results = new int[m + 1];
        check = new boolean[n + 1];
        inputs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            inputs[i] = scanner.nextInt();
        }

        Arrays.sort(inputs);
        go(0);

    }

    private static void go(int index) {
        StringBuffer stringBuffer = new StringBuffer();

        if (index == m) {
            for (int i = 0; i < index; i++) {
                if (i == index - 1) stringBuffer.append(results[i] + "\n");
                else stringBuffer.append(results[i] + " ");
            }

            if(!set.contains(stringBuffer.toString())) {
                set.add(stringBuffer.toString());
                System.out.print(stringBuffer.toString());
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i]) continue;
            check[i] = true;
            results[index] = inputs[i];
            go(index + 1);
            check[i] = false;
        }
    }
}
