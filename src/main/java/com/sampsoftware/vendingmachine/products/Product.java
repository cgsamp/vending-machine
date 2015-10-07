package com.sampsoftware.vendingmachine.products;

public abstract class Product {
	private String name;
	private int price;

	protected void setName(String n) {
		name = n;
	}

	protected void setPrice(int p) {
		price = p;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean equals(Object obj) {
		return this.getClass() == obj.getClass();
	}

	public static Product getProduct(String productName) {
		if (productName.equals("cola"))
			return new Cola();
		return null;
	}
}