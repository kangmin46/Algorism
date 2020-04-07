import java.util.ArrayList;
import java.util.List;

public class Number3 {
    static boolean[] check;
    static int[] array;
    static int max = 0;

    public static void main(String[] args) {
        String road = "111011110011111011111100011111";
        int n = 3;

        List<RepairPoint> repairPoints = generateRepairPoint(road);
        array = new int[n];

        System.out.println(repairPoints.size());
        check = new boolean[repairPoints.size()];

        go(0, n, repairPoints.size(), repairPoints, road);
        System.out.println(max);

    }

    private static List<RepairPoint> generateRepairPoint(String road) {
        List<RepairPoint> list = new ArrayList<>();
        int start = 0;
        int length = 0;
        for (int i = 0; i < road.length() - 1; i++) {
            if (road.charAt(i) == '1' && road.charAt(i + 1) == '0') {
                start = i + 1;
            } else if (road.charAt(i) == '0' && road.charAt(i + 1) == '1') {
                length = i + 1 - start;
                list.add(new RepairPoint(start, length));
                start = 0;
            }
        }
        return list;
    }

    private static void go(int index, int n, int length, List<RepairPoint> repairPoints, String road) {
        if (index == n) {
            char[] chars = road.toCharArray();
            for (int i : array) {
                RepairPoint repairPoint = repairPoints.get(i);
                for (int j = repairPoint.start; j < repairPoint.length+repairPoint.start; j++) {
                    chars[j] = '1';
                }
            }
            int continueCount = 1;
            int continueMax = 0;
            for (int k = 0; k < chars.length - 1; k++) {
                if (chars[k] == '1' && chars[k] == chars[k + 1]) continueCount++;
                else {
                    if (continueMax < continueCount) continueMax = continueCount;
                    continueCount = 1;
                }
            }
            if (max < continueMax) max = continueMax;
            return;
        }

        for (int i = 0; i < length; i++) {
            if (check[i]) continue;
            check[i] = true;
            array[index] = i;
            go(index + 1, n, length, repairPoints, road);
            check[i] = false;
        }
    }

    static class RepairPoint {
        int start;
        int length;

        public RepairPoint(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }
}
