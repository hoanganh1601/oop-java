package ptit.classroom.thuc_hanh_02.bai_07;

import java.util.*;

class Movie implements Comparable<Movie> {

    private String id;
    private String tenTheLoai;
    private String ngayKhoiChieu;
    private String moiveName;
    private int soTap;
    private int day, month, year;

    public Movie(String id, String tenTheLoai, String ngayKhoiChieu, String moiveName, int soTap) {
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.id = id;
        this.tenTheLoai = tenTheLoai;
        this.moiveName = moiveName;
        this.soTap = soTap;

        String[] parts = ngayKhoiChieu.split("/");
        this.day = Integer.parseInt(parts[0]);
        this.month = Integer.parseInt(parts[1]);
        this.year = Integer.parseInt(parts[2]);
    }

    @Override
    public int compareTo(Movie other) {
        if(this.year != other.year) return Integer.compare(this.year, other.year);
        if(this.month != other.month) return Integer.compare(this.month, other.month);
        if(this.day != other.day) return Integer.compare(this.day, other.day);

        int cmpName = this.moiveName.compareTo(other.moiveName);
        if(cmpName != 0) return cmpName;

        if(this.soTap != other.soTap) return Integer.compare(this.soTap, other.soTap);

        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return id + " " + tenTheLoai + " " + ngayKhoiChieu + " " + moiveName + " " + soTap;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();

        Map<String, String> theLoaiMap = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            String idTL = String.format("TL%03d", i);
            String tenTL = sc.nextLine().trim();
            theLoaiMap.put(idTL, tenTL);
        }

        List<Movie> movieList = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            String idMovie = String.format("P%03d", i);
            String idTL = sc.nextLine().trim();
            String ngayChieu = sc.nextLine().trim();
            String tenPhim = sc.nextLine().trim();
            int soTap = Integer.parseInt(sc.nextLine().trim());
            String tenTL = theLoaiMap.get(idTL);

            movieList.add(new Movie(idMovie, theLoaiMap.get(idTL), ngayChieu, tenPhim, soTap));
        }

        Collections.sort(movieList);
        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }
}

