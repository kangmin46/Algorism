package graph;

import java.util.Scanner;

public class BaekJoon4693 {
    static int[][] map;
    static int[][] temp;
    static int[] dx = {1, -1, 0, 0,-1,1,1,-1};
    static int[] dy = {0, 0, 1, -1,1,-1,1,-1};
    static int globalX;
    static int globalY;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            globalX = scanner.nextInt();
            globalY = scanner.nextInt();
            if (globalX == 0 && globalY == 0) break;

            map = new int[globalY][globalX];
            temp = new int[globalY][globalX];

            for (int i = 0; i < globalY; i++) {
                for (int j = 0; j < globalX; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            int count = 0;
            for (int i = 0; i < globalY; i++) {
                for (int j = 0; j < globalX; j++) {
                    if (map[i][j] == 1 && temp[i][j] == 0) {
                        bfs(i, j, ++count);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int y, int x, int count) {
        temp[y][x] = count;

        for (int i = 0; i < 8; i++) {
            int localY = dy[i] + y;
            int localX = dx[i] + x;

            if(localX >= 0 && localX < globalX && localY >= 0 && localY < globalY) {
                if(map[localY][localX] == 1 && temp[localY][localX] == 0) bfs(localY, localX, count);
            }
        }
    }
}
