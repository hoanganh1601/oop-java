package ptit.classroom.thuc_hanh_02.bai_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class SanPham {
    private String maSp;
    private String tenSp;
    private long giaBan;
    private int thoiHan;

    public SanPham(String maSp, String tenSp, long giaBan, int thoiHan) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.thoiHan = thoiHan;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public int getThoiHan() {
        return thoiHan;
    }
}

class KhanhHang implements Comparable<KhanhHang> {

    private String maKh;
    private String tenKh;
    private String diaChi;
    private String maSp;
    private long tongTien;
    private LocalDate ngayHetHan;
    private String ngayHetHanStr;

    private static final DateTimeFormatter in = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter out = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public KhanhHang(String maKh, String tenKh, String diaChi, String maSp, long soLuong, String ngayMua, SanPham sp) {
        this.maKh = maKh;
        this.tenKh = tenKh;
        this.diaChi = diaChi;
        this.maSp = maSp;
        this.tongTien = soLuong * sp.getGiaBan();

        LocalDate start = LocalDate.parse(ngayMua, in);
        this.ngayHetHan = start.plusMonths(sp.getThoiHan());
        this.ngayHetHanStr = this.ngayHetHan.format(out);
    }

    @Override
    public int compareTo(KhanhHang other) {
        if(!this.ngayHetHan.isEqual(other.ngayHetHan)) {
            return this.ngayHetHan.compareTo(other.ngayHetHan);
        }
        return this.maKh.compareTo(other.maKh);
    }

    @Override
    public String toString() {
        return maKh + " " + tenKh + " " + diaChi + " " + maSp + " " + tongTien + " " + ngayHetHanStr;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));

        int n = Integer.parseInt(sc.nextLine());
        Map<String, SanPham> spMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String maSp = sc.nextLine();
            String tenSp = sc.nextLine();
            long giaBan = Long.parseLong(sc.nextLine());
            int thoiHan = Integer.parseInt(sc.nextLine());
            spMap.put(maSp, new SanPham(maSp, tenSp, giaBan, thoiHan));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<KhanhHang> dsKhachHang = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            String maKh = String.format("KH%02d", i);
            String tenKh = sc.nextLine();
            String diaChi = sc.nextLine();
            String maSp = sc.nextLine();
            long soLuong = Long.parseLong(sc.nextLine());
            String ngayMua = sc.nextLine();

            SanPham sp = spMap.get(maSp);
            dsKhachHang.add(new KhanhHang(maKh, tenKh, diaChi, maSp, soLuong, ngayMua, sp));
        }

        Collections.sort(dsKhachHang);
        for (KhanhHang kh : dsKhachHang) System.out.println(kh);

        sc.close();
    }
}
