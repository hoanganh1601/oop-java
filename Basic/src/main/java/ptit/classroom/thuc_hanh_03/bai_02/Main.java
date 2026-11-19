package ptit.classroom.thuc_hanh_03.bai_02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class SinhVien implements Comparable<SinhVien>{
    private String name;
    private long minutes;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public SinhVien(String name, String startTime, String endTime) throws ParseException {
        this.name = name;
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);

        long kc = end.getTime() - start.getTime();
        this.minutes = kc / 60000;
    }

    public String getName() {
        return name;
    }

    public long getMinutes() {
        return minutes;
    }

    @Override
    public int compareTo(SinhVien other) {
        if(this.minutes != other.minutes) {
            return Long.compare(other.minutes, this.minutes);
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " " + minutes;
    }
}

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> arr = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            String name = sc.nextLine();
            String startTime = sc.nextLine();
            String endTime = sc.nextLine();
            arr.add(new SinhVien(name, startTime, endTime));
        }
        sc.close();

        Collections.sort(arr);
        for (SinhVien sv : arr) {
            System.out.println(sv);
        }
    }
}
