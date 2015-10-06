package com.sampsoftware.vendingmachine;

import com.sampsoftware.vendingmachine.coins.*;

public class VendingMachine {
	private int balanceInCents = 0;

	private static int findCoinValue(Coin coin) {
		int value = 0;
		switch (coin.getWeight()) {
			case 2268:
				value = 10;
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

		int value = findCoinValue(coin);
		if (value == 0)
			return false;
		
		balanceInCents += value;
		return true;
	}

	public int getBalance() {
		return balanceInCents;
	}
}