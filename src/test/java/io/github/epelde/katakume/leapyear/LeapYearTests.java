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

    // All years divisible by 400 ARE leap years
    // (so, for example, 2000 was indeed a leap year),
    @Test
    public void aYearDivisibleBy400ShouldBeLeap() {
        assertTrue(leapYear.isLeap(2000));
        assertTrue(leapYear.isLeap(2400));
        assertTrue(leapYear.isLeap(2800));
    }

    // All years divisible by 4 but not by 100 ARE leap years
    // (e.g., 2008, 2012, 2016),
    @Test
    public void aYearDivisibleBy4ButNotBy100IsLeap() {
        assertTrue(leapYear.isLeap(2008));
        assertTrue(leapYear.isLeap(2012));
        assertTrue(leapYear.isLeap(2016));
        assertTrue(leapYear.isLeap(1988));
        assertFalse(leapYear.isLeap(2200));
    }

    // All years divisible by 100 but not by 400 are NOT leap years
    // (so, for example, 1700, 1800, and 1900 were NOT leap years, NOR will 2100 be a leap year),
    @Test
    public void aYearDivisibleBy100ButNotBy400AIsNOTYearLeap() {
        assertFalse(leapYear.isLeap(1700));
        assertFalse(leapYear.isLeap(1800));
        assertFalse(leapYear.isLeap(1900));
        assertFalse(leapYear.isLeap(2100));
    }

    // All years not divisible by 4 are NOT leap years
    // (e.g. 2017, 2018, 2019).
    @Test
    public void aYearNotDivisibleBy4IsNOTLeapYear() {
        assertFalse(leapYear.isLeap(2017));
        assertFalse(leapYear.isLeap(2018));
        assertFalse(leapYear.isLeap(2019));
    }
}
