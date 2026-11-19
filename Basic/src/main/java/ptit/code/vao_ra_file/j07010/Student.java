package ptit.code.vao_ra_file.j07010;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String className;
    private Date dob;
    private double gpa;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Student(int id, String name, String className, String dob, double gpa) throws ParseException {
        this.id = String.format("B20DCCN%03d", id);
        this.name = name;
        this.className = className;
        this.dob = sdf.parse(dob);
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className + " " + sdf.format(dob) + " " + String.format("%.2f", gpa);
    }
}
