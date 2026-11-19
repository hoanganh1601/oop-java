package ptit.code.khai_bao_lop_va_doi_tuong.j04003;

public class Fraction {
    private long tu;
    private long mau;

    public Fraction(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public long getTu() {
        return tu;
    }

    public void setTu(long tu) {
        this.tu = tu;
    }

    public long getMau() {
        return mau;
    }

    public void setMau(long mau) {
        this.mau = mau;
    }

    public long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public void toiGian() {
        long mc = gcd(tu, mau);
        tu /= mc;
        mau /= mc;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}
