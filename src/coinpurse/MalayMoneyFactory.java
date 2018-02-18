package coinpurse;
/**
 * MalayMoneyFactory Class is subclass of MoneyFactory that make MoneyFactory accept malaysia's money
 * @auther Atid Srisukhantapuek 
 * 
 */
public class MalayMoneyFactory extends MoneyFactory{
	
	/**
	 * This method modify createMoney from superclass(MoneyFactory) 
	 * for accept malaysia money
	 * @param malaysia money's value
	 * @return malaysia's money with value and currency
	 *         throw IllegalArgumentException if value not valid
	 */
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.5) {
			return new Coin(value, "Ringgit");
		}else if(value == 1||value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, "Ringgit",nextSerialNumber++);
		}
		throw new IllegalArgumentException(value+" is not a valid currency value");
	}
	

}
