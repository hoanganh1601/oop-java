package ptit.classroom.phan_so.bai3;

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

    public PhanSo mul(PhanSo a) {
        PhanSo res = new PhanSo(a.tu * tu, a.mau * mau);
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


public class MulPhanSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) {
            PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());

            PhanSo tong = a.add(b);
            PhanSo tmp = a.mul(b);
            PhanSo c = tong.mul(tong);
            System.out.println(c + " " + tmp.mul(c));
        }
    }
}
