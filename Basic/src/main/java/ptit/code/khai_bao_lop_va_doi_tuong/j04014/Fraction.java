package ptit.code.khai_bao_lop_va_doi_tuong.j04014;

public class Fraction {
    private long tu;
    private long mau;

    public Fraction(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
        this.toiGian();
    }

    public long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public void toiGian() {
        long mc = gcd(tu, mau);
        tu /= mc;
        mau /= mc;

        if(mau < 0) {
            tu = -tu;
            mau = -mau;
        }
    }

    public Fraction add(Fraction p) {
        long newTu = this.tu * p.mau + p.tu * this.mau;
        long newMau = this.mau * p.mau;
        Fraction res = new Fraction(newTu, newMau);
        res.toiGian();

        return res;
    }

    public Fraction multiply(Fraction p) {
        long newTu = this.tu * p.tu;
        long newMau = this.mau * p.mau;
        Fraction res = new Fraction(newTu, newMau);
        res.toiGian();

        return res;
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
}
