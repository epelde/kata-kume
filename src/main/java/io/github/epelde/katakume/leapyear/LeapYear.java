package io.github.epelde.katakume.leapyear;

public class LeapYear {
    public boolean isLeap(int year) {
        return (isDivisibleBy4(year) && !isDivisibleBy100(year))
                || isDivisibleBy400SpecialCase(year);
    }

    private boolean isDivisibleBy4(int year) {
        return year % 4 == 0;
    }

    private boolean isDivisibleBy100(int year) {
        return year % 100 == 0;
    }

    private boolean isDivisibleBy400SpecialCase(int year) {
        return year % 400 == 0;
    }

}
