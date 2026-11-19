package ptit.code.vao_ra_file.j07011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        int n = Integer.parseInt(sc.nextLine().trim());
        Map<String, Integer> mp = new HashMap<>();
        String regex = "[,.?\\!:;()\\-/\\s]+";
        while(sc.hasNextLine()) {
            String tmp = sc.nextLine();
            if(tmp.length() == 0) continue;

            String[] arr = tmp.trim().toLowerCase().split(regex);

            for (String words : arr) {
                if(words.isEmpty()) continue;
                mp.put(words, mp.getOrDefault(words, 0) + 1);
            }
        }

        List<WordCount> wordCountList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            wordCountList.add(new WordCount(entry.getKey(), entry.getValue()));
        }

        Collections.sort(wordCountList, new Comparator<WordCount>() {
            @Override
            public int compare(WordCount o1, WordCount o2) {
                if(o1.getCount() != o2.getCount()) {
                    return o2.getCount() - o1.getCount();
                }
                return o1.getWord().compareTo(o2.getWord());
            }
        });

        for (WordCount res : wordCountList) {
            System.out.println(res);
        }

        sc.close();
    }
}
