package ptit.classroom.thuc_hanh_03.bai_05.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ThiSinh {
    private String ma, hoTen, danToc;
    private double toan, ly, hoa;
    private int giaiQG;

    public ThiSinh(String ma, String hoTen, String danToc, double toan, double ly, double hoa, int giaiQG) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.danToc = danToc;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
        this.giaiQG = giaiQG;
    }

    public double getDiemKV() {
        String kv = ma.substring(0, 3).toUpperCase();
        if(kv.equals("KV1")) return 0.0;
        else if(kv.equals("KV2")) return 1.0;
        else if(kv.equals("KV3")) return 2.0;
        return 0.0;
    }

    public double getDiemDanToc() {
        if(danToc.trim().equalsIgnoreCase("kinh")) {
            return 0.0;
        }
        return 1.0;
    }

    public double getDiemQG() {
        if(giaiQG == 1) return 1.5;
        else if(giaiQG == 2) return 1.0;
        else if(giaiQG == 3) return 0.5;
        return 0.0;
    }

    public double getDiemUuTien() {
        return getDiemKV() + getDiemDanToc() + getDiemQG();
    }

    public double getTongDiem() {
        return toan + ly + hoa;
    }

    public double getDXT() {
        return getTongDiem() + getDiemUuTien();
    }
    public String getTrangThai() {
        if(getDXT() >= 26.8) {
            return "TRUNG TUYEN";
        }
        return "TRUOT";
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + getDiemUuTien() + " " + getTongDiem() + " " + getTrangThai();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<ThiSinh> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String ma = sc.nextLine();
            String hoTen = sc.nextLine();
            String danToc = sc.nextLine();
            double toan = Double.parseDouble(sc.nextLine());
            double ly = Double.parseDouble(sc.nextLine());
            double hoa = Double.parseDouble(sc.nextLine());
            int giaiQG = Integer.parseInt(sc.nextLine());

            list.add(new ThiSinh(ma, hoTen, danToc, toan, ly, hoa, giaiQG));
        }

        double A = Double.parseDouble(sc.nextLine());
        boolean check = false;

        for (ThiSinh ts : list) {
            if(ts.getTongDiem() >= A) {
                System.out.println(ts);
                check = false;
            }
        }

        if(!check) System.out.println("khong co");
        sc.close();
    }
}
