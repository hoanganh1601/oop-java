package ptit.classroom.luyen_tap.ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));

        Set<BigInteger> se = new TreeSet<>();
        while(sc.hasNext()) {
            String tmp = sc.next();
            se.add(new BigInteger(tmp));
        }

        if(se.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        BigInteger sum = BigInteger.ZERO;
        BigInteger product = BigInteger.ONE;

        for (BigInteger num : se) {
            sum = sum.add(num);
            product = product.multiply(num);
        }

        System.out.println(sum);
        System.out.println(product);

        sc.close();
    }
}
