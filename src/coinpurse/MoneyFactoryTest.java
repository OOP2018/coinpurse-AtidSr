package coinpurse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.Variable;

public class MoneyFactoryTest {

	private double ThaiValue[] = { 5, 10, 20, 50, 100, 500, 1000 };
	private String ThaiValueString[] = { "5", "10", "20", "50", "100", "500", "1000" };
	private double MalayValue[] = { 0.05, 0.10, 0.20, 0.5, 1, 20, 50, 100 };
	private String MalayValueString[] = { "0.05", "0.10", "0.20", "0.5", "1", "20", "50", "100" };

	@Before
	public void setUp() {
		// nothing to initialize
	}

	public void addMoney(double[] value, MoneyFactory F) {
		for (int i = 0; i < value.length; i++) {
			assertNotNull(F.createMoney(value[i]));
		}

	}

	public void addMoney(String[] value, MoneyFactory F) {
		for (int i = 0; i < value.length; i++) {
			assertNotNull(F.createMoney(value[i]));
		}
	}

	@Test
	public void testInstance() {
		MoneyFactory F = MoneyFactory.getInstance();
		MoneyFactory FF = MoneyFactory.getInstance();
		assertNotNull(F);
		assertEquals(F, FF);

	}

	@Test
	public void testCreateValueWithDouble() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory F = MoneyFactory.getInstance();
		addMoney(ThaiValue, F);

		// Malaysia Value
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory FF = MoneyFactory.getInstance();
		addMoney(MalayValue, FF);

	}

	@Test
	public void testCreateValueWithString() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory F = MoneyFactory.getInstance();

		addMoney(ThaiValueString, F);

		// Malaysia Value
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory FF = MoneyFactory.getInstance();

		addMoney(MalayValueString, FF);

	}

	@Test
	public void setFactory() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory ThaiFactory = MoneyFactory.getInstance();
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory MalayFactory = MoneyFactory.getInstance();
		assertNotEquals(ThaiFactory, MalayFactory);
		assertTrue(ThaiFactory instanceof ThaiMoneyFactory);
		assertTrue(MalayFactory instanceof MalayMoneyFactory);

	}

	@Test
	public void testMalayCurrency() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory MalayFactory = MoneyFactory.getInstance();
		
		Valuable m1 = new Coin(0.5, "Ringgit");
		assertEquals(m1.getCurrency(), MalayFactory.createMoney(0.5).getCurrency());
		Valuable m2 = new BankNote(100, "Ringgit");
		assertEquals(m2.getCurrency(), MalayFactory.createMoney(100).getCurrency());

	}
	
	
	@Test
	public void testThaiCurrency() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory ThaiFactory = MoneyFactory.getInstance();
		
		Valuable T1 = new Coin(5, "Baht");
		assertEquals(T1.getCurrency(), ThaiFactory.createMoney(5).getCurrency());
		Valuable T2 = new BankNote(100, "Baht");
		assertEquals(T2.getCurrency(), ThaiFactory.createMoney(100).getCurrency());

	}

}
