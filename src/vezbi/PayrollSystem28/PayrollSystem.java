package vezbi.PayrollSystem28;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class PayrollSystem {
    private Map<String, Double> hourlyRateByLevel;
    private Map<String, Double> ticketRateByLevel;
    List<Employee> employees;

    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this.hourlyRateByLevel = hourlyRateByLevel;
        this.ticketRateByLevel = ticketRateByLevel;
        employees = new ArrayList<>();
    }


    public void readEmployees(InputStream in) {
        this.employees = new BufferedReader(new InputStreamReader(in))
                .lines().map(l -> EmployeeFactory.createEmployee(l, hourlyRateByLevel, ticketRateByLevel))
                .collect(Collectors.toList());
    }

    public Map<String, Set<Employee>> printEmployeesByLevels(PrintStream out, Set<String> levels) {
        return employees.stream().filter(e->levels.contains(e.getLevel())).collect(Collectors.groupingBy(Employee::getLevel, TreeMap::new, Collectors.toCollection(TreeSet::new)));
    }
}
