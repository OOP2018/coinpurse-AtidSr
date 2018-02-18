package coinpurse;


public abstract class MoneyFactory {
	private static MoneyFactory factory;

	/** Next SerialNumber of MoneyFactory */
	protected static long nextSerialNumber = 1000000;

	
	public static MoneyFactory getInstance() {
		
		if (factory == null) {
			factory = new ThaiMoneyFactory();
		}

		return factory;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		try {
			double val = Double.parseDouble(value);
			return createMoney(val);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("This is not value");
		}
	}

	public static void setFactory(MoneyFactory f) {
		factory = f;
	}


}
