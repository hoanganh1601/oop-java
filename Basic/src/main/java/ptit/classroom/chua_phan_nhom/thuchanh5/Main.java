package ptit.classroom.chua_phan_nhom.thuchanh5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        Map<String, Integer> mp = new HashMap<>();
        Set<String> uniNames = new HashSet<>();

        while(sc.hasNextLine()) {
            String name = sc.nextLine().trim().toLowerCase();
            String[] res = name.split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (String word : res){
                sb.append(word).append(" ");
            }

            String normalize = sb.toString().trim();
            if(uniNames.contains(normalize)) continue;
            uniNames.add(normalize);

            StringBuilder tmp = new StringBuilder();
            tmp.append(res[res.length - 1]);
            for (int i = 0; i < res.length - 1; ++i) {
                tmp.append(res[i].charAt(0));
            }

            String mail = tmp.toString();

            if(mp.containsKey(mail)) {
                int cnt = mp.get(mail) + 1;
                mp.put(mail, cnt);
                System.out.println(mail + cnt + "@ptit.edu.vn");
            }
            else {
                mp.put(mail, 1);
                System.out.println(mail + "@ptit.edu.vn");
            }
        }
        sc.close();
    }
}
