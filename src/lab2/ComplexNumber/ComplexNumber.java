package lab2.ComplexNumber;

public class ComplexNumber<T extends Number, U extends Number> implements Comparable<ComplexNumber<T, U>> {
    private T real;
    private U imag;

    public ComplexNumber(T real, U imag) {
        this.real = real;
        this.imag = imag;
    }

    public T getReal() {
        return real;
    }

    public U getImaginary() {
        return imag;
    }

    public double modul() {
        return Math.sqrt(real.doubleValue() * real.doubleValue() + imag.doubleValue() * imag.doubleValue());
    }

    @Override
    public int compareTo(ComplexNumber<T, U> o) {
        return Double.compare(this.modul(), o.modul());
    }

    @Override
    public String toString() {
        if (imag.doubleValue() < 0) {
            return String.format("%.2f%.2fi", real.doubleValue(), imag.doubleValue());
        } else
            return String.format("%.2f+%.2fi", real.doubleValue(), imag.doubleValue());
    }
}
