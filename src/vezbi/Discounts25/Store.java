package vezbi.Discounts25;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    private String name;
    private List<DiscountAndPrice> discountsAndPrices;

    public Store() {
        discountsAndPrices = new ArrayList<>();
    }

    public Store(String line) {
        String[] parts = line.split("\\s+");
        name = parts[0];
        discountsAndPrices = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            String[] tokens = parts[i].split(":");
            int discount = Integer.parseInt(tokens[0]);
            int price = Integer.parseInt(tokens[1]);
            discountsAndPrices.add(new DiscountAndPrice(discount, price));
        }
    }

    public double avgDiscount() {
        return discountsAndPrices.stream().mapToDouble(DiscountAndPrice::getPercent).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public int getTotalDiscount() {
        return discountsAndPrices.stream().mapToInt(DiscountAndPrice::getDiscount).sum();
    }

    @Override
    public String toString() {
        String discounts = discountsAndPrices.stream()
                .sorted(Comparator.comparing(DiscountAndPrice::getPercent).thenComparing(DiscountAndPrice::getDiscounts).reversed())
                .map(DiscountAndPrice::toString)
                .collect(Collectors.joining("\n"));


        return String.format("%s\nAverage discount: %.1f%%\nTotal discount: %d\n%s", name, avgDiscount(), getTotalDiscount(), discounts);
    }
}
