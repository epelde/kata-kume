package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static io.github.epelde.katakume.potter.BasketOfBooksTotalPriceTests.Book.BOOK1;
import static io.github.epelde.katakume.potter.BasketOfBooksTotalPriceTests.Book.BOOK2;
import static org.junit.Assert.assertEquals;

public class BasketOfBooksTotalPriceTests {

    @Test
    public void empty_basket_price_is_zero() {
        Basket basket = new Basket(new Book[] {});

        assertEquals(0, basket.price());
    }

    @Test
    public void one_copy_of_any_of_books_costs_8_euros() {
        Basket basket = new Basket(new Book[] { BOOK1 });

        assertEquals(8, basket.price());
    }

    @Test
    public void two_copies_of_any_of_books_cost_8_euros_each() {
        Basket basket = new Basket(new Book[] { BOOK1, BOOK2 });

        assertEquals(16, basket.price());
    }

    public enum Book {
        BOOK1, BOOK2, BOOK3, BOOK4, BOOK5
    }

    private class Basket {

        private Book[] books;

        public Basket(Book[] books) {
            this.books = books;
        }

        public int price() {
            return 8 * this.books.length;
        }
    }
}
