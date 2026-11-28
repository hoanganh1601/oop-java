package ptit.code.vao_ra_file.j07018;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Student {
    private String id;
    private String ten;
    private String lop;
    private Date ngaySinh;
    private double gpa;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Student(int id, String ten, String lop, String ngaySinh, double gpa) throws ParseException {
        this.id = String.format("B20DCCN%03d",id);
        this.ten = normalize(ten);
        this.lop = lop;
        this.ngaySinh = sdf.parse(ngaySinh);
        this.gpa = gpa;
    }

    private String normalize(String ten) {
        String[] arr = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String tp : arr) {
            String tmp = Character.toUpperCase(tp.charAt(0)) + tp.substring(1);
            sb.append(tmp).append(" ");
        }

        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return id + " " + ten + " " + lop + " " + sdf.format(ngaySinh) + " " + String.format("%.2f", gpa);
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int test = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= test; ++i) {
            Student student = new Student(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
            System.out.println(student);
        }
    }
}
