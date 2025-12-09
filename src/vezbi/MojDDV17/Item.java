package vezbi.MojDDV17;

public class Item {
    private int price;
    private char type;

    public Item(int price, char type) {
        this.price = price;
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public double getTaxReturn() {
        double tax;
        switch (type) {
            case 'A':
                tax = 0.18;
                break;
            case 'B':
                tax = 0.05;
                break;
            default:
                tax = 0.0;
        }
        return price * tax * 0.15;
    }
}
