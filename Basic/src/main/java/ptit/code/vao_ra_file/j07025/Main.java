package ptit.code.vao_ra_file.j07025;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class KhachHang implements Comparable<KhachHang> {
    private String ma, ten, gioiTinh, diaChi;
    private Date ngaySinh;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public KhachHang(int id, String ten, String gioiTinh, String ngaySinh, String diaChi) throws ParseException {
        this.ma = String.format("KH%03d", id);
        this.ten = normalize(ten);
        this.gioiTinh = gioiTinh;
        this.ngaySinh = sdf.parse(ngaySinh);
        this.diaChi = diaChi;
    }

    private String normalize(String ten) {
        String[] words = ten.toLowerCase().trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String tmp = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            sb.append(tmp).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gioiTinh + " " + diaChi + " " + sdf.format(ngaySinh);
    }

    @Override
    public int compareTo(KhachHang other) {
        return this.ngaySinh.compareTo(other.ngaySinh);
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> list = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            list.add(new KhachHang(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        Collections.sort(list);
        for(KhachHang kh : list) {
            System.out.println(kh);
        }
    }
}
