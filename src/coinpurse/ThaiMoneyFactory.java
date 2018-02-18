package coinpurse;


public class ThaiMoneyFactory extends MoneyFactory {

	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10 ) {
			return new Coin(value, "Baht");
		}else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, "Baht", nextSerialNumber++);
		}
		throw new IllegalArgumentException(value+" is not a valid currency value");
	}

}
