package ptit.code.khai_bao_lop_va_doi_tuong.j04004;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fraction a = new Fraction(sc.nextLong(), sc.nextLong());
        Fraction b = new Fraction(sc.nextLong(), sc.nextLong());

        Fraction res = a.add(b);
        System.out.print(res);
    }
}
