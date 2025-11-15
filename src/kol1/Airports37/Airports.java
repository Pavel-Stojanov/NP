package kol1.Airports37;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Airports {
    Map<String, Airport> airports;

    public Airports() {
        airports = new TreeMap<>();
    }

    public void addAirport(String name, String country, String code, int passengers) {
        airports.put(code, new Airport(name, country, code, passengers));
    }

    public void addFlights(String from, String to, int time, int duration) {
        Airport airport = airports.get(from);
        airport.addFlight(from, to, time, duration);
    }

    public void showFlightsFromAirport(String code) {
        Airport airport = airports.get(code);
        System.out.println(airport);
        int i = 1;

        for (Set<Flight> flightsTo : airport.flights.values()) {
            for (Flight flight : flightsTo) {
                System.out.printf("%d. %s\n", i++, flight);
            }
        }
    }

    public void showDirectFlightsFromTo(String from, String to) {
        Airport airport = airports.get(from);
        Set<Flight> flights = airport.flights.get(to);
        if (flights == null) {
            System.out.printf("No flights from %s to %s%n", from, to);
        } else {
            flights.forEach(System.out::println);
        }

    }

    public void showDirectFlightsTo(String to) {
        Set<Flight> flights = new TreeSet<>();
        airports.values().stream()
                .flatMap(airport -> airport.flights.values().stream())
                .flatMap(Set::stream)
                .filter(flight -> flight.getTo().equalsIgnoreCase(to))
                .forEach(flights::add);

        flights.forEach(System.out::println);

    }
}
