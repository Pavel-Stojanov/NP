package lab2.Timestamp;

import java.time.LocalDateTime;

public class Timestamp<T> implements Comparable<Timestamp<T>> {
    private final LocalDateTime time;
    private final T element;

    public Timestamp(LocalDateTime time, T element) {
        this.time = time;
        this.element = element;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public T getElement() {
        return element;
    }

    @Override
    public int compareTo(Timestamp<T> t) {
        return time.compareTo(t.time);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp<?> that = (Timestamp<?>) o;
        return time.equals(that.time);

    }

    @Override
    public String toString() {
        return time.toString()+" "+element.toString();
    }
}
