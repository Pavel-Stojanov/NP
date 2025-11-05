package lab2.Arrays;


public class IntegerArray extends ResizableArray<Integer> {
    public IntegerArray() {
        super();
    }

    public double sum() {
        double total = 0;
        for (int i = 0; i < count(); i++) {
            total += elementAt(i);
        }
        return total;
    }

    public double mean() {
        if (count() == 0) {
            return 0;
        }
        return sum() / count();
    }

    public int countNonZero() {
        int n = 0;
        for (int i = 0; i < count(); i++) {
            if (elementAt(i) != 0) {
                n++;
            }
        }
        return n;
    }

    public IntegerArray distinct() {
        IntegerArray array = new IntegerArray();
        for (int i = 0; i < count(); i++) {
            Integer current = elementAt(i);
            if (!array.contains(current)) {
                array.addElement(current);
            }
        }
        return array;
    }

    public IntegerArray increment(int offset) {
        IntegerArray array = new IntegerArray();
        for (int i = 0; i < count(); i++) {
            array.addElement(elementAt(i) + offset);
        }
        return array;
    }

}
