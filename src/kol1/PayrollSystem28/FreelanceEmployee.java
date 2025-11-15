package kol1.PayrollSystem28;

import java.util.List;

public class FreelanceEmployee extends Employee {

    private List<Integer> tickets;

    public FreelanceEmployee(String level, String id, double rate, List<Integer> tickets) {
        super(level, id, rate);
        this.tickets = tickets;
    }

    @Override
    public double calculateSalary() {
        return getTotal() * rate;
    }

    public int getTotal() {
        return tickets.stream().mapToInt(t -> t).sum();
    }


    @Override
    public String toString() {
        return super.toString() + String.format(" Tickets count: %d Tickets points: %d", tickets.size(), getTotal());
    }
}
