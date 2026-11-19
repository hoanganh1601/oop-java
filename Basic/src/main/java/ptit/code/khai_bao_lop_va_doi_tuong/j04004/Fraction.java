package ptit.code.khai_bao_lop_va_doi_tuong.j04004;

public class Fraction {
    private long tu;
    private long mau;

    public Fraction(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public void rutGon() {
        long mc = gcd(tu, mau);
        tu /= mc;
        mau /= mc;
    }

    public Fraction add(Fraction b) {
        long newTu = this.tu * b.mau + this.mau * b.tu;
        long newMau = this.mau * b.mau;

        Fraction res = new Fraction(newTu, newMau);
        res.rutGon();

        return res;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}
