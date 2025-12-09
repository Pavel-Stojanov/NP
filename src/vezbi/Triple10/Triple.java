package vezbi.Triple10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triple<T extends Number & Comparable<T>> {
    private T a;
    private T b;
    private T c;

    public Triple(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double max(){
        return Math.max(a.doubleValue(),Math.max(b.doubleValue(),c.doubleValue()));

    }

    double avarage(){
        return (a.doubleValue()+b.doubleValue()+c.doubleValue())/3;

    }

    void sort(){
        List<T> elem = new ArrayList<>();
        elem.add(a);
        elem.add(b);
        elem.add(c);

        Collections.sort(elem);

        a=elem.get(0);
        b=elem.get(1);
        c=elem.get(2);
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f",a.doubleValue(),b.doubleValue(),c.doubleValue());
    }
}
