package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2178 {
    static int h;
    static int w;
    static int[][] map;
    static int[][] temp;
    static boolean[][] check;
    static int[] dh = {0, 0, 1, -1};
    static int[] dw = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        h = scanner.nextInt();
        w = scanner.nextInt();
        scanner.nextLine();
        map = new int[h][w];
        check = new boolean[h][w];
        temp = new int[h][w];
        for (int i = 0; i < h; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(new Fair(0, 0, 1));

        System.out.println(temp[h-1][w-1]);

    }

    private static void bfs(Fair fair) {
        Queue<Fair> queue = new LinkedList<>();

        queue.add(fair);
        temp[fair.h][fair.w] = fair.count;

        while (!queue.isEmpty()) {
            Fair remove = queue.remove();
            int localH = remove.h;
            int localW = remove.w;
            for (int i = 0; i < 4; i++) {
                int localDh = dh[i] + localH;
                int localDw = dw[i] + localW;
                if (localDh >= 0 && localDh < h && localDw >= 0 && localDw < w) {
                    if (temp[localDh][localDw] == 0 && map[localDh][localDw] == 1) {
                        queue.add(new Fair(localDw, localDh, remove.count + 1));
                        temp[localDh][localDw] = remove.count + 1;
                    }
                }
            }
        }
    }

    public static class Fair {
        private int w;
        private int h;
        private int count;

        public Fair(int w, int h, int count) {
            this.w = w;
            this.h = h;
            this.count = count;
        }
    }

}
