package ptit.classroom.chua_phan_nhom.thuchanh8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int bai;
    private int submit;

    public Student(String name, int bai, int submit) {
        this.name = name;
        this.bai = bai;
        this.submit = submit;
    }


    @Override
    public int compareTo(Student other) {
        if(other.bai != this.bai) return other.bai - this.bai;
        if(other.submit != this.submit) return this.submit - other.submit;
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " " + bai + " " + submit;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));
        int n = Integer.parseInt(sc.nextLine());

        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String name = sc.nextLine();
            int bai = sc.nextInt(), submit = sc.nextInt();

            if(sc.hasNextLine()) sc.nextLine();

            Student student = new Student(name, bai, submit);
            studentList.add(student);
        }
        Collections.sort(studentList);
        for(Student student : studentList) {
            System.out.println(student);
        }

        sc.close();
    }
}
