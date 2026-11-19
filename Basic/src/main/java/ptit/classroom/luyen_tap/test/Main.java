package ptit.classroom.luyen_tap.test;

import java.io.*;
import java.util.*;

public class Main {

    public static String formatLine(String line) {
        return line.toLowerCase().replaceAll("[,.?!:;()\\-/]", " ");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> arr = (ArrayList<String>) ois.readObject();
        ois.close();

        Map<String, Integer> map = new HashMap<>();
        for (String tmp : arr) {
            String line = formatLine(tmp);

            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
           int fa = map.get(a);
           int fb = map.get(b);
           if(fa != fb) return Integer.compare(fb, fa);
           return a.compareTo(b);
        });

        for (String word : list) {
            System.out.println(word + " " + map.get(word));
        }
    }
}
