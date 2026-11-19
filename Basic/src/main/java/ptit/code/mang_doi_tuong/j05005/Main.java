package ptit.code.mang_doi_tuong.j05005;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            Student student = new Student(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
            sc.nextLine();
            studentList.add(student);
        }

        Collections.sort(studentList, new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               return Double.compare(o2.getGpa(), o1.getGpa());
           }
        });

        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
