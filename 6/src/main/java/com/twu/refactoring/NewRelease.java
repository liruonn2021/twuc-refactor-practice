package com.twu.refactoring;

public class NewRelease extends Movie {
    public NewRelease(String title) {
        super(title);
    }

    @Override
    public double getThisAmount(Rental each) {
        double thisAmount = 0;
        thisAmount += each.getDaysRented() * 3;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        if (rental.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}
