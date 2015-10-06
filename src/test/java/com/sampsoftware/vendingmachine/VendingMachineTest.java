import com.sampsoftware.vendingmachine.VendingMachine;
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
	public void whenNonCoinIsInsertedRejectCoin() {
		VendingMachine vendingMachine = new VendingMachine();
		assertEquals(false,vendingMachine.insertCoin(new Object()));
	}

	@Test
	public void whenDimeIsInsertedAcceptDime() {
		VendingMachine vendingMachine = new VendingMachine();
		Coin coin = new Dime();
		assertEquals(true,vendingMachine.insertCoin(coin));
	}

	@Test
	public void whenDimeIsInsertedIncrementBalance() {
		VendingMachine vendingMachine = new VendingMachine();
		Coin coin = new Dime();
		vendingMachine.insertCoin(coin);
		assertEquals(10,vendingMachine.getBalance());
	}
}