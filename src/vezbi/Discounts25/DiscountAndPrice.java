package vezbi.Discounts25;

public class DiscountAndPrice {
    private int discount;
    private int price;

    public DiscountAndPrice(int discount, int price) {
        this.discount = discount;
        this.price = price;
    }

    public double getPercent() {
        return Math.floor((1 - (double) discount / price) * 100);

    }

    public int getDiscount() {
        return price-discount;
    }
    public int getDiscounts() {
        return discount;
    }



    @Override
    public String toString() {
        return String.format("%2.0f%% %d/%d", getPercent(), discount, price);
    }
}
