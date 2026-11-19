package ptit.classroom.phan_so.phanso;

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

    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}
