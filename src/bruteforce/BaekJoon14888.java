package bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon14888 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        int[] buho = new int[4];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            buho[i] = scanner.nextInt();
        }

        int m = 0;
        Integer[] array2  = new Integer[n-1];

        for (int i = 0; i < 4; i++) {
            int count = buho[i];
            for (int j = 0; j < count; j++) {
                array2[m++] = i+1;
            }
        }

        List<Integer> list1 = new ArrayList<>();

        do {
            int result = cal(arr, array2);
            list1.add(result);

        } while (nextPermutation(array2));

        Collections.sort(list1);

        int a = list1.size();
        System.out.println(list1.get(a-1));
        System.out.println(list1.get(0));
    }

    private static int cal(int[] arr, Integer[] buhoArray) {
        int result = arr[0];
        for(int i=0;i<buhoArray.length;i++) {
            switch (buhoArray[i]) {
                case 1:
                    result += arr[i+1];
                    break;
                case 2:
                    result -= arr[i+1];
                    break;
                case 3:
                    result *= arr[i+1];
                    break;
                case 4:
                    result /= arr[i+1];
                    break;
            }
        }
        return result;
    }

    private static boolean nextPermutation(Integer[] buhoArray) {
        int i = buhoArray.length - 1;

        while (i > 0 && buhoArray[i] <= buhoArray[i-1]) {
            i-=1;
        }

        if(i <= 0) return false;

        int j = buhoArray.length - 1;

        while(buhoArray[i-1] >= buhoArray[j]) {
            j-=1;
        }

        int temp = buhoArray[i-1];
        buhoArray[i-1] = buhoArray[j];
        buhoArray[j] = temp;

        j = buhoArray.length -1;

        while(i < j) {
            temp = buhoArray[i];
            buhoArray[i] = buhoArray[j];
            buhoArray[j] = temp;
            i+=1;
            j-=1;
        }

        return true;
    }
}
