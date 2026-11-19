package ptit.code.khai_bao_lop_va_doi_tuong.j04012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int basicWage = sc.nextInt();
        int worksDay = sc.nextInt();
        String pos = sc.next();

        Employee tmp = new Employee(1, name, basicWage, worksDay, pos);
        System.out.print(tmp);
    }
}
