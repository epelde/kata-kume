package io.github.epelde.katakume.potter;

import java.util.Arrays;
import java.util.List;

public class Basket {

    private static final double TWO_DIFFERENT_DISCOUNT = 0.95;
    private static final double THREE_DIFFERENT_DISCOUNT = 0.90;

    private List<Book> bookList;

    public Basket(Book[] books) {
        this.bookList = Arrays.asList(books);
    }

    public double price() {
        if (this.bookList.size() == 2 && this.bookList.get(0) != this.bookList.get(1)) {
            return 8 * this.bookList.size() * TWO_DIFFERENT_DISCOUNT;
        }
        if (this.bookList.size() == 3 && this.bookList.get(0) != this.bookList.get(1) &&
                this.bookList.get(0) != this.bookList.get(2) &&
                this.bookList.get(1) != this.bookList.get(2)) {
            return 8 * this.bookList.size() * THREE_DIFFERENT_DISCOUNT;
        }
        return 8 * this.bookList.size();
    }
}
