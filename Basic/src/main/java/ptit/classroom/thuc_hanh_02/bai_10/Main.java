package ptit.classroom.thuc_hanh_02.bai_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {

    private String maSV;
    private String hoTen;
    private String lop;
    private String email;
    private String sdt;
    private String gioiTinh;
    private String sizeAo;

    public SinhVien(String maSV, String hoTen, String lop, String email, String sdt, String gioiTinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSizeAo() {
        return sizeAo;
    }

    public void setSizeAo(String sizeAo) {
        this.sizeAo = sizeAo;
    }

    @Override
    public int compareTo(SinhVien other) {
        return this.maSV.compareTo(other.maSV);
    }

    @Override
    public String toString() {
        return maSV + " " + hoTen + " " + lop + " " + email + " " + sdt;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scSV = new Scanner(new File("SINHVIEN.in"));
        int num = Integer.parseInt(scSV.nextLine());
        List<SinhVien> listSV = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            String maSv = scSV.nextLine();
            String hoTen = scSV.nextLine();
            String lop = scSV.nextLine();
            String email = scSV.nextLine();
            String sdt = scSV.nextLine();
            String gioiTinh = scSV.nextLine();
            listSV.add(new SinhVien(maSv, hoTen, lop, email,sdt, gioiTinh));
        }
        scSV.close();

        Scanner scDK = new Scanner(new File("DANGKY.in"));
        Map<String, String> sizeMap = new HashMap<>();
        while(scDK.hasNext()) {
            String ma = scDK.next();
            String size = scDK.next();
            sizeMap.put(ma, size);
        }
        scDK.close();

        for (SinhVien sv : listSV) {
            if(sizeMap.containsKey(sv.getMaSV())) {
                sv.setSizeAo(sizeMap.get(sv.getMaSV()));
            }
        }

        Collections.sort(listSV);
        Scanner scTV = new Scanner(new File("TRUYVAN.in"));
        if(scTV.hasNextInt()) {
            int q = scTV.nextInt();
            while(q-- > 0 && scTV.hasNext()) {
                String qGioiTinh = scTV.next();
                String qSize = scTV.next();

                System.out.println("DANH SACH SINH VIEN " + qGioiTinh.toUpperCase() + " DANG KY SIZE " + qSize.toUpperCase());

                for (SinhVien sv : listSV) {
                    if(sv.getGioiTinh().equalsIgnoreCase(qGioiTinh)
                    && sv.getSizeAo() != null
                    && sv.getSizeAo().equalsIgnoreCase(qSize)) {
                        System.out.println(sv);
                    }
                }
            }
        }
        scTV.close();
    }
}
