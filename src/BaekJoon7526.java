import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7526 {
    static int[][] map;
    static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();


        for (int i = 0; i < testCase; i++) {
            n = scanner.nextInt();
            map = new int[n][n];
            int sx = scanner.nextInt();
            int sy = scanner.nextInt();
            int ex = scanner.nextInt();
            int ey = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                Arrays.fill(map[j], -1);
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(sx);
            q.add(sy);
            map[sx][sy] = 0;

            while (!q.isEmpty()) {
                Integer x = q.remove();
                Integer y = q.remove();
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if(map[nx][ny] == -1) {
                            map[nx][ny] = map[x][y] +1;
                            q.add(nx);
                            q.add(ny);
                        }
                    }
                }

            }
            System.out.println(map[ex][ey]);
        }
    }

}
