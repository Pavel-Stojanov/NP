package lab4.TermFrequency;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TermFrequency {
    private Map<String, Integer> freq;
    private Set<String> stopWords;
    private int total;

    public TermFrequency(InputStream inputStream, String[] stopWords) {
        this.freq = new TreeMap<>();
        this.stopWords = new HashSet<>(Arrays.asList(stopWords));
        total = 0;
        read(inputStream);

    }

    private void read(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        reader.lines()
                .flatMap(l -> Arrays.stream(l.toLowerCase().split("\\s+")))
                .map(w -> w.replaceAll("[.,]$", ""))
                .filter(word -> !word.isEmpty())
                .forEach(this::process);
    }

    private void process(String word) {
        if (!stopWords.contains(word)) {
            total++;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
    }

    public int countTotal() {
        return total;
    }

    public int countDistinct() {
        return freq.size();
    }

    public List<String> mostOften(int k) {
        return freq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
