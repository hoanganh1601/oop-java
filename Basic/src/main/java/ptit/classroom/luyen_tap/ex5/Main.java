package ptit.classroom.luyen_tap.ex5;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        int n = Integer.parseInt(sc.nextLine().trim());

        BigInteger min = null;
        BigInteger max = null;
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < n; ++i) {
            String line = sc.nextLine().trim();
            if(line.isEmpty()) continue;

            BigInteger cur = new BigInteger(line);

            if(min == null || cur.compareTo(min) < 0) {
                min = cur;
            }
            if(max == null || cur.compareTo(max) > 0) {
                max = cur;
            }
            sum = sum.add(cur);
        }

        if(min != null && max != null) {
            System.out.println(min);
            System.out.println(max);
            System.out.println(sum);
        }

        sc.close();
    }
}
