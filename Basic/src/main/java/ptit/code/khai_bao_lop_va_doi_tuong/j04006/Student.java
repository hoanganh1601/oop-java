package ptit.code.khai_bao_lop_va_doi_tuong.j04006;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String lop;
    private Date dob;
    private double gpa;

    public Student(int id, String name, String lop, String dob, double gpa) throws ParseException {
        this.id = String.format("B20DCCN%03d", id);
        this.name = name;
        this.lop = lop;
        this.dob = (new SimpleDateFormat("dd/MM/yyyy")).parse(dob);
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        String forrmattedDate = new SimpleDateFormat("dd/MM/yyyy").format(dob);
        return String.format("%s %s %s %s %.2f", id, name, lop, forrmattedDate, gpa);
    }
}
