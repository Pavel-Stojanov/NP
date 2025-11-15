package kol1.PayrollSystem28;

public class HourlyEmployee extends Employee {
    private double hours;
    private double overtime;
    private double regular;

    public HourlyEmployee(String level, String id, double rate, double hours) {
        super(level, id, rate);
        this.hours = hours;
        this.overtime = Math.max(0, hours - 40);
        this.regular = hours - overtime;
    }

    @Override
    double calculateSalary() {
        return rate * regular + overtime * rate * 1.5;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Regular hours: %.2f Overtime hours: %.2f", regular, overtime);
    }
}
