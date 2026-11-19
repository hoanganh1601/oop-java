package ptit.code.mang_doi_tuong.j05004;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; ++i) {
            Student student = new Student(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
            sc.nextLine();
            System.out.println(student);
        }
    }
}
