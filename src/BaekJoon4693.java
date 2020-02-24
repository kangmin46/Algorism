import java.util.Scanner;

public class BaekJoon4693 {
    static int[][] map;
    static int[][] temp;
    static int w;
    static int h;
    static int[] global_dh = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] global_dw = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        w = scanner.nextInt();
        h = scanner.nextInt();
        map = new int[w][h];
        temp = new int[w][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[j][i] = scanner.nextInt();
            }
        }

        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[j][i] == 1 && temp[j][i] == 0) {
                    dfs(j, i, ++count);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int localW, int localH, int count) {
        temp[localW][localH] = count;

        for (int i = 0; i < 8; i++) {
            int dh = global_dh[i] + localH;
            int dw = global_dw[i] + localW;
            if (dh >= 0 && dh < h && dw >= 0 && dw < w) {
                if (temp[dw][dh] == 0 && map[dw][dh] == 1) {
                    dfs(dw, dh, count);
                }
            }
        }
    }
}
