import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number5 {
    public static void main(String[] args) {
        String[][] dataSource = {
            {"doc1", "t1", "t2", "t3"},
        {"doc2", "t0", "t2", "t3"},
        {"doc3", "t1", "t6", "t7"},
        {"doc4", "t1", "t2", "t4"},
        {"doc5", "t6", "t100", "t8"}
        };
        String[] tags = {"t1","t2","t3"};

        List<Document> documents = new ArrayList<>();

        for (String[] data : dataSource) {
            String id = data[0];
            List<String> dataTags = new ArrayList<>();
            for(int i=1;i<data.length;i++) {
                dataTags.add(data[i]);;
            }
            Document document = new Document(id, dataTags);
            document.cal(tags);
            if(document.count == 0) continue;
            documents.add(document);
        }

        Collections.sort(documents, (o1, o2) -> {
            if(o1.count > o2.count) return -1;
            else if(o1.count == o2.count){
                return o1.id.compareTo(o2.id);
            }
            else return 1;
        });
        String[] answer = new String[documents.size()];
        int i = 0;

        for (Document document : documents) {
            answer[i]  = document.id;
            i++;
        }

    }
    static class Document {
        String id;
        List<String> tags;
        int count;

        public Document(String id, List<String> tags) {
            this.id = id;
            this.tags = tags;
            count = 0;
        }

        public void cal(String[] tags) {
            Set<String> set = new HashSet<>(this.tags);
            set.retainAll(Arrays.asList(tags));
            count = set.size();
        }
    }

}
