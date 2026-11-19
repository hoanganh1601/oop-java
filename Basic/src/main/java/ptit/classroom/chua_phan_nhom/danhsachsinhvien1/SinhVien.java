package ptit.classroom.chua_phan_nhom.danhsachsinhvien1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class SinhVien implements Serializable {

    private String ma, ten, lop;
    private Date ngaysinh;
    private float gpa;

    public SinhVien(int id, String ten, String lop, String ngaysinh, float gpa) throws ParseException {
        this.ma = "B20DCCN" + String.format("%03d", id);
        this.ten = ten;
        this.lop = lop;

        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        this.ngaysinh = parser.parse(ngaysinh);

        this.gpa = gpa;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return ma + " " + ten + " " + lop + " "
                + formatter.format(ngaysinh) + " "
                + String.format("%.2f", gpa);
    }
}
