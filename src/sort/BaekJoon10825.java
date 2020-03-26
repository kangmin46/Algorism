package sort;

import java.util.Arrays;
import java.util.Scanner;

class Member2 {
    String name;
    int gook;
    int young;
    int su;

    public Member2(String name, int gook, int young, int su) {
        this.name = name;
        this.gook = gook;
        this.young = young;
        this.su = su;
    }
}

public class BaekJoon10825 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Member2[] member2s = new Member2[n];

        scanner.nextLine();
        for(int i=0;i<n;i++) {
            String[] s = scanner.nextLine().split(" ");
            member2s[i] = new Member2(s[0],Integer.parseInt(s[1]), Integer.parseInt(s[2]),Integer.parseInt(s[3]));
        }

        Arrays.sort(member2s, (o1, o2) -> {
            if(o1.gook >  o2.gook) {
                return -1;
            }
            else if(o1.gook == o2.gook) {
                if(o1.young < o2.young) {
                    return -1;
                }else if(o1.young == o2.young) {
                    if(o1.su > o2.su) {
                        return -1;
                    } else if(o1.su == o2.su) {
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
            return 1;
        });

        for (Member2 member2 : member2s) {
            System.out.println(member2.name);
        }

    }
}
