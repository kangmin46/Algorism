package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NM11 {
    static int n;
    static int m;
    static List<Integer> inputs;
    static int results[];
    static List<String> temp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        results = new int[m + 1];

        Set<Integer> set = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            set.add(scanner.nextInt());
        }

        inputs = new ArrayList<>(set);
        Collections.sort(inputs);

        go(0);
    }

    private static void go(int index) {
        StringBuffer stringBuffer = new StringBuffer();
        if (index == m) {
            for (int i = 0; i < index; i++) {
                if (i == index - 1) stringBuffer.append(results[i]);
                else stringBuffer.append(results[i] + " ");
            }
            System.out.println(stringBuffer.toString());
            return;
        }

        for (int i = 1; i <= inputs.size(); i++) {
            results[index] = inputs.get(i-1);
            go(index+1);
        }
    }
}
