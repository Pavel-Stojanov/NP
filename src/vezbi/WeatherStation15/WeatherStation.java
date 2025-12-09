package vezbi.WeatherStation15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WeatherStation {
    private int daysToKeep;
    private List<Measurement> measurements;

    public WeatherStation(int daysToKeep) {
        this.daysToKeep = daysToKeep;
        measurements = new ArrayList<>();
    }

    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date) {
        for (Measurement m : measurements) {
            if (Math.abs(m.getDate().getTime() - date.getTime()) < 150000) {
                return;
            }
        }
        measurements.add(new Measurement(temperature, humidity, wind, visibility, date));

        long daysToKeepMillis = TimeUnit.DAYS.toMillis(daysToKeep);
        Date threshold = new Date(date.getTime() - daysToKeepMillis);

        measurements.removeIf(m -> m.getDate().before(threshold));
    }

    public int total() {
        return measurements.size();
    }

    public void status(Date from, Date to) {
        List<Measurement> fitered = measurements.stream()
                .filter(m -> !m.getDate().before(from) && !m.getDate().after(to))
                .sorted()
                .collect(Collectors.toList());
        if (fitered.isEmpty()) {
            throw new RuntimeException();
        }
        fitered.forEach(System.out::println);

        double avgTemp = fitered.stream()
                .mapToDouble(Measurement::getTemperature)
                .average()
                .orElse(0.0);
        System.out.printf("Average temperature: %.2f", avgTemp);
    }
}
