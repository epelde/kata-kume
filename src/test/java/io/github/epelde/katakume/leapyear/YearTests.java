package io.github.epelde.katakume.leapyear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YearTests {

    @Test
    public void aYearNotDivisibleBy4IsACommonYear() {
        assertFalse(new Year(2001).isLeap());
        assertFalse(new Year(2003).isLeap());
        assertFalse(new Year(2005).isLeap());
        assertFalse(new Year(2017).isLeap());
        assertFalse(new Year(2018).isLeap());
        assertFalse(new Year(2019).isLeap());
    }

    @Test
    public void aYearDivisibleBy4ButNotBy100IsLeapYear() {
        assertTrue(new Year(2008).isLeap());
        assertTrue(new Year(2012).isLeap());
        assertTrue(new Year(2016).isLeap());
        assertTrue(new Year(1988).isLeap());
        assertTrue(new Year(1992).isLeap());
    }

    @Test
    public void aYearDivisibleBy4AndBy100IsLeapCommon() {
        assertFalse(new Year(1900).isLeap());
        assertFalse(new Year(2100).isLeap());
        assertFalse(new Year(2200).isLeap());
    }

    @Test
    public void aYearDivisibleBy400IsALeapYear() {
        assertTrue(new Year(1600).isLeap());
        assertTrue(new Year(2000).isLeap());
        assertTrue(new Year(2400).isLeap());
        assertTrue(new Year(2800).isLeap());
    }

}
