package kol1.PayrollSystem28;

import java.util.Comparator;

public abstract class Employee implements Comparable<Employee> {
    protected String level;
    protected String id;
    protected double rate;

    public Employee(String level, String id, double rate) {
        this.level = level;
        this.id = id;
        this.rate = rate;
    }

    abstract double calculateSalary();

    public String getLevel() {
        return level;
    }

    public String getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public int compareTo(Employee o) {
        return Comparator.comparing(Employee::calculateSalary).reversed().thenComparing(Employee::getLevel).compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %s Level: %s Salary: %.2f", id, level, calculateSalary());
    }
}
