package ptit.classroom.thuc_hanh_03.bai_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class MonHoc implements Comparable<MonHoc> {

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

    @Override
    public int compareTo(MonHoc other) {
        return this.maMon.compareTo(other.maMon);
    }

    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + hinhThuc;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        Set<String> cnt = new HashSet<>();
        List<MonHoc> list = new ArrayList<>();

        while(sc.hasNextLine()) {
            String ma = sc.nextLine();

            String ten = sc.nextLine();
            String hinhThuc = sc.nextLine();

            if(!cnt.contains(ma)) {
                cnt.add(ma);
                list.add(new MonHoc(ma, ten, hinhThuc));
            }
        }
        sc.close();

        Collections.sort(list);
        for (MonHoc mh : list) {
            System.out.println(mh);
        }
    }
}
