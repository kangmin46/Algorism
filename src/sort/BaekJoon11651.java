package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon11651 {
    // 정렬 y에 대해서 오름차순으로 정리하고 y가 같다면 x로 오름차순 정리

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Fair[] fairs = new Fair[n];

        for(int i=0;i<n;i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            fairs[i] = new Fair(x,y);
        }

        Arrays.sort(fairs, (o1, o2) -> {
            if(o1.y < o2.y) {
                return -1;
            }

            else if(o1.y == o2.y) {
                if(o1.x > o2.x) {
                    return 1;
                }else if(o1.x == o2.x) return 0;
                else return -1;
            }

            return 1;
        });

        StringBuffer stringBuffer = new StringBuffer();

        for (Fair fair : fairs) {
            stringBuffer.append(fair.x+" "+fair.y+"\n");
        }

        System.out.print(stringBuffer);
    }
}
