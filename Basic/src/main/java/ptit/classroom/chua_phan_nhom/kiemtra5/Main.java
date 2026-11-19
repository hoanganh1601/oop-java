package ptit.classroom.chua_phan_nhom.kiemtra5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));

        Set<String> names = new HashSet<>();
        Map<String, Integer> preFreq = new HashMap<>();

        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            String[] tokens = line.toLowerCase().split("\\s+");

            String normalizeName = String.join(" ", tokens);
            if(names.contains(normalizeName)) continue;
            names.add(normalizeName);

            String tmp = tokens[tokens.length - 1];
            StringBuilder sb = new StringBuilder(tmp);
            for (int i = 0; i < tokens.length - 1; ++i) {
                sb.append(tokens[i].charAt(0));
            }
            String bPre = sb.toString();

            int cnt = preFreq.getOrDefault(bPre, 0) + 1;
            preFreq.put(bPre, cnt);

            if(cnt == 1) {
                System.out.println(bPre + "@ptit.edu.vn");
            }
            else {
                System.out.println(bPre + cnt + "@ptit.edu.vn");
            }
        }
    }
}


