package io.github.epelde.katakume.leapyear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTests {

    private LeapYear leapYear;

    @BeforeEach
    public void setUp() {
        leapYear = new LeapYear();
    }

    @Test
    public void aYearNotDivisibleBy4IsACommonYear() {
        assertFalse(leapYear.isLeap(2001));
        assertFalse(leapYear.isLeap(2003));
        assertFalse(leapYear.isLeap(2005));
        assertFalse(leapYear.isLeap(2006));
        assertFalse(leapYear.isLeap(2017));
        assertFalse(leapYear.isLeap(2018));
        assertFalse(leapYear.isLeap(2019));
    }

    @Test
    public void aYearDivisibleBy4ButNotBy100IsLeapYear() {
        assertTrue(leapYear.isLeap(2008));
        assertTrue(leapYear.isLeap(2012));
        assertTrue(leapYear.isLeap(2016));
        assertTrue(leapYear.isLeap(1988));
        assertTrue(leapYear.isLeap(1992));
    }

    @Test
    public void aYearDivisibleBy4AndBy100IsLeapCommon() {
        assertFalse(leapYear.isLeap(1900));
        assertFalse(leapYear.isLeap(2100));
        assertFalse(leapYear.isLeap(2100));
        assertFalse(leapYear.isLeap(2200));
    }

    @Test
    public void aYearDivisibleBy400IsALeapYear() {
        assertTrue(leapYear.isLeap(1600));
        assertTrue(leapYear.isLeap(2000));
        assertTrue(leapYear.isLeap(2400));
        assertTrue(leapYear.isLeap(2800));
    }

}
