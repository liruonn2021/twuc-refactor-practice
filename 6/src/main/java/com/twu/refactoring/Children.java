package com.twu.refactoring;

public class Children extends Movie {

    public Children(String title) {
        super(title);
    }

    @Override
    public double getThisAmount(Rental rental) {
        double thisAmount = 0;
        thisAmount += 1.5;
        if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 1.5;
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
        frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
