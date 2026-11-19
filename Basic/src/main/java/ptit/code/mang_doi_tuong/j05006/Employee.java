package ptit.code.mang_doi_tuong.j05006;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String id;
    private String name;
    private String gender;
    private Date dob;
    private String address;
    private String mst;
    private String hopDong;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Employee(int id, String name, String gender, String dob, String address, String mst, String hopDong) throws ParseException {
        this.id = String.format("%05d", id);
        this.name = name;
        this.gender = gender;
        this.dob = sdf.parse(dob);
        this.address = address;
        this.mst = mst;
        this.hopDong = hopDong;
    }

    @Override
    public String toString() {
        String formatedDate = sdf.format(dob);
        return id + " " + name + " " + gender + " " + formatedDate + " " + address + " " + mst + " " + hopDong;
    }
}
