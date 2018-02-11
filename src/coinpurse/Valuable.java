package coinpurse;

/**
 * An interface for objects having a monetary value and currency 
 * @author Atid Srisukhantapuek
 */
public interface Valuable extends Comparable<Valuable>{
	/**
	 * Get the value of this object
	 * @return the value of this object
	 */
	public double getValue();
	/**
	 * Get the currency of this object
	 * @return the currency of this object
	 */
	public String getCurrency();
	/**
	 * Compare Object which is equals other object or not 
	 * @return true if equals false if not
	 */
	boolean equals(Object arg);
}
