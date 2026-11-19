package ptit.classroom.chua_phan_nhom.kiemtra4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static boolean checkValid(String word) {
        boolean ktra = false;
        int num = 0;
        while(num < 10) {
            String checkNum = String.valueOf(num);
            if(word.contains(checkNum)) ktra = true;
            ++num;
        }

        if(word.contains(".") || word.contains(",")
                || word.contains("?") || word.contains("!") || word.contains(":")) return false;

        return ktra;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        TreeSet<String> res = new TreeSet<>();
        while(sc.hasNextLine()) {
            String tmp = sc.nextLine();
            StringTokenizer st = new StringTokenizer(tmp);
            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                if(checkValid(word)) res.add(word);
            }
        }

        for (String tmp : res) System.out.println(tmp);
    }
}
