package ptit.classroom.thuc_hanh_03.bai_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class SinhVien {
    private String maSV, hoTen, sdt, email;

    public SinhVien(String maSV, String hoTen, String sdt, String email) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }
}

class DeTai {
    private String maDT;
    private String tenGV;
    private String tenDeTai;

    public DeTai(int id, String tenGV, String tenDeTai) {
        this.maDT = String.format("DT%03d", id);
        this.tenGV = tenGV;
        this.tenDeTai = tenDeTai;
    }

    public String getMaDT() {
        return maDT;
    }

    public String getTenGV() {
        return tenGV;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }
}

class BaoCao implements Comparable<BaoCao> {
    private SinhVien sv;
    private DeTai dt;
    private String maHD;

    public BaoCao(SinhVien sv, DeTai dt, String maHD) {
        this.sv = sv;
        this.dt = dt;
        this.maHD = maHD;
    }

    public String getMaHD() {
        return maHD;
    }

    @Override
    public int compareTo(BaoCao other) {
        return this.sv.getMaSV().compareTo(other.sv.getMaSV());
    }

    @Override
    public String toString() {
        return sv.getMaSV() + " " + sv.getHoTen() + " " +
                dt.getTenDeTai() + " " + dt.getTenGV();
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scSV = new Scanner(new File("SINHVIEN.in"));
        int nSV = Integer.parseInt(scSV.nextLine());
        Map<String, SinhVien> mpSV = new HashMap<>();

        for (int i = 0; i < nSV; ++i) {
            String ma = scSV.nextLine();
            String ten = scSV.nextLine();
            String sdt = scSV.nextLine();
            String email = scSV.nextLine();
            mpSV.put(ma, new SinhVien(ma, ten, sdt, email));
        }
        scSV.close();

        Scanner scDT = new Scanner(new File("DETAI.in"));
        int nDT = Integer.parseInt(scDT.nextLine());
        Map<String, DeTai> mpDT = new HashMap<>();

        for (int i = 1; i <= nDT; ++i) {
            String tenGV = scDT.nextLine();
            String tenDeTai = scDT.nextLine();
            DeTai dt = new DeTai(i, tenGV, tenDeTai);
            mpDT.put(dt.getMaDT(), dt);
        }
        scDT.close();

        Scanner scHD = new Scanner(new File("HOIDONG.in"));
        int nPhanCong = scHD.nextInt();
        List<List<BaoCao>> hoiDong = new ArrayList<>();
        for (int i = 0; i <= 8; ++i) {
            hoiDong.add(new ArrayList<>());
        }

        for (int i = 0; i < nPhanCong; ++i) {
            String maSV = scHD.next();
            String maDT = scHD.next();
            String maHD = scHD.next();

            int idHD = Integer.parseInt(maHD.substring(2));
            SinhVien sv = mpSV.get(maSV);
            DeTai dt = mpDT.get(maDT);

            hoiDong.get(idHD).add(new BaoCao(sv,dt, maHD));
        }
        scHD.close();

        for (int k = 1; k <= 8; ++k) {
            List<BaoCao> ds = hoiDong.get(k);
            System.out.println("DANH SACH HOI DONG " + k + ":");
            Collections.sort(ds);
            for (BaoCao bc : ds) {
                System.out.println(bc);
            }
        }
    }
}
