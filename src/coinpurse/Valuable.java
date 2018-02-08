package coinpurse;

/**
 * An interface for objects having a monetary value and currency 
 * @author Atid Srisukhantapuek
 */
public interface Valuable {
	/**
	 * Get the value of this object
	 * @return the value of this object
	 */
	public double getValue();
	/**
	 * Get the monetary value of this object
	 * @return the currency of this object
	 */
	public String getCurrency();
}
