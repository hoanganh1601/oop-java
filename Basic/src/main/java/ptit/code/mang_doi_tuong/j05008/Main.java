package ptit.code.mang_doi_tuong.j05008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while(test-- > 0) {
            int n = sc.nextInt();

            Point[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point(sc.nextDouble(), sc.nextDouble());
            }

            double area = 0.0;
            for (int i = 0; i < n - 1; ++i) {
                Point cur = points[i];
                Point next = points[i + 1];
                area += cur.getX() * next.getY() - cur.getY() * next.getX();
            }

            area += points[n - 1].getX() * points[0].getY() - points[0].getX() * points[n - 1].getY();
            System.out.printf("%.3f\n", area / 2);
        }
    }
}
