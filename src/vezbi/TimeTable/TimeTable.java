package vezbi.TimeTable;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TimeTable {
    private List<LocalTime> times;

    public TimeTable() {
        times = new ArrayList<>();
    }

    public void readTimes(InputStream in) {
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            String time = sc.next();
            String[] parts;
            if (time.contains(":")) {
                parts = time.split(":");
            } else if (time.contains(".")) {
                parts = time.split("\\.");
            } else {
                throw new UnsupportedFormatException(time);
            }
            int hour;
            int minutes;
            try {
                hour = Integer.parseInt(parts[0]);
                minutes = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                throw new InvalidTimeException(time);
            }

            if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
                throw new InvalidTimeException(time);
            }
            times.add(LocalTime.of(hour, minutes));
        }
    }

    public void writeTimes(PrintStream out, TimeFormat timeFormat) {
        Collections.sort(times);
        for (LocalTime time : times) {
            if (timeFormat == TimeFormat.FORMAT_24) {
                out.printf("%2d:%02d\n", time.getHour(), time.getMinute());
            } else {
                int hour = time.getHour();
                int minute = time.getMinute();
                String ampm = "AM";
                int displayHour = hour;
                if (hour == 0) {
                    displayHour = 12;
                } else if (hour == 12) {
                    ampm = "PM";
                } else if (hour > 12) {
                    displayHour = hour - 12;
                    ampm = "PM";
                }
                out.printf("%2d:%02d %s\n", displayHour, minute, ampm);
            }
        }
    }
}
