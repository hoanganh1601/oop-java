package ptit.code.khai_bao_lop_va_doi_tuong.j04006;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String lop = sc.nextLine();
        String dob = sc.next();
        double gpa = sc.nextDouble();

        Student tmp = new Student(1, name, lop, dob, gpa);
        System.out.print(tmp);
    }
}
