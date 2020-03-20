package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NM10 {
    static int n;
    static int m;
    static int inputs[];
    static int results[];
    static List<String> temp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        inputs = new int[n + 1];
        results = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            inputs[i] = scanner.nextInt();
        }

        Arrays.sort(inputs);

        go(0,1);


    }

    private static void go(int index, int start) {
        StringBuffer stringBuffer = new StringBuffer();
        if (index == m) {
            for (int i = 0; i < index; i++) {
                if(i == index-1) stringBuffer.append(results[i]);
                else stringBuffer.append(results[i]+" ");
            }
            String result = stringBuffer.toString();
            if (!temp.contains(result)) {
                temp.add(result);
                System.out.println(result);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            results[index] = inputs[i];
            go(index+1, i+1);
        }
    }
}
