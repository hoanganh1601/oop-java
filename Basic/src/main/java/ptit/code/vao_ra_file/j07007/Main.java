package ptit.code.vao_ra_file.j07007;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        Set<String> se = new TreeSet<>();
        while(sc.hasNext()) {
            se.add(sc.next().trim().toLowerCase());
        }

        for (String tmp : se) {
            System.out.println(tmp);
        }

        sc.close();
    }
}
