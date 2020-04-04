package implement;

import java.util.Scanner;

public class BaekJoon2884 {
    public static void main(String[] args) {
        // 알람 45분 늦는 문제
        Scanner scanner = new Scanner(System.in);

        int h = scanner.nextInt();
        int m = scanner.nextInt();

        m = m - 45;
        if (m < 0) {
            h -= 1;
            m = 60 + m;
        }

        if (h < 0) {
            h = 23;
        }

        System.out.println(h + " " + m);
    }
}
