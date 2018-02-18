package coinpurse;


public abstract class MoneyFactory {
	/** instance of MoneyFactory*/
	private static MoneyFactory factory;

	/** Next SerialNumber of MoneyFactory */
	protected static long nextSerialNumber = 1000000;

	/**
	 * Get instance of MoneyFactory
	 * @return instance of MoneyFactory 
	 * 
	 */
	public static MoneyFactory getInstance() {
		
		if (factory == null) {
			factory = new ThaiMoneyFactory();
		}

		return factory;
	}
	
	/**
	 * Abstract method for create new money object in the local currency 
	 * if the value is invalid throw illegalArgumentExcepton 
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Accept money value as String. If value is an invalid number throw  illegalArgumentExcepton. 
	 * @param value of the money as string
	 * @return Valuable Object
	 */
	public Valuable createMoney(String value) {
		try {
			double val = Double.parseDouble(value);
			return createMoney(val);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("This is not value");
		}
	}
	
	/**
	 * Set Factory of MoneyFactory 
	 * @param factory
	 */
	public static void setFactory(MoneyFactory f) {
		factory = f;
	}


}
