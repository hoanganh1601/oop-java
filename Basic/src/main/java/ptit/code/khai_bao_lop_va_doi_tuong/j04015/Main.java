package ptit.code.khai_bao_lop_va_doi_tuong.j04015;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teacher tmp = new Teacher(sc.nextLine(), sc.nextLine(), sc.nextInt());
        System.out.print(tmp);
    }
}
