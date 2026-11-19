package ptit.code.mang_doi_tuong.j05014;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Teacher> teacherList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            Teacher teacher = new Teacher(i, sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble());
            sc.nextLine();

            teacherList.add(teacher);
        }

        Collections.sort(teacherList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return Double.compare(o2.getTotalScore(), o1.getTotalScore());
            }
        });

        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
}
