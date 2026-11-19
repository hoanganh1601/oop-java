package ptit.code.khai_bao_lop_va_doi_tuong.j04007;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String gender = sc.nextLine();
        String dob = sc.nextLine();
        String address = sc.nextLine();
        String taxCode = sc.nextLine();
        String hopDong = sc.nextLine();

        Employee tmp = new Employee(1, name, gender, dob, address, taxCode, hopDong);
        System.out.print(tmp);
    }
}
