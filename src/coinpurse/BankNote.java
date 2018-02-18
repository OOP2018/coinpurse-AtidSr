package coinpurse;

/**
 * BankNote Class which is include value currency and serial number
 * @auther Atid Srisukhantapuek 
 * 
 */
public class BankNote extends Money {
	/** Next SerialNumber of BankNote */
	private static long nextSerialNumber = 1000000;

	/** SerialNumber of BankNote */
	private long serialNumber;
	
	/**
	 *Constructor of BankNote Class with value and currency 
	 *@param value and currency
	 */
	public BankNote(double value ,String currency) {
	    super(value, currency);
		this.serialNumber = nextSerialNumber++;
	}
	
	/**
	 *Constructor of BankNote Class with value and currency 
	 *@param value and currency
	 */
	public BankNote(double value ,String currency, long newSerialNumber) {
	    super(value, currency);
		this.serialNumber = newSerialNumber++;
	}

	/** Get serial number of BankNote
	 * @return BankNote's serial number 
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**Get information of BankNote Class*/
	public String toString() {
		return this.getValue() + "-"+this.getCurrency()+" note [" + serialNumber + "]";
	}
}
