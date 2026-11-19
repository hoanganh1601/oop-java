package ptit.code.khai_bao_lop_va_doi_tuong.j04001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());

            System.out.printf("%.4f\n", p1.distance(p2));
        }
    }
}
