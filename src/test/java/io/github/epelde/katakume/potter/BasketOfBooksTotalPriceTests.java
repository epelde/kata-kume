package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BasketOfBooksTotalPriceTests {

    @Test
    public void empty_basket_price_is_zero() {
        Basket basket = new Basket(new String[] {});

        assertEquals(0, basket.price());
    }

    @Test
    public void one_copy_of_any_of_books_costs_8_euros() {
        Basket basket = new Basket(new String[] { "BOOK1" });

        assertEquals(8, basket.price());
    }

    @Test
    public void two_copies_of_any_of_books_costs_8_euros_each() {
        Basket basket = new Basket(new String[] { "BOOK1", "BOOK2" });

        assertEquals(16, basket.price());
    }

    private class Basket {

        private String[] books;

        public Basket(String[] books) {
            this.books = books;
        }

        public int price() {
            return 8 * this.books.length;
        }
    }
}
