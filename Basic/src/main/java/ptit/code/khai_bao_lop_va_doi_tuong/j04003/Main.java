package ptit.code.khai_bao_lop_va_doi_tuong.j04003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long tu = sc.nextLong(), mau = sc.nextLong();
        Fraction tmp = new Fraction(tu, mau);
        tmp.toiGian();

        System.out.print(tmp);

        sc.close();
    }
}

