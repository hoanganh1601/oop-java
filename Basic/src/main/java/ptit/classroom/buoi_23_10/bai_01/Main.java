package ptit.classroom.buoi_23_10.bai_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KhachHang {
    private String maKh;
    private String tenKh;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;

    public KhachHang(int maKh, String tenKh, String gioiTinh, String ngaySinh, String diaChi) {
        this.tenKh = tenKh;
        this.maKh = String.format("KH%03d", maKh);
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public String getDiaChi() {
        return diaChi;
    }
}

class MatHang {
    private String maMatHang;
    private String tenMatHang;
    private String donViTinh;
    private long giaMua;
    private long giaBan;

    public MatHang(int maMatHang, String tenMatHang, String donViTinh, long giaMua, long giaBan) {
        this.maMatHang = String.format("MH%03d", maMatHang);
        this.tenMatHang = tenMatHang;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public String getMaMatHang() {
        return maMatHang;
    }
}

class HoaDon {
    private String maHoaDon;
    private KhachHang khachHang;
    private MatHang matHang;
    private long soLuong;

    public HoaDon(int maHoaDon, KhachHang khachHang, MatHang matHang, long soLuong) {
        this.maHoaDon = String.format("HD%03d", maHoaDon);
        this.khachHang = khachHang;
        this.matHang = matHang;
        this.soLuong = soLuong;
    }

    public long getThanhTien() {
        return soLuong * matHang.getGiaBan();
    }

    @Override
    public String toString() {
        return maHoaDon + " " + khachHang.getTenKh() + " " + khachHang.getDiaChi() +
                " " + matHang.getTenMatHang() + " " + matHang.getDonViTinh() + " "
                + matHang.getGiaMua() + " " + matHang.getGiaBan() + " " + soLuong + " " + getThanhTien();
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scKH = new Scanner(new File("KH.in"));
        int n = Integer.parseInt(scKH.nextLine());
        Map<String, KhachHang> mpKH = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String tenKH = scKH.nextLine();
            String gioiTinh = scKH.nextLine();
            String ngaySinh = scKH.nextLine();
            String diaChi = scKH.nextLine();
            KhachHang kh = new KhachHang(i, tenKH, gioiTinh, ngaySinh, diaChi);
            mpKH.put(kh.getMaKh(), kh);
        }
        scKH.close();

        Scanner scMH = new Scanner(new File("MH.in"));
        int m = Integer.parseInt(scMH.nextLine());
        Map<String, MatHang> mpMH = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            String tenMH = scMH.nextLine();
            String donViTinh = scMH.nextLine();
            long giaMua = Long.parseLong(scMH.nextLine());
            long giaBan = Long.parseLong(scMH.nextLine());
            MatHang mh = new MatHang(i, tenMH, donViTinh, giaMua, giaBan);
            mpMH.put(mh.getMaMatHang(), mh);
        }
        scMH.close();

        Scanner scHD = new Scanner(new File("HD.in"));
        int k = scHD.nextInt();
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        for (int i = 1; i <= k; ++i) {
            String maKH = scHD.next();
            String maMH = scHD.next();
            int soLuong = scHD.nextInt();
            HoaDon hd = new HoaDon(i, mpKH.get(maKH), mpMH.get(maMH), soLuong);
            dsHoaDon.add(hd);
        }
        scHD.close();

        for (HoaDon hd : dsHoaDon) {
            System.out.println(hd);
        }
    }
}
