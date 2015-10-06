import com.sampsoftware.vendingmachine.VendingMachine;
import com.sampsoftware.vendingmachine.coins.*;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {
	VendingMachine vendingMachine = new VendingMachine();

	@Test
	public void whenNullCoinIsInsertedRejectCoin() {
		assertEquals(false,vendingMachine.insertCoin(null));
	}

	@Test
	public void whenNonCoinIsInsertedRejectCoin() {
		assertEquals(false,vendingMachine.insertCoin(new Object()));
	}

	@Test
	public void whenDimeIsInsertedAcceptDime() {
		assertEquals(true,vendingMachine.insertCoin(new Dime()));
	}

	@Test
	public void whenDimeIsInsertedIncrementBalance() {
		int beginningBalance = vendingMachine.getBalance();
		vendingMachine.insertCoin(new Dime());
		assertEquals(beginningBalance+10,vendingMachine.getBalance());
	}
}