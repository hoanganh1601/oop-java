package ptit.classroom.thuc_hanh_03.bai_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TuyenXe {

    private String ma, hoTen, ngayDi, kieuNgay;
    private int soHieu, soLuot;
    private long doanhThu;

    public TuyenXe(int id, String hoTen, String ngayDi, int soHieu, int soLuot, String kieuNgay) {
        this.hoTen = hoTen;
        this.ngayDi = ngayDi;
        this.soHieu = soHieu;
        this.soLuot = soLuot;
        this.kieuNgay = kieuNgay;

        this.ma = "HN" + soHieu + String.format("%02d", id);

        tinhDoanhThu();
    }

    public void tinhDoanhThu() {
        double donGia;
        if(soLuot < 5) donGia = 800.0;
        else if(soLuot <= 10) donGia = 780.0;
        else donGia = 750.0;

        double tong = soLuot * donGia;
        String kn = kieuNgay.toLowerCase();
        if(kn.equals("nghi")) tong *= 1.1;
        else if(kn.equals("le")) tong *= 1.2;

        this.doanhThu = Math.round(tong);
    }

    public void update(String hoTen, int soLuot,String kieuNgay) {
        this.hoTen = hoTen;
        this.soLuot = soLuot;
        this.kieuNgay = kieuNgay;
        tinhDoanhThu();
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + ngayDi + " " + soHieu + " " +
                soLuot + " " + kieuNgay + " " + doanhThu;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        List<TuyenXe> list = new ArrayList<>();

        for (int i = 1; i <= num; ++i) {
            list.add(new TuyenXe(i, sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine()));
        }

        if(!sc.hasNextLine()) {
            System.out.println("khong tim thay");
            sc.close();
            return;
        }

        String maSua = sc.nextLine();
        TuyenXe target = null;

        for (TuyenXe tx : list) {
            if(tx.getMa().equalsIgnoreCase(maSua)) {
                target = tx;
                break;
            }
        }

        if(target != null) {
            System.out.println(target);
            String newHoTen = sc.nextLine();
            int newSoLuot = Integer.parseInt(sc.nextLine());
            String newKieuNgay = sc.nextLine();

            target.update(newHoTen, newSoLuot, newKieuNgay);
            System.out.println(target);
        }
        else {
            System.out.println("khong tim thay");
        }
        sc.close();
    }
}
