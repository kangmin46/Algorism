package bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BaekJoon1339 {
    static int[] alpha = new int[256];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] inputs = new String[n];
        HashSet<Character> set = new HashSet<>();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            inputs[i] = scanner.nextLine();
            for (int j = 0; j < inputs[i].length(); j++) {
                set.add(inputs[i].charAt(j));
            }
        }

        Character[] letters = set.toArray(new Character[set.size()]);
        Arrays.sort(letters);

        int[] array = new int[letters.length];

        for (int i = 0; i < letters.length; i++) {
            array[i] = 9 - i;
        }

        Arrays.sort(array);
        int ans = 0;
        do{
            int cal = calculate(inputs, array, letters);
            if(ans < cal) ans = cal;
        }while(nextPermutation(array));

        System.out.println(ans);
    }

    private static int calculate(String[] inputs, int[] array, Character[] letters) {

        for(int i=0;i<letters.length;i++) {
            alpha[letters[i]] = array[i];
        }
        int sum = 0;
        for (String input : inputs) {
            int now = 0;
            for( char a : input.toCharArray()) {
                now = now*10 + alpha[a];
            }
            sum+=now;
        }

        return sum;

    }

    private static boolean nextPermutation(int[] array) {
        int i = array.length - 1;

        while (i > 0 && array[i] <= array[i - 1]) {
            i -= 1;
        }

        if (i <= 0) return false;

        int j = array.length - 1;

        while (array[i - 1] >= array[j]) {
            j -= 1;
        }

        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        j = array.length - 1;

        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
