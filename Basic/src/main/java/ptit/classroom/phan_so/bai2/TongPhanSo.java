package ptit.classroom.phan_so.bai2;

import java.util.Scanner;

class PhanSo {
    private long tu;
    private long mau;

    private long gcd(long tu, long mau) {
        if(mau == 0) return tu;
        return gcd(mau, tu % mau);
    }

    public void rutGon() {
        long tmp = gcd(tu, mau);
        tu /= tmp;
        mau /= tmp;
    }

    public PhanSo add(PhanSo a) {
        PhanSo res = new PhanSo(tu * a.mau + a.tu * mau, a.mau * mau);
        res.rutGon();

        return res;
    }


    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}


public class TongPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
        PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());

        System.out.print(a.add(b));
    }
}
