package ptit.code.mang_doi_tuong.j04018;

public class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex p) {
        int newReal = this.real + p.real;
        int newImaginary = this.imaginary + p.imaginary;

        Complex res = new Complex(newReal, newImaginary);
        return res;
    }

    public Complex multiply(Complex p) {
        int newReal = this.real * p.real - this.imaginary * p.imaginary;
        int newImaginary = this.imaginary * p.real + this.real * p.imaginary;

        return new Complex(newReal, newImaginary);
    }

    @Override
    public String toString() {
        if(imaginary < 0) {
            return real + " - " + Math.abs(imaginary) + "i";
        }
        else {
            return real + " + " + imaginary + "i";
        }
    }
}
