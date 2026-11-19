package ptit.code.mang_doi_tuong.j04018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            Complex a = new Complex(sc.nextInt(), sc.nextInt());
            Complex b = new Complex(sc.nextInt(), sc.nextInt());

            Complex ab = a.add(b);
            Complex c = ab.multiply(a);
            Complex d = ab.multiply(ab);

            System.out.println(c + ", " + d);
        }
    }
}
