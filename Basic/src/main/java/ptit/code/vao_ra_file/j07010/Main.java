package ptit.code.vao_ra_file.j07010;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 1; i <= n; ++i) {
            String name = sc.nextLine();
            String className = sc.nextLine();
            String dob = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine().trim());

            Student student = new Student(i, name, className, dob, gpa);
            System.out.println(student);
        }
    }
}
