package vezbi.BookCollection24;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String title;
    private String category;
    private double price;

    public Book(String title, String category, double price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Book o) {
        return Comparator.comparing(Book::getTitle).thenComparing(Book::getPrice).compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) %.2f", title, category, price);
    }
}
