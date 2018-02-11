package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Atid Srisukhantapuek
 * @version 2018.2.09
 */

public class Coin extends Money{
	

	
	/**
	 * Constructor of coin with value and currency
	 * @param Coin's value
	 * @param Coin's currency 
	 */
	
	public Coin(double value, String currency) {
	
		super(value, currency);
	}

	/** Show detail of coin (value and currency)
	 * @return coin value and currency
	 */
	public String toString() {
		return value + "-" + currency;
	}

}
