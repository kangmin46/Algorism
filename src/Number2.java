public class Number2 {
    static int maxQuestion;
    static int answer = 0;

    public static void main(String[] args) {
        String answerSheet = "4132315142";
        String[] sheets = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};

        question("3241523133","3243523133", answerSheet);
        for (int i = 0; i < sheets.length - 1; i++) {
            for (int j = i + 1; j < sheets.length; j++) {
                int count = question(sheets[i], sheets[j], answerSheet);
                int temp = count + (maxQuestion * maxQuestion);
                if (answer < temp) answer = temp;

            }
        }
        System.out.println(answer);

    }

    private static int question(String a, String b, String answerSheet) {
        int count = 0;
        int max = 0;
        int continuity = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i) && answerSheet.charAt(i) != a.charAt(i)) {
                count++;
                continuity++;
                if (max < continuity) max = continuity;
            } else {
                continuity = 0;
            }

        }
        maxQuestion = max;
        return count;
    }
}
