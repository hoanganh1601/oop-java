package ptit.classroom.chua_phan_nhom.thuchanh1;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("DATA.in"));
            BigInteger sum = BigInteger.ZERO;

            while(sc.hasNext()) {
                String num = sc.next();
                try {
                    long value = Long.parseLong(num);
                    if(value > Integer.MAX_VALUE) {
                        sum = sum.add(BigInteger.valueOf(value));
                    }
                }
                catch (NumberFormatException e) {

                }
            }

            sc.close();
            System.out.println(sum);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
