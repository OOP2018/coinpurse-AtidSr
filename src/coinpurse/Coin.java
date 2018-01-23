package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Atid Srisukhantapuek
 * @version 2018.1.23
 */

public class Coin implements Comparable<Coin> {
	
	/**value of coin*/
	private double value;
	/**currency of coin*/
	private String currency;
	
	/**
	 * Constructor of coin with value and currency
	 * @param coin's value
	 * @param coin's currency 
	 */
	
	public Coin(double value, String currency) {
		try {
			if(value <= 0) {
				throw new IllegalArgumentException();
			}else {
				this.value = value;
			}
				
		}catch(IllegalArgumentException e){
			System.out.println("value must be positive");
		}
		
		this.currency = currency;
	}

	/** get Coin's value
	 * @return value of coin 
	 */
	public double getValue() {
		return value;
	}

	/** get Coin's currency 
	 * @return currency of coin
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check value and currency of Coin that equal to other or not
	 * @param obj coin that user want to compare to this coin
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
		Coin other = (Coin) arg;
		// (4) compare whatever values determine "equal"
		if (value == other.getValue() && currency.equalsIgnoreCase(other.getCurrency()))
			return true;

		return false;
	}

	/**
	 * method for order coin by value which is the smallest come first
	 * @param coin that user want to compare 
	 * @return order value a compare to b, 
	 * -1 if coin a's value is greater than b's value 
	 *  0 if coin a's value is equals b's value 
	 *  1 if coin a's value is lower than b's value 
	 */
	public int compareTo(Coin coin) {
		if (value < coin.getValue()) {
			return -1;
		} else if (value > coin.getValue()) {
			return 1;
		}
		return 0;
	}

	/** show detail of coin (value and currency)
	 * @return coin value and currency
	 */
	public String toString() {
		return value + "-" + currency;
	}

}
