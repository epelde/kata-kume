package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BasketOfBooksTotalPriceTests {

    @Test
    public void empty_basket_price_is_zero() {
        Basket basket = new Basket();

        assertEquals(0, basket.price());
    }

    private class Basket {
        public int price() {
            return 0;
        }
    }
}
