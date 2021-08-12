package com.twu.refactoring;

public class Movie {

	private final String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle () {
		return title;
	}

	public double getThisAmount(Rental rental) {
		return 0;
	}

	public int getFrequentRenterPoints(int frequentRenterPoints, Rental rental) {
		return frequentRenterPoints;
	}
}

