package ptit.code.khai_bao_lop_va_doi_tuong.j04014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while(test-- > 0) {
            Fraction p1 = new Fraction(sc.nextInt(), sc.nextInt());
            Fraction p2 = new Fraction(sc.nextInt(), sc.nextInt());

            Fraction tmp = p1.add(p2);
            Fraction C = tmp.multiply(tmp);
            Fraction D = p1.multiply(p2).multiply(C);

            System.out.println(C + " " + D);
        }
    }
}
