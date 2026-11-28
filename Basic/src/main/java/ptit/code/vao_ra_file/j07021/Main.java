package ptit.code.vao_ra_file.j07021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while(sc.hasNextLine()) {
            String name = sc.nextLine().trim();
            if(name.equals("END")) {
                break;
            }

            name = name.toLowerCase();
            String[] words = name.split("\\s+");

            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                String normalizeName = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                sb.append(normalizeName).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
