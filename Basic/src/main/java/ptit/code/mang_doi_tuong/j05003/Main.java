package ptit.code.mang_doi_tuong.j05003;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine();

        List<Student> studentList = new ArrayList<Student>();
        
        for (int i = 1; i <= test; ++i) {
            Student student = new Student(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
            sc.nextLine();

            studentList.add(student);
        }

        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
