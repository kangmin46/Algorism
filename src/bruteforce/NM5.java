package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class NM5 {
    static int n;
    static int m;
    static int[] inputs;
    static int[] result;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        check = new boolean[n+1];
        result = new int[m + 1];
        inputs = new int[n + 1];
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
                if(i == index-1) stringBuffer.append(result[i]+"\n");
                else stringBuffer.append(result[i]+" ");
            }
            return stringBuffer;
        }

        for(int i=1;i<=n;i++) {
            if(check[i]) continue;
            check[i] = true;
            result[index] = inputs[i];
            stringBuffer.append(go(index+1));
            check[i] = false;
        }
        return stringBuffer;
    }
}
