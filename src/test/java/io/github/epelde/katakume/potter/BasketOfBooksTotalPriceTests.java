package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static io.github.epelde.katakume.potter.BasketOfBooksTotalPriceTests.Book.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketOfBooksTotalPriceTests {

    @Test
    public void empty_basket_price_is_zero() {
        Basket basket = new Basket(new Book[] {});

        assertTrue(0 == basket.price());
    }

    @Test
    public void one_copy_of_any_of_books_costs_8_euros() {
        Basket basket = new Basket(new Book[] { BOOK1 });

        assertTrue(8 == basket.price());
    }

    @Test
    public void copies_of_any_same_book_cost_8_euros_each() {
        Basket basket = new Basket(new Book[] { BOOK1, BOOK1, BOOK1, BOOK1, BOOK1 });

        assertTrue(40 == basket.price());
    }

    @Test
    public void any_two_different_books_get_a_discount() {
        Basket basket = new Basket(new Book[] { BOOK1, BOOK2 });

        assertTrue(15.2 == basket.price());
    }

    @Test
    public void any_three_different_books_get_a_discount() {
        Basket basket = new Basket(new Book[] { BOOK1, BOOK2, BOOK3 });

        assertTrue(21.6 == basket.price());
    }


    public enum Book {
        BOOK1, BOOK2, BOOK3, BOOK4, BOOK5
    }

    private class Basket {

        private static final double TWO_DIFFERENT_DISCOUNT = 0.95;
        private static final double THREE_DIFFERENT_DISCOUNT = 0.90;

        private Book[] books;

        public Basket(Book[] books) {
            this.books = books;
        }

        public double price() {
            if (this.books.length == 2 && this.books[0] != this.books[1]) {
                return 8 * this.books.length * TWO_DIFFERENT_DISCOUNT;
            }
            if (this.books.length == 3 && this.books[0] != this.books[1] && this.books[0] != this.books[2]
                && this.books[1] != this.books[2]) {
                return 8 * this.books.length * THREE_DIFFERENT_DISCOUNT;
            }
            return 8 * this.books.length;
        }
    }
}
