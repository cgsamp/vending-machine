import com.sampsoftware.vendingmachine.coins.*;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {
	@Test
	public void whenNullCoinIsInsertedRejectCoin() {
		VendingMachine vendingMachine = new VendingMachine();
		assertEquals(false,vendingMachine.insertCoin(null));
	}

	@Test
	public void whenDimeIsInsertedAcceptDime() {
		VendingMachine vendingMachine = new VendingMachine();
		Coin coin = new Dime();
		assertEquals(true,vendingMachine.insertCoin(coin));
	}
}