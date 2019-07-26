package io.github.epelde.katakume.leapyear;

public class Year {

    private int year;

    Year(int year) {
        this.year = year;
    }

    public boolean isLeap() {
        return (isDivisibleBy4(this.year) && !isDivisibleBy100(this.year))
                || isDivisibleBy400SpecialCase(this.year);
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
