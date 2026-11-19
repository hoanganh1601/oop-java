package ptit.classroom.chua_phan_nhom.thuchanh12;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private long timeMinutes;

    public Student(String name, String startTime, String endTime) {
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);

        this.timeMinutes = ChronoUnit.MINUTES.between(start, end);
    }

    @Override
    public int compareTo(Student other) {
        if(this.timeMinutes != other.timeMinutes) {
            return Long.compare(other.timeMinutes, this.timeMinutes);
        }

        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " " + timeMinutes;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));

        int n = Integer.parseInt(sc.nextLine().trim());
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            studentList.add(new Student(sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }

        Collections.sort(studentList);
        for (Student s : studentList) {
            System.out.println(s);
        }

        sc.close();
    }
}
