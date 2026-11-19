package ptit.code.mang_doi_tuong.j05007;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Employee> employeeList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            Employee employee = new Employee(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            employeeList.add(employee);
        }

        Collections.sort(employeeList, new Comparator<Employee>(){
           @Override
           public int compare(Employee p1, Employee p2) {
               return p1.getDob().compareTo(p2.getDob());
           }
        });

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
