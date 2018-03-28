package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Money;
import coinpurse.Valuable;

public class WithdrawTest {

	private WithdrawStrategy strategy;
	
	@Before
	public void setUp() {
		strategy = new GreedyWithdrawStrategy();
		
	}
	
	private Valuable[] toArray(List<Valuable> temp) {
		
		Valuable[] array  = new Valuable[temp.size()];
		temp.toArray(array );
		return array;
	}
	
    /** Make a coin with the default currency. To save typing "new Coin(...)" */
    private Money makeMoney(double value, String Currency) {
		return new Money(value,Currency);
	}

	
	/** Add one coin and remove it. */
	@Test(timeout=1000)
	public void testEasyWithdraw() {

		List<Valuable> val = new ArrayList<Valuable>();
		double [] values = {1, 20, 0.5, 10}; 


		for(double value : values) {
			Valuable coin = makeMoney(value,"Baht");
			assertTrue(val.add(coin));
			Valuable [] result = toArray(strategy.withdraw(coin, val));
			assertTrue( result != null );
			assertEquals( 1, result.length );
			assertSame(  coin, result[0] ); // should be same object
			
		}
	}
	

	/** Add 4 coins and then withdraw in pairs, but not in same order. */
	@Test(timeout=1000)
	public void testMultiWithdraw() {

		List<Valuable> val = new ArrayList<Valuable>();

		Valuable[] coins = { makeMoney(5.0,"Baht"), makeMoney(10.0,"Baht"), makeMoney(1.0,"Baht"), makeMoney(5.0,"Baht") };
		for(Valuable coin: coins)  val.add(coin) ;
		
		double amount1 = coins[1].getValue() + coins[3].getValue();
		double amount2 = coins[0].getValue() + coins[2].getValue();

		Valuable [] wd1 = toArray(strategy.withdraw(makeMoney(amount1, "Baht"), val));
		assertEquals(amount1, sum(wd1) ,1.0E-6);
		


	}
	

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout=1000)
	public void testWithdrawEverything() {
	
		
		List<Valuable> val = new ArrayList<Valuable>();
		Valuable[] coins = { makeMoney(1.0,"Baht"), makeMoney(20,"Baht"), makeMoney(100,"Baht"), makeMoney(1000,"Baht"), makeMoney(500,"Baht")};
		double amount = 0.0;
		for(Valuable coin: coins) { 
			val.add(coin) ;
			amount += coin.getValue();
		}
		
		Valuable [] withdrawResult = toArray(strategy.withdraw(makeMoney(amount, "Baht"), val));
		assertEquals(amount, sum(withdrawResult),1.0E-6 );
			
	}

	/** Withdraw full amount in purse, using varying numbers of objects. */
	@Test(timeout=1000)
	public void testWithdrawEverythingExceptOne() {
	
		
		List<Valuable> val = new ArrayList<Valuable>();
		Valuable[] coins = { makeMoney(1.0,"Baht"), makeMoney(20,"Baht"), makeMoney(100,"Baht"), makeMoney(1000,"Baht"), makeMoney(500,"Baht")};
		double amount = 0.0;
		for(Valuable coin: coins) { 
			val.add(coin) ;
			amount += coin.getValue();
		}
		
		List<Valuable> withdrawResult = strategy.withdraw(makeMoney(amount-1000, "Baht"), val);
		assertEquals(amount-1000, sum(withdrawResult),1.0E-6 );
			
	}
	@Test(timeout=1000)
	public void testImpossibleWithdraw() {
		List<Valuable> val = new ArrayList<Valuable>();
		assertNull( strategy.withdraw(makeMoney(1, "Baht"), val) );
		val.add(makeMoney(20,"Baht"));
		assertNull( strategy.withdraw(makeMoney(1, "Baht"),val) );
		assertNull( strategy.withdraw(makeMoney(19, "Baht"),val) );
		assertNull( strategy.withdraw(makeMoney(21, "Baht"),val) );
		val.add(makeMoney(20, "Baht"));
		assertNull(strategy.withdraw(makeMoney(30, "Baht"),val) );
	}
	
	
	@Test(timeout=1000)
	public void testWithdrawDifferentCurrency() {
		List<Valuable> val = new ArrayList<Valuable>();
		val.add(makeMoney(1000, "Baht"));
		val.add(makeMoney(100, "Baht"));
		val.add(makeMoney(50, "Baht"));
		val.add(makeMoney(10, "Baht"));
		val.add(makeMoney(1, "Baht"));
		val.add(makeMoney(0.10, "Ringgit"));
		val.add(makeMoney(0.20, "Ringgit"));
		val.add(makeMoney(1, "Ringgit"));
		val.add(makeMoney(20, "Ringgit"));
		val.add(makeMoney(50, "Ringgit"));
		
		Valuable [] withdrawResult = toArray(strategy.withdraw(makeMoney(1000, "Baht"), val));
		assertEquals(1000, withdrawResult[0].getValue(),1.0E-6);
		assertEquals("Baht", withdrawResult[0].getCurrency());
		
		withdrawResult = toArray(strategy.withdraw(makeMoney(50, "Ringgit"), val));
		assertEquals(50, withdrawResult[0].getValue(),1.0E-6);
		assertEquals("Ringgit", withdrawResult[0].getCurrency());
		
		withdrawResult = toArray(strategy.withdraw(makeMoney(1, "Ringgit"), val));
		assertEquals(1, withdrawResult[0].getValue(),1.0E-6);
		assertEquals("Ringgit", withdrawResult[0].getCurrency());
	}
	
	
	/**
	 * Sum the value of some coins.
	 * @param result array of coins
	 * @return sum of values of the coins
	 */
	private double sum(Valuable[] result)  {
		if (result == null) return 0.0;
		double sum = 0;
		for(Valuable c: result) if (c != null) sum += c.getValue();
		return sum;
	}
	
	private double sum(List<Valuable> result)  {
		if (result == null) return 0;
		double sum = 0;
		for(Valuable c: result) if (c != null) sum += c.getValue();
		return sum;
	}
}
