package ptit.code.vao_ra_file.j07012;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("DATA.in"));
        // Read ArrayList<String> from binary file
        @SuppressWarnings("unchecked")
        ArrayList<String> list = (ArrayList<String>) obj.readObject();
        obj.close();

        Map<String, Integer> mp = new HashMap<>();
        String regex = "[\\s\\.,\\?!:;\\(\\)\\-/]+";
        for(String tmp : list) {
            tmp = tmp.toLowerCase();
            String[] words = tmp.split(regex);
            for(String word : words) {
                if(!word.isEmpty()) {
                    mp.put(word, mp.getOrDefault(word, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> resList = new ArrayList<>(mp.entrySet());
        Collections.sort(resList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue().compareTo(o1.getValue());
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry : resList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
