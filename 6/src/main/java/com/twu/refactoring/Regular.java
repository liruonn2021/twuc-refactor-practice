package com.twu.refactoring;

public class Regular extends Movie {
    public Regular(String title) {
        super(title);
    }

    @Override
    public double getThisAmount(Rental rental) {
        double thisAmount = 0;
        thisAmount += 2;
        if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
