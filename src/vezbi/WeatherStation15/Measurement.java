package vezbi.WeatherStation15;

import java.util.Date;

public class Measurement implements Comparable<Measurement>{
    private float temperature;
    private float humidity;
    private float wind;
    private float visibility;
    private Date date;

    public Measurement(float temperature, float humidity, float wind, float visibility, Date date) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.visibility = visibility;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public int compareTo(Measurement o) {
        return this.date.compareTo(o.date);
    }

    @Override
    public String toString() {
        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s",temperature,wind,humidity,visibility,date.toString());
    }
}
