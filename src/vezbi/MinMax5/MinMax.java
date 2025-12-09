package vezbi.MinMax5;

public class MinMax<T extends Comparable<T>> {
    T min, max;
    int different;

    public MinMax() {
        min = max = null;
        different = 0;
    }

    public void update(T elem) {
        if (min == null && max == null) {
            min = elem;
            max = elem;
        }
        if ((elem.compareTo(min) !=0  && elem.compareTo(max) !=0) && !(min.compareTo(max) == 0)) {
            different++;
        }
        if (elem.compareTo(min)<0){
            min = elem;
        }
        if (elem.compareTo(max)>0){
            max = elem;
        }
    }

    public T max(){
        return max;
    }

    @Override
    public String toString() {
        return min + " " + max + " " + different +"\n";
    }
}
