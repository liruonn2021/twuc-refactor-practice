package com.twu.refactoring;

public class LineItem {
	private String desc;
	private double price;
	private int quantity;

	public LineItem(String desc, double price, int quantity) {
		super();
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
	}

	public String getDescription() {
		return desc;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

	public void getDetailLineItems(StringBuilder output) {
		output.append(getDescription());
		output.append('\t');
		output.append(getPrice());
		output.append('\t');
		output.append(getQuantity());
		output.append('\t');
		output.append(totalAmount());
		output.append('\n');
	}
}
