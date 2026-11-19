package ptit.classroom.chua_phan_nhom.thuchanh9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String id;
    private String name;
    private String className;
    private String email;
    private String phone;

    public Student(String id, String name, String className,String email, String phone) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public int compareTo(Student other) {
        int check = this.className.compareTo(other.className);
        if(check != 0) return check;
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + email + " " + phone;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List<Student> studentList = new ArrayList<>();
        while(sc.hasNextLine()) {
            String id = sc.nextLine().trim();
            if(id.isEmpty()) continue;
            String name = sc.nextLine().trim();
            String className = sc.nextLine().trim();
            String email = sc.nextLine().trim();
            String phone = "0" + sc.nextLine().trim();

            studentList.add(new Student(id, name, className, email, phone));
        }

        Collections.sort(studentList);

        for(Student student : studentList) {
            System.out.println(student);
        }
    }
}
