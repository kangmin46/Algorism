package stack;

import java.util.Scanner;
import java.util.Stack;

public class BaekJoon1406 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char aChar : chars) {
            left.push(aChar);
        }

        int commandCase = scanner.nextInt();
        for (int i = 0; i < commandCase; i++) {
            char command = scanner.next().charAt(0);
            switch (command) {
                case 'P':
                    left.push(scanner.next().charAt(0));
                    break;
                case 'L':
                    if(!left.isEmpty()) {
                        Character pop = left.pop();
                        right.push(pop);
                    }
                    break;
                case 'D':
                    if(!right.isEmpty()) {
                        Character pop1 = right.pop();
                        left.push(pop1);
                    }
                    break;
                case 'B':
                    if(!left.isEmpty()) left.pop();
                    break;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (Character character : left) {
            stringBuffer.append(character);
        }
        while(!right.isEmpty()) {
            stringBuffer.append(right.pop());
        }

        System.out.println(stringBuffer);
    }
}
