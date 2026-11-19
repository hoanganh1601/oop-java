package ptit.classroom.chua_phan_nhom.danhsachsinhvien1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("SV.in"))) {
            ArrayList<SinhVien> ds = (ArrayList<SinhVien>) in.readObject();

            for (SinhVien tmp : ds) {
                System.out.println(tmp);
            }
        }
    }
}
