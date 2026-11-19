package ptit.classroom.thuc_hanh_03.bai_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        Set<String> cntNames = new HashSet<>();
        Map<String, Integer> email = new HashMap<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] words = line.toLowerCase().split("\\s+");
            String tmp = String.join(" ", words);
            if(cntNames.contains(tmp)) continue;
            cntNames.add(tmp);

            StringBuilder sb = new StringBuilder(words[words.length - 1]);
            for (int i = 0; i < words.length - 1; ++i) {
                sb.append(words[i].charAt(0));
            }

            String base = sb.toString();
            int cnt = email.getOrDefault(base, 0) + 1;
            email.put(base, cnt);

            if(cnt == 1) {
                System.out.println(base + "@ptit.edu.vn");
            }
            else {
                System.out.println(base + cnt + "@ptit.edu.vn");
            }
        }
    }
}
