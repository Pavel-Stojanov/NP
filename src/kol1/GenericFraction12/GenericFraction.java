package kol1.GenericFraction12;

public class GenericFraction<T extends Number, U extends Number> {
    private T numerator;
    private U denominator;

    public GenericFraction(T numerator, U denominator) {
        if (denominator.doubleValue() == 0) {
            throw new ZeroDenominatorException("Denominator cannot be zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;

    }

    public GenericFraction<Double, Double> add(GenericFraction<? extends Number, ? extends Number> gf) {
        double thisNum = this.numerator.doubleValue();
        double thisDen = this.denominator.doubleValue();
        double oNum = gf.numerator.doubleValue();
        double oDen = gf.denominator.doubleValue();

        double newNum = thisNum * oDen + oNum * thisDen;
        double newDen = thisDen * oDen;

        return new GenericFraction<>(newNum, newDen);

    }

    public double toDouble() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public double gcd(double a, double b) {
        if (b<0.00001){
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public String toString() {

        double divisor = gcd(numerator.doubleValue(),denominator.doubleValue());

        double normNum = numerator.doubleValue()/divisor;
        double normDen = denominator.doubleValue()/divisor;
        return String.format("%.2f / %.2f", normNum, normDen);
    }
}
