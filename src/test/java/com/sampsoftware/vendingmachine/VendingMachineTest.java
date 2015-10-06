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
	public void whenInvalidCoinIsInsertedRejectCoin() {
		assertEquals(false,vendingMachine.insertCoin(new Penny()));
	}

	@Test
	public void whenValidCoinIsInsertedAcceptValidCoin() {
		assertEquals(true,vendingMachine.insertCoin(new Nickel()));
		assertEquals(true,vendingMachine.insertCoin(new Dime()));
		assertEquals(true,vendingMachine.insertCoin(new Quarter()));
	}

	@Test
	public void whenValidCoinIsInsertedIncrementBalance() {
		int beginningBalance = vendingMachine.getBalance();
		vendingMachine.insertCoin(new Nickel());
		assertEquals(beginningBalance+5,vendingMachine.getBalance());
		
		beginningBalance = vendingMachine.getBalance();
		vendingMachine.insertCoin(new Dime());
		assertEquals(beginningBalance+10,vendingMachine.getBalance());
		
		beginningBalance = vendingMachine.getBalance();
		vendingMachine.insertCoin(new Quarter());
		assertEquals(beginningBalance+25,vendingMachine.getBalance());
	}
}