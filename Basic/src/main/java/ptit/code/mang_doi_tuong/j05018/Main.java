package ptit.code.mang_doi_tuong.j05018;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 1; i <= n; ++i) {
            String name = sc.nextLine().trim();
            String num = sc.nextLine().trim();
            String[] tokens = num.split("\\s+");
            double[] scores = new double[10];
            for (int j = 0; j < 10; j++) {
                scores[j] = Double.parseDouble(tokens[j]);
            }

            Student student = new Student(i, name, scores);
            students.add(student);
        }

        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
