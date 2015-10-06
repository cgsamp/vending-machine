import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class VendingMachineTest {
	@Test
	public void whenNullCoinIsInsertedRejectCoin() {
		VendingMachine vendingMachine = new VendingMachine();
		assertEquals(false,vendingMachine.insertCoin(null));
	}
}