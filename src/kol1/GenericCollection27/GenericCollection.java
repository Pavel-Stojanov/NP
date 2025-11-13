package kol1.GenericCollection27;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GenericCollection<T extends Comparable<T> & IHasTimestamp> {
    private Map<String, List<T>> elements;

    public GenericCollection() {
        elements = new HashMap<>();
    }

    void addGenericItem(String category, T element) {
        elements.computeIfAbsent(category, k -> new ArrayList<>()).add(element);
    }

    public Collection<T> findAllBetween(LocalDateTime from, LocalDateTime to) {
        return elements.values().stream()
                .flatMap(List::stream)
                .filter(e -> {
                    LocalDateTime time = e.getTimestamp();
                    return time.isAfter(from) && time.isBefore(to);
                })
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public Collection<T> itemsFromCategories(List<String> categories) {
        return categories.stream()
                .filter(elements::containsKey)
                .map(elements::get)
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public Map<String, Set<T>> byMonthAndDay() {
        Map<String, Set<T>> result = new TreeMap<>();
        for (T item : elements.values().stream().flatMap(List::stream).collect(Collectors.toList())) {
            LocalDateTime timestamp = item.getTimestamp();
            int monthValue = timestamp.getMonthValue();
            int dayOfMonth = timestamp.getDayOfMonth();
            String date = String.format("%02d-%02d", monthValue, dayOfMonth);
            result.computeIfAbsent(date, k -> new TreeSet<>(Comparator.reverseOrder())).add(item);
        }
        return result;
    }

    public Map<Integer, Long> countByYear() {
        return elements.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(e -> e.getTimestamp().getYear(),
                        TreeMap::new,
                        Collectors.counting()));
    }

}
