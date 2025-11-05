package lab2.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler<T> {
    private List<Timestamp<T>> timestamps;

    public Scheduler() {
        timestamps = new ArrayList<>();
    }

    public void add(Timestamp<T> t) {
        timestamps.add(t);
    }
    public boolean remove(Timestamp<T> t) {
        return timestamps.remove(t);
    }

    public Timestamp<T> next() {
        LocalDateTime now = LocalDateTime.now();
        return timestamps.stream().filter(t->t.getTime().isAfter(now)).min(Comparator.naturalOrder()).orElse(null);
    }

    public Timestamp<T> last() {
        LocalDateTime now = LocalDateTime.now();
        return timestamps.stream().filter(t->t.getTime().isBefore(now)).max(Comparator.naturalOrder()).orElse(null);
    }

    public List<Timestamp<T>> getAll(LocalDateTime begin, LocalDateTime end) {
        return timestamps.stream().filter(t->t.getTime().isAfter(begin) && t.getTime().isBefore(end)).collect(Collectors.toList());
    }
}
