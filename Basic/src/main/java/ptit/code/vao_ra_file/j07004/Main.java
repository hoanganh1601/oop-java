package ptit.code.vao_ra_file.j07004;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            Map<Integer, Integer> mp = new HashMap<>();

            while(sc.hasNextInt()) {
                int n = sc.nextInt();
                if(mp.containsKey(n)) {
                    mp.put(n, mp.get(n) + 1);
                }
                else {
                    mp.put(n, 1);
                }
            }

            for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }

            sc.close();
        }

        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
