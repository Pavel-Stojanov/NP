package lab5.LibrarySystem;

import java.util.Map;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private int copies;
    private int borrows;


    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.copies = 1;
        this.borrows = 0;
    }
}
