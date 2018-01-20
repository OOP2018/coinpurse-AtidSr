package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Atid Srisukhantapuek
 * @version 2018.1.19
 */

public class Coin implements Comparable<Coin> {

	private double value;
	private String currency;

	public Coin(double value, String currency) {
		if (value >= 0) {
			this.value = value;
		} else {
			this.value = 0;
		}
		this.currency = currency;
	}

	/** get Coin value */
	public double getValue() {
		return value;
	}

	/** get Coin currency */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check value and currency of Coin that equal to other or not
	 * @param other coin
	 * @return true or false
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
	 * compare coin to other coin
	 * @param other coin
	 * @return order value
	 *  a compare to b      -1 if a < b
	 *                       0 if a = b
	 *                       1 if a > b
	 */
	public int compareTo(Coin coin) {
		if (value < coin.getValue()) {
			return -1;
		} else if (value > coin.getValue()) {
			return 1;
		}
		return 0;
	}

	/** get string of this coin */
	public String toString() {
		return value + "-" + currency;
	}



}
