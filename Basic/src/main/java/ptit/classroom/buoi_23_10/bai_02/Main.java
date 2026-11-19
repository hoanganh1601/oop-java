package ptit.classroom.buoi_23_10.bai_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SinhVien {
    private String maSV;
    private String tenSV;
    private String sdt;
    private String email;

    public SinhVien(String maSV, String tenSV, String sdt, String email) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.sdt = sdt;
        this.email = email;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getMaSV() {
        return maSV;
    }
}

class DeTai {
    private String maDeTai;
    private String tenGiangVien;
    private String tenDeTai;

    public DeTai(int maDeTai, String tenGiangVien, String tenDeTai) {
        this.maDeTai = String.format("DT%03d", maDeTai);
        this.tenGiangVien = tenGiangVien;
        this.tenDeTai = tenDeTai;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public String getMaDeTai() {
        return maDeTai;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }
}

class BaoCao implements Comparable<BaoCao> {
    private SinhVien sinhVien;
    private DeTai deTai;

    public BaoCao(SinhVien sv, DeTai dt) {
        this.sinhVien = sv;
        this.deTai = dt;
    }

    public String getMaSV() {
        return sinhVien.getMaSV();
    }

    @Override
    public int compareTo(BaoCao other) {
        return this.sinhVien.getMaSV().compareTo(other.sinhVien.getMaSV());
    }

    @Override
    public String toString() {
        return sinhVien.getMaSV() + " " + sinhVien.getTenSV() +
                " " + deTai.getTenDeTai() + " " + deTai.getTenGiangVien();
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scSV = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(scSV.nextLine());
        Map<String, SinhVien> mpSV = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            SinhVien sv = new SinhVien(scSV.nextLine(), scSV.nextLine(), scSV.nextLine(), scSV.nextLine());
            mpSV.put(sv.getMaSV(), sv);
        }
        scSV.close();

        Scanner scDT = new Scanner(new File("DETAI.in"));
        int m = Integer.parseInt(scDT.nextLine());
        Map<String, DeTai> mpDT = new HashMap<>();
        for (int i = 1; i <= m; ++i) {
            DeTai dt = new DeTai(i, scDT.nextLine(), scDT.nextLine());
            mpDT.put(dt.getMaDeTai(), dt);
        }
        scDT.close();

        Scanner scHD = new Scanner(new File("HOIDONG.in"));
        int k = scHD.nextInt();
        List<List<BaoCao>> hoiDong = new ArrayList<>();
        for (int i = 0; i <= 8; ++i) {
            hoiDong.add(new ArrayList<>());
        }
        for (int i = 1; i <= k; ++i) {
            String maSV = scHD.next();
            String maDT = scHD.next();
            String maHD = scHD.next();
            int idHD = Integer.parseInt(maHD.substring(2));

            SinhVien sv = mpSV.get(maSV);
            DeTai dt = mpDT.get(maDT);
            hoiDong.get(idHD).add(new BaoCao(sv, dt));
        }
        scHD.close();

        for (int i = 1; i <= 8; ++i) {
            if(!hoiDong.get(i).isEmpty()) {
                System.out.println("DANH SACH HOI DONG " + i + ":");
                Collections.sort(hoiDong.get(i));
                for(BaoCao bc : hoiDong.get(i)) {
                    System.out.println(bc);
                }
            }
        }
    }
}
