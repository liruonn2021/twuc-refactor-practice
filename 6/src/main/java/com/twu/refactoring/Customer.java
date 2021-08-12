package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Customer {

	private final String name;
	private final ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public void updateRental(Movie movie) {
		Optional<Rental> oldRental = rentalList.stream().filter(rental -> rental.getMovie().getTitle().equals(movie.getTitle())).findAny();
		oldRental.ifPresent(Rental -> Rental.setMovie(movie));
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentals.hasNext()) {
			Rental each = rentals.next();

			double thisAmount = each.getMovie().getThisAmount(each);
			frequentRenterPoints = each.getMovie().getFrequentRenterPoints(frequentRenterPoints, each);

			result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
			totalAmount += thisAmount;
		}
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}

}
