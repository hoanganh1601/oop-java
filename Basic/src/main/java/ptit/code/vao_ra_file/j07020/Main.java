package ptit.code.vao_ra_file.j07020;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KhachHang {
    private String ma, ten, gioiTinh, diaChi;
    private Date ngaySinh;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public KhachHang(int ma, String ten, String gioiTinh, String ngaySinh, String diaChi) throws ParseException {
        this.ma = String.format("KH%03d", ma);
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = sdf.parse(ngaySinh);
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMa() {
        return ma;
    }
}

class MatHang {
    private String ma, ten, dvt;
    private Long giaMua, giaBan;

    public MatHang(int ma, String ten, String dvt, Long giaMua, Long giaBan) {
        this.ma = String.format("MH%03d", ma);
        this.ten = ten;
        this.dvt = dvt;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getTen() {
        return ten;
    }

    public String getDvt() {
        return dvt;
    }

    public Long getGiaMua() {
        return giaMua;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public String getMa() {
        return ma;
    }
}

class HoaDon {
    private String ma;
    private KhachHang khachHang;
    private MatHang matHang;
    private Long soLuong;

    public HoaDon(int ma, KhachHang khachHang, MatHang matHang, Long soLuong) {
        this.ma = String.format("HD%03d", ma);
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
    }

    private long tinhThanhTien() {
        return matHang.getGiaBan() * soLuong;
    }

    @Override
    public String toString() {
        return ma + " " + khachHang.getTen() + " " + khachHang.getDiaChi() + " "
                + matHang.getTen() + " " + matHang.getDvt() + " " + matHang.getGiaMua() + " "
                + matHang.getGiaBan() + " " + soLuong + " " + tinhThanhTien();
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc1 = new Scanner(new File("KH.in"));
        int n = Integer.parseInt(sc1.nextLine());
        Map<String, KhachHang> dsKH = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            KhachHang kh = new KhachHang(i, sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            dsKH.put(kh.getMa(), kh);
        }
        sc1.close();

        Scanner sc2 = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(sc2.nextLine());
        Map<String, MatHang> dsMH = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            MatHang mh = new MatHang(i, sc2.nextLine(), sc2.nextLine(), Long.parseLong(sc2.nextLine()), Long.parseLong(sc2.nextLine()));
            dsMH.put(mh.getMa(), mh);
        }
        sc2.close();


        Scanner sc3 = new Scanner(new File("HD.in"));
        int k = Integer.parseInt(sc3.nextLine());
        for (int i = 1; i <= k; ++i) {
            String maKH = sc3.next();
            String maMH = sc3.next();
            long soLuong = sc3.nextLong();

            HoaDon hd = new HoaDon(i, dsKH.get(maKH), dsMH.get(maMH), soLuong);
            System.out.println(hd);
        }
        sc3.close();
    }
}
