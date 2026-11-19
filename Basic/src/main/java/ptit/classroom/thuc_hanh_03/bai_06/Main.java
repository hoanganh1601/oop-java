package ptit.classroom.thuc_hanh_03.bai_06;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

class ThiSinh {
    private static DecimalFormat df = new DecimalFormat("0.#");
    private String ma, hoTen, danToc, trangThai;
    private double toan, ly, hoa;
    private int giaiQG;
    private double sum = 0, uuTien = 0, xt = 0;

    public ThiSinh(String ma, String hoTen, String danToc, double toan, double ly, double hoa, int giaiQG) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.danToc = danToc;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.giaiQG = giaiQG;

        sum = toan + ly + hoa;
        if(giaiQG == 1) uuTien += 1.5;
        else if(giaiQG == 2) uuTien += 1;
        else if(giaiQG == 3) uuTien += 0.5;

        if(!danToc.equalsIgnoreCase("kinh")) uuTien += 1;
        String id = ma.substring(2, 3);
        if(id.equals("2")) uuTien += 1;
        else if (id.equals("3")) uuTien += 2;

        xt = sum + uuTien;
        if(sum + uuTien >= 26.8) trangThai = "TRUNG TUYEN";
        else trangThai = "TRUOT";
    }

    public double getXt() {
        return xt;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + df.format(uuTien) + " " + df.format(sum) + " " + trangThai;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        List<ThiSinh> list = new ArrayList<>();
        for (int i = 0; i < num; ++i) {
            String ma = sc.nextLine();
            String hoTen = sc.nextLine();
            String danToc = sc.nextLine();
            double toan = Double.parseDouble(sc.nextLine());
            double ly = Double.parseDouble(sc.nextLine());
            double hoa = Double.parseDouble(sc.nextLine());
            int giaiQG = Integer.parseInt(sc.nextLine());

            list.add(new ThiSinh(ma, hoTen, danToc, toan, ly, hoa, giaiQG));
        }

        list.sort((a, b) -> {
           if(a.getXt() != b.getXt()) return Double.compare(b.getXt(), a.getXt());
           return Double.compare(b.getSum(), a.getSum());
        });

        for (ThiSinh thiSinh : list) {
            System.out.println(thiSinh);
        }
    }
}
