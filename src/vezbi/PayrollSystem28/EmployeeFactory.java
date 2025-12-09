package vezbi.PayrollSystem28;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeFactory {
    public static Employee createEmployee(String line, Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        String[] parts = line.split(";");
        String type = parts[0];
        String id = parts[1];
        String level = parts[2];

        if (type.equalsIgnoreCase("F")) {
            double rate = ticketRateByLevel.get(level);
            List<Integer> tickets = Arrays.stream(parts, 3, parts.length).map(Integer::parseInt).collect(Collectors.toList());
            return new FreelanceEmployee(level, id, rate, tickets);
        } else {
            double rate = hourlyRateByLevel.get(level);
            double hours = Double.parseDouble(parts[3]);
            return new HourlyEmployee(level, id, rate, hours);
        }
    }
}
