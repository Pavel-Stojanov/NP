package lab4.Sheduler;
import java.util.*;

public class Scheduler<T> {
    private TreeMap<Date, T> timestamps;

    public Scheduler() {
        timestamps = new TreeMap<>();
    }

    public void add(Date d, T t) {
        timestamps.put(d, t);
    }

    public boolean remove(Date t) {
        return timestamps.remove(t) != null;
    }

    public T next() {
        Date now = new Date();
        return timestamps.higherEntry(now).getValue();

    }

    public T last() {
        Date now = new Date();
        return timestamps.floorEntry(now).getValue();
    }

    public ArrayList<T> getAll(Date begin, Date end) {
        return new ArrayList<>(timestamps.subMap(begin, end).values());
    }

    public T getFirst() {
        return timestamps.get(timestamps.firstKey());
    }

    public T getLast() {
        return timestamps.get(timestamps.lastKey());
    }
}
