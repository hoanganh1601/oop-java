package ptit.classroom.thuc_hanh_02.bai_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class GiangVien {
    private String maGV;
    private String tenGV;
    private double tongGio;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGio = 0.0;
    }

    public String getMaGV() {
        return maGV;
    }

    public void addGio(double gio) {
        this.tongGio += gio;
    }

    @Override
    public String toString() {
        return tenGV + " " + String.format("%.2f", tongGio);
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        if (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; ++i) sc.nextLine();
        }
        sc.close();

        Scanner scGV = new Scanner(new File("GIANGVIEN.in"));
        int nGV = Integer.parseInt(scGV.nextLine());
        List<GiangVien> listGV = new ArrayList<>();
        Map<String, GiangVien> mpGV = new HashMap<>();

        for (int i = 0; i < nGV; ++i) {
            String line = scGV.nextLine();
            int spaceIdx = line.indexOf(' ');
            String maGV = line.substring(0, spaceIdx);
            String tenGV = line.substring(spaceIdx + 1).trim();

            GiangVien gv = new GiangVien(maGV, tenGV);
            listGV.add(gv);
            mpGV.put(maGV, gv);
        }
        scGV.close();

        Scanner scGio = new Scanner(new File("GIOCHUAN.in"));
        if(scGio.hasNextInt()) {
            int nLop = scGio.nextInt();
            for (int i = 0; i < nLop; ++i) {
                String maGV = scGio.next();
                String maMon = scGio.next();
                double gio = Double.parseDouble(scGio.next());

                if(mpGV.containsKey(maGV)) {
                    mpGV.get(maGV).addGio(gio);
                }
            }
        }
        scGio.close();

        for (GiangVien gv : listGV) {
            System.out.println(gv);
        }
    }
}
