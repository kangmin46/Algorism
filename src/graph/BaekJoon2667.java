package graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon2667 {
    static int[][] map;
    static int[][] temp;
    static int n;
    static final int[] global_dx = {0, 0, -1, 1};
    static final int[] global_dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        scanner.nextLine();

        temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && temp[i][j] == 0) {
                    dfs(i, j, ++count);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }


        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=count; i++) {
            result.add(getCount(i));
        }
        Collections.sort(result);

        System.out.println(count);
        for(int i: result) {
            System.out.println(i);
        }
    }

    private static int getCount(int target) {
        int count  =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(temp[i][j] == target) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, int count) {
        temp[x][y] = count;

        for (int k = 0; k < 4; k++) {
            int dx = x + global_dx[k];
            int dy = y + global_dy[k];
            if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                if (temp[dx][dy] == 0 && map[dx][dy] == 1) dfs(dx, dy, count);
            }
        }
    }
}

