import java.util.Scanner;

public class BaekJoon7576 {
    static int[][] map;
    static int[][] tomatoMap;
    static int h;
    static int w;
    static int[] dh = {0, 0, -1, 1};
    static int[] dw = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        w = scanner.nextInt();
        h = scanner.nextInt();

        map = new int[h][w];
        tomatoMap = new int[h][w];

        int empty = 0;
        int initialTomato = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = scanner.nextInt();
                tomatoMap[i][j] = map[i][j];
                if (map[i][j] == -1) empty++;
                if (map[i][j] == 1) initialTomato++;
            }
        }
        int maxTomato = (h * w) - empty;

        if (maxTomato == initialTomato) {
            System.out.println(0);
            System.exit(0);
        }

        int yesterDayTomato;
        int todayTomato = initialTomato;
        int day = 1;
        do {
            yesterDayTomato = todayTomato;
            todayTomato = oneDay(day);
            day++;
        }
        while (yesterDayTomato != todayTomato && todayTomato != maxTomato);

        if (yesterDayTomato == todayTomato) {
            System.out.println(-1);
        } else {
            System.out.println(day-1);
        }
    }

    private static int oneDay(int day) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tomatoMap[i][j] == day) {
                    go(i, j, day);
                }
            }
        }

        int tomato = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (tomatoMap[i][j] != 0 && tomatoMap[i][j] != -1) {
                    tomato++;
                }
            }
        }
        return tomato;
    }

    private static void go(int localH, int localW, int day) {
        for (int i = 0; i < 4; i++) {
            int local_dh = dh[i] + localH;
            int local_dw = dw[i] + localW;
            if (local_dh >= 0 && local_dh < h && local_dw >= 0 && local_dw < w) {
                if (tomatoMap[local_dh][local_dw] == 0) {
                    tomatoMap[local_dh][local_dw] = day + 1;
                }
            }
        }
    }
}
