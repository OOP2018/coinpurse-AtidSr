package coinpurse;
/**
 * ThaiMoneyFactory Class is subclass of MoneyFactory that make MoneyFactory accept Thai's money
 * @auther Atid Srisukhantapuek 
 * 
 */

public class ThaiMoneyFactory extends MoneyFactory {
	/** Next SerialNumber of MoneyFactory */
	private static long nextSerialNumber = 1000000;
	/**
	 * This method modify createMoney from superclass(MoneyFactory) 
	 * for accept Thai's money
	 * @param Thai money's value
	 * @return Thai's money with value and currency
	 *         throw IllegalArgumentException if value not valid
	 */
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10 ) {
			return new Coin(value, "Baht");
		}else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, "Baht", nextSerialNumber++);
		}
		throw new IllegalArgumentException(value+" is not a valid currency value");
	}

}
