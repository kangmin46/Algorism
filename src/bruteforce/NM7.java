package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class NM7 {
    static int n;
    static int m;
    static int[] inputs;
    static int[] results;

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
        System.out.println(go(0));
    }

    private static StringBuffer go(int index) {
        StringBuffer stringBuffer = new StringBuffer();

        if (index == m) {
            for (int i = 0; i < index; i++) {
                if(i == index-1) stringBuffer.append(results[i]+"\n");
                else stringBuffer.append(results[i]+" ");
            }
            return stringBuffer;
        }

        for(int i=1;i<=n;i++) {
            results[index] = inputs[i];
            stringBuffer.append(go(index+1));
        }
        return stringBuffer;
    }
}
