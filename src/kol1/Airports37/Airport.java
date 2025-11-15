package kol1.Airports37;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Airport {
    private String name;
    private String country;
    private String code;
    private int passengers;
    Map<String, Set<Flight>> flights;

    public Airport(String name, String country, String code, int passengers) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.passengers = passengers;
        flights = new TreeMap<>();
    }

    public void addFlight(String from, String to, int time, int duration) {
        flights.computeIfAbsent(to, k -> new TreeSet<>()).add(new Flight(from, to, time, duration));
    }

    @Override
    public String toString() {
        return String.format("%s (%s)\n%s\n%d", name, code, country, passengers);
    }
}
