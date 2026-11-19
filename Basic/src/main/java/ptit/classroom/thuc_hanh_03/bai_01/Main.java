package ptit.classroom.thuc_hanh_03.bai_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        int n = Integer.parseInt(sc.nextLine());

        BigInteger sum = BigInteger.ZERO;
        BigInteger maxVal = null;
        BigInteger minVal = null;

        for (int i = 0; i < n; ++i) {
            BigInteger num = sc.nextBigInteger();
            if(minVal == null || num.compareTo(minVal) < 0){
                minVal = num;
            }
            if(maxVal == null || num.compareTo(maxVal) > 0) {
                maxVal = num;
            }
            sum = sum.add(num);
        }
        sc.close();

        System.out.println(minVal);
        System.out.println(maxVal);
        System.out.println(sum);
    }
}
