package io.github.epelde.katakume.potter;

import org.junit.jupiter.api.Test;

import static io.github.epelde.katakume.potter.Book.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketOfBooksTotalPriceTests {

    @Test
    public void empty_basket_price_is_zero() {
        assertTrue(0 == new Basket(new Book[] {}).price());
    }

    @Test
    public void one_copy_of_any_of_books_costs_8_euros() {
        assertTrue(8 == new Basket(new Book[] { BOOK1 }).price());
    }

    @Test
    public void copies_of_any_same_book_have_no_discount() {
        assertTrue(16 == new Basket(new Book[] { BOOK2, BOOK2 }).price());
        assertTrue(24 == new Basket(new Book[] { BOOK3, BOOK3, BOOK3 }).price());
        assertTrue(32 == new Basket(new Book[] { BOOK4, BOOK4, BOOK4, BOOK4 }).price());
        assertTrue(40 == new Basket(new Book[] { BOOK5, BOOK5, BOOK5, BOOK5, BOOK5 }).price());
        assertTrue(48 == new Basket(new Book[] { BOOK5, BOOK5, BOOK5, BOOK5, BOOK5, BOOK5 }).price());
    }

    @Test
    public void any_two_different_book_set_get_a_5_per_cent_discount() {
        assertTrue(15.2 == new Basket(new Book[] { BOOK1, BOOK2 }).price());
    }

    @Test
    public void any_three_different_book_set_get_a_10_per_cent_discount() {
        assertTrue(21.6 == new Basket(new Book[] { BOOK1, BOOK2, BOOK3 }).price());
    }

    @Test
    public void any_four_different_book_set_get_a_20_per_cent_discount() {
        assertTrue(25.6 == new Basket(new Book[] { BOOK1, BOOK2, BOOK3, BOOK4 }).price());
    }

    @Test
    public void any_five_different_book_set_get_a_20_per_cent_discount() {
        assertTrue(30 == new Basket(new Book[] { BOOK1, BOOK2, BOOK3, BOOK4, BOOK5 }).price());
    }

}
