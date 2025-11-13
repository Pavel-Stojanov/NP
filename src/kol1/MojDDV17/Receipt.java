package kol1.MojDDV17;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private int id;
    private List<Item> items;

    public Receipt(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public static Receipt create(String line) throws AmountNotAllowedException {
        String[] parts = line.split("\\s+");
        int id = Integer.parseInt(parts[0]);
        List<Item> items = new ArrayList<>();
        int total = 0;
        for (int i = 1; i < parts.length; i += 2) {
            items.add(new Item(Integer.parseInt(parts[i]), parts[i + 1].charAt(0)));
            total += Integer.parseInt(parts[i]);
        }
        if (total > 30000) {
            throw new AmountNotAllowedException(total);
        }
        return new Receipt(id, items);
    }

    public int getTotalPrice() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public double getTotalTax() {
        return items.stream().mapToDouble(Item::getTaxReturn).sum();
    }

    @Override
    public String toString() {
        return String.format("%10d\t%10d\t%10.5f", id, getTotalPrice(), getTotalTax());
    }
}
