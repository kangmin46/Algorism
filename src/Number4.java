import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number4 {
    public static void main(String[] args) {
        String[][] snapshots = {{"ACCOUNT1", "100"},
            {"ACCOUNT2", "150"},
            {"ACCOUNT10", "150"}};
        String[][] transactions = {
            {"1", "SAVE", "ACCOUNT2", "100"},
            {"2", "WITHDRAW", "ACCOUNT1", "50"},
            {"1", "SAVE", "ACCOUNT2", "100"},
            {"4", "SAVE", "ACCOUNT3", "500"},
            {"3", "WITHDRAW", "ACCOUNT2", "30"}
        };

        Map<String, Integer> map = new HashMap<>();
        List<Transaction> transactionList = new ArrayList<>();

        for (int i = 0; i < snapshots.length; i++) {
            map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
        }

        for (int i = 0; i < transactions.length; i++) {
            int id = Integer.parseInt(transactions[i][0]);
            String command = transactions[i][1];
            String accountId = transactions[i][2];
            int money = Integer.parseInt(transactions[i][3]);
            if (transactionList.stream().anyMatch(t -> t.id == id)) {
                continue;
            } else {
                transactionList.add(new Transaction(id, command, accountId, money));
            }
        }


        for (int i = 0; i < transactionList.size(); i++) {
            Transaction transaction = transactionList.get(i);

            if(!map.containsKey(transaction.accountId)) {
                map.put(transaction.accountId, transaction.money);
                continue;
            }

            Integer snapShotMoney = map.get(transaction.accountId);
            if (transaction.command.equals("SAVE")) {
                snapShotMoney += transaction.money;
            } else {
                snapShotMoney -= transaction.money;
            }
            map.put(transaction.accountId, snapShotMoney);
        }
        String[][] answer = new String[map.size()][2];
        int i = 0;
        for (String s : map.keySet()) {
            answer[i][0] = s;
            answer[i][1] = String.valueOf(map.get(s));
            i++;
        }

        Arrays.sort(answer, (o1, o2) -> {
            int thisMoney = Integer.parseInt(o1[1]);
            int thatMoney = Integer.parseInt(o2[1]);
            if(thisMoney < thatMoney) return -1;
            else if(thisMoney == thatMoney) return 0;
            else return 1;
        });

        for (String[] strings : answer) {
            System.out.println(strings[0]+" "+ strings[1]);
        }
    }

    static class Transaction {
        int id;
        String command;
        String accountId;
        int money;

        public Transaction(int id, String command, String accountId, int money) {
            this.id = id;
            this.command = command;
            this.accountId = accountId;
            this.money = money;
        }
    }
}
