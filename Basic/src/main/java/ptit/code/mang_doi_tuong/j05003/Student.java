package ptit.code.mang_doi_tuong.j05003;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String className;
    private Date dob;
    private double gpa;

    public Student(int id, String name, String className, String dob, double gpa) throws ParseException {
        this.id = String.format("B20DCCN%03d", id);
        this.name = name;
        this.className = className;
        this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        String formatedDate = new SimpleDateFormat("dd/MM/yyyy").format(dob);
        return String.format("%s %s %s %s %.2f", id, name, className, formatedDate, gpa);
    }
}

