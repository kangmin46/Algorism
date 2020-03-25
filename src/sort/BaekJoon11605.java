package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon11605 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Fair[] arr = new Fair[n];

        for (int i = 0; i < n; i++) {
            String[] a = bf.readLine().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            arr[i] = new Fair(x,y);
        }

        Arrays.sort(arr);

        StringBuffer stringBuffer = new StringBuffer();

        for (Fair fair : arr) {
            stringBuffer.append(fair.x+" "+fair.y+"\n");
        }

        System.out.print(stringBuffer);
    }
}

class Fair implements Comparable<Fair> {
    int x;
    int y;

    public Fair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Fair that) {
        if (this.x < that.x) {
            return -1;
        }

        else if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            } else if (this.y == that.y) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
