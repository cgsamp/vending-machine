package com.sampsoftware.vendingmachine.coins;

/**
* Coins are defined by weight, not value, as the vending machine can only read weight.
* Weight is specified in milligrams.
*
* http://www.usmint.gov/about_the_mint/?action=coin_specifications
*/

public abstract class Coin {
	private int weight;

	public int getWeight() {
		return weight;
	}

	protected void setWeight(int w) {
		weight = w;
	}
}
