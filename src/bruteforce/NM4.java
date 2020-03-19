package bruteforce;

import java.util.Scanner;

public class NM4 {
    static int n;
    static int m;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        result = new int[m + 1];

        System.out.println(go(0, 1));
    }

    private static StringBuffer go(int index, int start) {
        StringBuffer stringBuffer = new StringBuffer();
        if (index == m) {
            for (int i = 0; i < index; i++) {
                if(i== index-1) stringBuffer.append(result[i]+"\n");
                else stringBuffer.append(result[i]+" ");
            }
            return stringBuffer;
        }

        for (int i = start; i <= n; i++) {
            result[index] = i;
            stringBuffer.append(go(index + 1, i));
        }

        return stringBuffer;
    }
}
