package ptit.classroom.thuc_hanh_03.bai_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class MonHoc {
    private String maMon;
    private String tenMon;
    private String hinhThuc;

    public MonHoc(String maMon, String tenMon, String hinhThuc) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThuc = hinhThuc;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }
}

class CaThi {
    private String maCa, ngayThi, gioThi, phongThi;
    private int ngay, thang, nam;
    private int gio, phut;

    public CaThi(int id, String ngayThi, String gioThi, String phongThi) {
        this.maCa = String.format("C%03d", id);
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.phongThi = phongThi;

        String[] date = ngayThi.split("/");
        this.ngay = Integer.parseInt(date[0]);
        this.thang = Integer.parseInt(date[1]);
        this.nam = Integer.parseInt(date[2]);

        String[] time = gioThi.split(":");
        this.gio = Integer.parseInt(time[0]);
        this.phut = Integer.parseInt(time[1]);
    }

    public String getMaCa() {
        return maCa;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public int getNgay() {
        return ngay;
    }

    public int getThang() {
        return thang;
    }

    public int getNam() {
        return nam;
    }

    public int getGio() {
        return gio;
    }

    public int getPhut() {
        return phut;
    }
}

class LichThi implements Comparable<LichThi> {

    private CaThi caThi;
    private MonHoc monHoc;
    private String maNhom;
    private int soSV;

    public LichThi(CaThi caThi, MonHoc monHoc,String maNhom, int soSV) {
        this.caThi = caThi;
        this.monHoc = monHoc;
        this.maNhom = maNhom;
        this.soSV = soSV;
    }

    @Override
    public int compareTo(LichThi other) {
        if(this.caThi.getNam() != other.caThi.getNam()) {
            return Integer.compare(this.caThi.getNam(), other.caThi.getNam());
        }
        if(this.caThi.getThang() != other.caThi.getThang()) {
            return Integer.compare(this.caThi.getThang(), other.caThi.getThang());
        }
        if(this.caThi.getNgay() != other.caThi.getNgay()) {
            return Integer.compare(this.caThi.getNgay(), other.caThi.getNgay());
        }
        if(this.caThi.getGio() != other.caThi.getGio()) {
            return Integer.compare(this.caThi.getGio(), other.caThi.getGio());
        }
        if(this.caThi.getPhut() != other.caThi.getPhut()) {
            return Integer.compare(this.caThi.getPhut(), other.caThi.getPhut());
        }

        return this.caThi.getMaCa().compareTo(other.caThi.getMaCa());
    }

    @Override
    public String toString() {
        return caThi.getNgayThi() + " " + caThi.getGioThi() + " " + caThi.getPhongThi() + " "
                + monHoc.getTenMon() + " " + maNhom + " " + soSV;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scMon = new Scanner(new File("MONTHI.in"));
        int nMon = Integer.parseInt(scMon.nextLine());
        Map<String, MonHoc> mpMon = new HashMap<>();

        for (int i = 0; i < nMon; ++i) {
            String ma = scMon.nextLine();
            String ten = scMon.nextLine();
            String ht = scMon.nextLine();

            mpMon.put(ma, new MonHoc(ma, ten, ht));
        }
        scMon.close();

        Scanner scCa = new Scanner(new File("CATHI.in"));
        int nCa = Integer.parseInt(scCa.nextLine());
        Map<String, CaThi> mpCa = new HashMap<>();

        for (int i = 1; i <= nCa; ++i) {
            String ngay = scCa.nextLine();
            String gio = scCa.nextLine();
            String phong = scCa.nextLine();

            CaThi ca = new CaThi(i, ngay, gio, phong);
            mpCa.put(ca.getMaCa(), ca);
        }
        scCa.close();

        Scanner scLich = new Scanner(new File("LICHTHI.in"));
        int nLich = scLich.nextInt();
        List<LichThi> listLich = new ArrayList<>();

        for (int i = 0; i < nLich; ++i) {
            String maCa = scLich.next();
            String maMon = scLich.next();
            String maNhom = scLich.next();

            int soSV = scLich.nextInt();
            listLich.add(new LichThi(mpCa.get(maCa), mpMon.get(maMon), maNhom, soSV));
        }
        scLich.close();

        Collections.sort(listLich);
        for (LichThi lt : listLich) {
            System.out.println(lt);
        }
    }
}
