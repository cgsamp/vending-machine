package com.sampsoftware.vendingmachine;

import com.sampsoftware.vendingmachine.coins.*;
import com.sampsoftware.vendingmachine.products.*;

public class VendingMachine {
	private int balanceInCents = 0;
	private Product slot = null;
	private int coinSlot = 0;

	public int getBalance() {
		return balanceInCents;
	}

	public Product getItemFromSlot() {
		Product slotContents = slot;
		slot = null;
		return slotContents;
	}

	//TODO: Compose change into set of coins
	public int checkCoinReturn() {
		int change = balanceInCents;
		balanceInCents = 0;
		return change;
	}

	private static int findCoinValue(Coin coin) {
		int value = 0;
		switch (coin.getWeight()) {
			case 2268:
				value = 10;
				break;
			case 5000:
				value = 5;
				break;
			case 5670:
				value = 25;
				break;
		}
		return value;
	}

	public boolean insertCoin(Object inserted) {
		if (inserted == null)
			return false;
		
		if (!(inserted instanceof Coin))
			return false;

		Coin coin = (Coin)inserted;

		if (
				!(
					(coin instanceof Nickel) ||
					(coin instanceof Dime) ||
					(coin instanceof Quarter)
				)
			)
			return false;

		int value = findCoinValue(coin);
		if (value == 0)
			return false;
		
		balanceInCents += value;
		return true;
	}

	public String pushButton(String productName) {
		Product product = Product.getProduct(productName);
		if (product == null)
			return "INVALID PRODUCT";

		if (balanceInCents >= product.getPrice()) {
			balanceInCents = balanceInCents - product.getPrice();
			slot = product;
			return "THANK YOU";
		}

		return "INSERT COINS";
	}

}