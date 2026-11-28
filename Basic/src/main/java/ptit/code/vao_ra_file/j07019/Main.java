package ptit.code.vao_ra_file.j07019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SanPham {
    private String ma, ten;
    private Double loai1, loai2;

    public SanPham(String ma, String ten, Double loai1, Double loai2) {
        this.ma = ma;
        this.ten = ten;
        this.loai1 = loai1;
        this.loai2 = loai2;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public Double getGia(int loai) {
        return loai == 1 ? loai1 : loai2;
    }
}

class HoaDon {
    private String ma;
    private int soLuong;
    private SanPham sanPham;
    private int loai;

    public HoaDon(int id, String ma, int soLuong, SanPham sanPham) {
        this.ma = ma + "-" + String.format("%03d", id);
        this.soLuong = soLuong;
        this.sanPham = sanPham;
        this.loai = ma.charAt(2) - '0';
    }

    public Double getThanhTien() {
        return sanPham.getGia(loai) * soLuong;
    }

    public Double getGiamGia() {
        Double thanhTien = getThanhTien();
        if (soLuong >= 150) {
            return thanhTien * 0.5;
        }
        else if (soLuong >= 100) {
            return thanhTien * 0.3;
        }
        else if (soLuong >= 50) {
            return thanhTien * 0.15;
        }
        return 0.0;
    }

    public Double getPhaiTra() {
        return getThanhTien() - getGiamGia();
    }

    @Override
    public String toString() {
        return ma + " " + sanPham.getTen() + " " + String.format("%.0f",getGiamGia()) + " " + String.format("%.0f",getPhaiTra());
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("DATA1.in"));
        Map<String, SanPham> mp = new HashMap<>();
        int n = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < n; ++i) {
            String ma = sc1.nextLine();
            String ten = sc1.nextLine();
            Double loai1 = Double.parseDouble(sc1.nextLine());
            Double loai2 = Double.parseDouble(sc1.nextLine());

            SanPham sp = new SanPham(ma, ten, loai1, loai2);
            mp.put(ma, sp);
        }
        sc1.close();

        Scanner sc2 = new Scanner(new File("DATA2.in"));
        int m = Integer.parseInt(sc2.nextLine());
        for (int i = 1; i <= m; ++i) {
            String ma = sc2.next();
            int soLuong = sc2.nextInt();

            String maSP = ma.substring(0, 2);
            SanPham sp = mp.get(maSP);
            HoaDon hd = new HoaDon(i, ma, soLuong, sp);
            System.out.println(hd);
        }
        sc2.close();
    }
}
