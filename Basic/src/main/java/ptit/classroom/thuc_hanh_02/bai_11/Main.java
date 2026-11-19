package ptit.classroom.thuc_hanh_02.bai_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class CongNhan implements Comparable<CongNhan> {
    private String ma;
    private String ten;
    private int totalMinutes;
    private int hour;
    private int minute;
    private String status;

    public CongNhan(String ma, String ten, String gioVao, String gioRa) {
        this.ma = ma;
        this.ten = ten;

        String[] vao = gioVao.split(":");
        int tVao = Integer.parseInt(vao[0]) * 60 + Integer.parseInt(vao[1]);

        String[] ra = gioRa.split(":");
        int tRa = Integer.parseInt(ra[0]) * 60 + Integer.parseInt(ra[1]);

        this.totalMinutes = tRa - tVao - 60;
        this.hour = this.totalMinutes / 60;
        this.minute = this.totalMinutes % 60;

        if(this.totalMinutes >= 480) this.status = "DU";
        else this.status = "THIEU";
    }

    @Override
    public int compareTo(CongNhan other) {
        if(this.totalMinutes != other.totalMinutes) {
            return Integer.compare(other.totalMinutes, this.totalMinutes);
        }
        return this.ma.compareTo(other.ma);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + hour + " gio " + minute + " phut " + status;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<CongNhan> list = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String gioVao = sc.nextLine();
            String gioRa = sc.nextLine();

            list.add(new CongNhan(ma, ten, gioVao, gioRa));
        }

        Collections.sort(list);
        for (CongNhan cn : list) {
            System.out.println(cn);
        }

        sc.close();
    }
}
