package ptit.code.khai_bao_lop_va_doi_tuong.j04007;

public class Employee {
    private String id;
    private String name;
    private String dob;
    private String gender;
    private String address;
    private String mst;
    private String hopDong;

    public Employee(int id, String name, String gender, String dob, String address, String mst, String hopDong) {
        this.id = String.format("%05d", id);
        this.dob = dob;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.mst = mst;
        this.hopDong = hopDong;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gender + " " + dob + " " + address + " " + mst + " " + hopDong;
    }
}