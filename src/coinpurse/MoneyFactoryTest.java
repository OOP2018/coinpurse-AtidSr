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
/**
 * Test the Purse using JUnit.
 * This is a JUnit 4 test suite.  
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4,
 * but you have to tell the IDE to add it to your project as a "Library".
 * To run these tests, right click on this file (in Project panel)
 * and choose Run As -> JUnit test
 * 
 * @author Atid Srisukhantapuek
 * 
 */
public class MoneyFactoryTest {
	/** Thai's money value as double*/
	private double ThaiValue[] = { 5, 10, 20, 50, 100, 500, 1000 };
	/** Thai's money value as String*/
	private String ThaiValueString[] = { "5", "10", "20", "50", "100", "500", "1000" };
	/** Malay's money value as double*/
	private double MalayValue[] = { 0.05, 0.10, 0.20, 0.5, 1, 20, 50, 100 };
	/** Malay's money value as String*/
	private String MalayValueString[] = { "0.05", "0.10", "0.20", "0.5", "1", "20", "50", "100" };

	@Before
	public void setUp() {
		// nothing to initialize
	}
	
	/** 
	 * This method use for reduce code in testCreateValueWithDouble
	 * @param Value that valid in country and factory 
	 */
	public void addMoney(double[] value, MoneyFactory F) {
		for (int i = 0; i < value.length; i++) {
			assertNotNull(F.createMoney(value[i]));
		}

	}

	/** 
	 * This method use for reduce code in testCreateValueWithString
	 * @param Value that valid in country and factory 
	 */
	public void addMoney(String[] value, MoneyFactory F) {
		for (int i = 0; i < value.length; i++) {
			assertNotNull(F.createMoney(value[i]));
		}
	}

	/**
	 * Test Instance method of MoneyFactory 
	 */
	@Test
	public void testInstance() {
		MoneyFactory F = MoneyFactory.getInstance();
		MoneyFactory FF = MoneyFactory.getInstance();
		assertNotNull(F);
		assertEquals(F, FF);

	}
	
	/**
	 * Test CreateValue method of MoneyFactory with double
	 */
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
	/**
	 * Test CreateValue method of MoneyFactory with string
	 */
	@Test
	public void testCreateValueWithString() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory F = MoneyFactory.getInstance();

		addMoney(ThaiValueString, F);

		// Malaysia's Value
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory FF = MoneyFactory.getInstance();

		addMoney(MalayValueString, FF);

	}
	/**
	 * Test setValue method of MoneyFactory
	 */
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
	/**
	 * Test currency of MalayFactory
	 */
	@Test
	public void testMalayCurrency() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory MalayFactory = MoneyFactory.getInstance();
		
		Valuable m1 = new Coin(0.5, "Ringgit");
		assertEquals(m1.getCurrency(), MalayFactory.createMoney(0.5).getCurrency());
		Valuable m2 = new BankNote(100, "Ringgit");
		assertEquals(m2.getCurrency(), MalayFactory.createMoney(100).getCurrency());

	}
	/**
	 * Test currency of ThaiFactory
	 */
	
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
