package bruteforce;

import java.util.Scanner;

public class NM2 {
    static int n;
    static int m;
    static boolean check[];
    static int result[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        check = new boolean[n + 1];
        result = new int[m + 1];

        go(0, 1);
    }

    private static void go(int index, int pre) {
        if (index == m) {
            for (int i = 0; i < index; i++) {
                if(i== index-1) System.out.println(result[i]);
                else System.out.print(result[i]+" ");
            }
            return;
        }

        for (int i = pre; i <= n; i++) {
            if (check[i]) continue;
            check[i] = true;
            result[index] = i;
            go(index + 1, i+1);
            check[i] = false;
        }
    }
}
