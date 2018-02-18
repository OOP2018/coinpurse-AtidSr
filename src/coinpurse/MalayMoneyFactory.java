package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{

	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.5) {
			return new Coin(value, "Ringgit");
		}else if(value == 1||value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, "Ringgit",nextSerialNumber++);
		}
		throw new IllegalArgumentException(value+" is not a valid currency value");
	}
	

}
