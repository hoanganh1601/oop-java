package ptit.code.khai_bao_lop_va_doi_tuong.j04005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String dob = sc.next();
        double s1 = sc.nextDouble();
        double s2 = sc.nextDouble();
        double s3 = sc.nextDouble();
        Candidate tmp = new Candidate(name, dob, s1, s2, s3);

        System.out.print(tmp);
    }
}
