package coinpurse;

/**
 * Money Class for represent money with value and currency 
 * 
 * @author Atid Srisukhantapuek
 * 
 */


public class Money implements Valuable {
	/**Value of money*/
	private double value;
	/**Currency of money*/
	private String currency;
	/**
	 * Constructor of Money with value and currency
	 * @param Money's value
	 * @param Money's currency 
	 */
	
	public Money(double value, String currency) {

		if(value < 0) {
			throw new IllegalArgumentException("Value must be positive");
		}else {
			this.value = value;
		}
		
		this.currency = currency;
	}
	/** 
	 * Get value of money
	 * @param value of money;
	 */
	public double getValue() {
		return value;
	}
	
	/** Get currency of money
	 * @param currency of money;
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Method for order money by value which is the smallest come first
	 * @param Money that user want to compare 
	 * @return Order money a compare to b, 
	 * -1 if coin a's value is lower than b's value 
	 *  0 if coin a's value is equals b's value 
	 *  1 if coin a's value is greater than b's value 
	 */
	public int compareTo(Valuable value) {
		
		if(this.getCurrency().equalsIgnoreCase(value.getCurrency())){
			
			if (this.getValue() < value.getValue()) {
				return -1;
			} else if (this.getValue() > value.getValue()) {
				return 1;
			}else 
				return 0;
			
		}
		
		return this.getCurrency().compareToIgnoreCase(value.getCurrency());



		
		
	}

	/**
	 * Check value and currency of money that equal to other or not
	 * @param Obj money that user want to compare to this money
	 * @return true if equal otherwise false
	 */
	@Override
	public boolean equals(Object arg) {
		// (1) verify that obj is not null
		if (arg == null)
			return false;
		// (2) test that obj is the same class as "this" object
		if (arg.getClass() != this.getClass())
			return false;
		// (3) cast obj to this class's type
		Valuable other = (Valuable) arg;
		// (4) compare whatever values determine "equal"
		if (value == other.getValue() && currency.equalsIgnoreCase(other.getCurrency()))
			return true;
	
		return false;
	}



	
}
