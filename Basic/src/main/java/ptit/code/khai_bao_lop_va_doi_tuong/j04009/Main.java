package ptit.code.khai_bao_lop_va_doi_tuong.j04009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while(test-- > 0) {

            Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
            Point p3 = new Point(sc.nextDouble(), sc.nextDouble());

            double edge12 = p1.distance(p2);
            double edge13 = p1.distance(p3);
            double edge23 = p2.distance(p3);

            if(edge12 < edge13 + edge23 && edge13 < edge12 + edge23 && edge23 < edge12 + edge13) {
                double p = (edge12 + edge13 + edge23) / 2;
                double square = Math.sqrt(p * (p - edge12) * (p - edge13) * (p - edge23));
                System.out.printf("%.2f\n", square);
            }
            else {
                System.out.println("INVALID");
            }
        }
    }
}
