package ptit.code.mang_doi_tuong.j05004;

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
        this.name = normalizeName(name);
        this.className = className;
        this.dob = sdf.parse(dob);
        this.gpa = gpa;
    }

    public String normalizeName(String name) {
        StringBuilder sb = new StringBuilder();
        String[] arr = name.trim().toLowerCase().split("\\s+");
        for (String tmp : arr) {
            String res = Character.toUpperCase(tmp.charAt((0))) + tmp.substring(1);
            sb.append(res).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        String formatDate = sdf.format(dob);
        return String.format("%s %s %s %s %.2f", id, name, className, formatDate, gpa);
    }
}
