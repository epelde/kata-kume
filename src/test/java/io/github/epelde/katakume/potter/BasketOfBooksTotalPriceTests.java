package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BasketOfBooksTotalPriceTests {

    @Test
    public void empty_basket_price_is_zero() {
        Basket basket = new Basket();

        assertEquals(0, basket.price());
    }

    @Test
    public void one_copy_of_any_of_books_costs_8_euros() {
        Basket basket = new Basket(1);

        assertEquals(8, basket.price());

    }

    private class Basket {

        private int bookUnits;

        public Basket() {
            
        }

        public Basket(int bookUnits) {
            this.bookUnits = bookUnits;
        }

        public int price() {
            return 8 * this.bookUnits;
        }
    }
}
