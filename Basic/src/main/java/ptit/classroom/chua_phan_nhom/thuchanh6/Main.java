package ptit.classroom.chua_phan_nhom.thuchanh6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        Set<String> se = new TreeSet<>();
        while(sc.hasNextLine()) {
            String word = sc.next().toLowerCase();
            if(chuaDigit(word) && !chuaDau(word)) {
                se.add(word);
            }
        }

        for (String tmp : se) {
            System.out.println(tmp);
        }

        sc.close();
    }

    public static boolean chuaDigit(String s) {
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean chuaDau(String s) {
        for (char c : s.toCharArray()) {
            if(c == '.' || c == ',' || c == '!' || c == '?' || c == ':') {
                return true;
            }
        }

        return false;
    }
}
