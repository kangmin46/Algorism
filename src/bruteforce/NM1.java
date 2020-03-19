package bruteforce;

import java.util.Scanner;

public class NM1 {
    static boolean check[];
    static int result[];
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n =  scanner.nextInt();
        m = scanner.nextInt();
        check = new boolean[n+1];
        result = new int[n+1];

        go(0);
    }

    private static void go(int index) {
        if(index == m) {
            for(int i=0;i<index; i++) {
                if(i==index-1) System.out.println(result[i]);
                else System.out.print(result[i]+" ");
            }
        }

        for(int i=1;i<=n;i++) {
            if(check[i]) continue;
            check[i] = true;
            result[index] = i;
            go(index+1);
            check[i] = false;
            result[index] = 0;
        }
    }
}
