package coinpurse;

/**
 * BankNote Class which is include value currency and serial number
 * @auther Atid Srisukhantapuek 
 * 
 */
public class BankNote implements Valuable {
	/** Next SerialNumber of BankNote */
	private static long nextSerialNumber = 1000000;
	/** Value of BankNote */
	private double value;
	/** Currency of BankNote */
	private String currency;
	/** SerialNumber of BankNote */
	private long serialNumber;
	
	/**
	 *Constructor of BankNote Class with value and currency 
	 *@param value and currency
	 */
	public BankNote(double value ,String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}
	/** Get value of BankNote
	  @return BankNote's value
	 */
	public double getValue() {
		return value;
	}
	
	/** Get currency of BankNote
	  @return BankNote's currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/** Get serial number of BankNote
	  @return BankNote's serial number 
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Check value and currency of BankNote that equal to other or not
	 * @param Obj BankNote that user want to compare to this BankNote
	 * @return true if equal otherwise false
	 */
	public boolean equals(Object arg) {
		// (1) verify that obj is not null
		if (arg == null)
			return false;
		// (2) test that obj is the same class as "this" object
		if (arg.getClass() != this.getClass())
			return false;
		// (3) cast obj to this class's type
		BankNote other = (BankNote) arg;
		// (4) compare whatever values determine "equal"
		if (value == other.getValue() && currency.equalsIgnoreCase(other.getCurrency()))
			return true;

		return false;
	}

	/**Get information of BankNote Class*/
	public String toString() {
		return value + "-"+currency+" note [" + serialNumber + "]";
	}
}
