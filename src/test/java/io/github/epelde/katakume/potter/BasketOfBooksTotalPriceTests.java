package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static io.github.epelde.katakume.potter.Book.*;
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
    public void any_two_different_book_set_get_a_discount() {
        Basket basket = new Basket(new Book[] { BOOK1, BOOK2 });

        assertTrue(15.2 == basket.price());
    }

    @Test
    public void any_three_different_book_set_get_a_discount() {
        Basket basket = new Basket(new Book[] { BOOK1, BOOK2, BOOK3 });

        assertTrue(21.6 == basket.price());
    }

}
