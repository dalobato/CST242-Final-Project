package textbook;

import java.util.ArrayList;

/**
 * Created by dalob on 4/5/2017.
 */
public class Textbook {

    String bookISBN;
    String bookTitle;
    ArrayList<Author> bookAuthors;
    Double bookPrice;

    public Textbook(String bookISBN, String bookTitle, ArrayList<Author> bookAuthors, Double bookPrice) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookAuthors = bookAuthors;
        this.bookPrice = bookPrice;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public ArrayList<Author> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(ArrayList<Author> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Textbook:\n" +
                "Book Title: " + bookTitle + "\n" +
                "Book ISBN: " + bookISBN + "\n" +
                "Book Authors: " + bookAuthors + "\n" +
                "Book Price: " + bookPrice;
    }
}
