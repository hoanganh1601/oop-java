package ptit.code.mang_doi_tuong.j05016;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Customer> customerList = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            Customer customer = new Customer(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLong());
            sc.nextLine();
            customerList.add(customer);
        }

        Collections.sort(customerList);
        for(Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
